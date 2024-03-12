package com.ianm1647.expandeddelight;

import draylar.omegaconfig.api.Config;

public class ExpandedDelightConfig implements Config {
    public boolean generateAsparagus = true;
    public boolean generateSweetPotatoes = true;
    public boolean generateChiliPeppers = true;
    public boolean generatePeanuts = true;
    public boolean generateCinnamonTrees = true;
    public boolean generateSaltOre = true;


    @Override
    public String getName() {
        return "expanded-delight";
    }
}
