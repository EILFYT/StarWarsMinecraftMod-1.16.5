package com.eilfyt.starwarsinminecraft.items;

import com.eilfyt.starwarsinminecraft.lists.SoundList;
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
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class Hyperion extends SwordItem {
    public Hyperion() {
        super(ModItemTier.NECRON_BLADE, 48, 1000f, new Item.Properties().group(StarWarsInMinecraft.SB_TAB));

    }

    int extraRadius = 0;


    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        Vector3d vec3d = Hyperion.rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.NONE).getHitVec();
        playerIn.setPosition(vec3d.x, vec3d.y, vec3d.z);
        playerIn.getEntityWorld().createExplosion(
                playerIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), 5, Explosion.Mode.NONE);
        playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 3000, 1));

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
    protected static BlockRayTraceResult rayTrace(World worldIn, PlayerEntity player, RayTraceContext.FluidMode fluidMode) {
        double range = 10;

        float f = player.rotationPitch;
        float f1 = player.rotationYaw;
        Vector3d vector3d = player.getEyePosition(1.0F);
        float f2 = MathHelper.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f3 = MathHelper.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f4 = -MathHelper.cos(-f * ((float)Math.PI / 180F));
        float f5 = MathHelper.sin(-f * ((float)Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        Vector3d vector3d1 = vector3d.add((double)f6 * range, (double)f5 * range, (double)f7 * range);
        return worldIn.rayTraceBlocks(new RayTraceContext(vector3d, vector3d1, RayTraceContext.BlockMode.OUTLINE, fluidMode, player));
    }
}
