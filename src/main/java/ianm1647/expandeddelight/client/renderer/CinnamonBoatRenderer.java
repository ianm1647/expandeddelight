package ianm1647.expandeddelight.client.renderer;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.entity.CinnamonBoat;
import ianm1647.expandeddelight.common.entity.CinnamonChestBoat;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

import java.util.Map;
import java.util.stream.Stream;

public class CinnamonBoatRenderer extends BoatRenderer {
    private final Map<CinnamonBoat.Type, Pair<ResourceLocation, ListModel<Boat>>> boatResources;

    public CinnamonBoatRenderer(EntityRendererProvider.Context context, boolean chestBoat) {
        super(context, false);
        this.shadowRadius = 0.8F;
        this.boatResources = Stream.of(CinnamonBoat.Type.values()).collect(ImmutableMap.toImmutableMap((key) -> key, (model) ->
                Pair.of(ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID, getTextureLocation(model, chestBoat)), createBoatModel(context, model, chestBoat))));
    }

    private static String getTextureLocation(CinnamonBoat.Type type, boolean chestBoat) {
        return chestBoat ? "textures/entity/chest_boat/" + type.getName() + ".png" : "textures/entity/boat/" + type.getName() + ".png";
    }

    private BoatModel createBoatModel(EntityRendererProvider.Context context, CinnamonBoat.Type type, boolean hasChest) {
        ModelLayerLocation modellayerlocation = hasChest ? chestBoatTextureLocation(type) : boatTextureLocation(type);
        ModelPart baked = context.bakeLayer(modellayerlocation);
        return hasChest ? new ChestBoatModel(baked) : new BoatModel(baked);
    }

    private static ModelLayerLocation getModel(String name, String model) {
        return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ExpandedDelight.MODID, name), model);
    }

    public static ModelLayerLocation boatTextureLocation(CinnamonBoat.Type type) {
        return getModel("boat/" + type.getName(), "main");
    }

    public static ModelLayerLocation chestBoatTextureLocation(CinnamonBoat.Type type) {
        return getModel("chest_boat/" + type.getName(), "main");
    }

    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
        if (boat instanceof CinnamonBoat cinnamonBoat) {
            return this.boatResources.get(cinnamonBoat.getModel());
        } else if (boat instanceof CinnamonChestBoat cinnamonChestBoat) {
            return this.boatResources.get(cinnamonChestBoat.getModel());
        } else {
            return null;
        }
    }
}
