package com.ianm1647.expandeddelight.mixin;

import com.ianm1647.expandeddelight.ExpandedDelight;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class InitializeMixin {
    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) {
        ExpandedDelight.LOGGER.info("This makes sure Expanded Delight mixins are loaded");
    }
}
