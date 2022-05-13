package com.ianm1647.expandeddelight.util;

import com.ianm1647.expandeddelight.block.BlockList;
import com.ianm1647.expandeddelight.item.ItemList;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;

public class CompostablesUtil {

    public static void registerCompostables() {
        CompostingChanceRegistry.INSTANCE.add(ItemList.ASPARAGUS_SEEDS, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ItemList.ASPARAGUS, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ItemList.ASPARAGUS_CHOPPED, 0.325F);

        CompostingChanceRegistry.INSTANCE.add(ItemList.RAW_CINNAMON, 0.4F);

        CompostingChanceRegistry.INSTANCE.add(BlockList.WILD_ASPARAGUS, 0.65F);
    }
}
