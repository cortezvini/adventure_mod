package com.cortez.adventuremod.command;

import com.cortez.adventuremod.util.IEntityDataSaver;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import java.util.function.Supplier;

public class ReturnHomeCommand
{

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(CommandManager.literal("home")
                .then(CommandManager.literal("return").executes(ReturnHomeCommand::run)));
    }

    private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        IEntityDataSaver player = (IEntityDataSaver)context.getSource().getPlayer();


        int[] homepos = player.getPersistentData().getIntArray("homepos");

        if(homepos.length != 0) {
            int[] playerPos = player.getPersistentData().getIntArray("homepos");
            context.getSource().getPlayer().requestTeleport(playerPos[0], playerPos[1], playerPos[2]);

            Supplier<Text> success = new Supplier<Text>() {
                @Override
                public Text get() {
                    return Text.translatable("adventuremod.command.returnhome.success");
                }
            };

            context.getSource().sendFeedback(success, true);
            return 1;
        }
        else {
            Supplier<Text> notdefined = new Supplier<Text>() {
                @Override
                public Text get() {
                    return Text.translatable("adventuremod.command.returnhome.notdefined");
                }
            };
            context.getSource().sendFeedback(notdefined, true);
            return -1;
        }
    }


}
