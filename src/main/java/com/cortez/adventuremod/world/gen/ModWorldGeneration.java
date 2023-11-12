package com.cortez.adventuremod.world.gen;

public class ModWorldGeneration
{
    public static void generateModWorldGen() {
        ModTreeGeneration.generateTrees();
        ModOreGeneration.generateOres();
    }
}
