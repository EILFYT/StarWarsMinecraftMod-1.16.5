package com.eilfyt.starwarsinminecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class DragonSoulFragment extends Block {

    public DragonSoulFragment() {
        super(Block.Properties
                .of(Material.STONE, MaterialColor.SAND)
                .requiresCorrectToolForDrops()
                .strength(3.0F, 9.0F));
    }
}
