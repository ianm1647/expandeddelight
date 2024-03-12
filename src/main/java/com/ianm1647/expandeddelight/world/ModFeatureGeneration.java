package com.ianm1647.expandeddelight.world;

import com.ianm1647.expandeddelight.ExpandedDelight;
import com.ianm1647.expandeddelight.world.feature.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModFeatureGeneration {

    public static void generateFeature() {
        if (ExpandedDelight.CONFIG.generateAsparagus == true) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_ASPARAGUS_PLACED);
        }
        if (ExpandedDelight.CONFIG.generateSweetPotatoes == true) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.JUNGLE),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_SWEET_POTATO_PLACED);
        }
        if (ExpandedDelight.CONFIG.generateChiliPeppers == true) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DESERT),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_CHILI_PEPPER_PLACED);
        }
        if (ExpandedDelight.CONFIG.generatePeanuts == true) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SAVANNA),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_PEANUTS_PLACED);
        }

        if (ExpandedDelight.CONFIG.generateCinnamonTrees == true) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.JUNGLE),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CINNAMON_TREE_PLACED);
        }

        if (ExpandedDelight.CONFIG.generateSaltOre == true) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OCEAN, BiomeKeys.COLD_OCEAN),
                    GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.SALT_ORE_PLACED);
        }
    }
    private static void generatePlantTemp(int lessTemp, int greatTemp, RegistryKey<PlacedFeature> feature) {
        BiomeModifications.addFeature((context) -> context.getBiome().getTemperature() < lessTemp && context.getBiome().getTemperature() > greatTemp,
                GenerationStep.Feature.VEGETAL_DECORATION, feature);
    }
}
