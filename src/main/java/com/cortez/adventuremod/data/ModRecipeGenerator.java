package com.cortez.adventuremod.data;

import com.cortez.adventuremod.blocks.ModBlocks;
import com.cortez.adventuremod.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;


// Classe responsável pela geração de receitas personalizadas do mod
public class ModRecipeGenerator extends FabricRecipeProvider
{
    // Construtor da classe que recebe um objeto FabricDataOutput como parâmetro
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    // Método responsável pela geração das receitas
    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        //Fornalha
        offerSmelting(exporter, List.of(ModItems.LATEX), RecipeCategory.MISC, ModItems.RUBBER, 0.0F, 200, "adventuremod");
        offerSmelting(exporter, List.of(ModBlocks.RUBBER_TREE_LOG), RecipeCategory.MISC, Blocks.OAK_LOG, 0.0F, 200, "adventuremod");
        offerSmelting(exporter, List.of(ModItems.RAW_TIN), RecipeCategory.MISC, ModItems.TIN_INGOT, 0.0F, 200, "adventuremod");
        offerBlasting(exporter, List.of(ModItems.RAW_TIN), RecipeCategory.MISC, ModItems.TIN_INGOT, 0.0F, 100, "adventuremod");


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TIN_INGOT)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.TIN_NUGGET)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TIN_NUGGET), FabricRecipeProvider.conditionsFromItem(ModItems.TIN_NUGGET))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.TIN_INGOT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.TIN_BLOCK)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.TIN_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TIN_INGOT), FabricRecipeProvider.conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.TIN_BLOCK)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TIN_NUGGET, 9)
                .input(ModItems.TIN_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TIN_INGOT), FabricRecipeProvider.conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.TIN_NUGGET)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TIN_INGOT, 9)
                .input(ModBlocks.TIN_BLOCK)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TIN_BLOCK), FabricRecipeProvider.conditionsFromItem(ModBlocks.TIN_BLOCK))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.TIN_INGOT) + "_block"));

        //Craft table
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LATEX_EXTRACTOR)
                .pattern(" # ")
                .pattern("###")
                .pattern("#  ")
                .input('#', Items.OAK_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(Items.OAK_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(Items.OAK_PLANKS))
                .criterion(FabricRecipeProvider.hasItem(ModItems.LATEX_EXTRACTOR),
                        FabricRecipeProvider.conditionsFromItem(ModItems.LATEX_EXTRACTOR))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.LATEX_EXTRACTOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DIVINGSUIT_HELMET)
                .pattern("###")
                .pattern("#G#")
                .pattern(" O ")
                .input('#', ModItems.RUBBER)
                .input('G', Items.GLASS_PANE)
                .input('O', Items.ORANGE_DYE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.RUBBER),
                        FabricRecipeProvider.conditionsFromItem(ModItems.RUBBER))
                .criterion(FabricRecipeProvider.hasItem(Items.GLASS_PANE),
                        FabricRecipeProvider.conditionsFromItem(Items.GLASS_PANE))
                .criterion(FabricRecipeProvider.hasItem(Items.ORANGE_DYE),
                        FabricRecipeProvider.conditionsFromItem(Items.ORANGE_DYE))
                .criterion(FabricRecipeProvider.hasItem(ModItems.DIVINGSUIT_HELMET),
                        FabricRecipeProvider.conditionsFromItem(ModItems.DIVINGSUIT_HELMET))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.DIVINGSUIT_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DIVINGSUIT_CHESTPLATE)
                .pattern("#G#")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.RUBBER)
                .input('G', Items.ORANGE_DYE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.RUBBER),
                        FabricRecipeProvider.conditionsFromItem(ModItems.RUBBER))
                .criterion(FabricRecipeProvider.hasItem(Items.ORANGE_DYE),
                        FabricRecipeProvider.conditionsFromItem(Items.ORANGE_DYE))
                .criterion(FabricRecipeProvider.hasItem(ModItems.DIVINGSUIT_CHESTPLATE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.DIVINGSUIT_CHESTPLATE))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.DIVINGSUIT_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DIVINGSUIT_LEGGINGS)
                .pattern("###")
                .pattern("#G#")
                .pattern("# #")
                .input('#', ModItems.RUBBER)
                .input('G', Items.ORANGE_DYE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.RUBBER),
                        FabricRecipeProvider.conditionsFromItem(ModItems.RUBBER))
                .criterion(FabricRecipeProvider.hasItem(Items.ORANGE_DYE),
                        FabricRecipeProvider.conditionsFromItem(Items.ORANGE_DYE))
                .criterion(FabricRecipeProvider.hasItem(ModItems.DIVINGSUIT_LEGGINGS),
                        FabricRecipeProvider.conditionsFromItem(ModItems.DIVINGSUIT_LEGGINGS))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.DIVINGSUIT_LEGGINGS)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DIVINGSUIT_BOOTS)
                .pattern("# #")
                .pattern("# #")
                .input('#', ModItems.RUBBER)
                .criterion(FabricRecipeProvider.hasItem(ModItems.RUBBER),
                        FabricRecipeProvider.conditionsFromItem(ModItems.RUBBER))
                .criterion(FabricRecipeProvider.hasItem(ModItems.DIVINGSUIT_BOOTS),
                        FabricRecipeProvider.conditionsFromItem(ModItems.DIVINGSUIT_BOOTS))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.DIVINGSUIT_BOOTS)));


    }
}
