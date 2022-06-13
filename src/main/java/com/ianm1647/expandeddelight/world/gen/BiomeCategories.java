package com.ianm1647.expandeddelight.world.gen;

import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

import java.util.Collection;
import java.util.List;

public class BiomeCategories {
    public static Collection<RegistryKey<Biome>> PLAINS = List.of(new RegistryKey[]{BiomeKeys.PLAINS, BiomeKeys.SUNFLOWER_PLAINS, BiomeKeys.SNOWY_PLAINS});
    public static Collection<RegistryKey<Biome>> JUNGLE = List.of(new RegistryKey[]{BiomeKeys.JUNGLE, BiomeKeys.BAMBOO_JUNGLE, BiomeKeys.SPARSE_JUNGLE});
    public static Collection<RegistryKey<Biome>> DESERT = List.of(new RegistryKey[]{BiomeKeys.DESERT});
    public static Collection<RegistryKey<Biome>> SAVANNA = List.of(new RegistryKey[]{BiomeKeys.SAVANNA, BiomeKeys.SAVANNA_PLATEAU});
    public static Collection<RegistryKey<Biome>> OCEAN = List.of(new RegistryKey[]{BiomeKeys.OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.FROZEN_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.WARM_OCEAN});
}
