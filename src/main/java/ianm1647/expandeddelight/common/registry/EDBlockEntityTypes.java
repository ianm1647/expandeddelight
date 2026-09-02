package ianm1647.expandeddelight.common.registry;

import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.block.entity.CinnamonCabinetBlockEntity;
import ianm1647.expandeddelight.common.block.entity.CinnamonHangingSignBlockEntity;
import ianm1647.expandeddelight.common.block.entity.CinnamonSignBlockEntity;
import ianm1647.expandeddelight.common.block.entity.JuicerBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.function.Supplier;

public class EDBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> TILES;

    public static final Supplier<BlockEntityType<CinnamonSignBlockEntity>> CINNAMON_SIGN;
    public static final Supplier<BlockEntityType<CinnamonHangingSignBlockEntity>> CINNAMON_HANGING_SIGN;
    public static final Supplier<BlockEntityType<CinnamonCabinetBlockEntity>> CINNAMON_CABINET;

    public static final Supplier<BlockEntityType<JuicerBlockEntity>> JUICER;

    public EDBlockEntityTypes() {
    }

    static {
        TILES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, ExpandedDelight.MODID);

        CINNAMON_SIGN = TILES.register("cinnamon_sign",
                () -> BlockEntityType.Builder.of(CinnamonSignBlockEntity::new, new Block[]{EDBlocks.CINNAMON_SIGN.get(), EDBlocks.CINNAMON_WALL_SIGN.get()}).build(null));
        CINNAMON_HANGING_SIGN = TILES.register("cinnamon_hanging_sign",
                () -> BlockEntityType.Builder.of(CinnamonHangingSignBlockEntity::new, new Block[]{EDBlocks.CINNAMON_CEILING_HANGING_SIGN.get(), EDBlocks.CINNAMON_WALL_HANGING_SIGN.get()}).build(null));
        CINNAMON_CABINET = TILES.register("cinnamon_cabinet",
                () -> BlockEntityType.Builder.of(CinnamonCabinetBlockEntity::new, new Block[]{EDBlocks.CINNAMON_CABINET.get()}).build(null));

        JUICER = TILES.register("juicer",
                () -> BlockEntityType.Builder.of(JuicerBlockEntity::new, new Block[]{EDBlocks.JUICER.get()}).build(null));
    }
}
