package com.eilfyt.starwarsinminecraft.items;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.sun.javafx.geom.Vec3d;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.resources.AsyncReloader;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.server.ServerWorldLightManager;
import net.minecraft.world.storage.ServerWorldInfo;
import net.minecraftforge.event.world.NoteBlockEvent;

import java.awt.*;
import java.util.UUID;

public class NukeTargetingDevice extends Item {
    public static int e = 0;
    public static boolean ee = false;
    public NukeTargetingDevice() {
        super(new Item.Properties().tab(StarWarsInMinecraft.TAB).stacksTo(1));
    }




    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack itemStack = p_77659_2_.getItemInHand(p_77659_3_);
        if(ee=false) {
        ee=true;
        }
        if (p_77659_2_.abilities.invulnerable == true) {}
        else {
            p_77659_2_.getCooldowns().addCooldown(itemStack.getItem(), 1200);
            itemStack.setCount(0);
        }
        Vector3d vec3d = rayTrace(p_77659_1_, p_77659_2_, RayTraceContext.FluidMode.NONE).getLocation();
        p_77659_1_.explode(p_77659_2_, vec3d.x, vec3d.y, vec3d.z, 100, Explosion.Mode.BREAK);
        return super.use(p_77659_1_, p_77659_2_, p_77659_3_);
    }

    public static BlockRayTraceResult rayTrace(World worldIn, PlayerEntity player, RayTraceContext.FluidMode fluidMode) {
        double range = 200;

        float f = player.xRot;
        float f1 = player.yRot;
        Vector3d vector3d = player.getEyePosition(1.0F);
        float f2 = MathHelper.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f3 = MathHelper.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f4 = -MathHelper.cos(-f * ((float)Math.PI / 180F));
        float f5 = MathHelper.sin(-f * ((float)Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        Vector3d vector3d1 = vector3d.add((double)f6 * range, (double)f5 * range, (double)f7 * range);
        return worldIn.clip(new RayTraceContext(vector3d, vector3d1, RayTraceContext.BlockMode.OUTLINE, fluidMode, player));

    }
}
