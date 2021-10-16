package com.eilfyt.starwarsinminecraft.entities;

import com.eilfyt.starwarsinminecraft.init.EffectRegister;
import com.eilfyt.starwarsinminecraft.init.ModEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.DamagingProjectileEntity;
import net.minecraft.network.IPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.HashSet;
import java.util.Set;

public class IceBallEntity extends DamagingProjectileEntity {
    public IceBallEntity(EntityType<? extends IceBallEntity> p_i50163_1_, World p_i50163_2_) {
        super(p_i50163_1_, p_i50163_2_);
    }

    public IceBallEntity(World p_i1769_1_, LivingEntity p_i1769_2_, double p_i1769_3_, double p_i1769_5_, double p_i1769_7_) {
        super(ModEntityTypes.ICEBALL.get(), p_i1769_2_, p_i1769_3_, p_i1769_5_, p_i1769_7_, p_i1769_1_);
    }

    @Override
    protected void onHit(RayTraceResult p_70227_1_) {
        super.onHit(p_70227_1_);
        BlockPos bp = new BlockPos(p_70227_1_.getLocation().x, p_70227_1_.getLocation().y, p_70227_1_.getLocation().z);
        if (!this.level.isClientSide) {
            blockReplacement(3, this.level, bp);
            this.remove();
        }
    }

    public void blockReplacement(int size, World world, BlockPos blockPos) {
        BlockPos.betweenClosedStream(blockPos.getX() - size, blockPos.getY() - size, blockPos.getZ() - size,
                blockPos.getX() + size, blockPos.getY() + size, blockPos.getZ() + size).forEach(blockPos1 -> {

            Block block = world.getBlockState(blockPos1).getBlock();
        if (block == Blocks.AIR || block == Blocks.CAVE_AIR || block == Blocks.VOID_AIR || block == Blocks.BEDROCK || block == Blocks.END_PORTAL_FRAME || block == Blocks.END_PORTAL || block == Blocks.NETHER_PORTAL || block == Blocks.END_GATEWAY) {
            } else if (block == Blocks.LAVA) {
                world.setBlockAndUpdate(blockPos1, Blocks.OBSIDIAN.defaultBlockState());
            } else if (block == Blocks.OBSIDIAN || block == Blocks.ICE) {
            } else {
                world.setBlockAndUpdate(blockPos1, Blocks.ICE.defaultBlockState());
            }
            world.getBlockState(blockPos1).getBlock();
            for (Entity entity : world.getEntities((Entity) null, new AxisAlignedBB(blockPos.getX() - size, blockPos.getY() - size, blockPos.getZ() - size,blockPos.getX() + size, blockPos.getY() + size, blockPos.getZ() + size), EntityPredicates.NO_CREATIVE_OR_SPECTATOR)) {
                if (entity instanceof LivingEntity) {
                        LivingEntity livingEntity = (LivingEntity) entity;
                        livingEntity.addEffect(new EffectInstance(EffectRegister.FREEZE.get(), 200, 0));
                        livingEntity.addEffect(new EffectInstance(Effects.JUMP, 200, -10));
                        livingEntity.addEffect(new EffectInstance(Effects.DIG_SLOWDOWN, 200, 0));
                }
            }
        }

        );
    }
    @Override
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

    @Override
    protected boolean shouldBurn() {
        return false;
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
