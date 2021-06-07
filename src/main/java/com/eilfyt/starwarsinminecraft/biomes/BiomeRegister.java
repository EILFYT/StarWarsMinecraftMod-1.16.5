package com.eilfyt.starwarsinminecraft.biomes;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;

public class BiomeRegister {
    private static final Int2ObjectMap<RegistryKey<Biome>> idToKeyMap = new Int2ObjectArrayMap<>();

    private static Biome register(int id, RegistryKey<Biome> key, Biome biome) {
        idToKeyMap.put(id, key);
        return WorldGenRegistries.registerMapping(WorldGenRegistries.BIOME, id, key, biome);
    }
    public static RegistryKey<Biome> getKeyFromID(int id) {
        return ((net.minecraftforge.registries.ForgeRegistry<Biome>)net.minecraftforge.registries.ForgeRegistries.BIOMES).getKey(id);
    }
    static {
        register(174, com.eilfyt.starwarsinminecraft.biomes.Biomes.HOTHKEY, BiomeMaker.makeIceierSpikesBiome());
        register(175, Biomes.MUSTAFARKEY, BiomeMaker.makeBasaltierDeltasBiome());
    }
}
