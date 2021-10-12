package com.eilfyt.starwarsinminecraft.util;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.init.EffectRegister;
import com.eilfyt.starwarsinminecraft.items.Lightsaber;
import com.eilfyt.starwarsinminecraft.items.NukeTargetingDevice;
import javafx.scene.effect.LightBuilder;
import javafx.scene.effect.LightingBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.Explosion;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.model.pipeline.LightUtil;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.Level;

@Mod.EventBusSubscriber
public class CommonEventBusSubscriber {
    @SubscribeEvent
    public static void testEvent(PlayerInteractEvent.LeftClickEmpty event) {
        PlayerEntity player = (PlayerEntity) event.getEntity();
        if (player.getItemInHand(Hand.MAIN_HAND) == RegistryHandler.COMMAND_BOOK.get().getDefaultInstance()) {
                Minecraft.getInstance().player.chat(player.getItemInHand(Hand.MAIN_HAND).getTag().getString("command"));
        }
    }
}
