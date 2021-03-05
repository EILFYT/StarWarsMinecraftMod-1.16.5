package com.neonfish.starwarsinminecraft.init;

import com.neonfish.starwarsinminecraft.StarWarsInMinecraft;
import com.neonfish.starwarsinminecraft.entities.PorgEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, StarWarsInMinecraft.MOD_ID);

    public static final RegistryObject<EntityType<PorgEntity>> PORG = ENTITY_TYPES.register("porg",
            () -> EntityType.Builder.create(PorgEntity::new, EntityClassification.CREATURE)


    .size(1.0f, 2.0f)
    .build(new ResourceLocation(StarWarsInMinecraft.MOD_ID, "porg").toString()));
}
