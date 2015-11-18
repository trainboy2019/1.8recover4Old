package com.camp.item;
 
import com.example.examplemod.cm;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.registry.GameRegistry;
 
public class ItemManager {
 
    public static CustomItem customItem;
    public static CustomPickaxe customPickaxe;
    public static CustomAxe customAxe;
    public static CustomHoe customHoe;
    public static CustomShovel customShovel;
    public static CustomSword customSword;
    public static LightningOrb lightningOrb;
    public static CustomArmor customHelmet;
    public static CustomArmor customChestplate;
    public static CustomArmor customLeggings;
    public static CustomArmor customBoots;
    public static AmericanSword americanSword;
    public static AmericanIngot americanIngot;
    public static TrainboyItem trainboyItem;
    public static EnderBackpack enderBackpack;
    public static DebugArmor debugHelmet;
    public static DebugArmor debugChestplate;
    public static DebugArmor debugLeggings;
    public static DebugArmor debugBoots;
    public static CakeItem cakeItem;
    public static GravityItem gravityItem;
    public static Eraser eraser;
    public static DiamondMultiTool diamondMultiTool;
    public static GoldMultiTool goldMultiTool;
    public static IronMultiTool ironMultiTool;
    public static StoneMultiTool stoneMultiTool;
    public static WoodenMultiTool woodenMultiTool;
    public static CustomMultiTool customMultiTool;
     
    public static void mainRegistry() {
        initializeItem();
        registerItem();
    }
 
    public static void initializeItem() {
    	diamondMultiTool=new DiamondMultiTool(ToolMaterial.EMERALD);
    	goldMultiTool=new GoldMultiTool(ToolMaterial.GOLD);
    	ironMultiTool=new IronMultiTool(ToolMaterial.IRON);
    	stoneMultiTool=new StoneMultiTool(ToolMaterial.STONE);
    	woodenMultiTool=new WoodenMultiTool(ToolMaterial.WOOD);
    	customMultiTool=new CustomMultiTool(cm.customToolMaterial);
    	eraser = new Eraser();
    	gravityItem=new GravityItem();
    	cakeItem = new CakeItem();
    	enderBackpack = new EnderBackpack();
    	americanIngot = new AmericanIngot();
    	trainboyItem = new TrainboyItem();
        customItem = new CustomItem();
        customPickaxe = new CustomPickaxe(cm.customToolMaterial);
        customAxe = new CustomAxe(cm.customToolMaterial);
        customHoe = new CustomHoe(cm.customToolMaterial);
        customShovel = new CustomShovel(cm.customToolMaterial);
        customSword = new CustomSword(cm.customToolMaterial);
        americanSword = new AmericanSword(cm.americanToolMaterial);
        lightningOrb= new LightningOrb();
        customHelmet = new CustomArmor(ArmorMaterial.IRON, 0, 0, "CustomHelmet");
        customChestplate = new CustomArmor(ArmorMaterial.IRON, 0, 1, "CustomChestplate");
        customLeggings = new CustomArmor(ArmorMaterial.IRON, 0, 2, "CustomLeggings");
        customBoots = new CustomArmor(ArmorMaterial.IRON, 0, 3, "CustomBoots");
        debugHelmet = new DebugArmor(cm.debugArmorMaterial, 0, 0, "DebugHelmet");
        debugChestplate = new DebugArmor(cm.debugArmorMaterial, 0, 1, "DebugChestplate");
        debugLeggings = new DebugArmor(cm.debugArmorMaterial, 0, 2, "DebugLeggings");
        debugBoots = new DebugArmor(cm.debugArmorMaterial, 0, 3, "DebugBoots");

    }
    
    
 
    public static void registerItem() {
    	GameRegistry.registerItem(diamondMultiTool, diamondMultiTool.name);
    	GameRegistry.registerItem(goldMultiTool, goldMultiTool.name);
    	GameRegistry.registerItem(ironMultiTool, ironMultiTool.name);
    	GameRegistry.registerItem(stoneMultiTool, stoneMultiTool.name);
    	GameRegistry.registerItem(woodenMultiTool, woodenMultiTool.name);
    	GameRegistry.registerItem(customMultiTool, customMultiTool.name);
    	GameRegistry.registerItem(eraser, eraser.name);
    //	GameRegistry.registerItem(gravityItem, gravityItem.name);
    	GameRegistry.registerItem(cakeItem, cakeItem.name);
    	GameRegistry.registerItem(enderBackpack, enderBackpack.name);
    	GameRegistry.registerItem(trainboyItem, trainboyItem.name);
    	GameRegistry.registerItem(americanIngot, americanIngot.name);
        GameRegistry.registerItem(customItem, customItem.name);
        GameRegistry.registerItem(customPickaxe, customPickaxe.name);
        GameRegistry.registerItem(customAxe, customAxe.name);
        GameRegistry.registerItem(customHoe, customHoe.name);
        GameRegistry.registerItem(customShovel, customShovel.name);
        GameRegistry.registerItem(customSword, customSword.name);
        GameRegistry.registerItem(lightningOrb, lightningOrb.name);
        GameRegistry.registerItem(customHelmet, customHelmet.name);
        GameRegistry.registerItem(customChestplate, customChestplate.name);
        GameRegistry.registerItem(customLeggings, customLeggings.name);
        GameRegistry.registerItem(customBoots, customBoots.name);
        GameRegistry.registerItem(americanSword, americanSword.name);
        GameRegistry.registerItem(debugHelmet, debugHelmet.name);
        GameRegistry.registerItem(debugChestplate, debugChestplate.name);
        GameRegistry.registerItem(debugLeggings, debugLeggings.name);
        GameRegistry.registerItem(debugBoots, debugBoots.name);
    }

	
 
}