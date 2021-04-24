package com.eilfyt.starwarsinminecraft.init;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.entities.PorgEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, StarWarsInMinecraft.MOD_ID);

    public static final RegistryObject<EntityType<PorgEntity>> PORG = ENTITY_TYPES.register("porg",
            () -> EntityType.Builder.of(PorgEntity::new, EntityClassification.CREATURE)


    .sized(1.0f, 2.0f)
    .build(new ResourceLocation(StarWarsInMinecraft.MOD_ID, "porg").toString()));
}
