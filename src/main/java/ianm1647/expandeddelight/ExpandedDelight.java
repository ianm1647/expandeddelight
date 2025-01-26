package ianm1647.expandeddelight;

import ianm1647.expandeddelight.common.registry.*;
import ianm1647.expandeddelight.common.world.tree.EDTreePlacers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ExpandedDelight.MODID)
public class ExpandedDelight
{
    public static final String MODID = "expandeddelight";
    public static final Logger LOGGER = LogManager.getLogger();

    public ExpandedDelight(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, EDConfig.COMMON_CONFIG);
        EDBlocks.BLOCKS.register(modEventBus);
        EDItems.ITEMS.register(modEventBus);
        EDDataComponents.DATA_COMPONENTS.register(modEventBus);
        EDBlockEntityTypes.TILES.register(modEventBus);
        EDMenuTypes.MENU_TYPES.register(modEventBus);
        EDRecipeTypes.RECIPE_TYPES.register(modEventBus);
        EDRecipeSerializers.RECIPE_SERIALIZERS.register(modEventBus);
        EDTabs.CREATIVE_TABS.register(modEventBus);
        EDEntityTypes.ENTITIES.register(modEventBus);

        EDTreePlacers.FOLIAGE_PLACERS.register(modEventBus);
        //EDWoodTypes.register();
        NeoForge.EVENT_BUS.register(this);
    }



    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("Expanded Delight is starting...");
    }
}
