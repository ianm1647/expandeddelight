package com.ianm1647.expandeddelight.registry;

import com.ianm1647.expandeddelight.ExpandedDelight;
import com.ianm1647.expandeddelight.util.inventory.screen.CoolerScreen;
import com.ianm1647.expandeddelight.util.inventory.screen.CoolerScreenHandler;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry.SimpleClientHandlerFactory;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ScreenHandlersRegistry {
    public static ScreenHandlerType<CoolerScreenHandler> COOLER_HANDLER;

    public static void registerHandlers() {
        COOLER_HANDLER = handler("cooler", CoolerScreenHandler::new);
    }

    public static void registerScreens() {
        ScreenRegistry.register(COOLER_HANDLER, CoolerScreen::new);
    }

    private static ScreenHandlerType handler(String name, SimpleClientHandlerFactory<ScreenHandler> handler) {
        return ScreenHandlerRegistry.registerSimple(new Identifier(ExpandedDelight.MOD_ID, name), handler);
    }
}
