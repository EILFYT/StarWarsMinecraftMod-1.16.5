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

public class VerticalKyberSlabBlock extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Block.makeCuboidShape(0, 0, 0, 16, 16, 8);
    public static final VoxelShape SHAPE_E = Block.makeCuboidShape(8, 0, 0, 16, 16, 16);
    public static final VoxelShape SHAPE_S = Block.makeCuboidShape(0, 0, 8, 16, 16, 16);
    public static final VoxelShape SHAPE_W = Block.makeCuboidShape(0, 0, 0, 8, 16, 16);
    public VerticalKyberSlabBlock() {
        super(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(40.0f,1200.0f)
                .sound(SoundType.METAL)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
        );

    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)){
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
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.7f;
    }



}