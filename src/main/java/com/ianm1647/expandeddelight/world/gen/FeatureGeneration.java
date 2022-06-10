package com.ianm1647.expandeddelight.world.gen;

import com.ianm1647.expandeddelight.world.feature.FeatureList;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.Collection;
import java.util.List;

public class FeatureGeneration {
    private static Collection<RegistryKey<Biome>> PLAINS = List.of(new RegistryKey[]{BiomeKeys.PLAINS, BiomeKeys.SUNFLOWER_PLAINS, BiomeKeys.SNOWY_PLAINS});
    private static Collection<RegistryKey<Biome>> JUNGLE = List.of(new RegistryKey[]{BiomeKeys.JUNGLE, BiomeKeys.BAMBOO_JUNGLE, BiomeKeys.SPARSE_JUNGLE});
    private static Collection<RegistryKey<Biome>> DESERT = List.of(new RegistryKey[]{BiomeKeys.DESERT});
    private static Collection<RegistryKey<Biome>> SAVANNA = List.of(new RegistryKey[]{BiomeKeys.SAVANNA, BiomeKeys.SAVANNA_PLATEAU});
    private static Collection<RegistryKey<Biome>> OCEAN = List.of(new RegistryKey[]{BiomeKeys.OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.FROZEN_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.WARM_OCEAN});

    public static void generateFeature() {
        generatePlantCategory(PLAINS, FeatureList.WILD_ASPARAGUS_PLACED.getKey().get());
        generatePlantCategory(JUNGLE, FeatureList.WILD_SWEET_POTATO_PLACED.getKey().get());
        generatePlantCategory(DESERT, FeatureList.WILD_CHILI_PEPPER_PLACED.getKey().get());
        generatePlantCategory(SAVANNA, FeatureList.WILD_PEANUTS_PLACED.getKey().get());

        generatePlantCategory(JUNGLE, FeatureList.CINNAMON_TREE_PLACED.getKey().get());

        generateOre(OCEAN, FeatureList.SALT_ORE_PLACED.getKey().get());
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
