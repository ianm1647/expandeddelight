package com.ianm1647.expandeddelight.util;

import com.ianm1647.expandeddelight.block.BlockList;
import com.ianm1647.expandeddelight.item.ItemList;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

public class UtilRegistries {

    public static void registerUtil() {
        registerCompostables();
        registerFuels();
        registerCompostables();

        LootTableUtil.modifyLootTables();
        VillageTradeUtil.registerTrades();
    }

    public static void registerCompostables() {
        CompostingChanceRegistry.INSTANCE.add(ItemList.ASPARAGUS_SEEDS, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ItemList.ASPARAGUS, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ItemList.SWEET_POTATO, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ItemList.CHILI_PEPPER, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ItemList.CHILI_PEPPER_SEEDS, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ItemList.PEANUT, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ItemList.RAW_CINNAMON, 0.4F);
        CompostingChanceRegistry.INSTANCE.add(ItemList.CHOCOLATE_COOKIE, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(ItemList.SUGAR_COOKIE, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(ItemList.SNICKERDOODLE, 0.85F);

        CompostingChanceRegistry.INSTANCE.add(BlockList.CINNAMON_SAPLING, 0.3F);

        CompostingChanceRegistry.INSTANCE.add(BlockList.WILD_ASPARAGUS, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(BlockList.WILD_SWEET_POTATO, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(BlockList.WILD_CHILI_PEPPER, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(BlockList.WILD_PEANUTS, 0.65F);
    }

    public static void registerFuels() {
        FuelRegistry.INSTANCE.add(BlockList.CINNAMON_LOG, 300);
    }

    public static void registerFlammables() {
        FlammableBlockRegistry register = FlammableBlockRegistry.getDefaultInstance();

        register.add(BlockList.CINNAMON_LOG, 5, 5);
    }

    public static void registerRenderLayer() {
        renderLayer(BlockList.CINNAMON_SAPLING, RenderLayer.getCutout());

        renderLayer(BlockList.ASPARAGUS_CROP, RenderLayer.getCutout());
        renderLayer(BlockList.WILD_ASPARAGUS, RenderLayer.getCutout());
        renderLayer(BlockList.SWEET_POTATO_CROP, RenderLayer.getCutout());
        renderLayer(BlockList.WILD_SWEET_POTATO, RenderLayer.getCutout());
        renderLayer(BlockList.CHILI_PEPPER_CROP, RenderLayer.getCutout());
        renderLayer(BlockList.WILD_CHILI_PEPPER, RenderLayer.getCutout());
        renderLayer(BlockList.PEANUT_CROP, RenderLayer.getCutout());
        renderLayer(BlockList.WILD_PEANUTS, RenderLayer.getCutout());

        renderLayer(BlockList.COOLER, RenderLayer.getCutout());
        renderLayer(BlockList.JUICER, RenderLayer.getCutout());
    }

    private static void renderLayer(Block block, RenderLayer layer) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, layer);
    }
}
