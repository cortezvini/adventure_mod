package com.cortez.adventuremod.groups;

import com.cortez.adventuremod.AdventureMod;
import com.cortez.adventuremod.blocks.ModBlocks;
import com.cortez.adventuremod.items.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/**
 * Classe responsável por registrar o grupo de itens do mod.
 */
public class ModGroups {
    /**
     * Grupo de itens do Adventure Mod.
     */
    public static final ItemGroup ADVENTURE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(AdventureMod.MODID, "adventuremod"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.adventuremod"))
                    .icon(() -> new ItemStack(ModItems.MAGIC_FRUIT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.MAGIC_FRUIT);
                        entries.add(ModItems.WITHERINGPOWDER);
                        entries.add(ModItems.LEVITATIONPOWDER);
                        entries.add(ModItems.OREDETECTOR);
                        entries.add(ModItems.OREDETECTORGENERIC);
                        entries.add(ModItems.LATEX_EXTRACTOR);
                        entries.add(ModItems.LATEX);
                        entries.add(ModItems.RUBBER);
                        entries.add(ModItems.DIVINGSUIT_HELMET);
                        entries.add(ModItems.DIVINGSUIT_CHESTPLATE);
                        entries.add(ModItems.DIVINGSUIT_LEGGINGS);
                        entries.add(ModItems.DIVINGSUIT_BOOTS);
                        entries.add(ModItems.RAW_TIN);
                        entries.add(ModItems.TIN_INGOT);
                        entries.add(ModItems.TIN_NUGGET);
                        //Blocks
                        entries.add(ModBlocks.RUBBER_TREE_LEAVES);
                        entries.add(ModBlocks.RUBBER_TREE_LOG);
                        entries.add(ModBlocks.RUBBER_TREE_WOOD);
                        entries.add(ModBlocks.RUBBER_TREE_SAPLING);
                        entries.add(ModBlocks.TIN_BLOCK);
                        entries.add(ModBlocks.TIN_ORE);
                        entries.add(ModBlocks.DEEPSLATE_TIN_ORE);
                        entries.add(ModBlocks.NETHER_TIN_ORE);
                        entries.add(ModBlocks.END_TIN_ORE);
                    }).build());


    public static void registerItemGroups() {
        AdventureMod.LOGGER.info("Registering Item Groups for " + AdventureMod.MODID);
    }

    /**
     * Registra o grupo de itens do Adventure Mod.
     */

}