package com.ianm1647.expandeddelight.registry;

import com.ianm1647.expandeddelight.ExpandedDelight;
import com.ianm1647.expandeddelight.block.entity.inventory.screen.JuicerScreenHandler;
import com.ianm1647.expandeddelight.block.entity.inventory.screen.JuicerScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;


public class ScreenHandlersRegistry {
    public static ScreenHandlerType<JuicerScreenHandler> JUICER_HANDLER;

    public static void registerHandlers() {
        JUICER_HANDLER = handler("juicer", JuicerScreenHandler::new);
    }

    public static void registerScreens() {
        HandledScreens.register(JUICER_HANDLER, JuicerScreen::new);
    }

    private static <T extends ScreenHandler> ScreenHandlerType<T> handler(String name, ScreenHandlerType.Factory<T> handler) {
        return Registry.register(Registries.SCREEN_HANDLER, new Identifier(ExpandedDelight.MODID, name), new ScreenHandlerType<>(handler, FeatureSet.empty()));
    }
}
