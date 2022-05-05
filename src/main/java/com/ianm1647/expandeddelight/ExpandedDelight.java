package com.ianm1647.expandeddelight;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpandedDelight implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("expandeddelight");

    @Override
    public void onInitialize() {
        LOGGER.info("Expanded Delight loaded!");
    } //Loader
}
