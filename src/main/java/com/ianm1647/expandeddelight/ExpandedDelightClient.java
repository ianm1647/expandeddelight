package com.ianm1647.expandeddelight;

import com.ianm1647.expandeddelight.registry.BlockRegistry;
import com.ianm1647.expandeddelight.registry.ScreenHandlersRegistry;
import net.fabricmc.api.ClientModInitializer;

public class ExpandedDelightClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRegistry.registerRenderLayer();
        ScreenHandlersRegistry.registerScreens();

    }
}
