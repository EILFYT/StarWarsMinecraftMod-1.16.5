package com.eilfyt.starwarsinminecraft.events;

import com.eilfyt.starwarsinminecraft.items.MagmaArmor;
import com.eilfyt.starwarsinminecraft.items.RodOfDiscord;
import com.eilfyt.starwarsinminecraft.util.RegistryHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.world.NoteBlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EventHandler {

    @SubscribeEvent
    public static void magmaArmor(TickEvent.PlayerTickEvent playerTickEvent) {
        for (ItemStack armor : playerTickEvent.player.inventory.armorInventory) {
            if (!armor.isEmpty() && armor.getItem() instanceof MagmaArmor) {
              playerTickEvent.player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 2, 0));
            }
        }
    }

    @SubscribeEvent
    public static void noFallDamageForYou(LivingFallEvent fallEvent) {
            fallEvent.setDamageMultiplier(0f);
    }
}
