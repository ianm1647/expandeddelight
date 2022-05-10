package com.ianm1647.expandeddelight.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;

public class FeatureList {
    //configured features
    public static RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PATCH_WILD_ASPARAGUS;

    //placed features
    public static RegistryEntry<PlacedFeature> WILD_ASPARAGUS_PLACED;
}
