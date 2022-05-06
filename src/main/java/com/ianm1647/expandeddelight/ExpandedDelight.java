package com.ianm1647.expandeddelight;

import com.ianm1647.expandeddelight.registry.*;
import com.ianm1647.expandeddelight.util.LootTableUtil;
import com.ianm1647.expandeddelight.world.FeatureGeneration;
import net.fabricmc.api.ModInitializer;
import net.minecraft.loot.LootTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpandedDelight implements ModInitializer {
    public static final String MOD_ID = "expandeddelight";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ItemRegistry.registerItems();
        BlockRegistry.registerBlocks();

        FeatureRegistry.registerFeatures();

        LootTableUtil.modifyLootTables();
        FeatureGeneration.generateFeature();

        BlockEntityRegistry.registerBlockEntity();

        RecipeRegistry.registerRecipes();
    }
}
