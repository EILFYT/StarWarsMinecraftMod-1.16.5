package com.eilfyt.starwarsinminecraft.util;

import com.eilfyt.starwarsinminecraft.entities.StormTrooperEntity;
import com.eilfyt.starwarsinminecraft.init.ModEntityTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CommonEventBusSubscriber {
    @SubscribeEvent
    public static void ee(EntityJoinWorldEvent e) {
        Entity eee = e.getEntity();
        if(eee instanceof StormTrooperEntity) {
            eee.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(RegistryHandler.BLASTER.get()));
        }
    }
}
