package com.ianm1647.expandeddelight.registry;

import com.ianm1647.expandeddelight.ExpandedDelight;
import com.ianm1647.expandeddelight.item.ItemList;
import com.nhoryzon.mc.farmersdelight.registry.EffectsRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {

    public static void registerItems() {
        //items
        ItemList.RAW_CINNAMON = item("raw_cinnamon");

        //seeds
        ItemList.ASPARAGUS_SEEDS = seed("asparagus_seeds", BlockRegistry.ASPARAGUS_CROP);

        //foods
        ItemList.CHEESE_WHEEL = food("cheese_wheel", 4, 0.7f);
        ItemList.CHEESE_SLICE = food("cheese_slice", 1, 0.3f);

        //crops
        ItemList.ASPARAGUS = food("asparagus", 2, 0.3f);
        ItemList.ASPARAGUS_CHOPPED = food("asparagus_chopped", 1, 0.2f);
        ItemList.ASPARAGUS_ROASTED = food("asparagus_roasted", 4, 0.3f);

        //soups
        ItemList.ASPARAGUS_SOUP = stew("asparagus_soup", 5, 0.8f);
        ItemList.ASPARAGUS_SOUP_CREAMY = stew("asparagus_soup_creamy", 6, 0.9f);

        //meals
        ItemList.ASPARAGUS_AND_BACON_CHEESY = meal("asparagus_and_bacon_cheesy", 9, 3.0f);

        //ExpandedDelight.LOGGER.info("ExpandedDelight items loaded");
    }

    private static Item item(String name) {
        return Registry.register(Registry.ITEM, new Identifier(ExpandedDelight.MOD_ID, name),
                new Item(new FabricItemSettings().group(ExpandedDelight.GROUP)));
    }

    private static Item seed(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(ExpandedDelight.MOD_ID, name),
                new AliasedBlockItem(block, new FabricItemSettings().group(ExpandedDelight.GROUP)));
    }

    private static Item food(String name, int hunger, float saturation) {
        return Registry.register(Registry.ITEM, new Identifier(ExpandedDelight.MOD_ID, name),
                new Item(new FabricItemSettings().group(ExpandedDelight.GROUP)
                        .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation).build())));
    }

    private static Item stew(String name, int hunger, float saturation) {
        return Registry.register(Registry.ITEM, new Identifier(ExpandedDelight.MOD_ID, name),
                new StewItem(new FabricItemSettings().group(ExpandedDelight.GROUP).recipeRemainder(Items.BOWL).maxCount(16)
                        .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation)
                                .statusEffect(new StatusEffectInstance(EffectsRegistry.COMFORT.get(), 2400, 0), 1.0f).build())));
    }

    private static Item meal(String name, int hunger, float saturation) {
        return Registry.register(Registry.ITEM, new Identifier(ExpandedDelight.MOD_ID, name),
                new Item(new FabricItemSettings().group(ExpandedDelight.GROUP)
                        .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation)
                                .statusEffect(new StatusEffectInstance(EffectsRegistry.NOURISHED.get(), 3600, 0), 1.0f).build())));
    }
}
