package com.ianm1647.expandeddelight.world.feature.tree;

import com.ianm1647.expandeddelight.world.feature.FeatureList;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class CinnamonSaplingGenerator extends SaplingGenerator {
    @Nullable
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(net.minecraft.util.math.random.Random random, boolean bees) {
        return FeatureList.CINNAMON_TREE;
    }
}
