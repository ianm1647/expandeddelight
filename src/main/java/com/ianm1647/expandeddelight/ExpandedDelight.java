package com.ianm1647.expandeddelight;

import com.ianm1647.expandeddelight.block.BlockList;
import com.ianm1647.expandeddelight.registry.*;
import com.ianm1647.expandeddelight.util.LootTableUtil;
import com.ianm1647.expandeddelight.util.UtilRegistries;
import com.ianm1647.expandeddelight.util.VillageTradeUtil;
import com.ianm1647.expandeddelight.world.gen.FeatureGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpandedDelight implements ModInitializer {
    public static final String MOD_ID = "expandeddelight";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final ItemGroup GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "group"), () -> new ItemStack(BlockList.COOLER));

    @Override
    public void onInitialize() {
        ItemRegistry.registerItems();
        BlockRegistry.registerBlocks();

        FeatureRegistry.registerFeatures();
        FeatureGeneration.generateFeature();

        BlockEntityRegistry.registerBlockEntity();

        RecipeRegistry.registerRecipes();
        ScreenHandlersRegistry.registerHandlers();

        LootTableUtil.modifyLootTables();
        VillageTradeUtil.registerTrades();

        UtilRegistries.registerUtil();
    }

    /*if(FabricLoader.getInstance().isModLoaded("string")) {
            ready for mod implementation with any aspect
    }*/
}
