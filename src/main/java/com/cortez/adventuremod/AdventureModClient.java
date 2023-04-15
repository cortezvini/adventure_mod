package com.cortez.adventuremod;

import com.cortez.adventuremod.blocks.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

/**
 * Classe responsável pela inicialização do mod no lado do cliente.
 */
public class AdventureModClient implements ClientModInitializer
{
    /**
     * Método chamado durante a inicialização do cliente.
     */

    @Override
    public void onInitializeClient() {
        // Nenhuma ação necessária no momento.
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBBER_TREE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBBER_TREE_SAPLING, RenderLayer.getCutout());
    }
}