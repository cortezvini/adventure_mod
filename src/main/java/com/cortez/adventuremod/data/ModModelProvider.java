package com.cortez.adventuremod.data;

import com.cortez.adventuremod.blocks.ModBlocks;
import com.cortez.adventuremod.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

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
        itemModelGenerator.register(ModItems.DIVINGSUIT_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIVINGSUIT_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIVINGSUIT_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIVINGSUIT_BOOTS, Models.GENERATED);
    }
}
