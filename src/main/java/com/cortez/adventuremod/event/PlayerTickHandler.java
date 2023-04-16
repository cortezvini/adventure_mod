package com.cortez.adventuremod.event;

import com.cortez.adventuremod.util.IEntityDataSaver;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class PlayerTickHandler implements ServerTickEvents.StartTick
{

    @Override
    public void onStartTick(MinecraftServer server) {
        for (ServerPlayerEntity player: server.getPlayerManager().getPlayerList())
        {
            if (player.isDead()) {
                IEntityDataSaver dataPlayer = ((IEntityDataSaver) player);
                BlockPos playerPos = player.getBlockPos();
                dataPlayer.getPersistentData().putIntArray("backpos", new int[] {playerPos.getX(), playerPos.getY(), playerPos.getZ() });
            }
        }
    }
}
