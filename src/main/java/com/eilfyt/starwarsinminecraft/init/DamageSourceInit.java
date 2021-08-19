package com.eilfyt.starwarsinminecraft.init;

import net.minecraft.util.DamageSource;

public class DamageSourceInit {
    public static DamageSource KILL = (new DamageSource("keel")).bypassInvul().bypassArmor();
    public static DamageSource SUGAR_RUSH = (new DamageSource("sugar_rush")).bypassInvul().bypassArmor();
}
