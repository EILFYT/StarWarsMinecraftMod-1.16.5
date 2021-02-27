package com.eilfyt.starwarsinminecraft.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class DragonSoulFragment extends Block {

    public DragonSoulFragment() {
        super(Block.Properties
                .create(Material.ROCK, MaterialColor.SAND)
                .setRequiresTool()
                .hardnessAndResistance(3.0F, 9.0F));
    }
}
