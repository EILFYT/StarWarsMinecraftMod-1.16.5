package com.eilfyt.starwarsinminecraft.init;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.entities.*;
import com.eilfyt.starwarsinminecraft.util.RegistryHandler;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.EnderCrystalEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, StarWarsInMinecraft.MOD_ID);


    public static final RegistryObject<EntityType<PorgEntity>> PORG = ENTITY_TYPES.register("porg",
            () -> EntityType.Builder.of(PorgEntity::new, EntityClassification.CREATURE)    .sized(1.0f, 2.0f)
                    .build(new ResourceLocation(StarWarsInMinecraft.MOD_ID, "porg").toString()));


    public static final RegistryObject<EntityType<DragonArcherEntity>> DRAGON_ARCHER = ENTITY_TYPES.register("dragon_archer",
            () -> EntityType.Builder.<DragonArcherEntity>of(DragonArcherEntity::new, EntityClassification.MISC).sized(1.0f, 2.0f).fireImmune()
                    .build(new ResourceLocation(StarWarsInMinecraft.MOD_ID, "dragon_archer").toString()));
//    public static final RegistryObject<EntityType<StormTrooperEntity>> STORMTROOPER = ENTITY_TYPES.register("stormtrooper",
  //          () -> EntityType.Builder.of(StormTrooperEntity::new, EntityClassification.MONSTER)    .sized(1.0f, 2.0f)
    //                .build(new ResourceLocation(StarWarsInMinecraft.MOD_ID, "textures/entity/stormtrooper.png").toString()));

    public static final RegistryObject<EntityType<BulletEntity>> BULLET = ENTITY_TYPES.register("bullet",
            () -> EntityType.Builder.<BulletEntity>of(BulletEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
                    .build(new ResourceLocation(StarWarsInMinecraft.MOD_ID, "textures/entity/bullet.png").toString()));

    public static final RegistryObject<EntityType<IceBallEntity>> ICEBALL = ENTITY_TYPES.register("iceball",
            () -> EntityType.Builder.<IceBallEntity>of(IceBallEntity::new, EntityClassification.MISC).sized(1.0F, 1.0F)
                    .clientTrackingRange(4).updateInterval(10).build(new ResourceLocation(StarWarsInMinecraft.MOD_ID,
                            "textures/entity/iceball.png").toString()));

}
