package com.ianm1647.expandeddelight.world.feature.tree;

import com.ianm1647.expandeddelight.registry.FeatureRegistry;
import com.ianm1647.expandeddelight.world.feature.FeatureList;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class CinnamonSaplingGenerator extends SaplingGenerator {
    @Nullable
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return FeatureList.CINNAMON_TREE;
    }
}
