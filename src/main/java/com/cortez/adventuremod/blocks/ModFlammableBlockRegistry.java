package com.cortez.adventuremod.blocks;


import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class ModFlammableBlockRegistry
{
    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();
        registry.add(ModBlocks.RUBBER_TREE_LEAVES, 30, 60);
        registry.add(ModBlocks.RUBBER_TREE_LOG_LATEX, 5,5);
        registry.add(ModBlocks.RUBBER_TREE_WOOD_LATEX,5,5);
        registry.add(ModBlocks.RUBBER_TREE_LOG,5,5);
        registry.add(ModBlocks.RUBBER_TREE_WOOD,5,5);
    }
}