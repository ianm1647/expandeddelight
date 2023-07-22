package com.ianm1647.expandeddelight.world.feature;

import com.ianm1647.expandeddelight.ExpandedDelight;
import com.ianm1647.expandeddelight.block.BlockList;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {

    public static RegistryKey<PlacedFeature> WILD_ASPARAGUS_PLACED = registerPlacedKey("wild_asparagus_placed");
    public static RegistryKey<PlacedFeature> WILD_SWEET_POTATO_PLACED = registerPlacedKey("wild_sweet_potato_placed");
    public static RegistryKey<PlacedFeature> WILD_CHILI_PEPPER_PLACED = registerPlacedKey("wild_chili_pepper_placed");
    public static RegistryKey<PlacedFeature> WILD_PEANUTS_PLACED = registerPlacedKey("wild_peanuts_placed");
    public static RegistryKey<PlacedFeature> SALT_ORE_PLACED = registerPlacedKey("salt_ore_placed");
    public static RegistryKey<PlacedFeature> CINNAMON_TREE_PLACED = registerPlacedKey("cinnamon_tree_placed");
    public static RegistryKey<PlacedFeature> CINNAMON_TREE_CHECKED = registerPlacedKey("cinnamon_tree_checked");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, CINNAMON_TREE_CHECKED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CINNAMON_TREE),
                List.of(PlacedFeatures.wouldSurvive(BlockList.CINNAMON_SAPLING)));
        register(context, CINNAMON_TREE_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CINNAMON_TREE),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.025f, 1), BlockList.CINNAMON_SAPLING));

        register(context, SALT_ORE_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SALT_ORE),
                ModOreFeature.modifiersWithCount(6,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-20), YOffset.fixed(60))));

        register(context, WILD_ASPARAGUS_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WILD_ASPARAGUS),
                RarityFilterPlacementModifier.of(12), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, WILD_SWEET_POTATO_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WILD_SWEET_POTATO),
                RarityFilterPlacementModifier.of(12), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, WILD_CHILI_PEPPER_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WILD_CHILI_PEPPER),
                RarityFilterPlacementModifier.of(12), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, WILD_PEANUTS_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WILD_PEANUTS),
                RarityFilterPlacementModifier.of(12), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    }

    public static RegistryKey<PlacedFeature> registerPlacedKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(ExpandedDelight.MODID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
