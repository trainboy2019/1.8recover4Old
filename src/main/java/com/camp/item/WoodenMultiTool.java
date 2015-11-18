package com.camp.item;

import com.example.examplemod.cm;

public class WoodenMultiTool extends CustomTool{
	
	public static final String name = "WoodenMultiTool";

	protected WoodenMultiTool(ToolMaterial material) {
		super(material.WOOD);
		this.setUnlocalizedName(this.name);
        this.setCreativeTab(cm.tabIke);

	}

}
