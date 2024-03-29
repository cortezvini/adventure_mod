package com.cortez.adventuremod.screen.coffee_machine;


import com.cortez.adventuremod.blocks.entity.coffee_machine.CoffeeMachineBlockEntity;
import com.cortez.adventuremod.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class CoffeeMachineScreenHandler extends ScreenHandler
{
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public final CoffeeMachineBlockEntity blockEntity;

    public CoffeeMachineScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf)
    {
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()), new ArrayPropertyDelegate(2));
    }

    public CoffeeMachineScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, PropertyDelegate arrayPropertyDelegate)
    {
        super(ModScreenHandlers.COFFEE_MACHINE_SCREEN_HANDLER,syncId);
        checkSize(((Inventory) blockEntity), 5);
        this.inventory = ((Inventory) blockEntity);
        this.propertyDelegate = arrayPropertyDelegate;
        this.blockEntity = ((CoffeeMachineBlockEntity) blockEntity);

        addSlot(new Slot(inventory, 0, 61, 41));
        addSlot(new Slot(inventory, 1, 8, 60));
        addSlot(new Slot(inventory, 2, 155, 7));
        addSlot(new Slot(inventory, 3, 88, 61));
        addSlot(new Slot(inventory, 4, 132, 61));

        addProperties(arrayPropertyDelegate);
        addPlayerHotbar(playerInventory);
        addPlayerInventory(playerInventory);
    }



    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }


    public boolean isCrafting() {
        return propertyDelegate.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);  // Max Progress
        int progressArrowSize = 24; // This is the width in pixels of your arrow

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }


    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory)
    {
        for (int i =0; i < 9; i++){
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

}
