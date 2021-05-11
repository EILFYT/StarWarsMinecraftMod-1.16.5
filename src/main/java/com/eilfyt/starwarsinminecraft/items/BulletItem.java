package com.eilfyt.starwarsinminecraft.items;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.entities.BulletEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BulletItem extends Item {
    public BulletItem() {
        super(new Item.Properties().tab(StarWarsInMinecraft.TAB));

    }

    public AbstractArrowEntity createArrow(World p_200887_1_, LivingEntity e) {
        BulletEntity arrowentity = new BulletEntity(p_200887_1_, e);
        return arrowentity;
    }
}