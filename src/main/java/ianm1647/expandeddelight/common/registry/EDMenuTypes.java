package ianm1647.expandeddelight.common.registry;

import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.block.entity.container.JuicerMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EDMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES;
    public static final Supplier<MenuType<JuicerMenu>> JUICER;

    public EDMenuTypes() {
    }

    static {
        MENU_TYPES = DeferredRegister.create(Registries.MENU, ExpandedDelight.MODID);
        JUICER = MENU_TYPES.register("juicer", () -> IMenuTypeExtension.create(JuicerMenu::new));
    }
}

