package com.eilfyt.starwarsinminecraft.entities;

import com.eilfyt.starwarsinminecraft.init.ModEntityTypes;
import com.eilfyt.starwarsinminecraft.util.RegistryHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BulletEntity extends AbstractArrowEntity {

    public BulletEntity(EntityType<? extends BulletEntity> type, World world) {
        super(type, world);
    }

    public BulletEntity(World worldIn, LivingEntity shooter) {
        super(ModEntityTypes.BULLET.get(), shooter, worldIn);
        this.setBaseDamage(1);
    }

    public BulletEntity(World worldIn, double x, double y, double z) {
        super(ModEntityTypes.BULLET.get(), x, y, z, worldIn);
    }


    protected ItemStack getPickupItem() {

                return new ItemStack(RegistryHandler.BULLET.get());
            }

            @Override
    public IPacket<?> getAddEntityPacket(){

        return NetworkHooks.getEntitySpawningPacket(this);
    }
    public void tick() {
        super.tick();
        if (!this.inGround || !this.isInWaterOrRain() || !this.isInWater()) {
            this.getCommandSenderWorld().addParticle(ParticleTypes.HAPPY_VILLAGER, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D,
                    0.0D);
            this.getCommandSenderWorld().addParticle(ParticleTypes.HAPPY_VILLAGER, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D,
                    0.0D);
        }
    }

}

