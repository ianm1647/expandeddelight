package com.ianm1647.expandeddelight.registry;

import com.ianm1647.expandeddelight.block.BlockList;
import com.ianm1647.expandeddelight.world.feature.FeatureList;
import net.minecraft.block.Block;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class FeatureRegistry {

    public static void registerFeatures() {
        //configured features
        FeatureList.PATCH_WILD_ASPARAGUS = featurePatch("wild_asparagus", BlockList.WILD_ASPARAGUS);

        //placed features
        FeatureList.WILD_ASPARAGUS_PLACED = placedPatch("wild_asparagus", FeatureList.PATCH_WILD_ASPARAGUS);

        //ExpandedDelight.LOGGER.info("ExpandedDelight features loaded");
    }

    private static RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> featurePatch(String name, Block block) {
        return ConfiguredFeatures.register(name, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(64, 2, 2,
                PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(block)))));
    }

    private static RegistryEntry<PlacedFeature> placedPatch(String name, RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> configuredFeature) {
        return PlacedFeatures.register(name, configuredFeature, RarityFilterPlacementModifier.of(48), SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    }
}
