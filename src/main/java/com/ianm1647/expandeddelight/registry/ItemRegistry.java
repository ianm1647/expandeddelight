package com.ianm1647.expandeddelight.registry;

import com.ianm1647.expandeddelight.ExpandedDelight;
import com.ianm1647.expandeddelight.block.BlockList;
import com.ianm1647.expandeddelight.item.ItemList;
import com.ianm1647.expandeddelight.item.custom.CookBookItem;
import com.ianm1647.expandeddelight.item.custom.MortarPestleItem;
import com.nhoryzon.mc.farmersdelight.registry.EffectsRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {

    public static void registerItems() {
        //book
        ItemList.COOK_BOOK = customItem("cook_book",
                new CookBookItem(new FabricItemSettings().group(ExpandedDelight.GROUP)));

        //items
        ItemList.RAW_CINNAMON = item("raw_cinnamon");
        ItemList.GROUND_CINNAMON = item("ground_cinnamon");
        ItemList.SALT_ROCK = item("salt_rock");
        ItemList.GROUND_SALT = item("ground_salt");

        //seeds
        ItemList.ASPARAGUS_SEEDS = seed("asparagus_seeds", BlockList.ASPARAGUS_CROP);

        //crops
        ItemList.ASPARAGUS = food("asparagus", null,2, 0.3f);
        ItemList.ASPARAGUS_CHOPPED = food("asparagus_chopped", null,1, 0.2f);
        ItemList.ASPARAGUS_ROASTED = food("asparagus_roasted", null,4, 0.3f);

        ItemList.PEANUT = foodSeed("peanut", BlockList.PEANUT_CROP, null, 1, 0.2f);

        //foods
        ItemList.CHEESE_WHEEL = food("cheese_wheel", null,4, 0.4f);
        ItemList.CHEESE_SLICE = food("cheese_slice", null,1, 0.1f);
        ItemList.CHEESE_SANDWICH = food("cheese_sandwich", null, 3, 0.3f);
        ItemList.GRILLED_CHEESE = food("grilled_cheese", null, 5, 0.5f);
        ItemList.PEANUT_BUTTER = food("peanut_butter", Items.BOWL,2, 0.3f);
        ItemList.PEANUT_BUTTER_SANDWICH = food("peanut_butter_sandwich", null,4, 0.4f);
        ItemList.PEANUT_BUTTER_JELLY_SANDWICH = food("peanut_butter_jelly_sandwich", null, 5, 0.5f);
        ItemList.SWEET_ROLL = food("sweet_roll", null, 4, 0.3f);

        //soups
        ItemList.ASPARAGUS_SOUP = stew("asparagus_soup", 5, 0.8f);
        ItemList.ASPARAGUS_SOUP_CREAMY = stew("asparagus_soup_creamy", 6, 0.8f);

        //meals
        ItemList.ASPARAGUS_AND_BACON_CHEESY = meal("asparagus_and_bacon_cheesy", 10, 1.0f);

        //functional items
        ItemList.MORTAR_AND_PESTLE = customItem("mortar_and_pestle",
                new MortarPestleItem(new FabricItemSettings().group(ExpandedDelight.GROUP).maxDamage(64)));

        //ExpandedDelight.LOGGER.info("ExpandedDelight items loaded");
    }

    private static Item item(String name) {
        return Registry.register(Registry.ITEM, new Identifier(ExpandedDelight.MOD_ID, name),
                new Item(new FabricItemSettings().group(ExpandedDelight.GROUP)));
    }

    private static Item customItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(ExpandedDelight.MOD_ID, name), item);
    }

    private static Item seed(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(ExpandedDelight.MOD_ID, name),
                new AliasedBlockItem(block, new FabricItemSettings().group(ExpandedDelight.GROUP)));
    }

    private static Item food(String name, Item remainder, int hunger, float saturation) {
        return Registry.register(Registry.ITEM, new Identifier(ExpandedDelight.MOD_ID, name),
                new Item(new FabricItemSettings().group(ExpandedDelight.GROUP).recipeRemainder(remainder)
                        .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation).build())));
    }

    private static Item foodSeed(String name, Block block, Item remainder, int hunger, float saturation) {
        return Registry.register(Registry.ITEM, new Identifier(ExpandedDelight.MOD_ID, name),
                new AliasedBlockItem(block, new FabricItemSettings().group(ExpandedDelight.GROUP).recipeRemainder(remainder)
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
                new Item(new FabricItemSettings().group(ExpandedDelight.GROUP).recipeRemainder(Items.BOWL).maxCount(16)
                        .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation)
                                .statusEffect(new StatusEffectInstance(EffectsRegistry.NOURISHED.get(), 3600, 0), 1.0f).build())));
    }
}
