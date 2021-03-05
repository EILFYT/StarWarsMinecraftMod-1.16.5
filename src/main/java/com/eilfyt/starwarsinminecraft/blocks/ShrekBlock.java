package com.eilfyt.starwarsinminecraft.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;

public class ShrekBlock extends Block {
    public ShrekBlock() {
        super(Block.Properties.create(Material.IRON)
                .sound(SoundType.BAMBOO)
                .jumpFactor(2.0f)
                .zeroHardnessAndResistance()

                .slipperiness(0.01f)
        );
    }
}

