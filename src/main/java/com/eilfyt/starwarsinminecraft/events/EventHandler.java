package com.eilfyt.starwarsinminecraft.events;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.entities.DragonArcherEntity;
import com.eilfyt.starwarsinminecraft.entities.PorgEntity;
import com.eilfyt.starwarsinminecraft.init.ModEntityTypes;
import com.eilfyt.starwarsinminecraft.items.MagmaArmor;
import com.eilfyt.starwarsinminecraft.util.RegistryHandler;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EnderCrystalRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.EnderCrystalEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.ForgeWorldType;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Level;
import org.spongepowered.asm.mixin.MixinEnvironment;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.logging.Logger;

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

static PriorityQueue<BlockPos> priorityQueue = new PriorityQueue<>();

//&d&lCRAZY RARE DROP! &r&7(&6Judgement Core&7) &b(+200% Magic Find!)
@SubscribeEvent
public static void worldLoad(EntityJoinWorldEvent e) {
   World world = e.getWorld();
    Entity entity = e.getEntity();
       if (entity instanceof EnderCrystalEntity) {
           StarWarsInMinecraft.LOGGER.log(Level.DEBUG, entity);
           priorityQueue.add(entity.blockPosition());

       }
    }
    @SubscribeEvent
    public static void worldTick(TickEvent.WorldTickEvent event) {
        World world = event.world;
        if (priorityQueue.size() >= 1) {
        DragonArcherEntity dragonarcherentity = ModEntityTypes.DRAGON_ARCHER.get().create(world);
            dragonarcherentity.moveTo(Vector3d.atCenterOf(priorityQueue.element()));
            dragonarcherentity.setItemSlot(EquipmentSlotType.MAINHAND, RegistryHandler.DRAGON_SOUL_BOW.get().getDefaultInstance());

            event.world.addFreshEntity(dragonarcherentity);
            StarWarsInMinecraft.LOGGER.log(Level.DEBUG, dragonarcherentity);
            priorityQueue.remove();

        }
    }
}


