package com.ianm1647.expandeddelight.world.gen;

import com.ianm1647.expandeddelight.world.feature.FeatureList;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.Collection;

public class FeatureGeneration {

    public static void generateFeature() {
        generatePlantCategory(BiomeCategories.PLAINS, FeatureList.WILD_ASPARAGUS_PLACED.getKey().get());
        generatePlantCategory(BiomeCategories.JUNGLE, FeatureList.WILD_SWEET_POTATO_PLACED.getKey().get());
        generatePlantCategory(BiomeCategories.DESERT, FeatureList.WILD_CHILI_PEPPER_PLACED.getKey().get());
        generatePlantCategory(BiomeCategories.SAVANNA, FeatureList.WILD_PEANUTS_PLACED.getKey().get());

        generatePlantCategory(BiomeCategories.JUNGLE, FeatureList.CINNAMON_TREE_PLACED.getKey().get());

        generateOre(BiomeCategories.OCEAN, FeatureList.SALT_ORE_PLACED.getKey().get());
    }

    private static void generatePlantCategory(Collection<RegistryKey<Biome>> biome, RegistryKey<PlacedFeature> feature) {
        BiomeModifications.addFeature((context) ->
                BiomeSelectors.includeByKey(biome).test(context),
                GenerationStep.Feature.VEGETAL_DECORATION, feature);
    }

    private static void generatePlantTemp(int lessTemp, int greatTemp, RegistryKey<PlacedFeature> feature) {
        BiomeModifications.addFeature((context) ->
                context.getBiome().getTemperature() < lessTemp && context.getBiome().getTemperature() > greatTemp,
                GenerationStep.Feature.VEGETAL_DECORATION, feature);
    }

    private static void generateOre(Collection biome, RegistryKey<PlacedFeature> feature) {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(biome),
                GenerationStep.Feature.UNDERGROUND_ORES, feature);
    }
}
