package ianm1647.expandeddelight.common.registry;

import ianm1647.expandeddelight.common.block.JuicerBlock;
import ianm1647.expandeddelight.common.block.entity.CinnamonCabinetBlockEntity;
import ianm1647.expandeddelight.common.block.entity.CinnamonHangingSignBlockEntity;
import ianm1647.expandeddelight.common.block.entity.CinnamonSignBlockEntity;
import ianm1647.expandeddelight.common.block.entity.JuicerBlockEntity;
import ianm1647.expandeddelight.common.utility.RegUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;
import vectorwing.farmersdelight.common.registry.ModBlocks;

import java.util.function.Supplier;

public class EDBlockEntityTypes {

    public static Supplier<BlockEntityType<CinnamonSignBlockEntity>> CINNAMON_SIGN;
    public static Supplier<BlockEntityType<CinnamonHangingSignBlockEntity>> CINNAMON_HANGING_SIGN;
    public static Supplier<BlockEntityType<CinnamonCabinetBlockEntity>> CINNAMON_CABINET;

    public static Supplier<BlockEntityType<JuicerBlockEntity>> JUICER;

    public static final Supplier<BlockEntityType<CookingPotBlockEntity>> COOKING_POT = RegUtils.regBlockEntity("cooking_pot",
            () -> BlockEntityType.Builder.of(CookingPotBlockEntity::new, new Block[]{ModBlocks.COOKING_POT.get()}).build());

    public EDBlockEntityTypes() {
    }

    public static void register() {
        CINNAMON_SIGN = RegUtils.regBlockEntity("cinnamon_sign",
                () -> BlockEntityType.Builder.of(CinnamonSignBlockEntity::new, new Block[]{EDBlocks.CINNAMON_SIGN.get(), EDBlocks.CINNAMON_WALL_SIGN.get()}).build());
        CINNAMON_HANGING_SIGN = RegUtils.regBlockEntity("cinnamon_hanging_sign",
                () -> BlockEntityType.Builder.of(CinnamonHangingSignBlockEntity::new, new Block[]{EDBlocks.CINNAMON_CEILING_HANGING_SIGN.get(), EDBlocks.CINNAMON_WALL_HANGING_SIGN.get()}).build());
        CINNAMON_CABINET = RegUtils.regBlockEntity("cinnamon_cabinet",
                () -> BlockEntityType.Builder.of(CinnamonCabinetBlockEntity::new, new Block[]{EDBlocks.CINNAMON_CABINET.get()}).build());

        JUICER = RegUtils.regBlockEntity("juicer",
                () -> BlockEntityType.Builder.of(JuicerBlockEntity::new, new Block[]{EDBlocks.JUICER.get()}).build());
    }
}
