package com.eilfyt.starwarsinminecraft.biomes;

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
        return MathHelper.hsvToRgb(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
    }

    public static Biome makeIceierSpikesBiome() {
        float depth = 2f;
        float scale = 2f;
        MobSpawnInfo.Builder mobspawninfo$builder = (new MobSpawnInfo.Builder()).creatureGenerationProbability(0.07F);
        DefaultBiomeFeatures.snowySpawns(mobspawninfo$builder);
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.MOUNTAIN);
            biomegenerationsettings$builder.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.ICE_SPIKE);
            biomegenerationsettings$builder.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.ICE_PATCH);
        biomegenerationsettings$builder.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, com.eilfyt.starwarsinminecraft.biomes.Features.ICE_TREEE);


        BiomeFeatures.notWithCommonOverworldBlocks(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addSurfaceFreezing(biomegenerationsettings$builder);
        return (new Biome.Builder()).precipitation(Biome.RainType.SNOW).biomeCategory(Biome.Category.ICY).depth(depth).scale(scale).temperature(-100.0F).downfall(0.5F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(getSkyColorWithTemperatureModifier(0.0F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
    }

    public static Biome makeBasaltierDeltasBiome() {
        MobSpawnInfo mobspawninfo = (new MobSpawnInfo.Builder()).addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 1, 4, 4)).addSpawn(EntityClassification.MONSTER,  new MobSpawnInfo.Spawners(EntityType.SKELETON_HORSE, 10, 1, 3)).addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.PIGLIN, 15, 4, 4)).addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.STRIDER, 60, 1, 2)).build();
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.MOUNTAIN).addStructureStart(StructureFeatures.RUINED_PORTAL_NETHER).addCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.CANYON).addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.DELTA).addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SPRING_LAVA_DOUBLE).addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.SMALL_BASALT_COLUMNS).addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.LARGE_BASALT_COLUMNS).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.BASALT_BLOBS).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.BLACKSTONE_BLOBS).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.SPRING_DELTA).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.PATCH_FIRE).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.PATCH_SOUL_FIRE).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE_EXTRA).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.BROWN_MUSHROOM_NETHER).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.RED_MUSHROOM_NETHER).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.SPRING_CLOSED_DOUBLE).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.ORE_GOLD_DELTAS).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.ORE_QUARTZ_DELTAS);
       biomegenerationsettings$builder.addStructureStart(StructureFeatures.NETHER_FOSSIL).addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
        biomegenerationsettings$builder.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, com.eilfyt.starwarsinminecraft.biomes.Features.LAVA_TREE);
        DefaultBiomeFeatures.addDefaultCarvers(biomegenerationsettings$builder);
        return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.NETHER).depth(0.1F).scale(0.2F).temperature(2.0F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(4341314).fogColor(6840176).skyColor(getSkyColorWithTemperatureModifier(2.0F)).ambientParticle(new ParticleEffectAmbience(ParticleTypes.WHITE_ASH, 0.118093334F)).ambientLoopSound(SoundEvents.AMBIENT_BASALT_DELTAS_LOOP).ambientMoodSound(new MoodSoundAmbience(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new SoundAdditionsAmbience(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D)).backgroundMusic(BackgroundMusicTracks.createGameMusic(SoundEvents.MUSIC_BIOME_BASALT_DELTAS)).build()).mobSpawnSettings(mobspawninfo).generationSettings(biomegenerationsettings$builder.build()).build();

    }
}
