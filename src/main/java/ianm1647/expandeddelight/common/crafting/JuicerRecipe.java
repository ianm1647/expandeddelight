package ianm1647.expandeddelight.common.crafting;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import ianm1647.expandeddelight.client.recipebook.JuicerRecipeBookTab;
import ianm1647.expandeddelight.common.registry.EDItems;
import ianm1647.expandeddelight.common.registry.EDRecipeSerializers;
import ianm1647.expandeddelight.common.registry.EDRecipeTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.util.RecipeMatcher;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;

import javax.annotation.Nullable;
import java.util.*;

public class JuicerRecipe implements Recipe<RecipeWrapper> {
   public static final int INPUT_SLOTS = 2;
   private final String group;
   private final JuicerRecipeBookTab tab;
   private final NonNullList<Ingredient> inputItems;
   private final ItemStack output;
   private final ItemStack container;
   private final ItemStack containerOverride;
   private final float experience;
   private final int juiceTime;

   public JuicerRecipe(String group, @Nullable JuicerRecipeBookTab tab, NonNullList<Ingredient> inputItems, ItemStack output, ItemStack container, float experience, int juiceTime) {
      this.group = group;
      this.tab = tab;
      this.inputItems = inputItems;
      this.output = output;
      if (!container.isEmpty()) {
         this.container = container;
      } else if (!output.getCraftingRemainingItem().isEmpty()) {
         this.container = output.getCraftingRemainingItem();
      } else {
         this.container = ItemStack.EMPTY;
      }
      this.containerOverride = container;
      this.experience = experience;
      this.juiceTime = juiceTime;
   }

   public String getGroup() {
      return this.group;
   }

   @Nullable
   public JuicerRecipeBookTab getRecipeBookTab() {
      return this.tab;
   }

   public NonNullList<Ingredient> getIngredients() {
      return this.inputItems;
   }

   public ItemStack getResultItem(HolderLookup.Provider provider) {
      return this.output;
   }

   public ItemStack getOutputContainer() {
      return this.container;
   }

   public ItemStack getContainerOverride() {
      return this.containerOverride;
   }

   public ItemStack assemble(RecipeWrapper inv, HolderLookup.Provider provider) {
      return this.output.copy();
   }

   public float getExperience() {
      return this.experience;
   }

   public int getJuiceTime() {
      return this.juiceTime;
   }

   public boolean matches(RecipeWrapper inv, Level level) {
      List<ItemStack> inputs = new ArrayList();
      int i = 0;

      for(int j = 0; j < 2; ++j) {
         ItemStack itemstack = inv.getItem(j);
         if (!itemstack.isEmpty()) {
            ++i;
            inputs.add(itemstack);
         }
      }

      return i == this.inputItems.size() && RecipeMatcher.findMatches(inputs, this.inputItems) != null;
   }

   public boolean canCraftInDimensions(int width, int height) {
      return width * height >= this.inputItems.size();
   }

   public RecipeSerializer<?> getSerializer() {
      return EDRecipeSerializers.JUICING.get();
   }

   public RecipeType<?> getType() {
      return EDRecipeTypes.JUICING.get();
   }

   public ItemStack getToastSymbol() {
      return new ItemStack(EDItems.JUICER.get());
   }

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         JuicerRecipe that = (JuicerRecipe)o;
         if (Float.compare(that.getExperience(), this.getExperience()) != 0) {
            return false;
         } else if (this.getJuiceTime() != that.getJuiceTime()) {
            return false;
         } else if (!this.getGroup().equals(that.getGroup())) {
            return false;
         } else if (this.tab != that.tab) {
            return false;
         } else if (!this.inputItems.equals(that.inputItems)) {
            return false;
         } else {
            return this.output.equals(that.output) && this.container.equals(that.container);
         }
      } else {
         return false;
      }
   }

   public int hashCode() {
      int result = this.getGroup().hashCode();
      result = 31 * result + (this.getRecipeBookTab() != null ? this.getRecipeBookTab().hashCode() : 0);
      result = 31 * result + this.inputItems.hashCode();
      result = 31 * result + this.output.hashCode();
      result = 31 * result + this.container.hashCode();
      result = 31 * result + (this.getExperience() != 0.0F ? Float.floatToIntBits(this.getExperience()) : 0);
      result = 31 * result + this.getJuiceTime();
      return result;
   }

   public static class Serializer implements RecipeSerializer<JuicerRecipe> {
      private static final MapCodec<JuicerRecipe> CODEC = RecordCodecBuilder.mapCodec((inst) -> inst.group(Codec.STRING.optionalFieldOf("group", "").forGetter(JuicerRecipe::getGroup),
              JuicerRecipeBookTab.CODEC.optionalFieldOf("recipe_book_tab").xmap((optional) -> optional.orElse(JuicerRecipeBookTab.MISC), Optional::of).forGetter(JuicerRecipe::getRecipeBookTab),
              Ingredient.LIST_CODEC_NONEMPTY.fieldOf("ingredients").xmap((ingredients) -> {
         NonNullList<Ingredient> nonNullList = NonNullList.create();
         nonNullList.addAll(ingredients);
         return nonNullList;
      }, (ingredients) -> ingredients).forGetter(JuicerRecipe::getIngredients), ItemStack.STRICT_CODEC.fieldOf("result").forGetter((r) -> r.output),
              ItemStack.STRICT_CODEC.optionalFieldOf("container", ItemStack.EMPTY).forGetter(JuicerRecipe::getContainerOverride), Codec.FLOAT.optionalFieldOf("experience", 0.0F)
                      .forGetter(JuicerRecipe::getExperience), Codec.INT.optionalFieldOf("juicingtime", 200).forGetter(JuicerRecipe::getJuiceTime)).apply(inst, JuicerRecipe::new));
      public static final StreamCodec<RegistryFriendlyByteBuf, JuicerRecipe> STREAM_CODEC = StreamCodec.of(JuicerRecipe.Serializer::toNetwork, JuicerRecipe.Serializer::fromNetwork);

      public Serializer() {
      }

      public MapCodec<JuicerRecipe> codec() {
         return CODEC;
      }

      @Override
      public StreamCodec<RegistryFriendlyByteBuf, JuicerRecipe> streamCodec() {
         return STREAM_CODEC;
      }

      private static JuicerRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
         String groupIn = buffer.readUtf();
         JuicerRecipeBookTab tabIn = JuicerRecipeBookTab.findByName(buffer.readUtf());
         int i = buffer.readVarInt();
         NonNullList<Ingredient> inputItemsIn = NonNullList.withSize(i, Ingredient.EMPTY);
         inputItemsIn.replaceAll((ignored) -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
         ItemStack outputIn = ItemStack.STREAM_CODEC.decode(buffer);
         ItemStack container = ItemStack.OPTIONAL_STREAM_CODEC.decode(buffer);
         float experienceIn = buffer.readFloat();
         int cookTimeIn = buffer.readVarInt();
         return new JuicerRecipe(groupIn, tabIn, inputItemsIn, outputIn, container, experienceIn, cookTimeIn);
      }

      private static void toNetwork(RegistryFriendlyByteBuf buffer, JuicerRecipe recipe) {
         buffer.writeUtf(recipe.group);
         buffer.writeUtf(recipe.tab != null ? recipe.tab.toString() : "");
         buffer.writeVarInt(recipe.inputItems.size());
         Iterator var2 = recipe.inputItems.iterator();

         while(var2.hasNext()) {
            Ingredient ingredient = (Ingredient)var2.next();
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient);
         }

         ItemStack.STREAM_CODEC.encode(buffer, recipe.output);
         ItemStack.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.container);
         buffer.writeFloat(recipe.experience);
         buffer.writeVarInt(recipe.juiceTime);
      }
   }
}
