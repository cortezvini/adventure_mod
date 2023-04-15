package com.cortez.adventuremod.items.custom;


import com.cortez.adventuremod.blocks.ModBlocks;
import com.cortez.adventuremod.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

import java.util.Random;


public class LatexExtractor extends Item
{

    public LatexExtractor(Settings settings)
    {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context)
    {
        if (!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            Block blockBelow = context.getWorld().getBlockState(positionClicked).getBlock();

            if (blockBelow == ModBlocks.RUBBER_TREE_LOG_LATEX || blockBelow == ModBlocks.RUBBER_TREE_LOG)
            {
                if (blockBelow == ModBlocks.RUBBER_TREE_LOG_LATEX){
                    BlockState newState = ModBlocks.RUBBER_TREE_LOG.getDefaultState();
                    context.getWorld().setBlockState(positionClicked, newState);
                    Random random = new Random();
                    int latexCount = random.nextInt(3) + 1;
                    context.getWorld().spawnEntity(new ItemEntity(context.getWorld(), positionClicked.getX() + 0.5, positionClicked.getY() + 0.5, positionClicked.getZ() + 0.5, new ItemStack(ModItems.LATEX, latexCount)));
                    if (!player.isCreative())
                    {
                        context.getStack().damage(1, player, p -> p.sendToolBreakStatus(context.getHand()));
                    }
                }else {
                    if (!player.isCreative())
                    {
                        context.getStack().damage(1, player, p -> p.sendToolBreakStatus(context.getHand()));
                    }
                }

            }
        }
        return super.useOnBlock(context);
    }


}