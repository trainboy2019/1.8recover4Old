package com.camp.item;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class SmeltingPickaxe extends ItemPickaxe{

	protected SmeltingPickaxe(ToolMaterial material) {
		super(material);
		
	}
	
	
	
	@SuppressWarnings("null")
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, BlockPos pos, EntityLivingBase playerIn)
    {
		worldIn.getBlockState(pos);
        if (worldIn.getBlockState(pos).equals(Blocks.diamond_ore))
        {
            blockIn.dropBlockAsItem(worldIn, pos, worldIn.getBlockState(pos), (Integer) null);
        }

        return true;
    }

}
