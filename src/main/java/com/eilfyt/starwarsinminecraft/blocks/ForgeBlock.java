package com.eilfyt.starwarsinminecraft.blocks;

import com.eilfyt.starwarsinminecraft.util.RegistryHandler;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.tileentity.ShulkerBoxTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Stream;

public class ForgeBlock extends Block {
    public static final IntegerProperty LAVA_LEVEL = IntegerProperty.create("lava_level", 0, 3);
    public ForgeBlock(AbstractBlock.Properties p_i48440_1_) {
        super(p_i48440_1_);
        this.registerDefaultState(this.stateDefinition.any().setValue(LAVA_LEVEL, 0));
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
        builder.add(LAVA_LEVEL);
    }

    @Override
    public float getShadeBrightness(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.7f;
    }

    @Override
    public ActionResultType use(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        if (p_225533_2_.isClientSide) {
            return ActionResultType.SUCCESS;
        }
        if (p_225533_4_.getItemInHand(p_225533_5_).getItem() == RegistryHandler.BLUE_LAVA_BUCKET.get()) {
            if (p_225533_1_.getValue(LAVA_LEVEL) == 2) {
                return super.use(p_225533_1_, p_225533_2_, p_225533_3_, p_225533_4_, p_225533_5_, p_225533_6_);
            } else if (p_225533_1_.getValue(LAVA_LEVEL) == 1) {
                BlockState blockstate = p_225533_1_.setValue(LAVA_LEVEL, 2);
            p_225533_2_.setBlock(p_225533_3_, blockstate, 2);
            p_225533_4_.setItemInHand(p_225533_5_, Items.LAVA_BUCKET.getDefaultInstance());
            return super.use(p_225533_1_, p_225533_2_, p_225533_3_, p_225533_4_, p_225533_5_, p_225533_6_);
        }

                BlockState blockstate = p_225533_1_.setValue(LAVA_LEVEL, 2);
                    p_225533_2_.setBlock(p_225533_3_, blockstate, 2);
                    p_225533_4_.setItemInHand(p_225533_5_, Items.BUCKET.getDefaultInstance());
                    return ActionResultType.CONSUME;

        } else if (p_225533_4_.getItemInHand(p_225533_5_).getItem() == Items.LAVA_BUCKET) {
            if (p_225533_1_.getValue(LAVA_LEVEL) == 1) {
                return super.use(p_225533_1_, p_225533_2_, p_225533_3_, p_225533_4_, p_225533_5_, p_225533_6_);
            } else if (p_225533_1_.getValue(LAVA_LEVEL) == 2) {            BlockState blockstate = p_225533_1_.setValue(LAVA_LEVEL, 1);
                p_225533_2_.setBlock(p_225533_3_, blockstate, 1);
                p_225533_4_.setItemInHand(p_225533_5_, RegistryHandler.BLUE_LAVA_BUCKET.get().getDefaultInstance());
                return super.use(p_225533_1_, p_225533_2_, p_225533_3_, p_225533_4_, p_225533_5_, p_225533_6_);
            }
            BlockState blockstate = p_225533_1_.setValue(LAVA_LEVEL, 1);
            p_225533_2_.setBlock(p_225533_3_, blockstate, 1);
            p_225533_4_.setItemInHand(p_225533_5_, Items.BUCKET.getDefaultInstance());
            return ActionResultType.CONSUME;
        } else if (p_225533_4_.getItemInHand(p_225533_5_).getItem() == Items.BUCKET) {
            if (p_225533_1_.getValue(LAVA_LEVEL) == 2) {
                p_225533_4_.setItemInHand(p_225533_5_, RegistryHandler.BLUE_LAVA_BUCKET.get().getDefaultInstance());
                BlockState blockstate = p_225533_1_.setValue(LAVA_LEVEL, 0);
                p_225533_2_.setBlock(p_225533_3_, blockstate, 0);
            } else if (p_225533_1_.getValue(LAVA_LEVEL) == 1) {
                p_225533_4_.setItemInHand(p_225533_5_, Items.LAVA_BUCKET.getDefaultInstance());
                BlockState blockstate = p_225533_1_.setValue(LAVA_LEVEL, 0);
                p_225533_2_.setBlock(p_225533_3_, blockstate, 0);
            }
        } else {

            p_225533_4_.openMenu(p_225533_1_.getMenuProvider(p_225533_2_, p_225533_3_));
        }
        return super.use(p_225533_1_, p_225533_2_, p_225533_3_, p_225533_4_, p_225533_5_, p_225533_6_);
    }
    private static final ITextComponent CONTAINER_TITLE = new StringTextComponent("Forge Gui");

    public INamedContainerProvider getMenuProvider(BlockState p_220052_1_, World p_220052_2_, BlockPos p_220052_3_) {
        return new SimpleNamedContainerProvider((p_220270_2_, p_220270_3_, p_220270_4_) -> {
            return new ForgeContainer(p_220270_2_, p_220270_3_, IWorldPosCallable.create(p_220052_2_, p_220052_3_));
        }, CONTAINER_TITLE);
    }

}
