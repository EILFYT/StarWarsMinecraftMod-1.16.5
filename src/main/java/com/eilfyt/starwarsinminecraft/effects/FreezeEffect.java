package com.eilfyt.starwarsinminecraft.effects;

import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;

public class FreezeEffect extends Effect {
    public FreezeEffect() {
        super(EffectType.HARMFUL, 0xADFFF6);
        addAttributeModifier(Attributes.MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", (double) -1F, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }
}
