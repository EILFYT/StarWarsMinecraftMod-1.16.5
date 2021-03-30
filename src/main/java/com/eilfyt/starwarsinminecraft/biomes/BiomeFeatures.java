package com.eilfyt.starwarsinminecraft.biomes;

import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;

public class BiomeFeatures {
    public static void notWithCommonOverworldBlocks(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.PILE_SNOW);
        builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.BLUE_ICE);
    }
 }
