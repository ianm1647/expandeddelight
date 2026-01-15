package ianm1647.expandeddelight.common.registry;

import ianm1647.expandeddelight.common.block.entity.container.JuicerMenu;
import ianm1647.expandeddelight.common.utility.RegUtils;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public class EDMenuTypes {
    public static Supplier<MenuType<JuicerMenu>> JUICER;

    public EDMenuTypes() {
    }

    public static void register() {
        JUICER = RegUtils.regMenu("juicer", () -> new ExtendedScreenHandlerType<>(JuicerMenu::new, BlockPos.STREAM_CODEC));
    }
}

