package com.cortez.adventuremod;

import com.cortez.adventuremod.blocks.ModBlocks;
import com.cortez.adventuremod.blocks.entity.ModBlockEntities;
import com.cortez.adventuremod.blocks.entity.renderer.CrusherMachineRenderer;
import com.cortez.adventuremod.screen.CrusherMachine.CrusherScreen;
import com.cortez.adventuremod.screen.ModScreenHandlers;
import com.cortez.adventuremod.screen.coffee_machine.CoffeeMachineScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

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

        HandledScreens.register(ModScreenHandlers.CRUSHER_MACHINE_SCREEN_HANDLER, CrusherScreen::new);
        BlockEntityRendererFactories.register(ModBlockEntities.CRUSHER_MACHINE_BLOCK_ENTITY_BLOCK, CrusherMachineRenderer::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORN_CROP, RenderLayer.getCutout());
        HandledScreens.register(ModScreenHandlers.COFFEE_MACHINE_SCREEN_HANDLER, CoffeeMachineScreen::new);
    }
}