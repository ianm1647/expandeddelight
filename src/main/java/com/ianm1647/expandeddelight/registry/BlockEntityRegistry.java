package com.ianm1647.expandeddelight.registry;

import com.ianm1647.expandeddelight.ExpandedDelight;
import com.ianm1647.expandeddelight.block.BlockList;
import com.ianm1647.expandeddelight.block.entity.JuicerBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder.Factory;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockEntityRegistry {
    public static BlockEntityType<JuicerBlockEntity> JUICER;

    public static void registerBlockEntity() {
        JUICER = entity("juicer", JuicerBlockEntity::new, BlockList.JUICER);
    }

    private static BlockEntityType entity(String name, Factory<? extends BlockEntity> entity, Block block) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(ExpandedDelight.MODID, name),
                FabricBlockEntityTypeBuilder.create(entity, block).build(null));
    }
}
