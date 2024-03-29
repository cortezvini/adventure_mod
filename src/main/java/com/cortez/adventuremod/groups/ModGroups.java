package com.cortez.adventuremod.groups;

import com.cortez.adventuremod.AdventureMod;
import com.cortez.adventuremod.blocks.ModBlocks;
import com.cortez.adventuremod.fluids.ModFluids;
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
                        entries.add(ModItems.TIN_DUST);
                        entries.add(ModItems.COPPER_DUST);
                        entries.add(ModItems.BRONZE_DUST);
                        entries.add(ModItems.BRONZE_INGOT);
                        entries.add(ModItems.BRONZE_PICKAXE);
                        entries.add(ModItems.BRONZE_AXE);
                        entries.add(ModItems.BRONZE_SHOVEL);
                        entries.add(ModItems.BRONZE_SWORD);
                        entries.add(ModItems.BRONZE_HOE);
                        entries.add(ModItems.BRONZE_HELMET);
                        entries.add(ModItems.BRONZE_CHESTPLATE);
                        entries.add(ModItems.BRONZE_LEGGINGS);
                        entries.add(ModItems.BRONZE_BOOTS);
                        entries.add(ModItems.CORN_SEEDS);
                        entries.add(ModItems.CORN_COB);
                        entries.add(ModFluids.COFFEE_FLUID_BUCKET);
                        entries.add(ModItems.COFFEE_POWDER);
                        entries.add(ModItems.EMPTY_CUP);
                        entries.add(ModItems.COFFEE_CUP);
                        entries.add(ModItems.ROASTED_COFFEE);
                        entries.add(ModItems.FRUIT_COFFEE);
                        entries.add(ModItems.DRIED_FRUIT_COFFEE);
                        entries.add(ModItems.SEMIDRIED_FRUIT_COFFEE);
                        entries.add(ModItems.COFFEE_SEED);
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
                        entries.add(ModBlocks.NETHER_COAL_ORE);
                        entries.add(ModBlocks.END_COAL_ORE);
                        entries.add(ModBlocks.NETHER_IRON_ORE);
                        entries.add(ModBlocks.END_IRON_ORE);
                        entries.add(ModBlocks.NETHER_COPPER_ORE);
                        entries.add(ModBlocks.END_COPPER_ORE);
                        entries.add(ModBlocks.END_GOLD_ORE);
                        entries.add(ModBlocks.NETHER_REDSTONE_ORE);
                        entries.add(ModBlocks.END_REDSTONE_ORE);
                        entries.add(ModBlocks.NETHER_LAPISLAZULI_ORE);
                        entries.add(ModBlocks.END_LAPISLAZULI_ORE);
                        entries.add(ModBlocks.NETHER_DIAMOND_ORE);
                        entries.add(ModBlocks.END_DIAMOND_ORE);
                        entries.add(ModBlocks.NETHER_EMERALD_ORE);
                        entries.add(ModBlocks.END_EMERALD_ORE);
                        //MACHINES
                        entries.add(ModBlocks.CRUSHER_MACHINE);
                        entries.add(ModBlocks.COFFEE_MACHINE);

                    }).build());


    public static void registerItemGroups() {
        AdventureMod.LOGGER.info("Registering Item Groups for " + AdventureMod.MODID);
    }

    /**
     * Registra o grupo de itens do Adventure Mod.
     */

}