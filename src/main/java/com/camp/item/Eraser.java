package com.camp.item;

import com.example.examplemod.cm;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class Eraser extends Item{
	public static final String name = "Eraser";
	public static final String name1 = "Eraser";
	
	protected Eraser() {
        super();
        this.setCreativeTab(cm.tabIke);
        this.setUnlocalizedName(this.name);
		}
	
	


	public boolean onItemRightClick(ItemStack stack, EntityPlayer playerIn,
			World worldIn, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ) {
		// TODO Auto-generated method stub
		boolean flag = this.name == this.name1;
		MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(worldIn, playerIn, flag);
		BlockPos blockpos = movingobjectposition.getBlockPos();
		IBlockState iblockstate = worldIn.getBlockState(blockpos);
        Material material = iblockstate.getBlock().getMaterial();
	//	Entity bolt = new EntityLightningBolt(worldIn, pos.getX(), pos.getY(), pos.getZ());
	    playerIn.worldObj.setBlockToAir(pos);
	    if (material == Material.water || material == Material.lava || worldIn.getBlockState(blockpos)==Blocks.dragon_egg)
	    {
            worldIn.setBlockToAir(blockpos);
            
           // playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
           /// return this.fillBucket(itemStackIn, playerIn, Items.water_bucket);
        }
	    
	    return true;
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn,
			World worldIn, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ) {
		// TODO Auto-generated method stub
		boolean flag = this.name == this.name1;
		MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(worldIn, playerIn, flag);
		BlockPos blockpos = movingobjectposition.getBlockPos();
		IBlockState iblockstate = worldIn.getBlockState(blockpos);
        Material material = iblockstate.getBlock().getMaterial();
	//	Entity bolt = new EntityLightningBolt(worldIn, pos.getX(), pos.getY(), pos.getZ());
	    playerIn.worldObj.setBlockToAir(pos);
	    IBlockState targetID = worldIn.getBlockState(pos);
	    if(targetID == Blocks.water || targetID == Blocks.water){
	    	worldIn.setBlockToAir(blockpos);
	    return true;
	    }

	    
	    return true;
	}
}
