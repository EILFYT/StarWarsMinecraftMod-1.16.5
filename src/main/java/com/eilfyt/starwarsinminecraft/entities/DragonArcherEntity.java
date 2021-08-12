package com.eilfyt.starwarsinminecraft.entities;

import com.eilfyt.starwarsinminecraft.init.ModEntityTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.EnderCrystalEntity;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class DragonArcherEntity extends AbstractDragonArcherEntity {
    public DragonArcherEntity(EntityType<? extends AbstractDragonArcherEntity> type, World world) {
        super(type, world);
    }

    public DragonArcherEntity(World p_i1699_1_, double p_i1699_2_, double p_i1699_4_, double p_i1699_6_) {
        this(ModEntityTypes.DRAGON_ARCHER.get(), p_i1699_1_);
        this.setPos(p_i1699_2_, p_i1699_4_, p_i1699_6_);
    }




    @Override
    protected SoundEvent getStepSound() {
        return SoundEvents.CHICKEN_STEP;
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.ELDER_GUARDIAN_DEATH_LAND;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ELDER_GUARDIAN_DEATH;
    }

}
