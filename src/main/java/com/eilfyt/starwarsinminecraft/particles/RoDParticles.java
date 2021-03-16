package com.eilfyt.starwarsinminecraft.particles;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class RoDParticles extends SpriteTexturedParticle {

    protected RoDParticles(ClientWorld world, double x, double y, double z, double motionX, double motionY, double motionZ) {
        super(world, x, y, z, motionX, motionY, motionZ);
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.setSize(0.2f, 0.2f);
        this.particleScale *= this.rand.nextFloat() * 1.1f;
        this.motionX *= (double) 0.1f;
        this.motionX *= (double) 0.1f;
        this.motionX *= (double) 0.1f;
        this.maxAge = (int) (20.0D / (Math.random() * 1.0D));
    }

    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void tick() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.maxAge-- <= 0) {
            this.setExpired();
        } else {
            this.move(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 1.0D;
            this.motionY *= 1.0D;
            this.motionZ *= 1.0D;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType> {

        private final IAnimatedSprite spriteSet;

        public Factory(IAnimatedSprite sprite) {
            this.spriteSet = sprite;
        }
        @Nullable
        @Override
        public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            RoDParticles rodParticles = new RoDParticles(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
            rodParticles.setColor(1f, 1f, 1f);
            rodParticles.selectSpriteRandomly(this.spriteSet);
            return rodParticles;
        }
    }
}