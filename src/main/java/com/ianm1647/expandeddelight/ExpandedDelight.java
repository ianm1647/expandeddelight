package com.ianm1647.expandeddelight;

import com.ianm1647.expandeddelight.item.ItemList;
import com.ianm1647.expandeddelight.registry.*;
import com.ianm1647.expandeddelight.util.UtilRegistries;
import com.ianm1647.expandeddelight.world.ModFeatureGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpandedDelight implements ModInitializer {
    public static final String MODID = "expandeddelight";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
    public static final RegistryKey<ItemGroup> GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MODID, "group"));

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM_GROUP, GROUP, FabricItemGroup.builder()
                .displayName(Text.translatable("itemGroup.expandeddelight.group"))
                .icon(() -> new ItemStack(ItemList.PEPERONATA))
                .build());

        ItemRegistry.registerItems();
        BlockRegistry.registerBlocks();

        ModFeatureGeneration.generateFeature();

        BlockEntityRegistry.registerBlockEntity();

        RecipeRegistry.registerRecipes();
        ScreenHandlersRegistry.registerHandlers();

        UtilRegistries.registerUtil();
    }
}
