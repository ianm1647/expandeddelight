package ianm1647.expandeddelight.client.event;

import ianm1647.expandeddelight.client.gui.JuicerScreen;
import ianm1647.expandeddelight.client.gui.JuicerTooltip;
import ianm1647.expandeddelight.client.recipebook.RecipeCategories;
import ianm1647.expandeddelight.client.renderer.CinnamonBoatRenderer;
import ianm1647.expandeddelight.common.entity.CinnamonBoat;
import ianm1647.expandeddelight.common.registry.EDBlockEntityTypes;
import ianm1647.expandeddelight.common.registry.EDEntityTypes;
import ianm1647.expandeddelight.common.registry.EDMenuTypes;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.neoforge.client.ClientHooks;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterClientTooltipComponentFactoriesEvent;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.event.RegisterRecipeBookCategoriesEvent;


@EventBusSubscriber(
        modid = "expandeddelight",
        bus = Bus.MOD,
        value = {Dist.CLIENT}
)
public class ClientSetupEvents {
    public ClientSetupEvents() {
    }

    @SubscribeEvent
    public static void registerRecipeBookCategories(RegisterRecipeBookCategoriesEvent event) {
        RecipeCategories.init(event);
    }

    @SubscribeEvent
    public static void registerCustomTooltipRenderers(RegisterClientTooltipComponentFactoriesEvent event) {
        event.register(JuicerTooltip.JuicerTooltipComponent.class, JuicerTooltip::new);
    }

    @SubscribeEvent
    public static void registerGuiLayers(RegisterGuiLayersEvent event) {
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        LayerDefinition boatLayerDefinition = BoatModel.createBodyModel();
        LayerDefinition chestBoatLayerDefinition = ChestBoatModel.createBodyModel();
        for (CinnamonBoat.Type type : CinnamonBoat.Type.values()) {
            ClientHooks.registerLayerDefinition(CinnamonBoatRenderer.boatTextureLocation(type), () -> boatLayerDefinition);
            ClientHooks.registerLayerDefinition(CinnamonBoatRenderer.chestBoatTextureLocation(type), () -> chestBoatLayerDefinition);
        }
        event.registerEntityRenderer(EDEntityTypes.CINNAMON_BOAT.get(), context -> new CinnamonBoatRenderer(context, false));
        event.registerEntityRenderer(EDEntityTypes.CINNAMON_CHEST_BOAT.get(), context -> new CinnamonBoatRenderer(context, true));

        event.registerBlockEntityRenderer(EDBlockEntityTypes.CINNAMON_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(EDBlockEntityTypes.CINNAMON_HANGING_SIGN.get(), HangingSignRenderer::new);
    }

    @SubscribeEvent
    public static void registerMenuScreens(RegisterMenuScreensEvent event) {
        event.register(EDMenuTypes.JUICER.get(), JuicerScreen::new);
    }

    @SubscribeEvent(
            priority = EventPriority.LOWEST
    )
    public static void registerParticles(RegisterParticleProvidersEvent event) {

    }
}
