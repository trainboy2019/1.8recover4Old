package com.camp.block;

import com.example.examplemod.cm;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DeathBlock extends Block{
	public static final String name = "DeathBlock";
	protected DeathBlock() {
		super(Material.cactus);
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(this.name);
		this.setCreativeTab(cm.tabIke);
	}
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        return null;
    }

    
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
		entityIn.attackEntityFrom(DamageSource.generic, 100.0F);
		entityIn.attackEntityFrom(DamageSource.magic, 100.0f);
        entityIn.attackEntityFrom(DamageSource.wither, 100.0F);
        entityIn.attackEntityFrom(DamageSource.cactus, 100.0F);
        entityIn.attackEntityFrom(DamageSource.outOfWorld, 100.0F);
      //  entityIn.motionY=1.0F;
        //entityIn.fallDistance=0F;
    }


}
