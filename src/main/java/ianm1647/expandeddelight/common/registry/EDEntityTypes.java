package ianm1647.expandeddelight.common.registry;

import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.entity.CinnamonBoat;
import ianm1647.expandeddelight.common.entity.CinnamonChestBoat;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EDEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITIES;

    public static Supplier<EntityType<CinnamonBoat>> CINNAMON_BOAT;
    public static Supplier<EntityType<CinnamonChestBoat>> CINNAMON_CHEST_BOAT;

    static {
        ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, ExpandedDelight.MODID);

        CINNAMON_BOAT = ENTITIES.register("cinnamon_boat",
                () -> EntityType.Builder.<CinnamonBoat>of(CinnamonBoat::new, MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10).build(ExpandedDelight.MODID + ":cinnamon_boat"));
        CINNAMON_CHEST_BOAT = ENTITIES.register("cinnamon_chest_boat",
                () -> EntityType.Builder.<CinnamonChestBoat>of(CinnamonChestBoat::new, MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10).build(ExpandedDelight.MODID + ":cinnamon_chest_boat"));


    }
}
