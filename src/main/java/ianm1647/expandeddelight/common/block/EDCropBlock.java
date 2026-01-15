package ianm1647.expandeddelight.common.block;

import ianm1647.expandeddelight.common.registry.EDBlocks;
import ianm1647.expandeddelight.common.registry.EDItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EDCropBlock extends CropBlock {
    private static final VoxelShape[] SHAPE_BY_AGE;


    public EDCropBlock() {
        super(Properties.ofFullCopy(Blocks.WHEAT).instabreak().randomTicks().noCollission());
    }

    protected ItemLike getBaseSeedId() {
        if(this == EDBlocks.ASPARAGUS_CROP) {
            return EDItems.ASPARAGUS_SEEDS.get();
        }
        if(this == EDBlocks.SWEET_POTATO_CROP) {
            return EDItems.SWEET_POTATO.get();
        }
        if(this == EDBlocks.CHILI_PEPPER_CROP) {
            return EDItems.CHILI_PEPPER_SEEDS.get();
        }
        if(this == EDBlocks.PEANUT_CROP) {
            return EDItems.PEANUT.get();
        }
        return this;
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
    }

    static {
        SHAPE_BY_AGE = new VoxelShape[]{Block.box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0), Block.box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0), Block.box(0.0, 0.0, 0.0, 16.0, 6.0, 16.0), Block.box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0), Block.box(0.0, 0.0, 0.0, 16.0, 10.0, 16.0), Block.box(0.0, 0.0, 0.0, 16.0, 12.0, 16.0), Block.box(0.0, 0.0, 0.0, 16.0, 14.0, 16.0), Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)};
    }
}
