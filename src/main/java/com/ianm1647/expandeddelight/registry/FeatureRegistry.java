package com.ianm1647.expandeddelight.registry;

import com.ianm1647.expandeddelight.block.BlockList;
import com.ianm1647.expandeddelight.world.feature.FeatureList;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class FeatureRegistry {

    public static void registerFeatures() {
        //configured features
        FeatureList.PATCH_WILD_ASPARAGUS = featurePatch("wild_asparagus_feature", BlockList.WILD_ASPARAGUS);
        FeatureList.PATCH_WILD_PEANUTS = featurePatch("wild_peanuts_feature", BlockList.WILD_PEANUTS);

        //placed features
        FeatureList.WILD_ASPARAGUS_PLACED = placedPatch("wild_asparagus_placed", FeatureList.PATCH_WILD_ASPARAGUS);
        FeatureList.WILD_PEANUTS_PLACED = placedPatch("wild_peanuts_placed", FeatureList.PATCH_WILD_PEANUTS);

        //trees
            //cinnamon
        FeatureList.CINNAMON_TREE = featureStraightTree("cinnamon_tree_feature", BlockList.CINNAMON_LOG, Blocks.OAK_LEAVES, 6, 2, 0, 2);
        FeatureList.CINNAMON_TREE_CHECKED = checkedTree("cinnamon_tree_checked", FeatureList.CINNAMON_TREE, BlockList.CINNAMON_SAPLING);
        FeatureList.CINNAMON_TREE_SPAWN = spawnTree("cinnamon_tree_spawn", FeatureList.CINNAMON_TREE_CHECKED, 0.25f);
        FeatureList.CINNAMON_TREE_PLACED = placedTree("cinnamon_tree_placed", FeatureList.CINNAMON_TREE_SPAWN, 1, 0.025f, 1);


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

    private static RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> featureStraightTree(String name, Block trunk, Block leaves,
                                                                                              int baseHeight, int randomHeight1, int randomHeight2, int radius) {
        return ConfiguredFeatures.register(name, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(trunk), new StraightTrunkPlacer(baseHeight, randomHeight1, randomHeight2),
                BlockStateProvider.of(leaves), new BlobFoliagePlacer(ConstantIntProvider.create(radius), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());
    }

    private static RegistryEntry<PlacedFeature> checkedTree(String name, RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> configuredFeature, Block sapling) {
        return PlacedFeatures.register(name, configuredFeature, PlacedFeatures.wouldSurvive(sapling));
    }

    private static RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> spawnTree(String name, RegistryEntry<PlacedFeature> checked, float chance) {
        return ConfiguredFeatures.register(name, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(new RandomFeatureEntry(checked, chance)), checked));
    }

    private static RegistryEntry<PlacedFeature> placedTree(String name, RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> spawn,
                                                           int count, float extraChance, int extraCount) {
        return PlacedFeatures.register(name, spawn, VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(count, extraChance, extraCount)));
    }
}
