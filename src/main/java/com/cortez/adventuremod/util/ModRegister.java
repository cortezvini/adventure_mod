package com.cortez.adventuremod.util;
/**
 * Classe responsável pelo registro de todas as funcionalidades do mod.
 */
public class ModRegister implements IModRegister
{
    public static void register(){
        // Registra grupos, itens, blocos, poções e tabelas de loot personalizadas
        IModRegister.registerGroups();
        IModRegister.registerItems();
        IModRegister.registerBlocks();
        IModRegister.registerPotions();
        IModRegister.registerModifyLootTables();
        IModRegister.regiterWorldGen();
    }
}
