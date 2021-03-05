package com.eilfyt.starwarsinminecraft.effects;

import com.eilfyt.starwarsinminecraft.init.DamageSourceInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class KeelEveryoneEffect extends Effect {
    public KeelEveryoneEffect() {
        super(EffectType.BENEFICIAL, 16262179);
    }

    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        entityLivingBaseIn.attackEntityFrom(DamageSourceInit.KEELED, 1000000.0f);
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }
}
