package com.cortez.adventuremod.blocks.entity.coffee_machine;

import com.cortez.adventuremod.blocks.entity.ImplementedInventory;
import com.cortez.adventuremod.blocks.entity.ModBlockEntities;
import com.cortez.adventuremod.blocks.entity.crushermachine.CrusherMachineBlockEntity;
import com.cortez.adventuremod.fluids.ModFluids;
import com.cortez.adventuremod.items.ModItems;
import com.cortez.adventuremod.networking.ModMessages;
import com.cortez.adventuremod.recipe.crushermachine.CrusherRecipe;
import com.cortez.adventuremod.screen.coffee_machine.CoffeeMachineScreenHandler;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyStorage;

import java.util.Optional;

public class CoffeeMachineBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory
{

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(5, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int WATER_ITEM_SLOT = 1;

    private static final int ENERGY_ITEM_SLOT = 2;

    private static final int OUTPUT_COFFEE_ONE = 3;

    private static final int OUTPUT_COFFEE_TWO = 4;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;

    public CoffeeMachineBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.COFFEE_MACHINE_BE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index){
                    case 0 -> CoffeeMachineBlockEntity.this.progress;
                    case 1 -> CoffeeMachineBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index){
                    case 0 -> CoffeeMachineBlockEntity.this.progress = value;
                    case 1 -> CoffeeMachineBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public void markDirty() {
        if(!world.isClient()) {
            PacketByteBuf data = PacketByteBufs.create();
            data.writeInt(inventory.size());
            for(int i = 0; i < inventory.size(); i++) {
                data.writeItemStack(inventory.get(i));
            }
            data.writeBlockPos(getPos());

            for(ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) world, getPos())) {
                ServerPlayNetworking.send(player, ModMessages.ITEM_SYNC_COFFEE_MACHINE, data);
            }
        }

        super.markDirty();
    }

    public void setInventory(DefaultedList<ItemStack> list) {
        for(int i = 0; i < list.size(); i++) {
            this.inventory.set(i, list.get(i));
        }
    }

    public SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(64000, 200, 200){
        @Override
        protected void onFinalCommit() {
            markDirty();
            getWorld().updateListeners(pos, getCachedState(), getCachedState(), 3);
        }
    };

    public final SingleVariantStorage<FluidVariant> waterStorage = new SingleVariantStorage<FluidVariant>() {
        @Override
        protected FluidVariant getBlankVariant() {
            return FluidVariant.blank();
        }

        @Override
        protected long getCapacity(FluidVariant variant) {
            return (FluidConstants.BUCKET / 81) * 2; // 1 Bucket = 81000 Droplets = 1000mB || *64 ==> 64,000mB = 64 Buckets
        }

        @Override
        protected void onFinalCommit() {
            markDirty();
            getWorld().updateListeners(pos, getCachedState(), getCachedState(), 3);
        }
    };

    public final SingleVariantStorage<FluidVariant> coffeeStorage = new SingleVariantStorage<FluidVariant>() {
        @Override
        protected FluidVariant getBlankVariant() {
            return FluidVariant.blank();
        }

        @Override
        protected long getCapacity(FluidVariant variant) {
            return (FluidConstants.BUCKET / 81) * 2; // 1 Bucket = 81000 Droplets = 1000mB || *64 ==> 64,000mB = 64 Buckets
        }

        @Override
        protected void onFinalCommit() {
            markDirty();
            getWorld().updateListeners(pos, getCachedState(), getCachedState(), 3);
        }
    };

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.adventuremod.coffee_machine");
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("coffee_machine.progress", progress);
        nbt.putLong(("coffee_machine.energy"), energyStorage.amount);
        nbt.put("coffee_machine.water_variant", waterStorage.variant.toNbt());
        nbt.putLong("coffee_machine.water_amount", waterStorage.amount);
        nbt.put("coffee_machine.coffee_variant", coffeeStorage.variant.toNbt());
        nbt.putLong("coffee_machine.coffee_amount", coffeeStorage.amount);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("coffee_machine.progress");
        energyStorage.amount = nbt.getLong("coffee_machine.energy");
        waterStorage.variant = FluidVariant.fromNbt((NbtCompound) nbt.get("coffee_machine.water_variant"));
        waterStorage.amount = nbt.getLong("coffee_machine.water_amount");
        coffeeStorage.variant = FluidVariant.fromNbt((NbtCompound) nbt.get("coffee_machine.coffee_variant"));
        coffeeStorage.amount = nbt.getLong("coffee_machine.coffee_amount");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new CoffeeMachineScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public void tick(World world, BlockPos pos, BlockState state)
    {
        fillUpOnEnergy(); // until we have machines/other mods that give us Energy
        fillUpOnWater();
        fillDownCoffee();


        if(hasRecipe()) {
            increaseCraftingProgress();
            extractEnergy();
            markDirty(world, pos, state);

            if(hasCraftingFinished()) {
                craftItem();
                extractWater();
                transferCoffeeToTank();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void fillDownCoffee() {
        if (hasCoffeeSourceItemInFluidSlot(OUTPUT_COFFEE_ONE) && this.coffeeStorage.amount >= 250){
            extractCoffee(250);
            this.setStack(OUTPUT_COFFEE_ONE, new ItemStack(ModItems.COFFEE_CUP));
        }else if (hasCoffeeSourceItemInFluidSlot(OUTPUT_COFFEE_TWO) && this.coffeeStorage.amount >= 250){
            extractCoffee(250);
            this.setStack(OUTPUT_COFFEE_TWO, new ItemStack(ModItems.COFFEE_CUP));
        }
    }

    private void extractCoffee(int maxlong) {
        try(Transaction transaction = Transaction.openOuter()) {
            this.coffeeStorage.extract(FluidVariant.of(ModFluids.COFFEE_FLUID), maxlong, transaction);
            transaction.commit();
        }
    }

    private boolean hasCoffeeSourceItemInFluidSlot(int fluidItemSlot) {
        return this.getStack(fluidItemSlot).getItem() == ModItems.EMPTY_CUP && this.getStack(fluidItemSlot).getCount() == 1;
    }

    private void extractWater() {
        try(Transaction transaction = Transaction.openOuter()) {
            this.waterStorage.extract(FluidVariant.of(Fluids.WATER), 1000, transaction);
            transaction.commit();
        }
    }


    private void fillUpOnWater() {
        if(hasWaterSourceItemInFluidSlot(WATER_ITEM_SLOT) && waterStorage.amount < waterStorage.getCapacity()) {
            transferItemWaterToTank(WATER_ITEM_SLOT);
        }
    }

    private void transferItemWaterToTank(int fluidItemSlot) {
        try(Transaction transaction = Transaction.openOuter()) {
            this.waterStorage.insert(FluidVariant.of(Fluids.WATER),
                    (FluidConstants.BUCKET / 81), transaction);
            transaction.commit();

            this.setStack(fluidItemSlot, new ItemStack(Items.BUCKET));
        }
    }

    private boolean hasWaterSourceItemInFluidSlot(int fluidItemSlot) {
        return this.getStack(fluidItemSlot).getItem() == Items.WATER_BUCKET;
    }



    private void transferCoffeeToTank() {
        try(Transaction transaction = Transaction.openOuter()) {
            this.coffeeStorage.insert(FluidVariant.of(ModFluids.FLOWING_COFFEE_FLUID),
                    (FluidConstants.BUCKET / 81), transaction);
            transaction.commit();
        }
    }

    private void extractEnergy() {
        try(Transaction transaction = Transaction.openOuter()) {
            this.energyStorage.extract(32L, transaction);
            transaction.commit();
        }
    }

    private void fillUpOnEnergy() {
        if(hasEnergyItemInEnergySlot(ENERGY_ITEM_SLOT)) {
            try(Transaction transaction = Transaction.openOuter()) {
                this.energyStorage.insert(64, transaction);
                transaction.commit();
            }
        }
    }

    private boolean hasEnergyItemInEnergySlot(int energyItemSlot) {
        return this.getStack(energyItemSlot).getItem() == Items.REDSTONE;
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        this.progress++;
    }

    private void craftItem() {
        this.removeStack(INPUT_SLOT, 4);
    }

    private boolean hasRecipe() {
        return canInsertAmountIntoOutputSlot()
                 && hasEnoughEnergyToCraft() && hasEnoughWaterAndNotMaxCapacityCoffeeToCraft();
    }

    private boolean hasEnoughEnergyToCraft() {
        return this.energyStorage.amount >= 32L * this.maxProgress;
    }

    private boolean canInsertAmountIntoOutputSlot() {
        return this.getStack(INPUT_SLOT).getItem() == ModItems.COFFEE_POWDER && this.getStack(INPUT_SLOT).getCount() >= 4;
    }

    private boolean hasEnoughWaterAndNotMaxCapacityCoffeeToCraft() {
        return this.waterStorage.amount >= 1000 && this.coffeeStorage.amount < 2000 && this.coffeeStorage.amount == 0 || this.coffeeStorage.amount == 1000; // mB amount!
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }


    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }
}
