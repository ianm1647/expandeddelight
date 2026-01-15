package ianm1647.expandeddelight;

import com.chocohead.mm.api.ClassTinkerers;
import ianm1647.expandeddelight.common.registry.EDItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.function.Supplier;

public class ExpandedDelightASM implements Runnable {
    public static final String JUICING_RECIPE_BOOK_TYPE = "EXPANDEDDELIGHT_COOKING";
    public static final String COOKING_MEALS_RECIPE_BOOK_CATEGORY = "EXPANDEDDELIGHT_COOKING_MEALS";
    public static final String JUICING_DRINKS_RECIPE_BOOK_CATEGORY = "EXPANDEDDELIGHT_COOKING_DRINKS";
    public static final String JUICING_MISC_RECIPE_BOOK_CATEGORY = "EXPANDEDDELIGHT_COOKING_MISC";

    public ExpandedDelightASM() {
    }

    public void run() {
        MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();
        String recipeBookTypeTarget = remapper.mapClassName("intermediary", "net.minecraft.class_5421");
        ClassTinkerers.enumBuilder(recipeBookTypeTarget).addEnum("EXPANDEDDELIGHT_JUICING", new Object[0]).build();
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            String recipeBookCategoriesTarget = remapper.mapClassName("intermediary", "net.minecraft.class_314");
            String itemStackParamType = "[L" + remapper.mapClassName("intermediary", "net.minecraft.class_1799") + ";";
            ClassTinkerers.enumBuilder(recipeBookCategoriesTarget, itemStackParamType).addEnum("EXPANDEDDELIGHT_JUICING_SEARCH", getSearchCategoryStacks()).build();
            ClassTinkerers.enumBuilder(recipeBookCategoriesTarget, itemStackParamType).addEnum("EXPANDEDDELIGHT_JUICING_DRINKS", getDrinksCategoryStacks()).build();
            ClassTinkerers.enumBuilder(recipeBookCategoriesTarget, itemStackParamType).addEnum("EXPANDEDDELIGHT_JUICING_MISC", getMiscCategoryStacks()).build();
        }

    }

    public static Supplier<Object[]> getSearchCategoryStacks() {
        return () -> new Object[]{new ItemStack[]{new ItemStack(Items.COMPASS)}};
    }

    public static Supplier<Object[]> getDrinksCategoryStacks() {
        return () -> new Object[]{new ItemStack[]{new ItemStack(EDItems.APPLE_JUICE.get())}};
    }

    public static Supplier<Object[]> getMiscCategoryStacks() {
        return () -> new Object[]{new ItemStack[]{new ItemStack(EDItems.CRANBERRY_JUICE.get())}};
    }
}
