 package com.eilfyt.starwarsinminecraft.biomes;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.google.common.collect.ImmutableList;
import net.minecraft.potion.Effect;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

 public class Biomes {
     public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, StarWarsInMinecraft.MOD_ID);

     private static final RegistryObject<Biome> HOTH = BIOMES.register("hoth", BiomeMaker::makeIceierSpikesBiome);
     private static final RegistryKey<Biome> HOTHKEY = RegistryKey.getOrCreateKey(
             Registry.BIOME_KEY, new ResourceLocation(StarWarsInMinecraft.MOD_ID, "hoth"));

     public static void biomeLoading(BiomeLoadingEvent event) {
         if (event.getName() == HOTHKEY.getRegistryName()) {
             BiomeManager.addBiome(BiomeManager.BiomeType.COOL,
                     new BiomeManager.BiomeEntry(HOTHKEY, 30));
         }
     }}