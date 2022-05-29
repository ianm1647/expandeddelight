package com.ianm1647.expandeddelight.block.custom;

import com.ianm1647.expandeddelight.block.BlockList;
import com.ianm1647.expandeddelight.item.ItemList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class DelightCropBlock extends CropBlock {
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 2.0, 16.0), Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 3.0, 16.0), Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 5.0, 16.0), Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 7.0, 16.0), Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 8.0, 16.0), Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 9.0, 16.0), Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 9.0, 16.0), Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 10.0, 16.0)};

    public DelightCropBlock(Settings settings) {
        super(settings);
    }

    protected ItemConvertible getSeedsItem() {
        if(this == BlockList.ASPARAGUS_CROP) {
            return ItemList.ASPARAGUS_SEEDS;
        }
        if(this == BlockList.SWEET_POTATO_CROP) {
            return ItemList.SWEET_POTATO;
        }
        if(this == BlockList.CHILI_PEPPER_CROP) {
            return ItemList.CHILI_PEPPER_SEEDS;
        }
        if(this == BlockList.PEANUT_CROP) {
            return ItemList.PEANUT;
        }
        return null;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE_BY_AGE[state.get(this.getAgeProperty())];
    }
}
