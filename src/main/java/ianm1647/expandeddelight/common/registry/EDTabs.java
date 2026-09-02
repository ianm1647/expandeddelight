package ianm1647.expandeddelight.common.registry;

import ianm1647.expandeddelight.ExpandedDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EDTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS;
    public static final Supplier<CreativeModeTab> TAB_ED;

    public EDTabs() {
    }

    static {
        CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExpandedDelight.MODID);
        TAB_ED = CREATIVE_TABS.register(ExpandedDelight.MODID,
                () -> CreativeModeTab.builder().title(Component.translatable("itemGroup." + ExpandedDelight.MODID)).icon(
                        () -> new ItemStack(EDItems.JUICER.get())).displayItems((parameters, output) ->
                        EDItems.CREATIVE_TAB_ITEMS.forEach((item) -> output.accept(item.get()))).build());
    }
}
