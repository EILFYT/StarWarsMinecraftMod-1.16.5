package com.neonfish.starwarsinminecraft.blocks;

import com.neonfish.starwarsinminecraft.entities.RipEntity;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class RipPc extends Block {
    public static final BooleanProperty UNSTABLE = BlockStateProperties.UNSTABLE;

    public RipPc() {
        super(AbstractBlock.Properties.create(Material.TNT).zeroHardnessAndResistance().sound(SoundType.PLANT));
        this.setDefaultState(this.getDefaultState().with(UNSTABLE, Boolean.valueOf(false)));
    }

    public void catchFire(BlockState state, World world, BlockPos pos, @Nullable net.minecraft.util.Direction face, @Nullable LivingEntity igniter) {
        explode(world, pos, igniter);
    }

    public void onExplosionDestroy(World worldIn, BlockPos pos, Explosion explosionIn) {
        if (!worldIn.isRemote) {
            RipEntity ripEntity = new RipEntity(worldIn, (double) pos.getX() + 0.5D, (double) pos.getY(), (double) pos.getZ() + 0.5D, explosionIn.getExplosivePlacedBy());
            ripEntity.setFuse((short) (worldIn.rand.nextInt(ripEntity.getFuse() / 4) + ripEntity.getFuse() / 8));
            worldIn.addEntity(ripEntity);
        }
    }

    public static void explode(World world, BlockPos worldIn) {
        explode(world, worldIn, (LivingEntity) null);
    }

    private static void explode(World worldIn, BlockPos pos, @Nullable LivingEntity entityIn) {
        if (!worldIn.isRemote) {
            RipEntity tntentity = new RipEntity(worldIn, (double) pos.getX() + 0.5D, (double) pos.getY(), (double) pos.getZ() + 0.5D, entityIn);
            worldIn.addEntity(tntentity);
            worldIn.playSound((PlayerEntity) null, tntentity.getPosX(), tntentity.getPosY(), tntentity.getPosZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack itemstack = player.getHeldItem(handIn);
        Item item = itemstack.getItem();
        if (item != Items.FLINT_AND_STEEL && item != Items.FIRE_CHARGE) {
            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
        } else {
            catchFire(state, worldIn, pos, hit.getFace(), player);
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 11);
            if (!player.isCreative()) {
                if (item == Items.FLINT_AND_STEEL) {
                    itemstack.damageItem(1, player, (player1) -> {
                        player1.sendBreakAnimation(handIn);
                    });
                } else {
                    itemstack.shrink(1);
                }
            }
            return ActionResultType.func_233537_a_(worldIn.isRemote);
        }
    }
    public void onProjectileCollision(World worldIn, BlockState state, BlockRayTraceResult hit, ProjectileEntity projectile) {
        if (!worldIn.isRemote) {
            Entity entity = projectile.func_234616_v_();
            if (projectile.isBurning()) {
                BlockPos blockpos = hit.getPos();
                catchFire(state, worldIn, blockpos, null, entity instanceof LivingEntity ? (LivingEntity)entity : null);
                worldIn.removeBlock(blockpos, false);
            }
        }

    }

    public boolean canDropFromExplosion(Explosion explosionIn) {
        return false;
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(UNSTABLE);
    }
}