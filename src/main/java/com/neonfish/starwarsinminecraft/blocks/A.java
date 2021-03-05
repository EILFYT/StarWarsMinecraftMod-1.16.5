package com.neonfish.starwarsinminecraft.blocks;

import com.neonfish.starwarsinminecraft.StarWarsInMinecraft;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class A extends BlockItem {
    public A(Block block) {
        super(block, new Item.Properties().group(StarWarsInMinecraft.E));
    }
}

