package com.eilfyt.starwarsinminecraft.biomes;

import net.minecraft.block.Blocks;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
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
            biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.ICE_SPIKE);
            biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.ICE_PATCH);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, com.eilfyt.starwarsinminecraft.biomes.Features.ICE_TREEE);


        BiomeFeatures.notWithCommonOverworldBlocks(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withFrozenTopLayer(biomegenerationsettings$builder);
        return (new Biome.Builder()).precipitation(Biome.RainType.SNOW).category(Biome.Category.ICY).depth(depth).scale(scale).temperature(-100.0F).downfall(0.5F).setEffects((new BiomeAmbience.Builder()).setWaterColor(4159204).setWaterFogColor(329011).setFogColor(12638463).withSkyColor(getSkyColorWithTemperatureModifier(0.0F)).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build()).withMobSpawnSettings(mobspawninfo$builder.copy()).withGenerationSettings(biomegenerationsettings$builder.build()).build();
    }

    public static Biome makeNetherierWastesierBiome() {
        MobSpawnInfo mobspawninfo = (new MobSpawnInfo.Builder()).withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 1, 4, 4)).withSpawner(EntityClassification.MONSTER,  new MobSpawnInfo.Spawners(EntityType.SKELETON_HORSE, 10, 1, 3)).withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.PIGLIN, 15, 4, 4)).withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.STRIDER, 60, 1, 2)).copy();
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244170_b).withStructure(StructureFeatures.RUINED_PORTAL_NETHER).withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.field_243772_f).withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.DELTA).withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SPRING_LAVA_DOUBLE).withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.SMALL_BASALT_COLUMNS).withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.LARGE_BASALT_COLUMNS).withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.BASALT_BLOBS).withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.BLACKSTONE_BLOBS).withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.SPRING_DELTA).withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.PATCH_FIRE).withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.PATCH_SOUL_FIRE).withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE_EXTRA).withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE).withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.BROWN_MUSHROOM_NETHER).withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.RED_MUSHROOM_NETHER).withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA).withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.SPRING_CLOSED_DOUBLE).withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.ORE_GOLD_DELTAS).withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.ORE_QUARTZ_DELTAS);
       biomegenerationsettings$builder.withStructure(StructureFeatures.NETHER_FOSSIL).withStructure(StructureFeatures.RUINED_PORTAL);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, com.eilfyt.starwarsinminecraft.biomes.Features.LAVA_TREE);
        DefaultBiomeFeatures.withCavesAndCanyons(biomegenerationsettings$builder);
        return (new Biome.Builder()).precipitation(Biome.RainType.NONE).category(Biome.Category.NETHER).depth(0.1F).scale(0.2F).temperature(2.0F).downfall(0.0F).setEffects((new BiomeAmbience.Builder()).setWaterColor(4159204).setWaterFogColor(4341314).setFogColor(6840176).withSkyColor(getSkyColorWithTemperatureModifier(2.0F)).setParticle(new ParticleEffectAmbience(ParticleTypes.WHITE_ASH, 0.118093334F)).setAmbientSound(SoundEvents.AMBIENT_BASALT_DELTAS_LOOP).setMoodSound(new MoodSoundAmbience(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D)).setAdditionsSound(new SoundAdditionsAmbience(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D)).setMusic(BackgroundMusicTracks.getDefaultBackgroundMusicSelector(SoundEvents.MUSIC_NETHER_BASALT_DELTAS)).build()).withMobSpawnSettings(mobspawninfo).withGenerationSettings(biomegenerationsettings$builder.build()).build();

    }
}
