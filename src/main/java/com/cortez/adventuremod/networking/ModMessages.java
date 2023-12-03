package com.cortez.adventuremod.networking;

import com.cortez.adventuremod.AdventureMod;
import com.cortez.adventuremod.networking.packet.ItemStackSyncS2CPacketCoffeeMachine;
import com.cortez.adventuremod.networking.packet.ItemStackSyncS2CPacketCrusherMachine;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;

public class ModMessages {
    public static final Identifier ITEM_SYNC_CRUSHER = new Identifier(AdventureMod.MODID, "item_sync_crusher");
    public static final Identifier ITEM_SYNC_COFFEE_MACHINE = new Identifier(AdventureMod.MODID, "item_sync_coffee_machine");


    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(ITEM_SYNC_CRUSHER, ItemStackSyncS2CPacketCrusherMachine::receive);
        ClientPlayNetworking.registerGlobalReceiver(ITEM_SYNC_COFFEE_MACHINE, ItemStackSyncS2CPacketCoffeeMachine::receive);
    }
}

