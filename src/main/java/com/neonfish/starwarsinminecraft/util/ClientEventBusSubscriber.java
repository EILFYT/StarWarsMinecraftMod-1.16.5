package com.neonfish.starwarsinminecraft.util;

import com.neonfish.starwarsinminecraft.StarWarsInMinecraft;
import com.neonfish.starwarsinminecraft.client.render.PorgRenderer;
import com.neonfish.starwarsinminecraft.init.ModEntityTypes;
import com.neonfish.starwarsinminecraft.items.ModSpawnEggItem;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = StarWarsInMinecraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLCommonSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PORG.get(), PorgRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }
}