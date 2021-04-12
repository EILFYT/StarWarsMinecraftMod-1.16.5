package com.eilfyt.starwarsinminecraft.lists;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundList {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,
            StarWarsInMinecraft.MOD_ID);
    public static final RegistryObject<SoundEvent> ROD_TP = SOUNDS.register("rod_of_discord",
            () -> new SoundEvent(new ResourceLocation(StarWarsInMinecraft.MOD_ID, "rod_of_discord")));
}
