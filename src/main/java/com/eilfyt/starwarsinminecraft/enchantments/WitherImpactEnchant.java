package com.eilfyt.starwarsinminecraft.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.world.Explosion;

public class WitherImpactEnchant extends Enchantment {
    public WitherImpactEnchant(Rarity rarity) {
        super(rarity, EnchantmentType.WEAPON, new EquipmentSlotType[] {EquipmentSlotType.MAINHAND});

    }

    @Override
    public void onUserHurt(LivingEntity user, Entity attacker, int level) {
        user.getEntityWorld().createExplosion(
                user, user.getPosX(), user.getPosY(), user.getPosZ(), 5, Explosion.Mode.NONE);
        super.onUserHurt(user, attacker, level);
    }
}
