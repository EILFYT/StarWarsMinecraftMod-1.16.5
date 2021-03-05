package com.eilfyt.starwarsinminecraft.items;

import com.eilfyt.starwarsinminecraft.util.MathUtils;
import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.tools.ModItemTier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class Hyperion extends SwordItem {
    public Hyperion() {
        super(ModItemTier.NECRON_BLADE, 48, 1000f, new Item.Properties().group(StarWarsInMinecraft.SB_TAB));

    }

    int extraRadius = 0;


    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.getEntityWorld().createExplosion(
                playerIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), 5, Explosion.Mode.NONE);
        playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 3000, 1));
        // playerIn.getHorizontalFacing().getAxis();
        Vector3d lookVector = playerIn.getLookVec();
        double magnitude = (10 + extraRadius) * 0.15;
        double extraPitch = 10;
        Vector3d dashVector = new Vector3d(lookVector.getX(), lookVector.getY(), lookVector.getZ());
        float initialYaw = (float) MathUtils.extractYaw(dashVector);
        dashVector = MathUtils.rotateYaw(dashVector, initialYaw);
        double dashPitch = Math.toDegrees(MathUtils.extractPitch(dashVector));
        if (dashPitch + extraPitch > 90) {
            dashVector = new Vector3d(0, 1, 0);
            dashPitch = 90;
        } else {
            dashVector = MathUtils.rotateRoll(dashVector, (float) Math.toRadians(-extraPitch));
            dashVector = MathUtils.rotateYaw(dashVector, -initialYaw);
            dashVector = dashVector.normalize();
        }
        double coef = 1.6 - MathUtils.map(Math.abs(dashPitch), 0.0d, 90.0d, 0.6, 1.0d);
        dashVector = dashVector.scale(magnitude * coef);
        playerIn.addVelocity(dashVector.getX(), dashVector.getY(), dashVector.getZ());
        playerIn.velocityChanged = true;
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
