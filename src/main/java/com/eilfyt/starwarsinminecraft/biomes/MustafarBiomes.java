package com.eilfyt.starwarsinminecraft.biomes;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

public class MustafarBiomes {
    public static final RegistryKey<Biome> MUSTAFAR_BIOME = makeKey("plains");

    private static RegistryKey<Biome> makeKey(String name) {
        return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, StarWarsInMinecraft.prefix(name));
    }
    public static final BiomeDictionary.Type STARWARS = BiomeDictionary.Type.getType("STARWARS");

    public static void addBiomeTypes() {
        BiomeDictionary.addTypes(MUSTAFAR_BIOME, STARWARS, BiomeDictionary.Type.NETHER);









    }
}
