package ianm1647.expandeddelight.common.registry;

import ianm1647.expandeddelight.ExpandedDelight;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.item.component.ItemStackWrapper;

public class EDDataComponents {
    public static final DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, ExpandedDelight.MODID);
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ItemStackWrapper>> DRINK;

    public EDDataComponents() {
    }

    static {
        DRINK = DATA_COMPONENTS.registerComponentType("drink", (builder) -> builder.persistent(ItemStackWrapper.CODEC).networkSynchronized(ItemStackWrapper.STREAM_CODEC).cacheEncoding());
    }
}
