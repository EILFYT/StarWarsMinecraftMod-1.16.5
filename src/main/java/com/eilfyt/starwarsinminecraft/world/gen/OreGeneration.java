package com.eilfyt.starwarsinminecraft.world.gen;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.biomes.MustafarBiomes;
import com.eilfyt.starwarsinminecraft.dimensions.ModDimensions;
import com.eilfyt.starwarsinminecraft.util.RegistryHandler;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import java.util.ArrayList;

@Mod.EventBusSubscriber
public class OreGeneration {

    private static final ArrayList<ConfiguredFeature<?, ?>> overworldOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> netherOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> endOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> mustafarOres = new ArrayList<ConfiguredFeature<?, ?>>();

    public static void registerOre(){
        //Overworld Ore Register
        overworldOres.add(register("crystal_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.CRYSTAL_ORE_BLOCK.get().getDefaultState(), 4))
                .range(30).square()
                .func_242731_b(32)));

        netherOres.add(register("nether_crystal_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER, RegistryHandler.NETHER_CRYSTAL_ORE_BLOCK.get().getDefaultState(), 4))
                .range(30).square()
                .func_242731_b(32)));

        endOres.add(register("dragon_soul_fragment", Feature.ORE.withConfiguration(new OreFeatureConfig(
                new BlockMatchRuleTest(Blocks.END_STONE), RegistryHandler.DRAGON_SOUL_FRAGMENT.get().getDefaultState(), 6)) //Vein Size
                .range(255).square()
                .func_242731_b(16)));
     /*   mustafarOres.add(register("idk_but_its_in_mustafar", Feature.ORE.withConfiguration(new OreFeatureConfig(
                new BlockMatchRuleTest(Blocks.BLACKSTONE), RegistryHandler.MUSTAFAR_ORE.get().getDefaultState(), 6)) //Vein Size
                .range(255).square()
               .func_242731_b(16)));
       */  }


    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void gen(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        if(event.getCategory().equals(Biome.Category.NETHER)){
            for(ConfiguredFeature<?, ?> ore : netherOres){
                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
        if(event.getCategory().equals(Biome.Category.THEEND)){
            for(ConfiguredFeature<?, ?> ore : endOres){
                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
        if(event.getCategory().equals(ModDimensions.MUSTAFAR)){
            for(ConfiguredFeature<?, ?> ore : mustafarOres) {
                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
        for(ConfiguredFeature<?, ?> ore : overworldOres){
            if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
        }
    }


    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, StarWarsInMinecraft.MOD_ID + ":" + name, configuredFeature);
}}


