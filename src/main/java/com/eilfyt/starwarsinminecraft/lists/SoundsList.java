package com.eilfyt.starwarsinminecraft.lists;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.client.audio.Sound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.swing.*;

public class SoundsList {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,
            StarWarsInMinecraft.MOD_ID);
    public static final RegistryObject<SoundEvent> ROD_TP = SOUNDS.register("item.rod_of_discord", () ->
            new SoundEvent(new ResourceLocation(StarWarsInMinecraft.MOD_ID, "item.rod_of_discord")));
}
