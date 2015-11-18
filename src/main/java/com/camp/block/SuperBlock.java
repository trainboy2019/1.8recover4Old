package com.camp.block;

import com.camp.tileentity.TileEntityEndBlock;
import com.camp.tileentity.TileEntitySuperBlock;
import com.example.examplemod.cm;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class SuperBlock extends BlockContainer
{
    private static final String __OBFID = "CL_00000236";
    
    
    
    public static final String name = "SuperBlock";

    
    
    	protected SuperBlock(Material materialIn)
        {
            super(materialIn);
            this.setLightLevel(1.0F);
            this.setCreativeTab(cm.tabIke);
            this.setUnlocalizedName(name);
        }

    		
    	
    	
        public TileEntity createNewTileEntity(World worldIn, int meta)
        {
            return new TileEntitySuperBlock();
        }

        

        /**
         * Add all collision boxes of this Block to the list that intersect with the given mask.
         *  
         * @param collidingEntity the Entity colliding with this Block
         */
    //    public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List list, Entity collidingEntity) {}

        public boolean isOpaqueCube()
        {
            return false;
        }

        public boolean isFullCube()
        {
            return false;
        }

       
        
        

       

        

        /**
         * Get the MapColor for this Block and the given BlockState
         */
        public MapColor getMapColor(IBlockState state)
        {
            return MapColor.obsidianColor;
        }
}