package com.eilfyt.starwarsinminecraft.entities;

import com.eilfyt.starwarsinminecraft.init.ModEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class PorgEntity extends TameableEntity {

    public static final Ingredient TEMPTATION_ITEM = Ingredient.fromItems(Items.SALMON, Items.COD);



    public PorgEntity(EntityType<? extends PorgEntity> type, World worldIn) {
        super(type, worldIn);
        this.setTamed(false);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
        .createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
        .createMutableAttribute(Attributes.MOVEMENT_SPEED, 1.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new SwimGoal(this));
        this.goalSelector.addGoal(3, new PanicGoal(this, 0.8D));
        this.goalSelector.addGoal(4, new BreedGoal(this, 0.5D));
        this.goalSelector.addGoal(1, new TemptGoal(this, 1.25D, TEMPTATION_ITEM, false));
        this.goalSelector.addGoal(0, new FollowOwnerGoal(this, 0.6D, 1.0F, 15.0F, true));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 10.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));

    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_DOLPHIN_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_DOLPHIN_DEATH;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_DOLPHIN_HURT;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_POLAR_BEAR_STEP, 0.5f, 1.0f);
    }

    @Override
    protected boolean canBeRidden(Entity entityIn) {
        return true;
    }

    @Nullable
    @Override
    public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return ModEntityTypes.PORG.get().create(this.world);
    }
    public void setTamed(boolean tamed) {
        super.setTamed(tamed);
        if (tamed) {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20.0D);
            this.setHealth(20.0F);
        } else {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20.0D);
        }
    }
    public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
        Item item = itemstack.getItem();
        if (this.world.isRemote) {
            boolean flag = item == Items.COD && !this.isTamed();
            return flag ? ActionResultType.CONSUME : ActionResultType.PASS;
        } else {
            if (this.isTamed()) {
                if (this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
                    if (!p_230254_1_.abilities.isCreativeMode) {
                        itemstack.shrink(1);
                    }

                    this.heal((float)item.getFood().getHealing());
                    return ActionResultType.SUCCESS;
                }

                if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, p_230254_1_)) {
                    this.setTamedBy(p_230254_1_);
                    this.navigator.clearPath();
                    this.func_233687_w_(true);
                    this.world.setEntityState(this, (byte)7);
                } else {
                    this.world.setEntityState(this, (byte)6);
                }

                return ActionResultType.SUCCESS;
            }

            return super.func_230254_b_(p_230254_1_, p_230254_2_);
        }
    }
}