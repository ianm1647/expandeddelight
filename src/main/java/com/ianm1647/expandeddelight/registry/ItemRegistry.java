package com.ianm1647.expandeddelight.registry;

import com.ianm1647.expandeddelight.ExpandedDelight;
import com.nhoryzon.mc.farmersdelight.FarmersDelightMod;
import com.nhoryzon.mc.farmersdelight.registry.EffectsRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {
    //items

    //seeds
    public static final Item ASPARAGUS_SEEDS = seed("asparagus_seeds", BlockRegistry.ASPARAGUS_CROP);

    //foods
    public static final Item CHEESE = food("cheese", 2, 0.5f);

    //crops
    public static final Item ASPARAGUS = food("asparagus", 2, 0.3f);
    public static final Item ASPARAGUS_CHOPPED = food("asparagus_chopped", 1, 0.2f);
    public static final Item ASPARAGUS_ROASTED = food("asparagus_roasted", 4, 0.3f);

    //soups
    public static final Item ASPARAGUS_SOUP = stew("asparagus_soup", 5, 0.8f);
    public static final Item ASPARAGUS_SOUP_CREAMY = stew("asparagus_soup_creamy", 6, 0.9f);

    //meals
    public static final Item ASPARAGUS_AND_BACON_CHEESY = meal("asparagus_and_bacon_cheesy", 9, 3.0f);

    private static Item item(String name) {
        return Registry.register(Registry.ITEM, new Identifier(ExpandedDelight.MOD_ID, name),
                new Item(new FabricItemSettings().group(FarmersDelightMod.ITEM_GROUP)));
    }

    private static Item seed(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(ExpandedDelight.MOD_ID, name),
                new AliasedBlockItem(block, new FabricItemSettings().group(FarmersDelightMod.ITEM_GROUP)));
    }

    private static Item food(String name, int hunger, float saturation) {
        return Registry.register(Registry.ITEM, new Identifier(ExpandedDelight.MOD_ID, name),
                new Item(new FabricItemSettings().group(FarmersDelightMod.ITEM_GROUP)
                        .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation).build())));
    }

    private static Item stew(String name, int hunger, float saturation) {
        return Registry.register(Registry.ITEM, new Identifier(ExpandedDelight.MOD_ID, name),
                new StewItem(new FabricItemSettings().group(FarmersDelightMod.ITEM_GROUP).recipeRemainder(Items.BOWL).maxCount(16)
                        .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation)
                                .statusEffect(new StatusEffectInstance(EffectsRegistry.COMFORT.get(), 2400, 0), 1.0f).build())));
    }

    private static Item meal(String name, int hunger, float saturation) {
        return Registry.register(Registry.ITEM, new Identifier(ExpandedDelight.MOD_ID, name),
                new Item(new FabricItemSettings().group(FarmersDelightMod.ITEM_GROUP)
                        .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation)
                                .statusEffect(new StatusEffectInstance(EffectsRegistry.NOURISHED.get(), 3600, 0), 1.0f).build())));
    }

    public static void registerItems() {
        ExpandedDelight.LOGGER.info("Registering items for Expanded Delight!");
    }
}
