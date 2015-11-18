package com.camp.item;

import com.example.examplemod.cm;

public class DiamondMultiTool extends CustomTool{
	
	public static final String name = "DiamondMultiTool";

	protected DiamondMultiTool(ToolMaterial material) {
		super(material.EMERALD);
		this.setUnlocalizedName(this.name);
        this.setCreativeTab(cm.tabIke);

	}

}
