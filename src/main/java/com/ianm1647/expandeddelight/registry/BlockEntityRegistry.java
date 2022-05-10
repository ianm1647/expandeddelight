package com.ianm1647.expandeddelight.registry;

import com.ianm1647.expandeddelight.ExpandedDelight;
import com.ianm1647.expandeddelight.block.BlockEntityList;
import com.ianm1647.expandeddelight.block.BlockList;
import com.ianm1647.expandeddelight.block.entity.CoolerBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockEntityRegistry {
    public static void registerBlockEntity() {
        BlockEntityList.COOLER = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ExpandedDelight.MOD_ID, "cooler"),
                FabricBlockEntityTypeBuilder.create(CoolerBlockEntity::new, BlockList.COOLER).build(null));
    }
}
