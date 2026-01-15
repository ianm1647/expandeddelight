package ianm1647.expandeddelight.common.registry;

import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.entity.CinnamonBoat;
import ianm1647.expandeddelight.common.entity.CinnamonChestBoat;
import ianm1647.expandeddelight.common.utility.RegUtils;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class EDEntityTypes {
    public static Supplier<EntityType<CinnamonBoat>> CINNAMON_BOAT;
    public static Supplier<EntityType<CinnamonChestBoat>> CINNAMON_CHEST_BOAT;

    public static void register() {
        CINNAMON_BOAT = RegUtils.regEntity("cinnamon_boat",
                () -> EntityType.Builder.<CinnamonBoat>of(CinnamonBoat::new, MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10).build(ExpandedDelight.MODID + ":cinnamon_boat"));
        CINNAMON_CHEST_BOAT = RegUtils.regEntity("cinnamon_chest_boat",
                () -> EntityType.Builder.<CinnamonChestBoat>of(CinnamonChestBoat::new, MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10).build(ExpandedDelight.MODID + ":cinnamon_chest_boat"));


    }
}
