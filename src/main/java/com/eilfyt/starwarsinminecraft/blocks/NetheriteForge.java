package com.eilfyt.starwarsinminecraft.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import java.util.stream.Stream;

public class NetheriteForge extends Block {
    public NetheriteForge() {
        super(AbstractBlock.Properties.of(Material.STONE)
                .strength(14f, 1200f)
                .sound(SoundType.METAL)
                .harvestLevel(4)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops());
    }

    private static final DirectionProperty FACING = HorizontalBlock.FACING;

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.box(0, 0, 0, 16, 1, 16),
            Block.box(1, 1, 1, 15, 2, 15),
            Block.box(1, 1, 15, 15, 3, 16),
            Block.box(1, 1, 0, 15, 3, 1),
            Block.box(0, 1, 0, 1, 3, 16),
            Block.box(15, 1, 0, 16, 3, 16),
            Block.box(15, 11, 7, 16, 12, 9),
            Block.box(14, 10, 7, 15, 12, 9),
            Block.box(13, 10, 6, 14, 12, 10),
            Block.box(1, 10, 7, 2, 11, 9),
            Block.box(2, 10, 6, 3, 11, 10),
            Block.box(3, 9, 6, 4, 11, 10),
            Block.box(12, 9, 6, 13, 12, 10),
            Block.box(4, 9, 5, 12, 12, 11),
            Block.box(6, 8, 6, 10, 9, 10),
            Block.box(7, 7, 7, 9, 8, 9),
            Block.box(6, 6, 6, 10, 7, 10),
            Block.box(5, 5, 6, 11, 6, 10)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    public static final VoxelShape SHAPE_E =Stream.of(
            Block.box(0, 0, 0, 16, 1, 16),
            Block.box(1, 1, 1, 15, 2, 15),
            Block.box(15, 1, 1, 16, 3, 15),
            Block.box(0, 1, 1, 1, 3, 15),
            Block.box(0, 1, 15, 16, 3, 16),
            Block.box(0, 1, 0, 16, 3, 1),
            Block.box(7, 11, 0, 9, 12, 1),
            Block.box(7, 10, 1, 9, 12, 2),
            Block.box(6, 10, 2, 10, 12, 3),
            Block.box(7, 10, 14, 9, 11, 15),
            Block.box(6, 10, 13, 10, 11, 14),
            Block.box(6, 9, 12, 10, 11, 13),
            Block.box(6, 9, 3, 10, 12, 4),
            Block.box(5, 9, 4, 11, 12, 12),
            Block.box(6, 8, 6, 10, 9, 10),
            Block.box(7, 7, 7, 9, 8, 9),
            Block.box(6, 6, 6, 10, 7, 10), Block.box(6, 5, 5, 10, 6, 11)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    public static final VoxelShape SHAPE_N = Stream.of(
            Block.box(0, 0, 0, 16, 1, 16),
            Block.box(1, 1, 1, 15, 2, 15),
            Block.box(1, 1, 0, 15, 3, 1),
            Block.box(1, 1, 15, 15, 3, 16), Block.box(15, 1, 0, 16, 3, 16),
            Block.box(0, 1, 0, 1, 3, 16),
            Block.box(0, 11, 7, 1, 12, 9), Block.box(1, 10, 7, 2, 12, 9), Block.box(2, 10, 6, 3, 12, 10),
            Block.box(14, 10, 7, 15, 11, 9),Block.box(13, 10, 6, 14, 11, 10), Block.box(12, 9, 6, 13, 11, 10),
            Block.box(3, 9, 6, 4, 12, 10),
            Block.box(4, 9, 5, 12, 12, 11),
            Block.box(6, 8, 6, 10, 9, 10),
            Block.box(7, 7, 7, 9, 8, 9),
            Block.box(6, 6, 6, 10, 7, 10),
            Block.box(5, 5, 6, 11, 6, 10)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    public static final VoxelShape SHAPE_W =Stream.of(
            Block.box(0, 0, 0, 16, 1, 16),
            Block.box(1, 1, 1, 15, 2, 15),
            Block.box(0, 1, 1, 1, 3, 15), Block.box(15, 1, 1, 16, 3, 15), Block.box(0, 1, 0, 16, 3, 1), Block.box(0, 1, 15, 16, 3, 16),
            Block.box(7, 11, 15, 9, 12, 16), Block.box(7, 10, 14, 9, 12, 15), Block.box(6, 10, 13, 10, 12, 14), Block.box(7, 10, 1, 9, 11, 2), Block.box(6, 10, 2, 10, 11, 3), Block.box(6, 9, 3, 10, 11, 4), Block.box(6, 9, 12, 10, 12, 13), Block.box(5, 9, 4, 11, 12, 12), Block.box(6, 8, 6, 10, 9, 10), Block.box(7, 7, 7, 9, 8, 9), Block.box(6, 6, 6, 10, 7, 10), Block.box(6, 5, 5, 10, 6, 11)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();


    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.getValue(FACING)){
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
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
