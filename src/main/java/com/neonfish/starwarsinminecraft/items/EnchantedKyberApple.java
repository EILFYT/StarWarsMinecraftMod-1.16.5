package com.neonfish.starwarsinminecraft.items;

import com.neonfish.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.item.EnchantedGoldenAppleItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class EnchantedKyberApple extends EnchantedGoldenAppleItem {

    public EnchantedKyberApple() {
        super(new Item.Properties().group(StarWarsInMinecraft.TAB)
                .food(new Food.Builder()
                        .hunger(5)
                        .saturation(2.0f)
                        .effect(new EffectInstance(Effects.ABSORPTION, 12000, 6),1.0f)
                        .effect(new EffectInstance(Effects.REGENERATION, 3000, 6), 1.0f)
                        .effect(new EffectInstance(Effects.RESISTANCE, 3000, 2), 1.0f)
                        .effect(new EffectInstance(Effects.FIRE_RESISTANCE, 3000, 2), 1.0f)
                        .effect(new EffectInstance(Effects.REGENERATION, 12000, 19), 0.2f)
                        .effect(new EffectInstance(Effects.SPEED, 12000, 2), 1.0f)
                        .setAlwaysEdible()
                        .build()
                )




        );
    }
}
