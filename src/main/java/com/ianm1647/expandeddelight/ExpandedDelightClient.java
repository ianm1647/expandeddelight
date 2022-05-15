package com.ianm1647.expandeddelight;

import com.ianm1647.expandeddelight.registry.BlockRegistry;
import com.ianm1647.expandeddelight.registry.ScreenHandlersRegistry;
import com.ianm1647.expandeddelight.util.UtilRegistries;
import net.fabricmc.api.ClientModInitializer;

public class ExpandedDelightClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        UtilRegistries.registerRenderLayer();
        ScreenHandlersRegistry.registerScreens();

    }
}
