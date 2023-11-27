package com.cortez.adventuremod.compat;

import com.cortez.adventuremod.blocks.ModBlocks;
import com.cortez.adventuremod.compat.coffee_machine.CoffeeMachineCategory;
import com.cortez.adventuremod.compat.coffee_machine.CoffeeMachineDisplay;
import com.cortez.adventuremod.compat.crushermachine.CrusherMachineCategory;
import com.cortez.adventuremod.compat.crushermachine.CrusherMachineDisplay;
import com.cortez.adventuremod.recipe.coffee_machine.CoffeeMachineRecipe;
import com.cortez.adventuremod.recipe.crushermachine.CrusherRecipe;
import com.cortez.adventuremod.screen.CrusherMachine.CrusherScreen;
import com.cortez.adventuremod.screen.coffee_machine.CoffeeMachineScreen;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;


public class AdventureModREIClientPlugin implements REIClientPlugin
{
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new CrusherMachineCategory());
        registry.add(new CoffeeMachineCategory());
        registry.addWorkstations(CrusherMachineCategory.CRUSHER_MACHINE, EntryStacks.of(ModBlocks.CRUSHER_MACHINE));
        registry.addWorkstations(CoffeeMachineCategory.COFFEE_MACHINE, EntryStacks.of(ModBlocks.COFFEE_MACHINE));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(CrusherRecipe.class, CrusherRecipe.Type.INSTANCE,
                CrusherMachineDisplay::new);
        registry.registerRecipeFiller(CoffeeMachineRecipe.class, CoffeeMachineRecipe.Type.INSTANCE,
                CoffeeMachineDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(75, 30, 20, 30), CrusherScreen.class,
                CrusherMachineCategory.CRUSHER_MACHINE);

        registry.registerClickArea(screen -> new Rectangle(75, 30, 20, 30), CoffeeMachineScreen.class,
                CoffeeMachineCategory.COFFEE_MACHINE);
    }
}
