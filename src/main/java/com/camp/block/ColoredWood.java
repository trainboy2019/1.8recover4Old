package com.camp.block;

import java.util.List;

import com.example.examplemod.cm;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ColoredWood extends Block implements IMetaBlockName {
		
		public static final PropertyEnum VARIANT = PropertyEnum.create("variant", ColoredWood.EnumType.class);
	    private static final String __OBFID = "CL_00000317";
	    public static final String name = "ColoredWood";
	    
	    

	    public ColoredWood()
	    {
	    	
	        super(Material.wood);
	        this.setUnlocalizedName(name);
	        this.setDefaultState(getBlockState().getBaseState().withProperty(VARIANT, ColoredWood.EnumType.White));
	        this.setCreativeTab(cm.tabIke);
	    }

	    

	    

	    
	    @SideOnly(Side.CLIENT)
	    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	    {
	        list.add(new ItemStack(itemIn, 1, 0));
	        list.add(new ItemStack(itemIn, 1, 1));
	        list.add(new ItemStack(itemIn, 1, 2));
	        list.add(new ItemStack(itemIn, 1, 3));
	        list.add(new ItemStack(itemIn, 1, 4));
	        list.add(new ItemStack(itemIn, 1, 5));
	        list.add(new ItemStack(itemIn, 1, 6));
	        list.add(new ItemStack(itemIn, 1, 7));
	        list.add(new ItemStack(itemIn, 1, 8));
	        list.add(new ItemStack(itemIn, 1, 9));
	        list.add(new ItemStack(itemIn, 1, 10));
	        list.add(new ItemStack(itemIn, 1, 11));
	        list.add(new ItemStack(itemIn, 1, 12));
	        list.add(new ItemStack(itemIn, 1, 13));
	        list.add(new ItemStack(itemIn, 1, 14));
	        list.add(new ItemStack(itemIn, 1, 15));
	    }

	    public static enum EnumType implements IStringSerializable
	    {
	        White(0, "white"),
	        Orange(1, "orange"),
	        Magenta(2, "magenta"),
	        LightBlue(3, "lightBlue"),
	        Yellow(4, "yellow"),
	        LimeGreen(5, "limeGreen"),
	        Pink(6, "pink"),
	    	Grey(7, "grey"),
	    	LightGrey(8, "lightGrey"),
	    	Cyan(9, "cyan"),
	    	Purple(10, "purple"),
	    	Blue(11, "blue"),
	    	Brown(12, "brown"),
	    	DarkGreen(13, "darkGreen"),
	    	Red(14, "red"),
	    	Black(15, "black");
	        /** Array of the Block's BlockStates */
	        private static final ColoredWood.EnumType[] META_LOOKUP = new ColoredWood.EnumType[values().length];
	        /** The BlockState's metadata. */
	        private int meta;
	        /** The EnumType's name. */
	        private final String name;
	        private final String unlocalizedName;
	        

	        private static final String __OBFID = "CL_00002058";

	        private EnumType(int meta, String name)
	        {
	            this(meta, name, name);
	        }

	        private EnumType(int meta, String name, String unlocalizedName)
	        {
	            this.meta = meta;
	            this.name = name;
	            this.unlocalizedName = unlocalizedName;
	        }

	        /**
	         * Returns the EnumType's metadata value.
	         */
	        public int getMetadata()
	        {
	            return this.meta;
	        }

	        public String toString()
	        {
	            return this.name;
	        }

	        /**
	         * Returns an EnumType for the BlockState from a metadata value.
	         */
	        public static ColoredWood.EnumType byMetadata(int meta)
	        {
	            if (meta < 0 || meta >= META_LOOKUP.length)
	            {
	                meta = 0;
	            }

	            return META_LOOKUP[meta];
	        }

	        public String getName()
	        {
	            return this.name;
	        }

	        public String getUnlocalizedName()
	        {
	            return this.unlocalizedName;
	        }

	        static
	        {
	            ColoredWood.EnumType[] var0 = values();
	            int var1 = var0.length;

	            for (int var2 = 0; var2 < var1; ++var2)
	            {
	            	ColoredWood.EnumType var3 = var0[var2];
	                META_LOOKUP[var3.getMetadata()] = var3;
	            }
	        }
	        
	    }

	    
	    public IBlockState getStateFromMeta(int meta)
	    {
	        return this.getDefaultState().withProperty(VARIANT, ColoredWood.EnumType.byMetadata(meta));
	    }
	    
	/**
     * Convert the BlockState into the correct metadata value
     *//*
     *
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((ColoredWood.EnumType)state.getValue(VARIANT)).getMetadata();
    }
    
   /* @Override
	public IBlockState getStateFromMeta(int meta) {
	
		return getDefaultState().cycleProperty(VARIANT);
	}*/
    
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {VARIANT});
    }
	
    public int getDamageValue(World worldIn, BlockPos pos)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        return iblockstate.getBlock().getMetaFromState(iblockstate) & 3;
    }
    
    
	public ColoredWood setBlockName(String string) {
		// TODO Auto-generated method stub
		return this;
	}



	public int damageDropped(IBlockState state)
    {
        return ((ColoredWood.EnumType)state.getValue(VARIANT)).getMetadata();
    }


	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		IBlockState newState;

		if (playerIn.isSneaking()) {
			newState = state.cycleProperty(VARIANT); // Cycle the facing (down -> up -> north -> south -> west -> east -> down)
		} else {
			newState = state.cycleProperty(VARIANT); // Cycle the lit state (true -> false -> true)
		}

		worldIn.setBlockState(pos, newState);

		return true;
	}
	
	



	@Override
	public String getSpecialName(ItemStack stack) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
