package ianm1647.expandeddelight.common.block.entity;

import ianm1647.expandeddelight.common.registry.EDBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.block.entity.CabinetBlockEntity;

public class CinnamonCabinetBlockEntity extends CabinetBlockEntity {
    public CinnamonCabinetBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    public BlockEntityType<?> getType() {
        return EDBlockEntityTypes.CINNAMON_CABINET.get();
    }
}
