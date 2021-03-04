package com.eilfyt.starwarsinminecraft.events;

import com.eilfyt.starwarsinminecraft.armor.ModArmorMaterial;
import com.eilfyt.starwarsinminecraft.items.MagmaArmor;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potions;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;
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
