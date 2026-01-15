package ianm1647.expandeddelight.common.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.mojang.datafixers.util.Pair;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import ianm1647.expandeddelight.client.recipebook.EDRecipeBookTypes;
import net.minecraft.stats.RecipeBookSettings;
import net.minecraft.world.inventory.RecipeBookType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({RecipeBookSettings.class})
public class RecipeBookSettingsMixin {
    @Final
    @Mutable
    @Shadow
    private static Map<RecipeBookType, Pair<String, String>> TAG_FIELDS;
    @Shadow
    @Final
    private Map<RecipeBookType, RecipeBookSettings.TypeSettings> states;

    public RecipeBookSettingsMixin() {
    }

    @Inject(
        method = {"<clinit>"},
        at = {@At("TAIL")}
    )
    private static void modifyTagFields(CallbackInfo ci) {
        Map<RecipeBookType, Pair<String, String>> newMap = new HashMap(TAG_FIELDS);
        newMap.put(EDRecipeBookTypes.JUICING, Pair.of("isFarmersDelightCookingGuiOpen", "isFarmersDelightCookingFilteringCraftable"));
        TAG_FIELDS = Map.copyOf(newMap);
    }

    @Inject(
        method = {"<init>(Ljava/util/Map;)V"},
        at = {@At("TAIL")}
    )
    private void defaultCookingRecipeBookTypeStates(CallbackInfo ci) {
        if (!this.states.containsKey(EDRecipeBookTypes.JUICING)) {
            this.states.put(EDRecipeBookTypes.JUICING, new RecipeBookSettings.TypeSettings(false, false));
        }

    }

    @ModifyExpressionValue(
        method = {"read(Lnet/minecraft/network/FriendlyByteBuf;)Lnet/minecraft/stats/RecipeBookSettings;"},
        at = {@At(
    value = "INVOKE",
    target = "Lnet/minecraft/world/inventory/RecipeBookType;values()[Lnet/minecraft/world/inventory/RecipeBookType;"
)}
    )
    private static RecipeBookType[] modifyReadFDRecipeBookSettingsToVanilla(RecipeBookType[] original) {
        return Arrays.stream(original).filter((recipeBookType) ->
                recipeBookType != EDRecipeBookTypes.JUICING).toArray((x$0) ->
                new RecipeBookType[x$0]);
    }

    @ModifyExpressionValue(
        method = {"write(Lnet/minecraft/network/FriendlyByteBuf;)V"},
        at = {@At(
    value = "INVOKE",
    target = "Lnet/minecraft/world/inventory/RecipeBookType;values()[Lnet/minecraft/world/inventory/RecipeBookType;"
)}
    )
    private RecipeBookType[] modifyWrittenFDRecipeBookSettingsToVanilla(RecipeBookType[] original) {
        return Arrays.stream(original).filter((recipeBookType) ->
                recipeBookType != EDRecipeBookTypes.JUICING).toArray((x$0) ->
                new RecipeBookType[x$0]);
    }
}