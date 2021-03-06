package com.eilfyt.starwarsinminecraft.items;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.init.EffectRegister;
import com.eilfyt.starwarsinminecraft.util.RegistryHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;


public class SugarFunnel extends Item {

    public SugarFunnel() {
        super(new Item.Properties().stacksTo(1).tab(StarWarsInMinecraft.TAB)
                .food(new Food.Builder()
                        .nutrition(20)
                        .saturationMod(200.0f)
                        .effect(() -> new EffectInstance(Effects.MOVEMENT_SPEED, 1200, 9), 1f)
                        .effect(() -> new EffectInstance(EffectRegister.SUGAR_RUSH.get(), 10, 0), .1f)
                        .alwaysEat()
                        .fast()
                        .build()
                ));}
    public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        ItemStack itemstack = super.finishUsingItem(stack, worldIn, entityLiving);

        return entityLiving instanceof PlayerEntity && ((PlayerEntity)entityLiving).abilities.invulnerable ? itemstack : new ItemStack(RegistryHandler.FUNNEL.get());
    }
}

