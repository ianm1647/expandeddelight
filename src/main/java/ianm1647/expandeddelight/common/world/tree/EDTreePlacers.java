package ianm1647.expandeddelight.common.world.tree;

import ianm1647.expandeddelight.common.utility.RegUtils;
import ianm1647.expandeddelight.common.world.tree.placer.CinnamonFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

import java.util.function.Supplier;

public class EDTreePlacers {
    public static Supplier<FoliagePlacerType<CinnamonFoliagePlacer>> CINNAMON_FOLIAGE_PLACER;

    public static void register() {
        CINNAMON_FOLIAGE_PLACER = RegUtils.regFoliagePlacer("cinnamon_foliage_placer", () -> new FoliagePlacerType<>(CinnamonFoliagePlacer.CODEC));
    }
}
