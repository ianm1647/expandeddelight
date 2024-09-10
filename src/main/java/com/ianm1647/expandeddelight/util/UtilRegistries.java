package com.ianm1647.expandeddelight.util;

import com.ianm1647.expandeddelight.registry.BlockRegistry;
import com.ianm1647.expandeddelight.registry.ItemRegistry;
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
        registerFlammables();

        LootTableUtil.modifyLootTables();
        VillageTradeUtil.registerTrades();
    }

    public static void registerCompostables() {
        CompostingChanceRegistry.INSTANCE.add(ItemRegistry.ASPARAGUS_SEEDS, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ItemRegistry.ASPARAGUS, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ItemRegistry.SWEET_POTATO, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ItemRegistry.CHILI_PEPPER, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ItemRegistry.CHILI_PEPPER_SEEDS, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ItemRegistry.PEANUT, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ItemRegistry.RAW_CINNAMON, 0.4F);
        CompostingChanceRegistry.INSTANCE.add(ItemRegistry.CHOCOLATE_COOKIE, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(ItemRegistry.SUGAR_COOKIE, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(ItemRegistry.SNICKERDOODLE, 0.85F);

        CompostingChanceRegistry.INSTANCE.add(BlockRegistry.CINNAMON_SAPLING, 0.3F);

        CompostingChanceRegistry.INSTANCE.add(BlockRegistry.WILD_ASPARAGUS, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(BlockRegistry.WILD_SWEET_POTATO, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(BlockRegistry.WILD_CHILI_PEPPER, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(BlockRegistry.WILD_PEANUTS, 0.65F);
    }

    public static void registerFuels() {
        FuelRegistry.INSTANCE.add(BlockRegistry.CINNAMON_LOG, 300);
    }

    public static void registerFlammables() {
        FlammableBlockRegistry register = FlammableBlockRegistry.getDefaultInstance();

        register.add(BlockRegistry.CINNAMON_LOG, 5, 5);
    }

    public static void registerRenderLayer() {
        renderLayer(BlockRegistry.CINNAMON_SAPLING, RenderLayer.getCutout());

        renderLayer(BlockRegistry.ASPARAGUS_CROP, RenderLayer.getCutout());
        renderLayer(BlockRegistry.WILD_ASPARAGUS, RenderLayer.getCutout());
        renderLayer(BlockRegistry.SWEET_POTATO_CROP, RenderLayer.getCutout());
        renderLayer(BlockRegistry.WILD_SWEET_POTATO, RenderLayer.getCutout());
        renderLayer(BlockRegistry.CHILI_PEPPER_CROP, RenderLayer.getCutout());
        renderLayer(BlockRegistry.WILD_CHILI_PEPPER, RenderLayer.getCutout());
        renderLayer(BlockRegistry.PEANUT_CROP, RenderLayer.getCutout());
        renderLayer(BlockRegistry.WILD_PEANUTS, RenderLayer.getCutout());

        renderLayer(BlockRegistry.MORTAR_AND_PESTLE, RenderLayer.getCutout());
        renderLayer(BlockRegistry.JUICER, RenderLayer.getCutout());
    }

    private static void renderLayer(Block block, RenderLayer layer) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, layer);
    }
}
