package com.eilfyt.starwarsinminecraft.entities;

import com.eilfyt.starwarsinminecraft.init.EffectRegister;
import com.eilfyt.starwarsinminecraft.init.ModEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.HashSet;
import java.util.Set;

public class IceBallEntity extends AbstractFireballEntity {
    public int explosionPower = 1;
    public IceBallEntity(EntityType<? extends IceBallEntity> p_i50163_1_, World p_i50163_2_) {
        super(p_i50163_1_, p_i50163_2_);
    }

    @OnlyIn(Dist.CLIENT)
    public IceBallEntity(World p_i1768_1_, double p_i1768_2_, double p_i1768_4_, double p_i1768_6_, double p_i1768_8_, double p_i1768_10_, double p_i1768_12_) {
        super(ModEntityTypes.ICEBALL.get(), p_i1768_2_, p_i1768_4_, p_i1768_6_, p_i1768_8_, p_i1768_10_, p_i1768_12_, p_i1768_1_);
    }

    public IceBallEntity(World p_i1769_1_, LivingEntity p_i1769_2_, double p_i1769_3_, double p_i1769_5_, double p_i1769_7_) {
        super(ModEntityTypes.ICEBALL.get(), p_i1769_2_, p_i1769_3_, p_i1769_5_, p_i1769_7_, p_i1769_1_);
    }

    protected void onHit(RayTraceResult p_70227_1_) {
        super.onHit(p_70227_1_);
        if (!this.level.isClientSide) {
            blockReplacement(2, this.level);
            this.remove();
        }

    }

    public Set<BlockPos> getCircleOffsets(float radius) {
        Set<BlockPos> circleOffsets = new HashSet<>();

        int radiusI = (int) Math.ceil(radius) + 1;
        for (int x = -radiusI; x <= radiusI; x++) {
            for (int y = -radiusI; y <= radiusI; y++) {
                for (int z = -radiusI; z <= radiusI; z++) {
                    float distSq = x * x + y * y + z * z;
                    if (distSq >= (radius - 0.5) * (radius - 0.5) && distSq <= (radius + 0.5) * (radius + 0.5)) {
                        circleOffsets.add(new BlockPos(x, y, z));
                    }
                }
            }
        }
        return circleOffsets;
    }

    public void blockReplacement(int size, World world) {
        Set<BlockPos> circleOffsets = getCircleOffsets(size);
        for (BlockPos blockpos : circleOffsets) {
            Block block = world.getBlockState(blockpos).getBlock();
            if (block == Blocks.AIR) {
            } else if (block == Blocks.LAVA) {
                world.setBlock(blockpos, Blocks.OBSIDIAN.defaultBlockState(), 0);
            } else if (block == Blocks.OBSIDIAN || block == Blocks.ICE) {
            } else {
                world.setBlock(blockpos, Blocks.ICE.defaultBlockState(), 0);
            }
            for (Entity entity : world.getEntities((Entity) null, this.getBoundingBox(), EntityPredicates.NO_CREATIVE_OR_SPECTATOR)) {
                if (entity instanceof LivingEntity) {
                    BlockPos entityPos = new BlockPos(entity.getX(), entity.getY(), entity.getZ());
                    if (entityPos == blockpos) {
                        LivingEntity livingEntity = (LivingEntity) entity;
                        livingEntity.addEffect(new EffectInstance(EffectRegister.FREEZE.get(), 100, 0));
                        livingEntity.addEffect(new EffectInstance(Effects.JUMP, 100, -10));
                    }
                }
            }
        }
    }

    protected void onHitEntity(EntityRayTraceResult p_213868_1_) {
        super.onHitEntity(p_213868_1_);
        if (!this.level.isClientSide) {
            Entity entity = p_213868_1_.getEntity();
            Entity entity1 = this.getOwner();
            if (entity instanceof LivingEntity) {
                LivingEntity entity2 = (LivingEntity) entity;
                entity2.addEffect(new EffectInstance(EffectRegister.FREEZE.get(), 100, 0));
                entity2.addEffect(new EffectInstance(Effects.JUMP, 100, -10));
            } if (entity1 instanceof LivingEntity) {
                this.doEnchantDamageEffects((LivingEntity) entity1, entity);
            }

        }
    }

    public void addAdditionalSaveData(CompoundNBT p_213281_1_) {
        super.addAdditionalSaveData(p_213281_1_);
        p_213281_1_.putInt("ExplosionPower", this.explosionPower);
    }

    public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
        super.readAdditionalSaveData(p_70037_1_);
        if (p_70037_1_.contains("ExplosionPower", 99)) {
            this.explosionPower = p_70037_1_.getInt("ExplosionPower");
        }
    }
}
