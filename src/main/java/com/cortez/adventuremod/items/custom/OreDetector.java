package com.cortez.adventuremod.items.custom;

import com.cortez.adventuremod.blocks.ModBlocks;
import com.cortez.adventuremod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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
                        BlockState state = context.getWorld().getBlockState(positionClicked.down(i));
                        Block blockBelow = state.getBlock();
                        if (isValueBlock(state)) {
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
                    BlockState state = context.getWorld().getBlockState(positionClicked.down(i));
                    Block blockBelow = state.getBlock();

                    if (isValueBlock(state)) {
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
    private boolean isValueBlock(BlockState state){
        return state.isIn(ModTags.Blocks.ORE_DETECTOR_BLOCKS);
    }
}