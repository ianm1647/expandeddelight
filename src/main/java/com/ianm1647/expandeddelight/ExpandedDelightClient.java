package com.ianm1647.expandeddelight;

import com.ianm1647.expandeddelight.registry.BlockRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class ExpandedDelightClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRegistry.registerRenderLayer();
    }
}
