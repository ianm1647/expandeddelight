package com.ianm1647.expandeddelight.registry;

import com.ianm1647.expandeddelight.ExpandedDelight;
import com.ianm1647.expandeddelight.util.inventory.screen.JuicerScreen;
import com.ianm1647.expandeddelight.util.inventory.screen.JuicerScreenHandler;

import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry.SimpleClientHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ScreenHandlersRegistry {
    public static ScreenHandlerType<JuicerScreenHandler> JUICER_HANDLER;

    public static void registerHandlers() {
        JUICER_HANDLER = handler("juicer", JuicerScreenHandler::new);
    }

    public static void registerScreens() {
        ScreenRegistry.register(JUICER_HANDLER, JuicerScreen::new);
    }

    private static ScreenHandlerType handler(String name, SimpleClientHandlerFactory<ScreenHandler> handler) {
        return ScreenHandlerRegistry.registerSimple(new Identifier(ExpandedDelight.MODID, name), handler);
    }
}

