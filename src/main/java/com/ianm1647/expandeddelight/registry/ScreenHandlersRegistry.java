package com.ianm1647.expandeddelight.registry;

import com.ianm1647.expandeddelight.ExpandedDelight;
import com.ianm1647.expandeddelight.util.inventory.screen.CoolerScreen;
import com.ianm1647.expandeddelight.util.inventory.screen.CoolerScreenHandler;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry.SimpleClientHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ScreenHandlersRegistry {
    public static ScreenHandlerType<CoolerScreenHandler> COOLER_HANDLER;

    public static void registerScreens() {
        ScreenRegistry.register(COOLER_HANDLER, CoolerScreen::new);
    }

    public static void registerHandlers() {
        COOLER_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(ExpandedDelight.MOD_ID, "cooler"), CoolerScreenHandler::new);
    }
}
