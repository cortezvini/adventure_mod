package com.cortez.adventuremod.command;

import com.cortez.adventuremod.util.IEntityDataSaver;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.function.Supplier;

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

            String dimension = player.getPersistentData().getString("backWorld");


            ServerPlayerEntity playerServer = (ServerPlayerEntity) player;

            if (dimension == "OVERWORLD")
            {
                context.getSource().getPlayer().requestTeleport(playerPos[0], playerPos[1], playerPos[2]);
            } else if (dimension == "NETHER") {

                ServerWorld nether = playerServer.getServer().getWorld(World.NETHER);
                playerServer.teleport(nether, playerPos[0], playerPos[1], playerPos[2], playerServer.getYaw(), playerServer.getPitch());
            } else if (dimension == "END") {
                ServerWorld end = playerServer.getServer().getWorld(World.END);
                playerServer.teleport(end, playerPos[0], playerPos[1], playerPos[2], playerServer.getYaw(), playerServer.getPitch());
            }


            Supplier<Text> success = new Supplier<Text>() {
                @Override
                public Text get() {
                    return Text.translatable("adventuremod.command.backpos.success");
                }
            };

            context.getSource().sendFeedback(success, true);
            return 1;
        }
        else {
            Supplier<Text> notdefined = new Supplier<Text>() {
                @Override
                public Text get() {
                    return Text.translatable("adventuremod.command.backpos.notdefined");
                }
            };

            context.getSource().sendFeedback(notdefined, true);
            return -1;
        }
    }

}
