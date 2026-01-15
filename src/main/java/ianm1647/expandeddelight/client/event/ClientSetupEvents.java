package ianm1647.expandeddelight.client.event;

import ianm1647.expandeddelight.client.gui.JuicerTooltip;
import ianm1647.expandeddelight.client.renderer.CinnamonBoatRenderer;
import ianm1647.expandeddelight.common.entity.CinnamonBoat;
import ianm1647.expandeddelight.common.registry.EDBlockEntityTypes;
import ianm1647.expandeddelight.common.registry.EDEntityTypes;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.inventory.tooltip.TooltipComponent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;


public class ClientSetupEvents {
    private static final Map<ModelLayerLocation, Supplier<LayerDefinition>> layerDefinitions = new HashMap();

    public ClientSetupEvents() {
    }

    public static ClientTooltipComponent registerCustomTooltipRenderers(TooltipComponent data) {
        return JuicerTooltip.JuicerTooltipComponent.class.isAssignableFrom(data.getClass()) ? new JuicerTooltip((JuicerTooltip.JuicerTooltipComponent)data) : null;
    }

    public static void onRegisterRenderers() {
        /*
        LayerDefinition boatLayerDefinition = BoatModel.createBodyModel();
        LayerDefinition chestBoatLayerDefinition = ChestBoatModel.createBodyModel();
        for (CinnamonBoat.Type type : CinnamonBoat.Type.values()) {
            registerLayerDefinition(CinnamonBoatRenderer.boatTextureLocation(type), () -> boatLayerDefinition);
            registerLayerDefinition(CinnamonBoatRenderer.chestBoatTextureLocation(type), () -> chestBoatLayerDefinition);
        }

        EntityRendererRegistry.register(EDEntityTypes.CINNAMON_BOAT.get(), context -> new CinnamonBoatRenderer(context, false));
        EntityRendererRegistry.register(EDEntityTypes.CINNAMON_CHEST_BOAT.get(), context -> new CinnamonBoatRenderer(context, true));

         */

        BlockEntityRenderers.register(EDBlockEntityTypes.CINNAMON_SIGN.get(), SignRenderer::new);
        BlockEntityRenderers.register(EDBlockEntityTypes.CINNAMON_HANGING_SIGN.get(), HangingSignRenderer::new);
    }

    public static void registerLayerDefinition(ModelLayerLocation layerLocation, Supplier<LayerDefinition> supplier) {
        layerDefinitions.put(layerLocation, supplier);
    }
}
