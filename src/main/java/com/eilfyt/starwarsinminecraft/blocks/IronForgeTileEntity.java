package com.eilfyt.starwarsinminecraft.blocks;

import com.eilfyt.starwarsinminecraft.init.TileEntityInit;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;

public class IronForgeTileEntity extends TileEntity {

    public IronForgeTileEntity() {
        super(TileEntityInit.IRON_FORGE_TE.get());
    }

    @Override
    public CompoundNBT save(CompoundNBT p_189515_1_) {
        return super.save(p_189515_1_);
    }

    @Override
    public void load(BlockState p_230337_1_, CompoundNBT p_230337_2_) {
        super.load(p_230337_1_, p_230337_2_);
    }


}
