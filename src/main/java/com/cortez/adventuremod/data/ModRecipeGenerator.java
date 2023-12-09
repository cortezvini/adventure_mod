package com.cortez.adventuremod.data;

import com.cortez.adventuremod.blocks.ModBlocks;
import com.cortez.adventuremod.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
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
    public void generate(RecipeExporter exporter) {
        //Fornalha
        offerSmelting(exporter, List.of(ModItems.LATEX), RecipeCategory.MISC, ModItems.RUBBER, 0.0F, 200, "adventuremod");
        offerSmelting(exporter, List.of(ModBlocks.RUBBER_TREE_LOG), RecipeCategory.MISC, Blocks.OAK_LOG, 0.0F, 200, "adventuremod");
        offerSmelting(exporter, List.of(ModItems.RAW_TIN), RecipeCategory.MISC, ModItems.TIN_INGOT, 0.5F, 200, "adventuremod");
        offerBlasting(exporter, List.of(ModItems.RAW_TIN), RecipeCategory.MISC, ModItems.TIN_INGOT, 0.5F, 100, "adventuremod");
        offerSmelting(exporter, List.of(ModItems.BRONZE_DUST), RecipeCategory.MISC, ModItems.BRONZE_INGOT, 0.5F, 200, "adventuremod");
        offerBlasting(exporter, List.of(ModItems.BRONZE_DUST), RecipeCategory.MISC, ModItems.BRONZE_INGOT, 0.5F, 100, "adventuremod");
        offerSmelting(exporter, List.of(ModItems.TIN_DUST), RecipeCategory.MISC, ModItems.TIN_INGOT, 0.5F, 200, "adventuremod");
        offerBlasting(exporter, List.of(ModItems.TIN_DUST), RecipeCategory.MISC, ModItems.TIN_INGOT, 0.5F, 100, "adventuremod");
        offerSmelting(exporter, List.of(ModItems.COPPER_DUST), RecipeCategory.MISC, Items.COPPER_INGOT, 0.5F, 200, "minecraft");
        offerBlasting(exporter, List.of(ModItems.COPPER_DUST), RecipeCategory.MISC, Items.COPPER_INGOT, 0.5F, 100, "adventuremod");

        offerSmelting(exporter, List.of(ModItems.CORN_COB), RecipeCategory.FOOD, ModItems.ROASTED_CORN, 0.0F, 200, "adventuremod");
        offerSmelting(exporter, List.of(ModItems.DRIED_FRUIT_COFFEE), RecipeCategory.MISC, ModItems.ROASTED_COFFEE, 0.0F, 200, "adventuremod");

        //CraftTable
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

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRONZE_DUST, 2)
                .input(ModItems.COPPER_DUST)
                .input(ModItems.COPPER_DUST)
                .input(ModItems.COPPER_DUST)
                .input(ModItems.TIN_DUST)
                .criterion(FabricRecipeProvider.hasItem(ModItems.COPPER_DUST), FabricRecipeProvider.conditionsFromItem(ModItems.COPPER_DUST))
                .criterion(FabricRecipeProvider.hasItem(ModItems.TIN_DUST), FabricRecipeProvider.conditionsFromItem(ModItems.TIN_DUST))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.BRONZE_DUST)));


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

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_PICKAXE)
                .pattern("###")
                .pattern(" A ")
                .pattern(" A ")
                .input('#', ModItems.BRONZE_INGOT)
                .input('A', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_PICKAXE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_PICKAXE))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.BRONZE_PICKAXE)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_AXE)
                .pattern("## ")
                .pattern("#A ")
                .pattern(" A ")
                .input('#', ModItems.BRONZE_INGOT)
                .input('A', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_AXE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_AXE))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.BRONZE_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_SHOVEL)
                .pattern(" # ")
                .pattern(" A ")
                .pattern(" A ")
                .input('#', ModItems.BRONZE_INGOT)
                .input('A', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_SHOVEL),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_SHOVEL))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.BRONZE_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_SWORD)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" A ")
                .input('#', ModItems.BRONZE_INGOT)
                .input('A', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_SWORD),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_SWORD))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.BRONZE_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_HOE)
                .pattern("## ")
                .pattern(" A ")
                .pattern(" A ")
                .input('#', ModItems.BRONZE_INGOT)
                .input('A', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_HOE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_HOE))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.BRONZE_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_HELMET)
                .pattern("###")
                .pattern("# #")
                .input('#', ModItems.BRONZE_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_HELMET),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_HELMET))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.BRONZE_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_CHESTPLATE)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.BRONZE_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_CHESTPLATE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_CHESTPLATE))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.BRONZE_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_LEGGINGS)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', ModItems.BRONZE_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_LEGGINGS),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_LEGGINGS))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.BRONZE_LEGGINGS)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_BOOTS)
                .pattern("# #")
                .pattern("# #")
                .input('#', ModItems.BRONZE_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_BOOTS),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BRONZE_BOOTS))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.BRONZE_BOOTS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRUSHER_MACHINE)
                .pattern("###")
                .pattern("#G#")
                .pattern("EEE")
                .input('#', Blocks.DEEPSLATE)
                .input('G', Blocks.IRON_BLOCK)
                .input('E', Items.IRON_INGOT)
                .criterion(FabricRecipeProvider.hasItem(Blocks.DEEPSLATE),
                        FabricRecipeProvider.conditionsFromItem(Blocks.DEEPSLATE))
                .criterion(FabricRecipeProvider.hasItem(Blocks.IRON_BLOCK),
                        FabricRecipeProvider.conditionsFromItem(Blocks.IRON_BLOCK))
                .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT),
                        FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.CRUSHER_MACHINE),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.CRUSHER_MACHINE))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.CRUSHER_MACHINE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CORN_SEEDS, 3)
                .input(ModItems.CORN_COB)
                .criterion(FabricRecipeProvider.hasItem(ModItems.CORN_COB), FabricRecipeProvider.conditionsFromItem(ModItems.CORN_COB))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.CORN_SEEDS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.SPAWNER)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Blocks.IRON_BARS)
                .criterion(FabricRecipeProvider.hasItem(Blocks.IRON_BARS),
                        FabricRecipeProvider.conditionsFromItem(Blocks.IRON_BARS))
                .criterion(FabricRecipeProvider.hasItem(Blocks.SPAWNER),
                        FabricRecipeProvider.conditionsFromItem(Blocks.SPAWNER))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(Blocks.SPAWNER)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COFFEE_SEED, 14)
                .input(ModItems.FRUIT_COFFEE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.FRUIT_COFFEE), FabricRecipeProvider.conditionsFromItem(ModItems.FRUIT_COFFEE))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.COFFEE_SEED)));
    }
}
