package com.eilfyt.starwarsinminecraft.world.gen;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.init.ModEntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = StarWarsInMinecraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEntitySpawns {

    @SubscribeEvent
    public static void onBiomeLoading(BiomeLoadingEvent e) {
    if (e.getCategory() != Biome.Category.THEEND && e.getCategory() != Biome.Category.NETHER) {
        e.getSpawns().addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(ModEntityTypes.PORG.get(), 3, 1, 2));

        }
        if (e.getCategory() == Biome.Category.THEEND) {
            e.getSpawns().addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(ModEntityTypes.DRAGON_ARCHER.get(), 20, 5, 10));
        }
    }
}
