package com.eilfyt.starwarsinminecraft.util;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
@ObjectHolder(StarWarsInMinecraft.MOD_ID)
@Mod.EventBusSubscriber(modid = StarWarsInMinecraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RecipeSubscriber {
     public static final ForgeRecipeSerializer<ForgeRecipe> crusher = null;

        @SubscribeEvent
        public static void registerTileEntity(RegistryEvent.Register<IRecipeSerializer<?>> event) {
            IForgeRegistry<IRecipeSerializer<?>> registry = event.getRegistry();
            registry.register(new ForgeRecipeSerializer<>(ForgeRecipe::new).setRegistryName(StarWarsInMinecraft.MOD_ID, "forge"));
        }
    }

