package com.camp.item;

import com.example.examplemod.cm;

public class IronMultiTool extends CustomTool{
	
	public static final String name = "IronMultiTool";

	protected IronMultiTool(ToolMaterial material) {
		super(material.IRON);
		this.setUnlocalizedName(this.name);
        this.setCreativeTab(cm.tabIke);

	}

}
