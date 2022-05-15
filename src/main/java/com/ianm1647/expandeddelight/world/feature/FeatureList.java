package com.ianm1647.expandeddelight.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class FeatureList {
    //configured features
    public static RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PATCH_WILD_ASPARAGUS;
    public static RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PATCH_WILD_PEANUTS;

    //placed features
    public static RegistryEntry<PlacedFeature> WILD_ASPARAGUS_PLACED;
    public static RegistryEntry<PlacedFeature> WILD_PEANUTS_PLACED;

    //ores
    public static List<OreFeatureConfig.Target> SALT_ORE_LIST;
    public static RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> SALT_ORE;
    public static RegistryEntry<PlacedFeature> SALT_ORE_PLACED;

    //trees
        //cinnamon
    public static RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> CINNAMON_TREE;
    public static RegistryEntry<PlacedFeature> CINNAMON_TREE_CHECKED;
    public static RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> CINNAMON_TREE_SPAWN;
    public static RegistryEntry<PlacedFeature> CINNAMON_TREE_PLACED;
}
