package com.cortez.adventuremod.items.custom;

import com.cortez.adventuremod.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

/**
 * Declaração da classe OreDetector que estende a classe Item
 */
public class OreDetector extends Item {

    //Variável para verificar se o detector de minério é genérico ou específico
    private boolean isGeneric;

    /**
     * Construtor da classe OreDetector que recebe um parâmetro booleano e um objeto Settings
     */

    public OreDetector(boolean isGeneric, Settings settings) {
        super(settings);
        this.isGeneric = isGeneric;
    }

    /**
     * Método para detectar blocos de minérios ao clicar em um bloco
     */
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            // Verifica se o detector de minério é genérico
            if (isGeneric) {
                Random random = new Random();
                int value = random.nextInt(2);

                // Em 50% dos casos, um minério é detectado aleatoriamente
                if (value == 1) {
                    for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                        Block blockBelow = context.getWorld().getBlockState(positionClicked.down(i)).getBlock();
                        if (isValueBlock(blockBelow)) {
                            outputValuableCoordinates(positionClicked.down(i), player, blockBelow);
                            foundBlock = true;
                            break;
                        }
                    }

                    if (!foundBlock) {
                        player.sendMessage(Text.translatable("item.adventuremod.oredetector.no_valuables"), false);
                    }
                }
                // Em 50% dos casos, não é detectado nenhum minério
                else {
                    player.sendMessage(Text.translatable("item.adventuremod.oredetector.no_valuables"), false);
                }
            } else {
                //Se o detector de minério é específico, o método busca o próximo bloco de minério específico
                for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                    Block blockBelow = context.getWorld().getBlockState(positionClicked.down(i)).getBlock();

                    if (isValueBlock(blockBelow)) {
                        outputValuableCoordinates(positionClicked.down(i), player, blockBelow);
                        foundBlock = true;
                        break;
                    }
                }

                if (!foundBlock) {
                    player.sendMessage(Text.translatable("item.adventuremod.oredetector.no_valuables"), false);
                }
            }
        }
        return super.useOnBlock(context);
    }

    /**
     * Método para enviar as coordenadas do bloco encontrado para o jogador
     */
    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block blockBelow) {
        player.sendMessage(Text.literal(blockBelow.asItem().getName().getString() + " " +
                "( X: " + blockPos.getX() + ", Y: " + blockPos.getY() + ", Z: " + blockPos.getZ() + ")"), false);
    }

    /**
     * Método para verificar se um bloco é valioso (ou seja, um minério)
     */
    private boolean isValueBlock(Block block){
        return block == Blocks.COAL_ORE
                || block == Blocks.DEEPSLATE_COAL_ORE
                || block == Blocks.IRON_ORE
                || block == Blocks.DEEPSLATE_IRON_ORE
                || block == Blocks.COPPER_ORE
                || block == Blocks.DEEPSLATE_COPPER_ORE
                || block == Blocks.GOLD_ORE
                || block == Blocks.DEEPSLATE_GOLD_ORE
                || block == Blocks.REDSTONE_ORE
                || block == Blocks.DEEPSLATE_REDSTONE_ORE
                || block == Blocks.LAPIS_ORE
                || block == Blocks.DEEPSLATE_LAPIS_ORE
                || block == Blocks.EMERALD_ORE
                || block == Blocks.DEEPSLATE_EMERALD_ORE
                || block == Blocks.DIAMOND_ORE
                || block == Blocks.DEEPSLATE_DIAMOND_ORE
                || block == Blocks.AMETHYST_BLOCK
                || block == Blocks.NETHER_GOLD_ORE
                || block == Blocks.NETHER_QUARTZ_ORE
                || block == Blocks.ANCIENT_DEBRIS
                || block == ModBlocks.TIN_ORE
                || block == ModBlocks.DEEPSLATE_TIN_ORE
                || block == ModBlocks.NETHER_TIN_ORE
                || block == ModBlocks.END_TIN_ORE
                || block == ModBlocks.NETHER_COAL_ORE
                || block == ModBlocks.END_COAL_ORE
                || block == ModBlocks.NETHER_IRON_ORE
                || block == ModBlocks.END_IRON_ORE
                || block == ModBlocks.NETHER_COPPER_ORE
                || block == ModBlocks.END_COPPER_ORE
                || block == ModBlocks.END_GOLD_ORE
                || block == ModBlocks.NETHER_REDSTONE_ORE
                || block == ModBlocks.END_REDSTONE_ORE
                || block == ModBlocks.NETHER_LAPISLAZULI_ORE
                || block == ModBlocks.END_LAPISLAZULI_ORE
                || block == ModBlocks.NETHER_DIAMOND_ORE
                || block == ModBlocks.END_DIAMOND_ORE
                || block == ModBlocks.NETHER_EMERALD_ORE
                || block == ModBlocks.END_EMERALD_ORE;
    }
}