package com.eilfyt.starwarsinminecraft.events;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public interface INotForgeBlock {
    default BlockState getBlockState()
    {
        return (BlockState)this;
    }
    default boolean isePortalFrame(BlockState state, IBlockReader world, BlockPos pos)
    {
        return state.isIn(Blocks.BLACKSTONE);
    }
    default boolean isPortalFrame(IBlockReader world, BlockPos pos)
    {
        return getBlockState().getBlock().isPortalFrame(getBlockState(), world, pos);
    }
}
