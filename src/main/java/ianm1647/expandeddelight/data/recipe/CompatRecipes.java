package ianm1647.expandeddelight.data.recipe;

import alabaster.hearthandharvest.common.registry.HHModItems;
import alabaster.hearthandharvest.common.tag.HHCommonTags;
import ianm1647.expandeddelight.common.registry.EDItems;
import ianm1647.expandeddelight.common.tag.EDCommonTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.conditions.NotCondition;
import net.neoforged.neoforge.common.conditions.TagEmptyCondition;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

public class CompatRecipes {

    public static void register(RecipeOutput output) {
        hearthAndHarvest(output);
    }

    private static void hearthAndHarvest(RecipeOutput output) {
        //crafting
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EDItems.CRANBERRY_GOAT_CHEESE_TOAST.get(), 2).requires(Items.BREAD).requires(EDCommonTags.FOODS_GOAT_CHEESE).requires(EDCommonTags.FRUITS_CRANBERRY).unlockedBy("has_cranberries", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CRANBERRIES.get())).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, EDItems.HONEYED_GOAT_CHEESE_TART.get(), 1).pattern("ccc").pattern("ehe").pattern("mOm").define('c', EDCommonTags.FOODS_GOAT_CHEESE).define('h', Items.HONEY_BOTTLE).define('e', Tags.Items.EGGS).define('m', Tags.Items.DRINKS_MILK).define('O', ModItems.PIE_CRUST.get()).unlockedBy("has_pie_crust", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PIE_CRUST.get())).save(output.withConditions(new ModLoadedCondition("hearthandharvest")));
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, EDItems.HONEYED_GOAT_CHEESE_TART.get(), 1).pattern("##").pattern("##").define('#', EDItems.HONEYED_GOAT_CHEESE_TART_SLICE.get()).unlockedBy("has_honeyed_goat_cheese_tart_slice", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.HONEYED_GOAT_CHEESE_TART_SLICE.get())).save(output.withConditions(new ModLoadedCondition("hearthandharvest")), ResourceLocation.fromNamespaceAndPath("expandeddelight", "honeyed_goat_cheese_tart_from_slices"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EDItems.PEANUT_SALAD.get()).requires(CommonTags.Items.FOODS_LEAFY_GREEN).requires(CommonTags.Items.CROPS_TOMATO).requires(HHCommonTags.CROPS_PEANUT).requires(Items.BOWL).unlockedBy("has_peanut", InventoryChangeTrigger.TriggerInstance.hasItems(HHModItems.PEANUT.get())).save(output.withConditions(new ModLoadedCondition("hearthandharvest")));

        //cooking
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.PEANUT_HONEY_SOUP.get(), 1, 200, 0.8F, Items.BOWL).addIngredient(Tags.Items.DRINKS_MILK).addIngredient(HHCommonTags.CROPS_PEANUT).addIngredient(Items.HONEY_BOTTLE).unlockedByItems("has_peanut", HHModItems.PEANUT.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output.withConditions(new ModLoadedCondition("hearthandharvest")));
        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.MAC_AND_CHEESE.get(), 1, 200, 1.0F, Items.BOWL).addIngredient(Tags.Items.DRINKS_MILK).addIngredient(EDCommonTags.FOODS_CHEESE).addIngredient(CommonTags.Items.FOODS_PASTA).addIngredient(HHCommonTags.DUSTS_SALT).unlockedByItems("has_cheese", HHModItems.CHEDDAR_CHEESE_SLICE.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output.withConditions(new ModLoadedCondition("hearthandharvest")));

        CookingPotRecipeBuilder.cookingPotRecipe(EDItems.ASPARAGUS_FRITTATA.get(), 1, 200, 1.2F, Items.BOWL).addIngredient(Tags.Items.EGGS).addIngredient(Tags.Items.EGGS).addIngredient(EDCommonTags.CROPS_ASPARAGUS).addIngredient(EDCommonTags.FOODS_CHEESE).addIngredient(HHCommonTags.DUSTS_SALT).unlockedByItems("has_asparagus", EDItems.ASPARAGUS.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output.withConditions(new NotCondition(new TagEmptyCondition(EDCommonTags.FOODS_CHEESE))));

        //juicing

    }

}
