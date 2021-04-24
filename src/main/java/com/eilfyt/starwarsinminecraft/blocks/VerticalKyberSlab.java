package com.eilfyt.starwarsinminecraft.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class VerticalKyberSlab extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.FACING;

    private static final VoxelShape SHAPE_N = Block.box(0, 0, 0, 16, 16, 8);
    public static final VoxelShape SHAPE_E = Block.box(8, 0, 0, 16, 16, 16);
    public static final VoxelShape SHAPE_S = Block.box(0, 0, 8, 16, 16, 16);
    public static final VoxelShape SHAPE_W = Block.box(0, 0, 0, 8, 16, 16);
    public VerticalKyberSlab() {
        super(AbstractBlock.Properties.of(Material.STONE)
                .strength(40f, 1200f)
                .sound(SoundType.METAL)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE));
    }



    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.getValue(FACING)){
            case NORTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_W;
            case SOUTH:
                return SHAPE_N;
            case WEST:
                return SHAPE_E;
            default:
                return SHAPE_S;
        }
    }


    @Override
    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        return this.defaultBlockState().setValue(FACING, p_196258_1_.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public float getShadeBrightness(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.7f;
    }



}