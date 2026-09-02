package ianm1647.expandeddelight.common.block.entity;

import ianm1647.expandeddelight.common.registry.EDBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CinnamonHangingSignBlockEntity extends HangingSignBlockEntity {
    public CinnamonHangingSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    public BlockEntityType<?> getType() {
        return EDBlockEntityTypes.CINNAMON_HANGING_SIGN.get();
    }

    public boolean isValidBlockState(BlockState state) {
        return this.getType().isValid(state);
    }

    public int getTextLineHeight() {
        return 9;
    }

    public int getMaxTextLineWidth() {
        return 60;
    }
}
