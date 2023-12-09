package com.cortez.adventuremod.items.custom;

import com.cortez.adventuremod.blocks.ModBlocks;
import com.cortez.adventuremod.blocks.custom.FruitCoffeeBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class CoffeeFruitItem extends Item
{
    public int age;
    public CoffeeFruitItem(Settings settings, int age) {
        super(settings);
        this.age = age;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos().offset(Direction.UP); // Obter a posição acima

        if (!world.isClient()){
            if (this.age == 0)
            {
                world.setBlockState(pos, ModBlocks.COFFEE_FRUIT_BLOCK.getDefaultState(), 3);
                if (!context.getPlayer().isCreative()){
                    context.getStack().decrement(1);
                }
            }else if (this.age == 1){
                world.setBlockState(pos, ModBlocks.COFFEE_FRUIT_BLOCK.getDefaultState().with(FruitCoffeeBlock.AGE, 1));
                if (!context.getPlayer().isCreative()){
                    context.getStack().decrement(1);
                }
            }
        }

        return super.useOnBlock(context);
    }
}
