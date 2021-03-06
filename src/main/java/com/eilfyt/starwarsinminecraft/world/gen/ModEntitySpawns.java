package com.eilfyt.starwarsinminecraft.world.gen;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.init.ModEntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = StarWarsInMinecraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEntitySpawns {

    @SubscribeEvent
    public static void onBiomeLoading(BiomeLoadingEvent e) {
        e.getSpawns().addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(ModEntityTypes.PORG.get(), 20, 5, 5));
    if (e.getCategory() != Biome.Category.THEEND && e.getCategory() != Biome.Category.OCEAN && e.getCategory() != Biome.Category.RIVER) {
        e.getSpawns().addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(ModEntityTypes.PORG.get(), 21, 5, 5));

        }
    }
}
