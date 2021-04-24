package com.eilfyt.starwarsinminecraft.items;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class IceCream extends Item {

    public IceCream() {
        super(new Item.Properties().tab(StarWarsInMinecraft.TAB)
                .food(new Food.Builder()
                        .nutrition(5)
                        .saturationMod(2.0f)
                        .effect(new EffectInstance(Effects.ABSORPTION, 12000, 4),1.0f)
                        .effect(new EffectInstance(Effects.REGENERATION, 3000, 4), 1.0f)
                        .effect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 3000, 1), 1.0f)
                        .effect(new EffectInstance(Effects.FIRE_RESISTANCE, 3000, 1), 1.0f)
                        .effect(new EffectInstance(Effects.REGENERATION, 12000, 19), 0.1f)
                        .effect(new EffectInstance(Effects.MOVEMENT_SPEED, 12000, 1), 1.0f)
                        .alwaysEat()
                        .build()
                )




        );
    }
}
