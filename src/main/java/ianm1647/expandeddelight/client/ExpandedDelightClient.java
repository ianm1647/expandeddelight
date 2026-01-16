package ianm1647.expandeddelight.client;

import ianm1647.expandeddelight.client.event.ClientSetupEvents;
import ianm1647.expandeddelight.client.gui.JuicerScreen;
import ianm1647.expandeddelight.common.registry.EDBlocks;
import ianm1647.expandeddelight.common.registry.EDMenuTypes;
import ianm1647.expandeddelight.common.utility.EDNetworking;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.TooltipComponentCallback;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;

public class ExpandedDelightClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TooltipComponentCallback.EVENT.register(ClientSetupEvents::registerCustomTooltipRenderers);
        ClientSetupEvents.onRegisterRenderers();

        MenuScreens.register(EDMenuTypes.JUICER.get(), JuicerScreen::new);
        EDNetworking.initClient();

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
                EDBlocks.CINNAMON_SAPLING.get(),
                EDBlocks.WILD_SWEET_POTATO.get(),
                EDBlocks.WILD_ASPARAGUS.get(),
                EDBlocks.WILD_CHILI_PEPPER.get(),
                EDBlocks.WILD_PEANUTS.get(),
                EDBlocks.CRANBERRY_PLANT.get(),
                EDBlocks.SWEET_POTATO_CROP.get(),
                EDBlocks.ASPARAGUS_CROP.get(),
                EDBlocks.CHILI_PEPPER_CROP.get(),
                EDBlocks.PEANUT_CROP.get());

    }
}
