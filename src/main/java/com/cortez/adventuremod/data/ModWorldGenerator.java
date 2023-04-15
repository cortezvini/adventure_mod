package com.cortez.adventuremod.data;

import com.cortez.adventuremod.AdventureMod;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

/**
 * Esta classe é responsável por prover dados dinâmicos de registro para o mod do mundo.
 * Ele estende a classe FabricDynamicRegistryProvider para gerar saída de dados para recursos
 * de recurso de mundo configurados e colocados.
 */
public class ModWorldGenerator extends FabricDynamicRegistryProvider
{
    /**
     * O construtor recebe uma saída de dados FabricDataOutput e um CompletableFuture
     * @param output
     * @param registriesFuture
     */
    public ModWorldGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    /**
     * O método configure é usado para adicionar os recursos configurados e colocados aos registros
     * @param registries
     * @param entries
     */
    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE));
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE));
    }

    /**
     * de envoltório. O método getName retorna o nome do mod.
     * @return
     */
    @Override
    public String getName() {
        return AdventureMod.MODID;
    }
}
