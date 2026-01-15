package ianm1647.expandeddelight.common.mixin;

import ianm1647.expandeddelight.client.recipebook.EDRecipeBookTypes;
import ianm1647.expandeddelight.common.utility.EDNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.protocol.game.ClientboundRecipePacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.RecipeBook;
import net.minecraft.stats.ServerRecipeBook;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin({ServerRecipeBook.class})
public class ServerRecipeBookMixin extends RecipeBook {
    public ServerRecipeBookMixin() {
    }

    @Inject(
        method = {"sendRecipes"},
        at = {@At("TAIL")}
    )
    private void sendJuicingRecipeValues(ClientboundRecipePacket.State state, ServerPlayer player, List<ResourceLocation> recipes, CallbackInfo ci) {
        ServerPlayNetworking.send(player, new EDNetworking.SendRecipeBookValuesMessage(this.getBookSettings().isOpen(EDRecipeBookTypes.JUICING), this.getBookSettings().isFiltering(EDRecipeBookTypes.JUICING)));
    }
}