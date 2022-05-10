package com.ianm1647.expandeddelight.world.generation;

import com.ianm1647.expandeddelight.registry.FeatureRegistry;
import com.ianm1647.expandeddelight.world.feature.FeatureList;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class FeatureGeneration {

    public static void generateFeature() {
        generatePlant(Biome.Category.PLAINS, FeatureList.WILD_ASPARAGUS_PLACED.getKey().get());
    }

    private static void generatePlant(Biome.Category biome, RegistryKey<PlacedFeature> feature) {
        BiomeModifications.addFeature(BiomeSelectors.categories(biome),
                GenerationStep.Feature.VEGETAL_DECORATION, feature);
    }
}
