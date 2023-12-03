package com.cortez.adventuremod.data;

import com.cortez.adventuremod.blocks.ModBlocks;
import com.cortez.adventuremod.blocks.custom.CornCropBlock;
import com.cortez.adventuremod.fluids.ModFluids;
import com.cortez.adventuremod.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

/**
 * É responsável por gerar os modelos dos blocos e itens personalizados do mod, usando a API de geração de modelos da Fabric.
 */
public class ModModelProvider extends FabricModelProvider
{

    /**
     * Construtor da classe ModModelProvider que recebe um objeto FabricDataOutput como parâmetro
     * @param output
     */
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    // Gera modelos para estados de blocos
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RUBBER_TREE_LEAVES);
        blockStateModelGenerator.registerLog(ModBlocks.RUBBER_TREE_LOG).log(ModBlocks.RUBBER_TREE_LOG).wood(ModBlocks.RUBBER_TREE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.RUBBER_TREE_LOG_LATEX).log(ModBlocks.RUBBER_TREE_LOG_LATEX).wood(ModBlocks.RUBBER_TREE_WOOD_LATEX);

        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.RUBBER_TREE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_COAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_COAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_IRON_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_IRON_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_COPPER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_COPPER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_GOLD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_REDSTONE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_REDSTONE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_LAPISLAZULI_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_LAPISLAZULI_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_DIAMOND_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_DIAMOND_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_EMERALD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_EMERALD_ORE);
        blockStateModelGenerator.registerSimpleState(ModBlocks.CRUSHER_MACHINE);

        //blockStateModelGenerator.registerCrop(ModBlocks.CORN_CROP, CornCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7, 8);
    }

    // Gera modelos para itens
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MAGIC_FRUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.WITHERINGPOWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEVITATIONPOWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.OREDETECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.OREDETECTORGENERIC, Models.GENERATED);
        itemModelGenerator.register(ModItems.LATEX_EXTRACTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.LATEX, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBBER, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_TIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CORN_SEEDS, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN_COB, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROASTED_CORN, Models.GENERATED);
        itemModelGenerator.register(ModFluids.COFFEE_FLUID_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.COFFEE_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMPTY_CUP, Models.GENERATED);
        itemModelGenerator.register(ModItems.COFFEE_CUP, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROASTED_COFFEE, Models.GENERATED);

        itemModelGenerator.registerArmor((ArmorItem)ModItems.DIVINGSUIT_HELMET);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.DIVINGSUIT_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.DIVINGSUIT_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.DIVINGSUIT_BOOTS);

        itemModelGenerator.registerArmor((ArmorItem)ModItems.BRONZE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.BRONZE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.BRONZE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.BRONZE_BOOTS);
    }
}
