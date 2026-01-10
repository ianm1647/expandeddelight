package ianm1647.expandeddelight.data.recipe;

import ianm1647.expandeddelight.common.registry.EDItems;
import ianm1647.expandeddelight.common.tag.EDCommonTags;
import ianm1647.expandeddelight.common.tag.EDTags;
import net.minecraft.advancements.critereon.EnterBlockTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.ItemExistsCondition;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;

public class CraftingRecipes {

    public static void register(RecipeOutput output) {
        recipesBlocks(output);
        recipesTools(output);
        recipesMaterials(output);
        recipesFoodstuffs(output);
        recipesFoodBlocks(output);
        recipesCraftedMeals(output);
    }

    private static void recipesBlocks(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EDItems.CINNAMON_WOOD.get(), 3).pattern("ii").pattern("ii").define('i', EDItems.CINNAMON_LOG.get()).group("bark").unlockedBy("has_log", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CINNAMON_LOG.get())).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EDItems.CINNAMON_PLANKS.get(), 4).requires(EDTags.CINNAMON_LOGS).group("wooden_planks").unlockedBy("has_log", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CINNAMON_LOG.get())).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EDItems.CINNAMON_STAIRS.get(), 4).pattern("i  ").pattern("ii ").pattern("iii").define('i', EDItems.CINNAMON_PLANKS.get()).group("wooden_stairs").unlockedBy("has_planks", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CINNAMON_PLANKS.get())).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EDItems.CINNAMON_SLAB.get(), 6).pattern("iii").define('i', EDItems.CINNAMON_PLANKS.get()).group("wooden_slab").unlockedBy("has_planks", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CINNAMON_PLANKS.get())).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, EDItems.CINNAMON_FENCE.get(), 3).pattern("isi").pattern("isi").define('s', Tags.Items.RODS_WOODEN).define('i', EDItems.CINNAMON_PLANKS.get()).group("wooden_fence").unlockedBy("has_planks", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CINNAMON_PLANKS.get())).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, EDItems.CINNAMON_FENCE_GATE.get()).pattern("sis").pattern("sis").define('s', Tags.Items.RODS_WOODEN).define('i', EDItems.CINNAMON_PLANKS.get()).group("wooden_fence_gate").unlockedBy("has_planks", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CINNAMON_PLANKS.get())).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, EDItems.CINNAMON_DOOR.get(), 3).pattern("ii").pattern("ii").pattern("ii").define('i', EDItems.CINNAMON_PLANKS.get()).group("wooden_door").unlockedBy("has_planks", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CINNAMON_PLANKS.get())).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, EDItems.CINNAMON_TRAPDOOR.get(), 2).pattern("iii").pattern("iii").define('i', EDItems.CINNAMON_PLANKS.get()).group("wooden_trapdoor").unlockedBy("has_planks", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CINNAMON_PLANKS.get())).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, EDItems.CINNAMON_PRESSURE_PLATE.get()).pattern("ii").define('i', EDItems.CINNAMON_PLANKS.get()).group("wooden_pressure_plate").unlockedBy("has_planks", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CINNAMON_PLANKS.get())).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, EDItems.CINNAMON_BUTTON.get()).requires(EDItems.CINNAMON_PLANKS.get()).group("wooden_button").unlockedBy("has_planks", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CINNAMON_PLANKS.get())).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, EDItems.CINNAMON_SIGN.get(), 3).pattern("iii").pattern("iii").pattern(" s ").define('s', Tags.Items.RODS_WOODEN).define('i', EDItems.CINNAMON_PLANKS.get()).group("wooden_sign").unlockedBy("has_planks", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CINNAMON_PLANKS.get())).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, EDItems.CINNAMON_HANGING_SIGN.get(), 6).pattern("s s").pattern("iii").pattern("iii").define('s', Tags.Items.CHAINS).define('i', EDItems.CINNAMON_STRIPPED_LOG.get()).group("hanging_sign").unlockedBy("has_stripped_logs", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CINNAMON_STRIPPED_LOG.get())).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, EDItems.CINNAMON_BOAT.get()).pattern("i i").pattern("iii").define('i', EDItems.CINNAMON_PLANKS.get()).group("boat").unlockedBy("in_water", EnterBlockTrigger.TriggerInstance.entersBlock(Blocks.WATER)).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TRANSPORTATION, EDItems.CINNAMON_CHEST_BOAT.get()).requires(EDItems.CINNAMON_BOAT.get()).requires(Tags.Items.CHESTS_WOODEN).group("chest_boat").unlockedBy("has_boat", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CINNAMON_BOAT.get())).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, EDItems.CINNAMON_CABINET.get()).pattern("iii").pattern("t t").pattern("iii").define('t', EDItems.CINNAMON_TRAPDOOR.get()).define('i', EDItems.CINNAMON_PLANKS.get()).group("fd_cabinet").unlockedBy("has_cinnamon_trapdoor", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CINNAMON_TRAPDOOR.get())).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, EDItems.JUICER.get()).pattern("iii").pattern(" b ").pattern("iii").define('i', Tags.Items.INGOTS_IRON).define('b', Blocks.BARREL).unlockedBy("has_iron", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, EDItems.CASK.get()).pattern("iwi").pattern("bBb").pattern("iwi").define('i', Tags.Items.INGOTS_IRON).define('b', Blocks.BARREL).define('w', ItemTags.PLANKS).define('B', Items.BUCKET).unlockedBy("has_iron", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT)).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EDItems.ASPARAGUS_CRATE.get()).requires(EDItems.ASPARAGUS.get(), 9).unlockedBy("has_asparagus", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.ASPARAGUS.get())).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EDItems.SWEET_POTATO_CRATE.get()).requires(EDItems.SWEET_POTATO.get(), 9).unlockedBy("has_sweet_potato", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.SWEET_POTATO.get())).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EDItems.CHILI_PEPPER_CRATE.get()).requires(EDItems.CHILI_PEPPER.get(), 9).unlockedBy("has_chili_pepper", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CHILI_PEPPER.get())).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EDItems.CRANBERRY_BAG.get()).requires(EDItems.CRANBERRIES.get(), 9).unlockedBy("has_cranberries", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CRANBERRIES.get())).save(output);

    }

    private static void recipesTools(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EDItems.CRUSHING_MALLET.get(), 1).pattern("  s").pattern(" S ").pattern("s  ").define('s', Items.STICK).define('S', Items.COBBLESTONE).unlockedBy("has_cobblestone", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COBBLESTONE)).save(output);
    }

    private static void recipesMaterials(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EDItems.GLASS_JAR.get(), 3).pattern("g g").pattern("gpg").pattern(" g ").define('g', Items.GLASS).define('p', Items.PAPER).unlockedBy("has_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLASS)).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EDItems.ASPARAGUS_SEEDS.get()).requires(EDItems.ASPARAGUS.get()).unlockedBy("has_asparagus", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.ASPARAGUS.get())).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EDItems.CHILI_PEPPER_SEEDS.get()).requires(EDItems.CHILI_PEPPER.get()).unlockedBy("has_chili_pepper", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CHILI_PEPPER.get())).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EDItems.ASPARAGUS.get(), 9).requires(EDItems.ASPARAGUS_CRATE.get()).unlockedBy("has_asparagus", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.ASPARAGUS.get())).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EDItems.SWEET_POTATO.get(), 9).requires(EDItems.SWEET_POTATO_CRATE.get()).unlockedBy("has_sweet_potato", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.SWEET_POTATO.get())).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EDItems.CHILI_PEPPER.get(), 9).requires(EDItems.CHILI_PEPPER_CRATE.get()).unlockedBy("has_chili_pepper", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CHILI_PEPPER.get())).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EDItems.CRANBERRIES.get(), 9).requires(EDItems.CRANBERRY_BAG.get()).unlockedBy("has_cranberries", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CRANBERRIES.get())).save(output);
    }

    private static void recipesFoodstuffs(RecipeOutput output) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EDItems.SWEET_ROLL.get()).requires(CommonTags.FOODS_MILK).requires(CommonTags.FOODS_DOUGH).requires(EDCommonTags.DUSTS_CINNAMON).requires(Items.SUGAR).unlockedBy("has_cinnamon", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CINNAMON.get())).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EDItems.BERRY_SWEET_ROLL.get()).requires(CommonTags.FOODS_MILK).requires(CommonTags.FOODS_DOUGH).requires(EDCommonTags.DUSTS_CINNAMON).requires(Items.SUGAR).requires(Items.SWEET_BERRIES).unlockedBy("has_berries", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SWEET_BERRIES)).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EDItems.GLOW_BERRY_SWEET_ROLL.get()).requires(CommonTags.FOODS_MILK).requires(CommonTags.FOODS_DOUGH).requires(EDCommonTags.DUSTS_CINNAMON).requires(Items.SUGAR).requires(Items.GLOW_BERRIES).unlockedBy("has_berries", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLOW_BERRIES)).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EDItems.CHEESE_SANDWICH.get()).requires(Items.BREAD).requires(EDCommonTags.FOODS_CHEESE).unlockedBy("has_cheese", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CHEESE_SLICE.get())).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EDItems.PEANUT_BUTTER_SANDWICH.get()).requires(Items.BREAD).requires(EDItems.PEANUT_BUTTER.get()).unlockedBy("has_peanut_butter", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.PEANUT_BUTTER.get())).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EDItems.PEANUT_BUTTER_HONEY_SANDWICH.get()).requires(Items.BREAD).requires(EDItems.PEANUT_BUTTER.get()).requires(Items.HONEY_BOTTLE).unlockedBy("has_honey", InventoryChangeTrigger.TriggerInstance.hasItems(Items.HONEY_BOTTLE)).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EDItems.SWEET_BERRY_JELLY_SANDWICH.get()).requires(Items.BREAD).requires(EDItems.PEANUT_BUTTER.get()).requires(EDCommonTags.JAMS_SWEET_BERRY).unlockedBy("has_jelly", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.SWEET_BERRY_JELLY.get())).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EDItems.GLOW_BERRY_JELLY_SANDWICH.get()).requires(Items.BREAD).requires(EDItems.PEANUT_BUTTER.get()).requires(EDCommonTags.JAMS_GLOW_BERRY).unlockedBy("has_jelly", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.GLOW_BERRY_JELLY.get())).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EDItems.CRANBERRY_JELLY_SANDWICH.get()).requires(Items.BREAD).requires(EDItems.PEANUT_BUTTER.get()).requires(EDCommonTags.JAMS_CRANBERRY).unlockedBy("has_jelly", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CRANBERRY_JELLY.get())).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, EDItems.CHOCOLATE_COOKIE.get(), 8).pattern("cwc").define('c', Items.COCOA_BEANS).define('w', CommonTags.CROPS_GRAIN).unlockedBy("has_cocoa", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COCOA_BEANS)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, EDItems.SUGAR_COOKIE.get(), 8).pattern("cwc").define('w', Items.SUGAR).define('c', Tags.Items.CROPS_WHEAT).unlockedBy("has_sugar", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SUGAR)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, EDItems.SNICKERDOODLE.get(), 8).pattern("cwc").define('w', EDItems.CINNAMON.get()).define('c', Tags.Items.CROPS_WHEAT).unlockedBy("has_cinnamon", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CINNAMON.get())).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EDItems.GOAT_MILK_BOTTLE.get(), 4).requires(EDItems.GOAT_MILK_BUCKET.get()).requires(Items.GLASS_BOTTLE, 4).unlockedBy("has_goat_milk", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.GOAT_MILK_BUCKET.get())).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EDItems.CRANBERRY_GOAT_CHESE_TOAST.get(), 2).requires(Items.BREAD).requires(EDCommonTags.FOODS_GOAT_CHEESE).requires(EDItems.CRANBERRIES.get()).unlockedBy("has_cranberries", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CRANBERRIES.get())).save(output);

        //fd overrides
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.WHEAT_DOUGH.get(), 3).requires(Items.WATER_BUCKET).requires(Items.WHEAT).requires(Items.WHEAT).requires(Items.WHEAT).requires(EDItems.SALT.get()).unlockedBy("has_wheat", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT)).group("fd_wheat_dough").save(output.withConditions(new ItemExistsCondition("farmersdelight", "wheat_dough")), ResourceLocation.fromNamespaceAndPath("farmersdelight", "wheat_dough_from_water"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.WHEAT_DOUGH.get(), 3).requires(Tags.Items.EGGS).requires(Items.WHEAT).requires(Items.WHEAT).requires(Items.WHEAT).requires(EDItems.SALT.get()).unlockedBy("has_wheat", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT)).group("fd_wheat_dough").save(output.withConditions(new ItemExistsCondition("farmersdelight", "wheat_dough")), ResourceLocation.fromNamespaceAndPath("farmersdelight", "wheat_dough_from_eggs"));
    }

    public static void recipesFoodBlocks(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, EDItems.CRANBERRY_COBBLER.get(), 1).pattern("#e#").pattern("aaa").pattern("xOx").define('#', Items.WHEAT).define('e', Tags.Items.EGGS).define('a', EDItems.CRANBERRIES.get()).define('x', Items.SUGAR).define('O', ModItems.PIE_CRUST.get()).unlockedBy("has_pie_crust", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PIE_CRUST.get())).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, EDItems.CRANBERRY_COBBLER.get(), 1).pattern("##").pattern("##").define('#', EDItems.CRANBERRY_COBBLER_SLICE.get()).unlockedBy("has_cranberry_cobbler_slice", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.CRANBERRY_COBBLER_SLICE.get())).save(output, ResourceLocation.fromNamespaceAndPath("expandeddelight", "cranberry_cobbler_from_slices"));
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, EDItems.HONEYED_GOAT_CHEESE_TART.get(), 1).pattern("ccc").pattern("ehe").pattern("mOm").define('c', EDCommonTags.FOODS_GOAT_CHEESE).define('h', Items.HONEY_BOTTLE).define('e', Tags.Items.EGGS).define('m', CommonTags.FOODS_MILK).define('O', ModItems.PIE_CRUST.get()).unlockedBy("has_pie_crust", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PIE_CRUST.get())).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, EDItems.HONEYED_GOAT_CHEESE_TART.get(), 1).pattern("##").pattern("##").define('#', EDItems.HONEYED_GOAT_CHEESE_TART_SLICE.get()).unlockedBy("has_honeyed_goat_cheese_tart_slice", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.HONEYED_GOAT_CHEESE_TART_SLICE.get())).save(output, ResourceLocation.fromNamespaceAndPath("expandeddelight", "honeyed_goat_cheese_tart_from_slices"));


    }

    private static void recipesCraftedMeals(RecipeOutput output) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EDItems.PEANUT_SALAD.get()).requires(CommonTags.FOODS_LEAFY_GREEN).requires(CommonTags.CROPS_TOMATO).requires(EDCommonTags.CROPS_PEANUT).requires(Items.BOWL).unlockedBy("has_peanut", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.PEANUT.get())).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EDItems.SWEET_POTATO_SALAD.get()).requires(CommonTags.FOODS_LEAFY_GREEN).requires(CommonTags.CROPS_ONION).requires(EDCommonTags.CROPS_SWEET_POTATO).requires(EDCommonTags.DUSTS_CINNAMON).requires(Items.BOWL).unlockedBy("has_sweet_potato", InventoryChangeTrigger.TriggerInstance.hasItems(EDItems.SWEET_POTATO.get())).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EDItems.GOAT_CHEESE_BEETROOT_SALAD.get()).requires(CommonTags.FOODS_LEAFY_GREEN).requires(EDCommonTags.FOODS_GOAT_CHEESE).requires(Tags.Items.CROPS_BEETROOT).requires(Items.BOWL).unlockedBy("has_beetroot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BEETROOT)).save(output);

    }
}
