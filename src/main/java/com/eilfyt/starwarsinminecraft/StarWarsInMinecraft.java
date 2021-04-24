package com.eilfyt.starwarsinminecraft;

import com.eilfyt.starwarsinminecraft.biomes.Biomes;
import com.eilfyt.starwarsinminecraft.commands.ModCommands;
import com.eilfyt.starwarsinminecraft.entities.PorgEntity;
import com.eilfyt.starwarsinminecraft.init.EffectRegister;
import com.eilfyt.starwarsinminecraft.init.ModEntityTypes;
import com.eilfyt.starwarsinminecraft.lists.SoundList;
import com.eilfyt.starwarsinminecraft.util.RegistryHandler;
import com.eilfyt.starwarsinminecraft.world.gen.OreGeneration;
import com.eilfyt.starwarsinminecraft.world.structures.ConfiguredStructures;
import com.eilfyt.starwarsinminecraft.world.structures.Structures;
import com.mojang.serialization.Codec;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Mod("starwars")
public class  StarWarsInMinecraft
{ 
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "starwars";

    public StarWarsInMinecraft() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);


        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Structures.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);
        ModEntityTypes.ENTITY_TYPES.register(modEventBus);
        EffectRegister.EFFECTS.register(modEventBus);
        EffectRegister.POTIONS.register(modEventBus);
        SoundList.SOUNDS.register(modEventBus);
        Biomes.BIOMES.register(modEventBus);
        RegistryHandler.BLOCKS.register(modEventBus);
        RegistryHandler.ITEMS.register(modEventBus);
        modEventBus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);

        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.addListener(EventPriority.NORMAL, this::addDimensionalSpacing);


        forgeBus.addListener(EventPriority.HIGH, this::biomeModification);
    }


    private void setup(final FMLCommonSetupEvent event) {


        OreGeneration.registerOre();
        EffectRegister.addPotionRecipes();
        event.enqueueWork(() -> {
            Structures.setupStructures();
            ConfiguredStructures.registerConfiguredStructures();
            GlobalEntityTypeAttributes.put(ModEntityTypes.PORG.get(), PorgEntity.setCustomAttributes().build());
        });
        ItemModelsProperties.register(RegistryHandler.DRAGON_SOUL_BOW.get(), new ResourceLocation("pulling"), (p_239428_0_, p_239428_1_, p_239428_2_) -> {

            return p_239428_2_ != null && p_239428_2_.isUsingItem() && p_239428_2_.getUseItem() == p_239428_0_ ? 1.0F : 0.0F;

        });

        ItemModelsProperties.register(RegistryHandler.DRAGON_SOUL_BOW.get(), new ResourceLocation("pull"), (p_239429_0_, p_239429_1_, p_239429_2_) -> {

            if (p_239429_2_ == null) {

                return 0.0F;

            } else {

                return p_239429_2_.getUseItem() != p_239429_0_ ? 0.0F : (float)(p_239429_0_.getUseDuration() - p_239429_2_.getUseItemRemainingTicks()) / 20.0F;

            }

        });
    }
    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(MOD_ID, name);
    }




    private void doClientStuff(final FMLClientSetupEvent event) { }

    public static final ItemGroup TAB = new ItemGroup("starwarsmod") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(RegistryHandler.KYBERCRYSTAL.get());
        }

    };
    public static final ItemGroup E = new ItemGroup("tab") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(RegistryHandler.SHREK_BLOCK.get());
        }

    };
    public static final ItemGroup SB_TAB = new ItemGroup("sb_tab") {

@Override
        public ItemStack makeIcon() {return new ItemStack(RegistryHandler.SKYBLOCK_TAB_LOGO.get());}

    };
    public static void init(final FMLCommonSetupEvent event) {

          event.enqueueWork(() -> {


          });
    }
    public void biomeModification(final BiomeLoadingEvent event) {

        event.getGeneration().getStructures().add(() -> ConfiguredStructures.CONFIGURED_WIZARD_TOWER);
        event.getGeneration().getStructures().add(() -> ConfiguredStructures.CONFIGURED_DEATH_STAR);
    }


    @SubscribeEvent
    public void serverLoad(RegisterCommandsEvent event) {
            ModCommands.register(event.getDispatcher());
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, Biomes::biomeLoading);
    }
    private static Method GETCODEC_METHOD;
    public void addDimensionalSpacing(final WorldEvent.Load event) {
        if(event.getWorld() instanceof ServerWorld){
            ServerWorld serverWorld = (ServerWorld)event.getWorld();


            try {
                if(GETCODEC_METHOD == null) GETCODEC_METHOD = ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "codec");
                ResourceLocation cgRL = Registry.CHUNK_GENERATOR.getKey((Codec<? extends ChunkGenerator>) GETCODEC_METHOD.invoke(serverWorld.getChunkSource().generator));
                if(cgRL != null && cgRL.getNamespace().equals("terraforged")) return;
            }
            catch(Exception e){
                StarWarsInMinecraft.LOGGER.error("Was unable to check if " + serverWorld.dimension().location() + " is using Terraforged's ChunkGenerator.");
            }

            if(serverWorld.getChunkSource().getGenerator() instanceof FlatChunkGenerator &&
                    serverWorld.dimension().equals(World.OVERWORLD)){
                return;
            }

            Map<Structure<?>, StructureSeparationSettings> tempMarp = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
            tempMarp.putIfAbsent(Structures.DEATH_STAR.get(), DimensionStructuresSettings.DEFAULTS.get(Structures.DEATH_STAR.get()));
            serverWorld.getChunkSource().generator.getSettings().structureConfig = tempMarp;

            Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
            tempMap.putIfAbsent(Structures.WIZARD_TOWER.get(), DimensionStructuresSettings.DEFAULTS.get(Structures.WIZARD_TOWER.get()));
            serverWorld.getChunkSource().generator.getSettings().structureConfig = tempMap;
        }
    }
}