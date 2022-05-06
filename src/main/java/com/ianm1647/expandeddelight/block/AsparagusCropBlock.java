package com.ianm1647.expandeddelight.block;

import com.ianm1647.expandeddelight.registry.ItemRegistry;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public class AsparagusCropBlock extends CropBlock {
    public AsparagusCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ItemRegistry.ASPARAGUS_SEEDS;
    }
}
