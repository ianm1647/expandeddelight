package ianm1647.expandeddelight.common.item;

import vectorwing.farmersdelight.common.item.ConsumableItem;

public class JellyItem extends ConsumableItem {
    public JellyItem(Properties properties) {
        super(properties);
    }

    public JellyItem(Properties properties, boolean hasFoodEffectTooltip) {
        super(properties, hasFoodEffectTooltip);
    }

    public JellyItem(Properties properties, boolean hasPotionEffectTooltip, boolean hasCustomTooltip) {
        super(properties, hasPotionEffectTooltip, hasCustomTooltip);
    }
}
