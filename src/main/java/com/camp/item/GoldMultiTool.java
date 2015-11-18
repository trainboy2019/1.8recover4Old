package com.camp.item;

import com.example.examplemod.cm;

public class GoldMultiTool extends CustomTool{
	
	public static final String name = "GoldMultiTool";

	protected GoldMultiTool(ToolMaterial material) {
		super(material.GOLD);
		this.setUnlocalizedName(this.name);
        this.setCreativeTab(cm.tabIke);

	}

}
