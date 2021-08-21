package com.eilfyt.starwarsinminecraft.util;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.blocks.ForgeContainer;
import com.eilfyt.starwarsinminecraft.blocks.ForgeScreen;
import com.eilfyt.starwarsinminecraft.client.render.BulletRenderer;
import com.eilfyt.starwarsinminecraft.client.render.DragonArcherRenderer;
import com.eilfyt.starwarsinminecraft.client.render.PorgRenderer;
import com.eilfyt.starwarsinminecraft.init.ContainerInit;
import com.eilfyt.starwarsinminecraft.init.ModEntityTypes;
import com.eilfyt.starwarsinminecraft.items.ModSpawnEggItem;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = StarWarsInMinecraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

        @SubscribeEvent
        public static void onStaticClientSetup(FMLClientSetupEvent event) {
            event.setPhase(EventPriority.HIGH);
            RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BULLET.get(), BulletRenderer::new);
            RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PORG.get(), PorgRenderer::new);
            RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DRAGON_ARCHER.get(), DragonArcherRenderer::new);
        }
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ScreenManager.register(ContainerInit.FORGE.get(), ForgeScreen::new);
    }
    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }
}