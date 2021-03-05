package com.neonfish.starwarsinminecraft.init;

import net.minecraft.util.DamageSource;

public class DamageSourceInit {
    public static DamageSource KEELED = (new DamageSource("keel")).setDamageAllowedInCreativeMode().setDamageIsAbsolute().setDamageBypassesArmor();
    public static DamageSource SUGAR_RUSH = (new DamageSource("sugar_rush")).setDamageAllowedInCreativeMode().setDamageIsAbsolute();
}
