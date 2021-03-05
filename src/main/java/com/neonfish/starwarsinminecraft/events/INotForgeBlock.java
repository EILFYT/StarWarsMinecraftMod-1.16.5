package com.neonfish.starwarsinminecraft.events;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public interface INotForgeBlock {
    default BlockState getBlockState()
    {
        return (BlockState)this;
    }
    static boolean isPortalFrame(BlockState state, IBlockReader world, BlockPos pos)
    {
        return state.isIn(Blocks.BLACKSTONE);
    }
    default boolean isPortalFrame(IBlockReader world, BlockPos pos)
    {
        return INotForgeBlock.isPortalFrame(getBlockState(), world, pos);
    }
}
