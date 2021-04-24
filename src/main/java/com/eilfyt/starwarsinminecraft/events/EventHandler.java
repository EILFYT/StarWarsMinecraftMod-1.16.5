package com.eilfyt.starwarsinminecraft.events;

import com.eilfyt.starwarsinminecraft.items.MagmaArmor;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EventHandler {

    @SubscribeEvent
    public static void magmaArmor(TickEvent.PlayerTickEvent playerTickEvent) {
        for (ItemStack armor : playerTickEvent.player.inventory.armor) {
            if (!armor.isEmpty() && armor.getItem() instanceof MagmaArmor) {
                playerTickEvent.player.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 2, 0));
            }
        }
    }

    @SubscribeEvent
    public static void noFallDamageForYou(LivingFallEvent fallEvent) {
            fallEvent.setDamageMultiplier(0f);
    }
}
