package ianm1647.expandeddelight.common.registry;

import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.utility.RegUtils;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class EDTabs {
    public static final ResourceKey<CreativeModeTab> ED_TAB_KEY =
            ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID, "group"));
    public static Supplier<CreativeModeTab> TAB_ED;

    public EDTabs() {
    }

    public static void register() {
        TAB_ED = RegUtils.regTab("group", () -> FabricItemGroup.builder()
                .icon(() -> new ItemStack(EDItems.CRANBERRIES.get()))
                .title(Component.translatable("itemGroup." + ExpandedDelight.MODID))
                .build());
    }
}
