package com.cortez.adventuremod.groups;

import com.cortez.adventuremod.AdventureMod;
import com.cortez.adventuremod.items.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/**
 * Classe responsável por registrar o grupo de itens do mod.
 */
public class ModGroups {
    /**
     * Grupo de itens do Adventure Mod.
     */
    public static ItemGroup ADVENTUREMOD;

    /**
     * Registra o grupo de itens do Adventure Mod.
     */
    public static void registerGroup(){
        ADVENTUREMOD = FabricItemGroup.builder(new Identifier(AdventureMod.MODID, "adventuremod"))
                .displayName(Text.literal("Adventure Mod"))
                .icon(()-> new ItemStack(ModItems.MAGIC_FRUIT)).build();
    }
}