package com.eilfyt.starwarsinminecraft.entities;

import com.eilfyt.starwarsinminecraft.init.EffectRegister;
import com.eilfyt.starwarsinminecraft.init.ModEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
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
import net.minecraftforge.fml.network.NetworkHooks;

public class LightningBallEntity extends DamagingProjectileEntity {
    public LightningBallEntity(EntityType<? extends LightningBallEntity> p_i50163_1_, World p_i50163_2_) {
        super(p_i50163_1_, p_i50163_2_);
    }

    public LightningBallEntity(World p_i1769_1_, LivingEntity p_i1769_2_, double p_i1769_3_, double p_i1769_5_, double p_i1769_7_) {
        super(ModEntityTypes.LIGHTNING_BALL.get(), p_i1769_2_, p_i1769_3_, p_i1769_5_, p_i1769_7_, p_i1769_1_);
    }

    @Override
    protected void onHit(RayTraceResult p_70227_1_) {
        super.onHit(p_70227_1_);
        BlockPos bp = new BlockPos(p_70227_1_.getLocation().x, p_70227_1_.getLocation().y, p_70227_1_.getLocation().z);
        if (!this.level.isClientSide) {
            LightningBoltEntity entity = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, this.level);
            entity.setPos(bp.getX(), bp.getY(), bp.getZ());
            level.addFreshEntity(entity);
            this.remove();
        }
    }


    @Override
    protected void onHitEntity(EntityRayTraceResult p_213868_1_) {
        super.onHitEntity(p_213868_1_);
        if (!this.level.isClientSide) {
            Entity entity = p_213868_1_.getEntity();
            LightningBoltEntity entity3 = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, this.level);
            entity3.setPos(entity.getX(), entity.getY(), entity.getZ());
            level.addFreshEntity(entity3);
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
