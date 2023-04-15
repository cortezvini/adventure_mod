package com.cortez.adventuremod.util;

import com.cortez.adventuremod.AdventureMod;
import com.cortez.adventuremod.blocks.ModBlocks;
import com.cortez.adventuremod.blocks.ModFlammableBlockRegistry;
import com.cortez.adventuremod.groups.ModGroups;
import com.cortez.adventuremod.items.ModItems;
import com.cortez.adventuremod.potions.ModPotions;
import com.cortez.adventuremod.world.gen.ModWorldGeneration;

/**
 * Interface responsável por definir os métodos de registro das funcionalidades do mod.
 */
public interface IModRegister
{
    /**
     * Registra os grupos do mod.
     */
    static void registerGroups(){
        AdventureMod.LOGGER.info("Register Groups " + AdventureMod.MODID);
        ModGroups.registerGroup();
    }

    /**
     * Registra os itens do mod.
     */
    static void registerItems(){
        AdventureMod.LOGGER.info("Register Items " + AdventureMod.MODID);
        ModItems.registerItems();
    }

    /**
     * Registra os blocos do mod.
     */
    static void registerBlocks(){
        AdventureMod.LOGGER.info("Register Blocks " + AdventureMod.MODID);
        ModBlocks.registerBlocks();
        ModFlammableBlockRegistry.registerFlammableBlocks();
    }

    /**
     * Registra as poções do mod.
     */
    static void registerPotions(){
        AdventureMod.LOGGER.info("Register Potions " + AdventureMod.MODID);
        ModPotions.registerPotions();
    }

    /**
     * Registra as tabelas de loot modificadas do mod.
     */
    static void registerModifyLootTables(){
        AdventureMod.LOGGER.info("Register LootTables " + AdventureMod.MODID);
        ModLootTableModdifiers.modifyLootTables();
    }
    /**
     * Registra WorldGen.
     */
    static void regiterWorldGen()
    {
        ModWorldGeneration.generateModWorldGen();
    }
}