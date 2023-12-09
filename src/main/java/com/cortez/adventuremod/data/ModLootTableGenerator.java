package com.cortez.adventuremod.data;

import com.cortez.adventuremod.blocks.ModBlocks;
import com.cortez.adventuremod.blocks.custom.CornCropBlock;
import com.cortez.adventuremod.blocks.custom.FruitCoffeeBlock;
import com.cortez.adventuremod.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.AnyOfLootCondition;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;

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
        addDrop(ModBlocks.NETHER_COAL_ORE, Items.COAL);
        addDrop(ModBlocks.END_COAL_ORE, Items.COAL);
        addDrop(ModBlocks.NETHER_IRON_ORE, Items.RAW_IRON);
        addDrop(ModBlocks.END_IRON_ORE, Items.RAW_IRON);
        addDrop(ModBlocks.END_GOLD_ORE, Items.RAW_GOLD);
        addDrop(ModBlocks.NETHER_DIAMOND_ORE, Items.DIAMOND);
        addDrop(ModBlocks.END_DIAMOND_ORE, Items.DIAMOND);
        addDrop(ModBlocks.NETHER_EMERALD_ORE, Items.EMERALD);
        addDrop(ModBlocks.END_EMERALD_ORE, Items.EMERALD);
        addDrop(Blocks.SPAWNER);

        /*AnyOfLootCondition.Builder builder2 =
                BlockStatePropertyLootCondition.builder(ModBlocks.CORN_CROP).properties(StatePredicate.Builder.create()
                                .exactMatch(CornCropBlock.AGE, 7))
                        .or(BlockStatePropertyLootCondition.builder(ModBlocks.CORN_CROP).properties(StatePredicate.Builder.create()

                                .exactMatch(CornCropBlock.AGE, 8)));*/


        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.CORN_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(CornCropBlock.AGE, 8));


        addDrop(ModBlocks.CORN_CROP, cropDrops(ModBlocks.CORN_CROP, ModItems.CORN_COB, ModItems.CORN_SEEDS, builder));

        /*BlockStatePropertyLootCondition.Builder builderCoffeeFruitBlock = BlockStatePropertyLootCondition.builder(ModBlocks.COFFEE_FRUIT_BLOCK)
                .properties(StatePredicate.Builder.create().exactMatch(FruitCoffeeBlock.DRIED, true));*/


        //addDrop(ModBlocks.COFFEE_FRUIT_BLOCK, cropDrops(ModBlocks.COFFEE_FRUIT_BLOCK, ModItems.DRIED_FRUIT_COFFEE, ModItems.FRUIT_COFFEE, builderCoffeeFruitBlock));
    }

}
