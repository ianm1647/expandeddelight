package com.ianm1647.expandeddelight.registry;

import com.ianm1647.expandeddelight.ExpandedDelight;
import com.ianm1647.expandeddelight.block.BlockList;
import com.ianm1647.expandeddelight.item.ItemList;
import com.ianm1647.expandeddelight.item.custom.JellyItem;
import com.ianm1647.expandeddelight.item.custom.JuiceItem;
import com.nhoryzon.mc.farmersdelight.registry.EffectsRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemRegistry {

    public static void registerItems() {
        //items
        ItemList.GLASS_JAR = item("glass_jar", new Item(basic()));

        ItemList.RAW_CINNAMON = item("raw_cinnamon", new Item(basic()));
        ItemList.GROUND_CINNAMON = item("ground_cinnamon", new Item(basic()));
        ItemList.SALT_ROCK = item("salt_rock", new Item(basic()));
        ItemList.GROUND_SALT = item("ground_salt", new Item(basic()));

        //seeds
        ItemList.ASPARAGUS_SEEDS = item("asparagus_seeds", new AliasedBlockItem(BlockList.ASPARAGUS_CROP, basic()));
        ItemList.CHILI_PEPPER_SEEDS = item("chili_pepper_seeds", new AliasedBlockItem(BlockList.CHILI_PEPPER_CROP, basic()));

        //crops
        ItemList.ASPARAGUS = item("asparagus", new Item(food(null, 2, 0.3f)));
        ItemList.SWEET_POTATO = item("sweet_potato", new AliasedBlockItem(BlockList.SWEET_POTATO_CROP, food(null, 2, 0.4f)));
        ItemList.CHILI_PEPPER = item("chili_pepper", new Item(food(null, 2, 0.3f)));

        ItemList.PEANUT = item("peanut", new AliasedBlockItem(BlockList.PEANUT_CROP, food(null, 1, 0.2f)));

        //foods
        ItemList.BAKED_SWEET_POTATO = item("baked_sweet_potato", new Item(food(null, 5, 0.5f)));

        ItemList.CHEESE_WHEEL = item("cheese_wheel", new Item(food(null, 8, 0.5f)));
        ItemList.CHEESE_SLICE = item("cheese_slice", new Item(food(null, 2, 0.2f)));
        ItemList.CHEESE_SANDWICH = item("cheese_sandwich", new Item(food(null, 3, 0.3f)));
        ItemList.GRILLED_CHEESE = item("grilled_cheese", new Item(food(null, 5, 0.5f)));

        ItemList.PEANUT_BUTTER = item("peanut_butter", new Item(food(Items.BOWL,2, 0.3f)));
        ItemList.PEANUT_BUTTER_SANDWICH = item("peanut_butter_sandwich", new Item(food(null,4, 0.4f)));
        ItemList.PEANUT_BUTTER_HONEY_SANDWICH = item("peanut_butter_honey_sandwich", new Item(food(null, 5, 0.5f)));
        ItemList.SWEET_BERRY_JELLY_SANDWICH = item("sweet_berry_jelly_sandwich", new Item(food(null, 6, 0.5f)));
        ItemList.GLOW_BERRY_JELLY_SANDWICH = item("glow_berry_jelly_sandwich", new Item(food(null, 6, 0.5f)));

        ItemList.SWEET_ROLL = item("sweet_roll", new Item(food(null, 4, 0.3f)));
        ItemList.BERRY_SWEET_ROLL = item("berry_sweet_roll", new Item(food(null, 5, 0.4f)));
        ItemList.GLOW_BERRY_SWEET_ROLL = item("glow_berry_sweet_roll", new Item(food(null, 5, 0.4f)));
        ItemList.CINNAMON_RICE = item("cinnamon_rice", new Item(food(Items.BOWL, 7, 0.5f)));
        ItemList.CINNAMON_APPLES = item("cinnamon_apples", new Item(food(Items.BOWL, 6, 0.6f)));

        ItemList.CHOCOLATE_COOKIE = item("chocolate_cookie", new Item(food(null, 2, 0.3f)));
        ItemList.SUGAR_COOKIE = item("sugar_cookie", new Item(food(null, 1, 0.3f)));
        ItemList.SNICKERDOODLE = item("snickerdoodle", new Item(food(null, 2, 0.3f)));

        //juices
        ItemList.APPLE_JUICE = item("apple_juice", new JuiceItem(juice(1, 1.2f, StatusEffects.SPEED)));
        ItemList.SWEET_BERRY_JUICE = item("sweet_berry_juice", new JuiceItem(juice(1, 1.2f, StatusEffects.HEALTH_BOOST)));
        ItemList.GLOW_BERRY_JUICE = item("glow_berry_juice", new JuiceItem(juice(1, 1.2f, StatusEffects.NIGHT_VISION)));

        //jellies
        ItemList.SWEET_BERRY_JELLY = item("sweet_berry_jelly", new JellyItem(jelly(3, 0.6f, StatusEffects.HEALTH_BOOST)));
        ItemList.GLOW_BERRY_JELLY = item("glow_berry_jelly", new JellyItem(jelly(3, 0.6f, StatusEffects.NIGHT_VISION)));

        //salads
        ItemList.PEANUT_SALAD = item("peanut_salad", new Item(salad(6, 0.6f)));
        ItemList.SWEET_POTATO_SALAD = item("sweet_potato_salad", new Item(salad(6, 0.6f)));

        //soups
        ItemList.ASPARAGUS_SOUP = item("asparagus_soup", new Item(stew(7, 0.8f)));
        ItemList.ASPARAGUS_SOUP_CREAMY = item("asparagus_soup_creamy", new Item(stew(8, 0.8f)));
        ItemList.PEANUT_HONEY_SOUP = item("peanut_honey_soup", new Item(stew(8, 0.8f)));

        //meals
        ItemList.MAC_AND_CHEESE = item("mac_and_cheese", new Item(meal(8, 0.8f)));
        ItemList.ASPARAGUS_AND_BACON_CHEESY = item("asparagus_and_bacon_cheesy", new Item(meal(10, 0.9f)));
        ItemList.PEPERONATA = item("peperonata", new Item(meal(10, 0.9f)));

        //block items
        ItemList.MORTAR_AND_PESTLE = item("mortar_and_pestle_item", new AliasedBlockItem(BlockList.MORTAR_AND_PESTLE, basic()));
        ItemList.JUICER_ITEM = item("juicer_item", new AliasedBlockItem(BlockList.JUICER, basic()));

        //ExpandedDelight.LOGGER.info("ExpandedDelight items loaded");
    }

    private static Item item(String name, Item item) {
        ItemGroupEvents.modifyEntriesEvent(ExpandedDelight.GROUP).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, new Identifier(ExpandedDelight.MODID, name), item);
    }

    private static FabricItemSettings basic() {
        return new FabricItemSettings();
    }

    private static FabricItemSettings food(Item remainder, int hunger, float saturation) {
        return new FabricItemSettings().recipeRemainder(remainder)
                .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation).build());
    }

    private static FabricItemSettings juice(int hunger, float saturation, StatusEffect effect) {
        return new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(16)
                .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation)
                .alwaysEdible().statusEffect(new StatusEffectInstance(effect, 200, 0), 1.0f).build());
    }

    private static FabricItemSettings jelly(int hunger, float saturation, StatusEffect effect) {
        return new FabricItemSettings().recipeRemainder(ItemList.GLASS_JAR).maxCount(16)
                .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation)
                .statusEffect(new StatusEffectInstance(effect, 400, 0), 1.0f).build());
    }

    private static FabricItemSettings salad(int hunger, float saturation) {
        return new FabricItemSettings().recipeRemainder(Items.BOWL).maxCount(16)
                .food(new FoodComponent.Builder().hunger(hunger)
                .saturationModifier(saturation).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0), 1.0f).build());
    }

    private static FabricItemSettings stew(int hunger, float saturation) {
        return new FabricItemSettings().recipeRemainder(Items.BOWL).maxCount(16)
                .food(new FoodComponent.Builder().hunger(hunger)
                .saturationModifier(saturation).statusEffect(new StatusEffectInstance(EffectsRegistry.COMFORT.get(), 2400, 0), 1.0f).build());
    }

    private static FabricItemSettings meal(int hunger, float saturation) {
        return new FabricItemSettings().recipeRemainder(Items.BOWL).maxCount(16)
                .food(new FoodComponent.Builder().hunger(hunger)
                .saturationModifier(saturation).statusEffect(new StatusEffectInstance(EffectsRegistry.NOURISHMENT.get(), 3600, 0), 1.0f).build());
    }
}
