package com.eilfyt.starwarsinminecraft.effects;

import com.eilfyt.starwarsinminecraft.init.DamageSourceInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class KillEffect extends Effect {
    public KillEffect() {
        super(EffectType.BENEFICIAL, 16262179);
    }

    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        entityLivingBaseIn.hurt(DamageSourceInit.KILL, 1000000.0f);
    }



    public boolean isReady(int duration, int amplifier) {
        return true;
    }
}
