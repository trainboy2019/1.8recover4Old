package com.camp.block;

import java.util.Random;

import com.example.examplemod.cm;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class CraftingBlock extends Block{

	private final boolean isOn;
    public static final String name = "Craft";
    public static final String nameOn = "Smelt";
	
    public CraftingBlock(boolean isOn)
    {
        super(Material.redstoneLight);
        this.isOn = isOn;
        this.setCreativeTab(cm.tabIke);
        if(this.isOn){
        	this.setUnlocalizedName(nameOn);
        }
        
    }
    
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            if (this.isOn && !worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, BlockManager.craftingBlock.getDefaultState(), 2);
            }
            else if (!this.isOn && worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, BlockManager.poweredCraftingBlock.getDefaultState(), 2);
            }
        }
    }

    /**
     * Called when a neighboring block changes.
     */
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        if (!worldIn.isRemote)
        {
            if (this.isOn && !worldIn.isBlockPowered(pos))
            {
                worldIn.scheduleUpdate(pos, this, 4);
            }
            else if (!this.isOn && worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, BlockManager.poweredCraftingBlock.getDefaultState(), 2);
            }
        }
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            if (this.isOn && !worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, BlockManager.craftingBlock.getDefaultState(), 2);
            }
        }
    }
    
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
        	if(!isOn){
            playerIn.displayGui(new BlockWorkbench.InterfaceCraftingTable(worldIn, pos));
            return true;
        	}
        	else
            {
                TileEntity tileentity = worldIn.getTileEntity(pos);

                //if (tileentity instanceof TileEntityFurnace)
                {
                    playerIn.displayGUIChest((TileEntityFurnace)tileentity);
                }

                return true;
            }
        }
    }

}
