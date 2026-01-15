package ianm1647.expandeddelight.common.registry;

import ianm1647.expandeddelight.common.utility.RegUtils;
import net.minecraft.core.component.DataComponentType;
import vectorwing.farmersdelight.common.item.component.ItemStackWrapper;

import java.util.function.Supplier;

public class EDDataComponents {
    public static Supplier<DataComponentType<ItemStackWrapper>> DRINK;

    public EDDataComponents() {
    }

    public static void register() {
        DRINK = RegUtils.regComponent("drink", (builder) -> builder.persistent(ItemStackWrapper.CODEC).networkSynchronized(ItemStackWrapper.STREAM_CODEC).cacheEncoding());
    }
}
