package com.camp.item;

import com.example.examplemod.cm;

public class StoneMultiTool extends CustomTool{
	
	public static final String name = "StoneMultiTool";

	protected StoneMultiTool(ToolMaterial material) {
		super(material.STONE);
		this.setUnlocalizedName(this.name);
        this.setCreativeTab(cm.tabIke);

	}

}
