package com.eilfyt.starwarsinminecraft.effects;

import com.eilfyt.starwarsinminecraft.init.DamageSourceInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class SugarRushEffect extends Effect {
    public SugarRushEffect() {
        super(EffectType.HARMFUL, 000000);
    }

    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        entityLivingBaseIn.attackEntityFrom(DamageSourceInit.SUGAR_RUSH, 1000000.0f);
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }
}
