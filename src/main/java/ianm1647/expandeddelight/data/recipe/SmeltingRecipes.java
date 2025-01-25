package ianm1647.expandeddelight.data.recipe;

import ianm1647.expandeddelight.common.registry.EDItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public class SmeltingRecipes {
    public SmeltingRecipes() {
    }

    public static void register(RecipeOutput output) {
        foodSmeltingRecipes("baked_sweet_potato", EDItems.SWEET_POTATO.get(), EDItems.BAKED_SWEET_POTATO.get(), 0.35f, output);

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(EDItems.CHEESE_SANDWICH.get()), RecipeCategory.FOOD, EDItems.GRILLED_CHEESE.get(), 0.55f, 600)
                .unlockedBy("has_cheese_sandwich", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CHEESE_SANDWICH.get())).save(output, ResourceLocation.fromNamespaceAndPath("expandeddelight", "grilled_cheese"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(EDItems.SALT_ORE.get()), RecipeCategory.MISC, EDItems.SALT_ROCK.get(), 0.1F, 200)
                .unlockedBy("has_salt_ore", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.SALT_ORE.get())).save(output, ResourceLocation.fromNamespaceAndPath("expandeddelight", "salt_rock_from_smelting"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(EDItems.SALT_ORE.get()), RecipeCategory.MISC, EDItems.SALT_ROCK.get(), 0.1F, 100)
                .unlockedBy("has_salt_ore", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.SALT_ORE.get())).save(output, ResourceLocation.fromNamespaceAndPath("expandeddelight", "salt_rock_from_blasting"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(EDItems.DEEPSLATE_SALT_ORE.get()), RecipeCategory.MISC, EDItems.SALT_ROCK.get(), 0.1F, 200)
                .unlockedBy("has_deepslate_salt_ore", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.DEEPSLATE_SALT_ORE.get())).save(output, ResourceLocation.fromNamespaceAndPath("expandeddelight", "deepslate_salt_rock_from_smelting"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(EDItems.DEEPSLATE_SALT_ORE.get()), RecipeCategory.MISC, EDItems.SALT_ROCK.get(), 0.1F, 100)
                .unlockedBy("has_deepslate_salt_ore", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.DEEPSLATE_SALT_ORE.get())).save(output, ResourceLocation.fromNamespaceAndPath("expandeddelight", "deepslate_salt_rock_from_blasting"));
    }

    private static void foodSmeltingRecipes(String name, ItemLike ingredient, ItemLike result, float experience, RecipeOutput output) {
        String namePrefix = ResourceLocation.fromNamespaceAndPath("expandeddelight", name).toString();
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 200).unlockedBy(name, InventoryChangeTrigger.TriggerInstance.hasItems(ingredient)).save(output);
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 600).unlockedBy(name, InventoryChangeTrigger.TriggerInstance.hasItems(ingredient)).save(output, namePrefix + "_from_campfire_cooking");
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 100).unlockedBy(name, InventoryChangeTrigger.TriggerInstance.hasItems(ingredient)).save(output, namePrefix + "_from_smoking");
    }
}
