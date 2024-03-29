package com.cortez.adventuremod.util;

import com.cortez.adventuremod.AdventureMod;
import com.cortez.adventuremod.blocks.ModBlocks;
import com.cortez.adventuremod.blocks.ModFlammableBlockRegistry;
import com.cortez.adventuremod.blocks.entity.ModBlockEntities;
import com.cortez.adventuremod.command.BackCommand;
import com.cortez.adventuremod.command.ReturnHomeCommand;
import com.cortez.adventuremod.command.SetHomeCommand;
import com.cortez.adventuremod.effect.ModEffects;
import com.cortez.adventuremod.event.AxeWoodcutter;
import com.cortez.adventuremod.event.ModPlayerEventCopyFrom;
import com.cortez.adventuremod.event.PlayerTickHandler;
import com.cortez.adventuremod.fluids.ModFluids;
import com.cortez.adventuremod.groups.ModGroups;
import com.cortez.adventuremod.items.ModItems;
import com.cortez.adventuremod.potions.ModPotions;
import com.cortez.adventuremod.recipe.ModRecipes;
import com.cortez.adventuremod.screen.ModScreenHandlers;
import com.cortez.adventuremod.world.gen.ModWorldGeneration;
import com.cortez.adventuremod.world.village.VillageAdditions;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;

/**
 * Classe responsável pelo registro de todas as funcionalidades do mod.
 */
public class ModRegister
{
    public static void register(){
        // Registra grupos, itens, blocos, poções e tabelas de loot personalizadas
        registerGroups();
        registerItems();
        registerBlocks();
        registerEffects();
        registerPotions();
        registerModifyLootTables();
        regiterWorldGen();
        registerCommands();
        registerEvents();
        registerBlocksEntity();
        registerScreen();
        registerRecipe();
        registerVillageStructures();
        registerFluids();
    }


    /**
     * Registra os grupos do mod.
     */
    private static void registerGroups(){
        AdventureMod.LOGGER.info("Register Groups " + AdventureMod.MODID);
        ModGroups.registerItemGroups();
    }

    /**
     * Registra os itens do mod.
     */
    private static void registerItems(){
        AdventureMod.LOGGER.info("Register Items " + AdventureMod.MODID);
        ModItems.registerItems();
    }

    /**
     * Registra os blocos do mod.
     */
    private static void registerBlocks(){
        AdventureMod.LOGGER.info("Register Blocks " + AdventureMod.MODID);
        ModBlocks.registerBlocks();
        ModFlammableBlockRegistry.registerFlammableBlocks();
    }

    /**
     * Registra as poções do mod.
     */
    private static void registerPotions(){
        AdventureMod.LOGGER.info("Register Potions " + AdventureMod.MODID);
        ModPotions.registerPotions();
    }

    /**
     * Registra as tabelas de loot modificadas do mod.
     */
    private static void registerModifyLootTables(){
        AdventureMod.LOGGER.info("Register LootTables " + AdventureMod.MODID);
        ModLootTableModdifiers.modifyLootTables();
    }
    /**
     * Registra WorldGen.
     */
    private static void regiterWorldGen()
    {
        ModWorldGeneration.generateModWorldGen();
    }

    private static void registerCommands() {
        CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
        CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);
        CommandRegistrationCallback.EVENT.register(BackCommand::register);
    }

    private static void registerEvents() {
        ServerPlayerEvents.COPY_FROM.register(new ModPlayerEventCopyFrom());
        ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
        PlayerBlockBreakEvents.AFTER.register(new AxeWoodcutter());
    }

    private static void registerEffects(){
        ModEffects.registerEffects();
    }

    private static void registerBlocksEntity() {
        ModBlockEntities.registerBlockEntities();
    }

    private static void registerScreen(){
        ModScreenHandlers.registerScreenHandlers();
    }

    private static void registerRecipe()
    {
        ModRecipes.registerRecipes();
    }

    private static void registerVillageStructures() {
        VillageAdditions.registerNewVillageStructures();
    }

    private static void registerFluids(){
        ModFluids.register();
    }
}
