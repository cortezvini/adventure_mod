package com.cortez.adventuremod.data;

import com.cortez.adventuremod.fluids.ModFluids;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.FluidTags;

import java.util.concurrent.CompletableFuture;

public class ModTagFluidProvider extends FabricTagProvider.FluidTagProvider{
    public ModTagFluidProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        this.getOrCreateTagBuilder(FluidTags.WATER)
                .add(ModFluids.FLOWING_COFFEE_FLUID)
                .add(ModFluids.COFFEE_FLUID);
    }


}
