package com.ianm1647.expandeddelight.world.gen;

import com.ianm1647.expandeddelight.world.feature.FeatureList;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class FeatureGeneration {

    public static void generateFeature() {
        generatePlantCategory(Biome.Category.PLAINS, FeatureList.WILD_ASPARAGUS_PLACED.getKey().get());
        generatePlantCategory(Biome.Category.JUNGLE, FeatureList.WILD_SWEET_POTATO_PLACED.getKey().get());
        generatePlantCategory(Biome.Category.DESERT, FeatureList.WILD_CHILI_PEPPER_PLACED.getKey().get());
        generatePlantCategory(Biome.Category.SAVANNA, FeatureList.WILD_PEANUTS_PLACED.getKey().get());

        generatePlantCategory(Biome.Category.JUNGLE, FeatureList.CINNAMON_TREE_PLACED.getKey().get());

        generateOre(Biome.Category.OCEAN, FeatureList.SALT_ORE_PLACED.getKey().get());
    }

    private static void generatePlantKey(RegistryKey<Biome> biome, RegistryKey<PlacedFeature> feature) {
        BiomeModifications.addFeature((context) ->
                context.getBiomeKey().equals(biome), GenerationStep.Feature.VEGETAL_DECORATION, feature);
    }

    private static void generatePlantCategory(Biome.Category biome, RegistryKey<PlacedFeature> feature) {
        BiomeModifications.addFeature((context) ->
                BiomeSelectors.categories(new Biome.Category[]{biome}).test(context),
                GenerationStep.Feature.VEGETAL_DECORATION, feature);
    }

    private static void generatePlantTemp(int lessTemp, int greatTemp, RegistryKey<PlacedFeature> feature) {
        BiomeModifications.addFeature((context) ->
                context.getBiome().getTemperature() < lessTemp && context.getBiome().getTemperature() > greatTemp,
                GenerationStep.Feature.VEGETAL_DECORATION, feature);
    }

    private static void generateOre(Biome.Category biome, RegistryKey<PlacedFeature> feature) {
        BiomeModifications.addFeature(BiomeSelectors.categories(biome),
                GenerationStep.Feature.UNDERGROUND_ORES, feature);
    }
}
