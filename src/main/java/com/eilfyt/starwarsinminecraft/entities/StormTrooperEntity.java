  /*      package com.eilfyt.starwarsinminecraft.entities;

        import com.eilfyt.starwarsinminecraft.items.Gun;
        import com.eilfyt.starwarsinminecraft.util.RangedGunAttackGoal;
        import com.eilfyt.starwarsinminecraft.util.RegistryHandler;
        import net.minecraft.entity.*;
        import net.minecraft.entity.ai.attributes.Attribute;
        import net.minecraft.entity.ai.attributes.AttributeModifierMap;
        import net.minecraft.entity.ai.attributes.Attributes;
        import net.minecraft.entity.ai.goal.*;
        import net.minecraft.entity.monster.AbstractSkeletonEntity;
        import net.minecraft.entity.monster.MonsterEntity;
        import net.minecraft.entity.monster.SkeletonEntity;
        import net.minecraft.entity.monster.ZombieEntity;
        import net.minecraft.entity.passive.IronGolemEntity;
        import net.minecraft.entity.passive.TurtleEntity;
        import net.minecraft.entity.passive.WolfEntity;
        import net.minecraft.entity.player.PlayerEntity;
        import net.minecraft.entity.projectile.AbstractArrowEntity;
        import net.minecraft.entity.projectile.ProjectileHelper;
        import net.minecraft.inventory.EquipmentSlotType;
        import net.minecraft.item.ItemStack;
        import net.minecraft.item.Items;
        import net.minecraft.item.ShootableItem;
        import net.minecraft.nbt.CompoundNBT;
        import net.minecraft.network.IPacket;
        import net.minecraft.util.SoundEvents;
        import net.minecraft.util.math.MathHelper;
        import net.minecraft.world.Difficulty;
        import net.minecraft.world.DifficultyInstance;
        import net.minecraft.world.World;

public class StormTrooperEntity extends MonsterEntity implements IRangedAttackMob{
    private final RangedGunAttackGoal<StormTrooperEntity> blasterGoal = new RangedGunAttackGoal<>(this, 1.0D, 20, 15.0F);
    private final MeleeAttackGoal meleeGoal = new MeleeAttackGoal(this, 1.2D, false) {
        public void stop() {
            super.stop();
            StormTrooperEntity.this.setAggressive(false);
        }

        public void start() {
            super.start();
            StormTrooperEntity.this.setAggressive(true);
        }
    };

    public StormTrooperEntity(EntityType<? extends StormTrooperEntity> type, World worldIn) {
        super(type, worldIn);
        this.reassessWeaponGoal();
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 40.0D)
                .add(Attributes.MOVEMENT_SPEED, 1.0D);
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new RestrictSunGoal(this));
        this.goalSelector.addGoal(3, new FleeSunGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, WolfEntity.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));

    }
    public void reassessWeaponGoal() {
        if (this.level != null && !this.level.isClientSide) {
            this.goalSelector.removeGoal(this.meleeGoal);
            this.goalSelector.removeGoal(this.blasterGoal);
            ItemStack itemstack = this.getItemInHand(ProjectileHelper.getWeaponHoldingHand(this, RegistryHandler.BLASTER.get()));
            if (itemstack.getItem() == RegistryHandler.BLASTER.get()) {
                int i = 20;
                if (this.level.getDifficulty() != Difficulty.HARD) {
                    i = 40;
                }

                this.blasterGoal.setMinAttackInterval(i);
                this.goalSelector.addGoal(4, this.blasterGoal);
            } else {
                this.goalSelector.addGoal(4, this.meleeGoal);
            }

        }
    }
    @Override
    protected void populateDefaultEquipmentSlots(DifficultyInstance p_180481_1_) {
        this.populateDefaultEquipmentSlots(p_180481_1_);
        this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(RegistryHandler.BLASTER.get()));
    }

    public void performRangedAttack(LivingEntity p_82196_1_, float p_82196_2_) {
        ItemStack itemstack = this.getProjectile(this.getItemInHand(ProjectileHelper.getWeaponHoldingHand(this, RegistryHandler.BLASTER.get())));
        AbstractArrowEntity abstractarrowentity = this.getArrow(itemstack, p_82196_2_);
        if (this.getMainHandItem().getItem() instanceof Gun)
            abstractarrowentity = ((Gun)this.getMainHandItem().getItem()).customArrow(abstractarrowentity);
        double d0 = p_82196_1_.getX() - this.getX();
        double d1 = p_82196_1_.getY(0.3333333333333333D) - abstractarrowentity.getY();
        double d2 = p_82196_1_.getZ() - this.getZ();
        double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
        abstractarrowentity.shoot(d0, d1 + d3 * (double)0.2F, d2, 1.6F, (float)(14 - this.level.getDifficulty().getId() * 4));
        this.playSound(SoundEvents.SKELETON_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level.addFreshEntity(abstractarrowentity);
    }
    protected float getStandingEyeHeight(Pose p_213348_1_, EntitySize p_213348_2_) {
        return 1.74F;
    }

    protected AbstractArrowEntity getArrow(ItemStack p_213624_1_, float p_213624_2_) {
        return ProjectileHelper.getMobArrow(this, p_213624_1_, p_213624_2_);
    }

    public boolean canFireProjectileWeapon(ShootableItem p_230280_1_) {
        return p_230280_1_ == RegistryHandler.BLASTER.get();
    }
} */