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

public class KyberForge extends ForgeBlock {
    public KyberForge() {
        super(AbstractBlock.Properties.of(Material.STONE)
                .strength(18f, 1200f)
                .sound(SoundType.METAL)
                .harvestLevel(5)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops());
    }

}
