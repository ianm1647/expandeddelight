package ianm1647.expandeddelight.integration.jei.category;

import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.crafting.JuicerRecipe;
import ianm1647.expandeddelight.common.registry.EDItems;
import ianm1647.expandeddelight.integration.jei.JEIRecipeTypes;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableAnimated.StartDirection;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Arrays;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class JuicingRecipeCategory implements IRecipeCategory<JuicerRecipe> {
   protected final IDrawableAnimated arrow;
   private final Component title = Component.translatable("expandeddelight.jei.juicing");
   private final IDrawable background;
   private final IDrawable icon;

   public JuicingRecipeCategory(IGuiHelper helper) {
      ResourceLocation backgroundImage = ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID, "textures/gui/jei/juicer.png");
      this.background = helper.createDrawable(backgroundImage, 29, 6, 117, 67);
      this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack((ItemLike) EDItems.JUICER.get()));
      this.arrow = helper.drawableBuilder(backgroundImage, 176, 0, 30, 17).buildAnimated(200, StartDirection.LEFT, false);
   }

   public RecipeType<JuicerRecipe> getRecipeType() {
      return JEIRecipeTypes.JUICING;
   }

   public Component getTitle() {
      return this.title;
   }

   public IDrawable getBackground() {
      return this.background;
   }

   public IDrawable getIcon() {
      return this.icon;
   }

   public void setRecipe(IRecipeLayoutBuilder builder, JuicerRecipe recipe, IFocusGroup focusGroup) {
      NonNullList<Ingredient> recipeIngredients = recipe.getIngredients();
      ItemStack resultStack = recipe.getResultItem(RegistryAccess.EMPTY);
      ItemStack containerStack = recipe.getOutputContainer();
      int borderSlotSize = 18;

      for(int row = 0; row < 2; ++row) {
         for(int column = 0; column < 1; ++column) {
            int inputIndex = row * 1 + column;
            if (inputIndex < recipeIngredients.size()) {
               builder.addSlot(RecipeIngredientRole.INPUT, column * borderSlotSize + 13, row * borderSlotSize + 17)
                  .addItemStacks(Arrays.asList(((Ingredient)recipeIngredients.get(inputIndex)).getItems()));
            }
         }
      }
      builder.addSlot(RecipeIngredientRole.OUTPUT, 89, 20).addItemStack(resultStack);
      if (!containerStack.isEmpty()) {
         builder.addSlot(RecipeIngredientRole.OUTPUT, 57, 49).addItemStack(containerStack);
      }
      builder.addSlot(RecipeIngredientRole.OUTPUT, 89, 49).addItemStack(resultStack);
   }

   public void draw(JuicerRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics matrixStack, double mouseX, double mouseY) {
      this.arrow.draw(matrixStack, 42, 19);
   }
}
