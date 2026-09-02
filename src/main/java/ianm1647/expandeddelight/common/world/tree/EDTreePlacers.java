package ianm1647.expandeddelight.common.world.tree;

import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.world.tree.placer.CinnamonFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EDTreePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS;

    public static final Supplier<FoliagePlacerType<CinnamonFoliagePlacer>> CINNAMON_FOLIAGE_PLACER;

    static {
        FOLIAGE_PLACERS = DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, ExpandedDelight.MODID);

        CINNAMON_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("cinnamon_foliage_placer", () -> new FoliagePlacerType<>(CinnamonFoliagePlacer.CODEC));
    }
}
