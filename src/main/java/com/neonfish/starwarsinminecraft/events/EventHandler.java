package com.neonfish.starwarsinminecraft.events;

import com.neonfish.starwarsinminecraft.items.MagmaArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EventHandler {

    @SubscribeEvent
    public static void MagmaArmor(TickEvent.PlayerTickEvent playerTickEvent) {
        int modifier = 0;
        for (ItemStack armor : playerTickEvent.player.inventory.armorInventory) {
            if (!armor.isEmpty() && armor.getItem() instanceof MagmaArmor) {
              playerTickEvent.player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 2, 0));
            }
        }
    }
}
