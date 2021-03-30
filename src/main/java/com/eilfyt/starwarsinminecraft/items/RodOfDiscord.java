package com.eilfyt.starwarsinminecraft.items;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.init.EffectRegister;
import com.eilfyt.starwarsinminecraft.lists.ParticleList;
import com.eilfyt.starwarsinminecraft.lists.SoundList;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CChatMessagePacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class RodOfDiscord extends Item {
    public RodOfDiscord() {
        super(new Item.Properties().group(StarWarsInMinecraft.TAB).maxStackSize(1));
    }



    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    Vector3d vec3d = RodOfDiscord.rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.NONE).getHitVec();
    worldIn.playSound(playerIn, new BlockPos(playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ()), SoundList.ROD_TP.get(), SoundCategory.PLAYERS, 1f, 1f);
    playerIn.setPosition(vec3d.x, vec3d.y, vec3d.z);
        double d0 = (double)playerIn.getPosX() + 0.5D;
        double d1 = (double)playerIn.getPosY() + 1.0D;
        double d2 = (double)playerIn.getPosZ() + 0.5D;
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleList.ROD_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
    return super.onItemRightClick(worldIn, playerIn, handIn);
    }


    protected static BlockRayTraceResult rayTrace(World worldIn, PlayerEntity player, RayTraceContext.FluidMode fluidMode) {
        double range = 20;

        float f = player.rotationPitch;
        float f1 = player.rotationYaw;
        Vector3d vector3d = player.getEyePosition(1.0F);
        float f2 = MathHelper.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f3 = MathHelper.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f4 = -MathHelper.cos(-f * ((float)Math.PI / 180F));
        float f5 = MathHelper.sin(-f * ((float)Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        Vector3d vector3d1 = vector3d.add((double)f6 * range, (double)f5 * range, (double)f7 * range);
        return worldIn.rayTraceBlocks(new RayTraceContext(vector3d, vector3d1, RayTraceContext.BlockMode.OUTLINE, fluidMode, player));
    }
}