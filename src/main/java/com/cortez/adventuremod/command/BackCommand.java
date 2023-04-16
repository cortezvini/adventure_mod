package com.cortez.adventuremod.command;

import com.cortez.adventuremod.util.IEntityDataSaver;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class BackCommand
{
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(CommandManager.literal("back").executes(BackCommand::run));
    }

    private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        IEntityDataSaver player = (IEntityDataSaver)context.getSource().getPlayer();


        int[] backPos = player.getPersistentData().getIntArray("backpos");

        if(backPos.length != 0) {
            int[] playerPos = player.getPersistentData().getIntArray("backpos");
            context.getSource().getPlayer().requestTeleport(playerPos[0], playerPos[1], playerPos[2]);


            context.getSource().sendFeedback(Text.translatable("adventuremod.command.backpos.success"), true);
            return 1;
        }
        else {
            context.getSource().sendFeedback(Text.translatable("adventuremod.command.backpos.notdefined"), true);
            return -1;
        }
    }
}
