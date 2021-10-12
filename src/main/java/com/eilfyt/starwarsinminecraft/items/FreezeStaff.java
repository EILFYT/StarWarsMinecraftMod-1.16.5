package com.eilfyt.starwarsinminecraft.items;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.entities.IceBallEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class FreezeStaff extends Item {
    public FreezeStaff() {
        super(new Item.Properties().tab(StarWarsInMinecraft.TAB).stacksTo(1).fireResistant());
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        Vector3d vector3d = p_77659_2_.getViewVector(0.0F);
        Vector3d eyePosition = p_77659_2_.getEyePosition(0);
        Vector3d traceEnd = eyePosition.add(vector3d.x * 5, vector3d.y * 5, vector3d.z * 5);
        double d2 = vector3d.x * 4.0D;
        double d3 = traceEnd.y() - (0.5D + p_77659_2_.getY(0.5D));
        double d4 = vector3d.z * 4.0D;
        IceBallEntity fbEntity = new IceBallEntity(p_77659_1_, p_77659_2_, d2, d3, d4);
        p_77659_1_.addFreshEntity(fbEntity);
        return ActionResult.consume(p_77659_2_.getItemInHand(p_77659_3_));
    }
}
