package ianm1647.expandeddelight.common.mixin;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Goat.class)
public class RemoveMilkGoatMixin {

	@Inject(method = "mobInteract", at = @At("HEAD"), cancellable = true)
	public void mobInteract(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
		if (player.getItemInHand(hand).getItem() instanceof BucketItem) {
			cir.setReturnValue(InteractionResult.FAIL);
		}
	}
}