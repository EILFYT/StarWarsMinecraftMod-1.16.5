package com.eilfyt.starwarsinminecraft.biomes;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class Features {
    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ICE_TREEE = register("ice_tree", Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.ICE.defaultBlockState()), new SimpleBlockStateProvider(Blocks.BLUE_ICE.defaultBlockState()), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> LAVA_TREE = register("lava_tree", Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.BLACKSTONE.defaultBlockState()), new SimpleBlockStateProvider(Blocks.MAGMA_BLOCK.defaultBlockState()), new BlobFoliagePlacer(FeatureSpread.fixed(3), FeatureSpread.fixed(1), 4), new StraightTrunkPlacer(6, 3, 1), new TwoLayerFeature(3, 3, 2))).ignoreVines().build()));
}
