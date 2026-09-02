package ianm1647.expandeddelight.client.gui;

import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.crafting.JuicerRecipe;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;

import javax.annotation.Nonnull;
import java.util.List;

public class JuicerRecipeBookComponent extends RecipeBookComponent {
    protected static final WidgetSprites RECIPE_BOOK_BUTTONS = new WidgetSprites(
            ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID, "recipe_book/juicer_enabled"),
            ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID, "recipe_book/juicer_disabled"),
            ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID, "recipe_book/juicer_enabled_highlighted"),
            ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID, "recipe_book/juicer_disabled_highlighted"));

    protected void initFilterButtonTextures() {
        this.filterButton.initTextureValues(RECIPE_BOOK_BUTTONS);
    }

    public void hide() {
        this.setVisible(false);
    }

    @Nonnull
    protected Component getRecipeFilterName() {
        return Component.translatable("expandeddelight.container.recipe_book.juiceable");
    }

    public void setupGhostRecipe(RecipeHolder<?> recipe, List<Slot> slots) {
        ItemStack resultStack = recipe.value().getResultItem(RegistryAccess.EMPTY);
        this.ghostRecipe.setRecipe(recipe);
        if (slots.get(2).getItem().isEmpty()) {
            this.ghostRecipe.addIngredient(Ingredient.of(resultStack), slots.get(2).x, slots.get(2).y);
        }

        if (recipe.value() instanceof JuicerRecipe juicerRecipe) {
            ItemStack containerStack = juicerRecipe.getOutputContainer();
            if (!containerStack.isEmpty()) {
                this.ghostRecipe.addIngredient(Ingredient.of(containerStack), slots.get(3).x, slots.get(3).y);
            }
        }

        this.placeRecipe(this.menu.getGridWidth(), this.menu.getGridHeight(), this.menu.getResultSlotIndex(), recipe, recipe.value().getIngredients().iterator(), 0);
    }
}