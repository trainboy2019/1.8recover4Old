package com.camp.item;

import com.example.examplemod.cm;

import net.minecraft.item.Item;

public class SpecialLapis extends Item{
public static final String name = "SpecialLapis";
	
	protected SpecialLapis() {
        super();
        this.setCreativeTab(cm.tabIke);
        this.setUnlocalizedName(this.name);
		}

}
