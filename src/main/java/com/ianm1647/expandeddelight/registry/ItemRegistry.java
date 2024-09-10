package com.ianm1647.expandeddelight.registry;

import com.ianm1647.expandeddelight.ExpandedDelight;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class ItemRegistry {

    //items
    public static Item GLASS_JAR;

    public static Item RAW_CINNAMON;
    public static Item GROUND_CINNAMON;

    public static Item SALT_ROCK;
    public static Item GROUND_SALT;

    //foods
    public static Item CHEESE_WHEEL;
    public static Item CHEESE_SLICE;
    public static Item CHEESE_SANDWICH;
    public static Item GRILLED_CHEESE;

    public static Item PEANUT;
    public static Item PEANUT_BUTTER;
    public static Item PEANUT_BUTTER_SANDWICH;
    public static Item PEANUT_BUTTER_HONEY_SANDWICH;
    public static Item SWEET_BERRY_JELLY_SANDWICH;
    public static Item GLOW_BERRY_JELLY_SANDWICH;

    public static Item SWEET_ROLL;
    public static Item BERRY_SWEET_ROLL;
    public static Item GLOW_BERRY_SWEET_ROLL;
    public static Item CINNAMON_RICE;
    public static Item CINNAMON_APPLES;

    public static Item CHOCOLATE_COOKIE;
    public static Item SUGAR_COOKIE;
    public static Item SNICKERDOODLE;

    //crops
    public static Item ASPARAGUS;
    public static Item ASPARAGUS_SEEDS;

    public static Item SWEET_POTATO;
    public static Item BAKED_SWEET_POTATO;

    public static Item CHILI_PEPPER;
    public static Item CHILI_PEPPER_SEEDS;

    //juices
    public static Item APPLE_JUICE;
    public static Item SWEET_BERRY_JUICE;
    public static Item GLOW_BERRY_JUICE;

    //jellies
    public static Item SWEET_BERRY_JELLY;
    public static Item GLOW_BERRY_JELLY;

    //salads
    public static Item PEANUT_SALAD;
    public static Item SWEET_POTATO_SALAD;

    //soups
    public static Item ASPARAGUS_SOUP;
    public static Item ASPARAGUS_SOUP_CREAMY;
    public static Item PEANUT_HONEY_SOUP;

    //meals
    public static Item MAC_AND_CHEESE;
    public static Item ASPARAGUS_AND_BACON_CHEESY;
    public static Item PEPERONATA;

    //functionals
    public static Item MORTAR_AND_PESTLE;
    public static Item JUICER_ITEM;

    public static void registerItems() {
        //items
        GLASS_JAR = item("glass_jar");

        RAW_CINNAMON = item("raw_cinnamon");
        GROUND_CINNAMON = item("ground_cinnamon");
        SALT_ROCK = item("salt_rock");
        GROUND_SALT = item("ground_salt");

        //seeds
        ASPARAGUS_SEEDS = itemBlock("asparagus_seeds", BlockRegistry.ASPARAGUS_CROP);
        CHILI_PEPPER_SEEDS = itemBlock("chili_pepper_seeds", BlockRegistry.CHILI_PEPPER_CROP);

        //crops
        ASPARAGUS = food("asparagus", null,2, 0.3f);
        SWEET_POTATO = foodSeed("sweet_potato", BlockRegistry.SWEET_POTATO_CROP, 2, 0.4f);
        CHILI_PEPPER = food("chili_pepper", null, 2, 0.3f);

        PEANUT = foodSeed("peanut", BlockRegistry.PEANUT_CROP, 1, 0.2f);

        //foods
        BAKED_SWEET_POTATO = food("baked_sweet_potato", null, 5, 0.5f);

        CHEESE_WHEEL = food("cheese_wheel",null, 8, 0.5f);
        CHEESE_SLICE = food("cheese_slice",null, 2, 0.2f);
        CHEESE_SANDWICH = food("cheese_sandwich", null, 3, 0.3f);
        GRILLED_CHEESE = food("grilled_cheese", null, 5, 0.5f);

        PEANUT_BUTTER = food("peanut_butter", Items.BOWL,2, 0.3f);
        PEANUT_BUTTER_SANDWICH = food("peanut_butter_sandwich", null,4, 0.4f);
        PEANUT_BUTTER_HONEY_SANDWICH = food("peanut_butter_honey_sandwich", null, 5, 0.5f);
        SWEET_BERRY_JELLY_SANDWICH = food("sweet_berry_jelly_sandwich", null, 6, 0.5f);
        GLOW_BERRY_JELLY_SANDWICH = food("glow_berry_jelly_sandwich", null, 6, 0.5f);

        SWEET_ROLL = food("sweet_roll", null, 4, 0.3f);
        BERRY_SWEET_ROLL = food("berry_sweet_roll", null, 5, 0.4f);
        GLOW_BERRY_SWEET_ROLL = food("glow_berry_sweet_roll", null, 5, 0.4f);
        CINNAMON_RICE = food("cinnamon_rice", Items.BOWL, 7, 0.5f);
        CINNAMON_APPLES = food("cinnamon_apples", Items.BOWL, 6, 0.6f);

        CHOCOLATE_COOKIE = food("chocolate_cookie", null, 2, 0.3f);
        SUGAR_COOKIE = food("sugar_cookie", null, 1, 0.3f);
        SNICKERDOODLE = food("snickerdoodle", null, 2, 0.3f);

        //juices
        APPLE_JUICE = juice("apple_juice", 1, 1.2f, StatusEffects.SPEED);
        SWEET_BERRY_JUICE = juice("sweet_berry_juice", 1, 1.2f, StatusEffects.HEALTH_BOOST);
        GLOW_BERRY_JUICE = juice("glow_berry_juice", 1, 1.2f, StatusEffects.NIGHT_VISION);

        //jellies
        SWEET_BERRY_JELLY = jelly("sweet_berry_jelly", 3, 0.6f, StatusEffects.HEALTH_BOOST);
        GLOW_BERRY_JELLY = jelly("glow_berry_jelly", 3, 0.6f, StatusEffects.NIGHT_VISION);

        //salads
        PEANUT_SALAD = salad("peanut_salad", 6, 0.6f);
        SWEET_POTATO_SALAD = salad("sweet_potato_salad", 6, 0.6f);

        //soups
        ASPARAGUS_SOUP = stew("asparagus_soup", 7, 0.8f);
        ASPARAGUS_SOUP_CREAMY = stew("asparagus_soup_creamy", 8, 0.8f);
        PEANUT_HONEY_SOUP = stew("peanut_honey_soup", 8, 0.8f);

        //meals
        MAC_AND_CHEESE = meal("mac_and_cheese", 8, 0.8f);
        ASPARAGUS_AND_BACON_CHEESY = meal("asparagus_and_bacon_cheesy", 10, 0.9f);
        PEPERONATA = meal("peperonata", 10, 0.9f);

        //block items
        MORTAR_AND_PESTLE = itemBlock("mortar_and_pestle_item", BlockRegistry.MORTAR_AND_PESTLE);
        JUICER_ITEM = itemBlock("juicer_item", BlockRegistry.JUICER);

        //ExpandedDelight.LOGGER.info("ExpandedDelight items loaded");
    }

    private static Item item(String name) {
        Item item = Registry.register(Registries.ITEM, new Identifier(ExpandedDelight.MODID, name),
                new Item(new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(ExpandedDelight.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item itemBlock(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(ExpandedDelight.MODID, name),
                new AliasedBlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(ExpandedDelight.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item food(String name, Item remainder, int hunger, float saturation) {
        Item item = Registry.register(Registries.ITEM, new Identifier(ExpandedDelight.MODID, name),
                new Item(new FabricItemSettings().recipeRemainder(remainder)
                        .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation).build())));
        ItemGroupEvents.modifyEntriesEvent(ExpandedDelight.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item foodSeed(String name, Block block, int hunger, float saturation) {
        Item item = Registry.register(Registries.ITEM, new Identifier(ExpandedDelight.MODID, name),
                new AliasedBlockItem(block, new FabricItemSettings().recipeRemainder(null)
                        .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation).build())));
        ItemGroupEvents.modifyEntriesEvent(ExpandedDelight.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item juice(String name, int hunger, float saturation, StatusEffect effect) {
        Item item = Registry.register(Registries.ITEM, new Identifier(ExpandedDelight.MODID, name),
                new DrinkableItem(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(16)
                        .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation).alwaysEdible()
                                .statusEffect(new StatusEffectInstance(effect, 200, 0), 1.0f).build())));
        ItemGroupEvents.modifyEntriesEvent(ExpandedDelight.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item jelly(String name, int hunger, float saturation, StatusEffect effect) {
        Item item = Registry.register(Registries.ITEM, new Identifier(ExpandedDelight.MODID, name),
                new Item(new FabricItemSettings().recipeRemainder(GLASS_JAR).maxCount(16)
                        .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation)
                                .statusEffect(new StatusEffectInstance(effect, 400, 0), 1.0f).build())));
        ItemGroupEvents.modifyEntriesEvent(ExpandedDelight.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item salad(String name, int hunger, float saturation) {
        Item item = Registry.register(Registries.ITEM, new Identifier(ExpandedDelight.MODID, name),
                new Item(new FabricItemSettings().recipeRemainder(Items.BOWL).maxCount(16)
                        .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation)
                                .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0), 1.0f).build())));
        ItemGroupEvents.modifyEntriesEvent(ExpandedDelight.GROUP).register(entries -> entries.add(item));
        return item;

    }

    private static Item stew(String name, int hunger, float saturation) {
        Item item = Registry.register(Registries.ITEM, new Identifier(ExpandedDelight.MODID, name),
                new Item(new FabricItemSettings().recipeRemainder(Items.BOWL).maxCount(16)
                        .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation)
                                .statusEffect(new StatusEffectInstance(ModEffects.COMFORT.get(), 2400, 0), 1.0f).build())));
        ItemGroupEvents.modifyEntriesEvent(ExpandedDelight.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item meal(String name, int hunger, float saturation) {
        Item item = Registry.register(Registries.ITEM, new Identifier(ExpandedDelight.MODID, name),
                new Item(new FabricItemSettings().recipeRemainder(Items.BOWL).maxCount(16)
                        .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation)
                                .statusEffect(new StatusEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1.0f).build())));
        ItemGroupEvents.modifyEntriesEvent(ExpandedDelight.GROUP).register(entries -> entries.add(item));
        return item;
    }
}
