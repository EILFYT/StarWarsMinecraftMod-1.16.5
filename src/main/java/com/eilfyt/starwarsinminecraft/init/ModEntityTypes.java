package com.eilfyt.starwarsinminecraft.init;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.entities.BulletEntity;
import com.eilfyt.starwarsinminecraft.entities.PorgEntity;
import com.eilfyt.starwarsinminecraft.entities.StormTrooperEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, StarWarsInMinecraft.MOD_ID);


    public static final RegistryObject<EntityType<PorgEntity>> PORG = ENTITY_TYPES.register("porg",
            () -> EntityType.Builder.of(PorgEntity::new, EntityClassification.CREATURE)    .sized(1.0f, 2.0f)
                    .build(new ResourceLocation(StarWarsInMinecraft.MOD_ID, "porg").toString()));
    public static final RegistryObject<EntityType<StormTrooperEntity>> STORMTROOPER = ENTITY_TYPES.register("stormtrooper",
            () -> EntityType.Builder.of(StormTrooperEntity::new, EntityClassification.MONSTER)    .sized(1.0f, 2.0f)
                    .build(new ResourceLocation(StarWarsInMinecraft.MOD_ID, "textures/entity/stormtrooper.png").toString()));
    public static final RegistryObject<EntityType<BulletEntity>> BULLET = ENTITY_TYPES.register("bullet",
            () -> EntityType.Builder.<BulletEntity>of(BulletEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
                    .build(new ResourceLocation(StarWarsInMinecraft.MOD_ID, "textures/entity/bullet.png").toString()));


}
