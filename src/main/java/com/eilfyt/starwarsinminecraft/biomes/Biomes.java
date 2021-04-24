 package com.eilfyt.starwarsinminecraft.biomes;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

 public class Biomes {
     public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, StarWarsInMinecraft.MOD_ID);

     public static final RegistryObject<Biome> HOTH = BIOMES.register("iceier_spikes", () -> BiomeMaker.makeIceierSpikesBiome());
     public static final RegistryKey<Biome> HOTHKEY = RegistryKey.create(
             Registry.BIOME_REGISTRY, new ResourceLocation(StarWarsInMinecraft.MOD_ID, "iceier_spikes"));
     public static final RegistryObject<Biome> MUSTAFARBIOME = BIOMES.register("mustafar_biome", () -> BiomeMaker.makeBasaltierDeltasBiome());
     public static final RegistryKey<Biome> MUSTAFARKEY = RegistryKey.create(
             Registry.BIOME_REGISTRY, new ResourceLocation(StarWarsInMinecraft.MOD_ID, "mustafar_biome"));

     @SubscribeEvent
     public static void biomeLoading(BiomeLoadingEvent event) {
         if (event.getName() == HOTHKEY.getRegistryName()) {
             BiomeManager.addBiome(BiomeManager.BiomeType.COOL,
                     new BiomeManager.BiomeEntry(HOTHKEY, 30));
         }
         if (event.getName() == MUSTAFARKEY.getRegistryName()) {
             BiomeManager.addBiome(BiomeManager.BiomeType.WARM,
                     new BiomeManager.BiomeEntry(MUSTAFARKEY, 30));
   }
     }}
