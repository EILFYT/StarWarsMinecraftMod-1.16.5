package com.eilfyt.starwarsinminecraft.lists;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ParticleList {
public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES,
        StarWarsInMinecraft.MOD_ID);

public static final RegistryObject<BasicParticleType> ROD_PARTICLES = PARTICLES.register("rod_particles",
        () -> new BasicParticleType(true));
}
