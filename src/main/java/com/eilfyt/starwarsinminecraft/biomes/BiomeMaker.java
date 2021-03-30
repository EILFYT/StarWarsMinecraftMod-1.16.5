package com.eilfyt.starwarsinminecraft.biomes;

import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;

public class BiomeMaker extends Biome.Builder {
    private static int getSkyColorWithTemperatureModifier(float temperature) {
        float lvt_1_1_ = temperature / 3.0F;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
        return MathHelper.hsvToRGB(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
    }

    public static Biome makeIceierSpikesBiome() {
        float depth = 2f;
        float scale = 2f;
        MobSpawnInfo.Builder mobspawninfo$builder = (new MobSpawnInfo.Builder()).withCreatureSpawnProbability(0.07F);
        DefaultBiomeFeatures.withSnowyBiomeMobs(mobspawninfo$builder);
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244178_j);

        DefaultBiomeFeatures.withStrongholdAndMineshaft(biomegenerationsettings$builder);

        biomegenerationsettings$builder.withStructure(StructureFeatures.RUINED_PORTAL);
        DefaultBiomeFeatures.withCavesAndCanyons(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withLavaAndWaterLakes(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withMonsterRoom(biomegenerationsettings$builder);
            biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.ICE_SPIKE);
            biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.ICE_PATCH);

        BiomeFeatures.notWithCommonOverworldBlocks(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withOverworldOres(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withDisks(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withSugarCaneAndPumpkins(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withLavaAndWaterSprings(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withFrozenTopLayer(biomegenerationsettings$builder);
        return (new Biome.Builder()).precipitation(Biome.RainType.SNOW).category(Biome.Category.ICY).depth(depth).scale(scale).temperature(-100.0F).downfall(0.5F).setEffects((new BiomeAmbience.Builder()).setWaterColor(4159204).setWaterFogColor(329011).setFogColor(12638463).withSkyColor(getSkyColorWithTemperatureModifier(0.0F)).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build()).withMobSpawnSettings(mobspawninfo$builder.copy()).withGenerationSettings(biomegenerationsettings$builder.build()).build();
    }
}
