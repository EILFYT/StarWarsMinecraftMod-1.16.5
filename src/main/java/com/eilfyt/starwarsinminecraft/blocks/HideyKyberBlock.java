
package com.eilfyt.starwarsinminecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class HideyKyberBlock extends Block {

    public HideyKyberBlock() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(9.0f, 1200.0f)
                .sound(SoundType.METAL)
                .harvestLevel(3)
                .doesNotBlockMovement()
                .setRequiresTool()
                .harvestTool(ToolType.PICKAXE));

    }



    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof PlayerEntity) { ((PlayerEntity) entityIn).addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 2, 0)); }
        super.onEntityCollision(state, worldIn, pos, entityIn);
    }
}

