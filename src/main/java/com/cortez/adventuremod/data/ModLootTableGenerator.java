package com.cortez.adventuremod.data;

import com.cortez.adventuremod.blocks.ModBlocks;
import com.cortez.adventuremod.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

/**
 * Classe responsável por gerar as tabelas de loot personalizadas para os blocos do Mod.
 */
public class ModLootTableGenerator extends FabricBlockLootTableProvider
{
    /**
     * Construtor da classe ModLootTableGenerator.
     *
     * @param dataOutput objeto FabricDataOutput para gerar os arquivos de saída.
     */
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    /**
     * Método responsável por gerar as tabelas de loot dos blocos personalizados do Mod.
     */
    @Override
    public void generate() {
        addDrop(ModBlocks.RUBBER_TREE_LOG);
        addDrop(ModBlocks.RUBBER_TREE_LOG_LATEX, ModBlocks.RUBBER_TREE_LOG);
        addDrop(ModBlocks.RUBBER_TREE_LEAVES, leavesDrops(ModBlocks.RUBBER_TREE_LEAVES, ModBlocks.RUBBER_TREE_SAPLING, 0.05F, 0.0625F, 0.083333336F, 0.1F ));
        addDrop(ModBlocks.RUBBER_TREE_SAPLING);
        addDrop(ModBlocks.TIN_BLOCK);
        addDrop(ModBlocks.TIN_ORE, ModItems.RAW_TIN);
        addDrop(ModBlocks.DEEPSLATE_TIN_ORE, ModItems.RAW_TIN);
        addDrop(ModBlocks.NETHER_TIN_ORE, ModItems.RAW_TIN);
        addDrop(ModBlocks.END_TIN_ORE, ModItems.RAW_TIN);
    }

}
