package com.cortez.adventuremod.screen;

import com.cortez.adventuremod.AdventureMod;
import com.cortez.adventuremod.screen.CrusherMachine.CrusherMachineScreenHandler;
import com.cortez.adventuremod.screen.coffee_machine.CoffeeMachineScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<CrusherMachineScreenHandler> CRUSHER_MACHINE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(AdventureMod.MODID, "crusher_machine"),
                    new ExtendedScreenHandlerType<>(CrusherMachineScreenHandler::new));

    public static final ScreenHandlerType<CoffeeMachineScreenHandler> COFFEE_MACHINE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(AdventureMod.MODID, "coffee_machine"),
                    new ExtendedScreenHandlerType<>(CoffeeMachineScreenHandler::new));

    public static void registerScreenHandlers() {
        AdventureMod.LOGGER.info("Registering Screen Handlers for " + AdventureMod.MODID);
    }
}
