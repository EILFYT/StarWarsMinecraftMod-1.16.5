package com.eilfyt.starwarsinminecraft.biomes;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.placement.CaveEdgeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeFeatures {
    public static void notWithCommonOverworldBlocks(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.BLUE_ICE);
        builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.PILE_SNOW);
    }

}
