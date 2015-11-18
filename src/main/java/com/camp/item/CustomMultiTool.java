package com.camp.item;

import com.example.examplemod.cm;

import net.minecraft.item.Item.ToolMaterial;

public class CustomMultiTool extends CustomTool{
	
	public static final String name = "CustomMultiTool";

	protected CustomMultiTool(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(this.name);
        this.setCreativeTab(cm.tabIke);

	}

}
