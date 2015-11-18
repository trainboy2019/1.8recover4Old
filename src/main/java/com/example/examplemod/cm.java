package com.example.examplemod;
import com.camp.IkeTab;
import com.camp.biome.WorldTypeTest;
import com.camp.block.BlockManager;
import com.camp.entity.CatCow;
import com.camp.entity.CustomMob;
import com.camp.entity.GiantSkeleton;
import com.camp.entity.ModelCatCow;
import com.camp.entity.ModelGiantSkeleton;
import com.camp.entity.ModelJoe;
import com.camp.entity.RenderCatCow;
import com.camp.entity.RenderCustomBiped;
import com.camp.entity.RenderGiantSkeleton;
import com.camp.init.ModBiomes;
import com.camp.item.ItemManager;
import com.camp.proxy.CommonProxy;
import com.camp.renderer.TileEntityEndBlockRenderer;
import com.camp.renderer.TileEntityNetherBlockRenderer;
import com.camp.tileentity.TileEntityEndBlock;
import com.camp.tileentity.TileEntityNetherBlock;
import com.camp.world.CustomDungeonGen;
import com.camp.world.CustomHouse;
import com.camp.world.CustomHouseGen;
import com.camp.world.CustomTeleporter;
import com.camp.world.CustomVillagePiece;
import com.camp.world.CustomWorldProvider;
import com.camp.world.ModMapGen;
import com.camp.world.TestGen;
import com.camp.world.gen.OrangeWorldGenerator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.relauncher.Side;
//import com.camp.world.CustomHome.House4Garden;
@Mod(modid = cm.MODID, version = cm.VERSION)
public class cm
{
    public static final String MODID = "cm";
    public static final String VERSION = "1.0";
    public static final IkeTab tabIke = new IkeTab("tabIke");
    public static ToolMaterial customToolMaterial;
    public static ToolMaterial americanToolMaterial;
    public static ArmorMaterial debugArmorMaterial;
    public static int lastBiomeID = 0;
    public static BiomeGenBase customBiome;
    public static CustomTeleporter teleporterSurface;
    public static CustomTeleporter teleporterCustom;
    
    @SidedProxy(clientSide = "com.camp.proxy.ClientProxy", serverSide = "com.camp.proxy.ServerProxy")
	public static CommonProxy proxy;
    
    @EventHandler
        public void serverStart(FMLServerStartedEvent event){
            this.teleporterSurface = new CustomTeleporter(MinecraftServer.getServer().worldServerForDimension(0));
            this.teleporterCustom = new CustomTeleporter(MinecraftServer.getServer().worldServerForDimension(2));
    }
        
   
    public static int getEmptyBiomeID(){
        int i;
        BiomeGenBase[] array = BiomeGenBase.getBiomeGenArray();
        //loop through biome array to find an empty id.
        for(i = lastBiomeID; i < array.length; i++){
            if( array[i] == null){
                // Found an empty spot
                // Set lastBiomeID then return index.
                lastBiomeID = i;
                return i;
            }
        }
        // didn't find an empty spot
        return -1;
    
    
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	customToolMaterial = EnumHelper.addToolMaterial("Custom", 3, 100, 4, 50, 0);
    	americanToolMaterial = EnumHelper.addToolMaterial("American", 3, 5000, 100, 200, 1000);
    	debugArmorMaterial = EnumHelper.addArmorMaterial("DebugArmor", "debug", 5000, new int[]{100, 100, 100, 100}, 1000);
    	
    	ItemManager.mainRegistry();
    	BlockManager.mainRegistry();
    	ModBiomes.registerBiomes();
    	BlockManager.registerTileEntities();
    	ModMapGen.registerMapGen();
    	
    	
    	createEntity(CustomMob.class, "CustomMob", 0x00FF00, 0xFF0000);
    	createEntity(CatCow.class, "CatCow", 0x000000, 0xFFFFFF);
    	createEntity(GiantSkeleton.class, "GiantSkeleton", 0xFFF000, 0x000FFF);
    	/**
    	 * 
    	 * 
    	 * 
    	 * 
    	 * BLOCKS WITH METADATA MODEL SETUP!!!!!!
    	 * 
    	 * 
    	 * 
    	 * 
    	 */
    			if (event.getSide().isClient()){
    				ModelBakery.addVariantName(Item.getItemFromBlock(BlockManager.bitBlock), "cm:BitBlock0", "cm:BitBlock1", "cm:BitBlock2", "cm:BitBlock3", "cm:BitBlock4", "cm:BitBlock5", "cm:BitBlock6", "cm:BitBlock7", "cm:BitBlock8", "cm:BitBlock9", "cm:BitBlock10", "cm:BitBlock11", "cm:BitBlock12", "cm:BitBlock13", "cm:BitBlock14", "cm:BitBlock15");
    				ModelBakery.addVariantName(Item.getItemFromBlock(BlockManager.coloredWood), "cm:ColoredWood0", "cm:ColoredWood1", "cm:ColoredWood2", "cm:ColoredWood3", "cm:ColoredWood4", "cm:ColoredWood5", "cm:ColoredWood6", "cm:ColoredWood7", "cm:ColoredWood8", "cm:ColoredWood9", "cm:ColoredWood10", "cm:ColoredWood11", "cm:ColoredWood12", "cm:ColoredWood13", "cm:ColoredWood14", "cm:ColoredWood15");
    			}
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
  {
    	
    	
    	/**
    	 * 
    	 * EASTER EGG ZONE!!!
    	 * 
    	 **/
    	
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEndBlock.class, new TileEntityEndBlockRenderer());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNetherBlock.class, new TileEntityNetherBlockRenderer());
    	
    	GameRegistry.registerWorldGenerator(new CustomDungeonGen(), 10000);
    	
    	ItemStack dyeStackRed = new ItemStack(Items.dye);
    	dyeStackRed.setItemDamage(14);
    	ItemStack dyeStackBlue = new ItemStack(Items.dye);
    	dyeStackRed.setItemDamage(12);
    	ItemStack dyeStackGreen = new ItemStack(Items.dye);
    	dyeStackRed.setItemDamage(13);

    	
    	// Crafting Recipes
    	 
        //Shaped Recipes
        GameRegistry.addShapedRecipe(new ItemStack(Items.book, 1), "xy", "yx", 'x', Blocks.stone, 'y', Blocks.gravel);
        GameRegistry.addShapedRecipe(new ItemStack(Items.carrot, 1), "xyx", "y y", "xyx", 'x', Blocks.stone, 'y', Blocks.gravel);
        GameRegistry.addShapedRecipe(new ItemStack(ItemManager.americanSword, 1), " y ", " y ", " x ", 'x', Items.stick, 'y', ItemManager.americanIngot);
        GameRegistry.addRecipe(new ItemStack(Items.cooked_chicken), "xxx", "xyx", "xxx", 'x', Items.stick, 'y', Items.chicken);
    	GameRegistry.addRecipe(new ItemStack(BlockManager.splatoonBlock, 1), "xxx", "xyx", "xxx", 'x', Blocks.glass, 'y', Blocks.glowstone);
    	GameRegistry.addRecipe(new ItemStack(BlockManager.trampolineBlock, 1), "xyx", "yzy", "xyx", 'x', Blocks.hay_block, 'y', Blocks.slime_block, 'z', Items.feather);
    	GameRegistry.addRecipe(new ItemStack(BlockManager.bitBlock, 1), "xxx", "abc", "xxx", 'x', Blocks.planks, 'a', dyeStackRed, 'b', dyeStackBlue, 'c', dyeStackGreen);
    	GameRegistry.addRecipe(new ItemStack(ItemManager.lightningOrb), "xyx", "yzy", "xyx", 'z', Items.skull, 'y', Items.gunpowder, 'x', Items.diamond);
 
        //Shapeless Recipes
      //  GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 64), Blocks.dirt);
        //GameRegistry.addShapelessRecipe(new ItemStack(Blocks.water, 1), Items.water_bucket);
    	GameRegistry.addShapelessRecipe(new ItemStack(BlockManager.blockPig), Items.cooked_porkchop);
        
      //End Portal
      		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.anvil,1),ItemManager.customItem);
      		//diamond block crafting
          	GameRegistry.addShapelessRecipe(new ItemStack(Blocks.diamond_block,500000000),Blocks.dragon_egg, Blocks.anvil);
          	//lava crafting
          	GameRegistry.addShapelessRecipe(new ItemStack(Blocks.lava,1),Blocks.dirt, Blocks.cobblestone);
         
        ItemStack dirtStack = new ItemStack(Blocks.dirt);
        ItemStack sandStack = new ItemStack(Blocks.tnt);
        sandStack.setItemDamage(1);
 
        GameRegistry.addShapelessRecipe((sandStack), dirtStack, dirtStack, dirtStack, dirtStack, Items.acacia_door, Items.cake);
        
        //Smelting Recipies
         GameRegistry.addSmelting(new ItemStack(BlockManager.splatoonBlock), new ItemStack(ItemManager.customItem, 4), 0.1f);
         	ItemStack potionPoisonStack = new ItemStack(Items.potionitem, 1, 8292);
    	GameRegistry.addSmelting(Items.poisonous_potato, potionPoisonStack, 0.1f);
    	GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(Items.leather), 0.1f);
    	//stone brick smelting
    	ItemStack stoneStackCrack = new ItemStack(Blocks.stonebrick);
    	stoneStackCrack.setItemDamage(2);
    	GameRegistry.addSmelting(Blocks.stonebrick, stoneStackCrack, 0.1f);
    	GameRegistry.addSmelting(Blocks.stone, new ItemStack(Blocks.stonebrick), 0.1f);
    	//carpet smelting
    	ItemStack carpetStackWhite = new ItemStack(Blocks.carpet);
    	ItemStack carpetStackOrange = new ItemStack(Blocks.carpet);
    	ItemStack carpetStackMagenta = new ItemStack(Blocks.carpet);
    	ItemStack carpetStackLightBlue = new ItemStack(Blocks.carpet);
    	ItemStack carpetStackYellow = new ItemStack(Blocks.carpet);
    	ItemStack carpetStackLime = new ItemStack(Blocks.carpet);
    	ItemStack carpetStackPink = new ItemStack(Blocks.carpet);
    	ItemStack carpetStackGrey = new ItemStack(Blocks.carpet);
    	ItemStack carpetStackLightGrey = new ItemStack(Blocks.carpet);
    	ItemStack carpetStackCyan = new ItemStack(Blocks.carpet);
    	ItemStack carpetStackPurple = new ItemStack(Blocks.carpet);
    	ItemStack carpetStackBlue = new ItemStack(Blocks.carpet);
    	ItemStack carpetStackBrown = new ItemStack(Blocks.carpet);
    	ItemStack carpetStackGreen = new ItemStack(Blocks.carpet);
    	ItemStack carpetStackRed = new ItemStack(Blocks.carpet);
    	ItemStack carpetStackBlack = new ItemStack(Blocks.carpet);
    	carpetStackWhite.setItemDamage(0);
    	carpetStackOrange.setItemDamage(1);
    	carpetStackMagenta.setItemDamage(2);
    	carpetStackLightBlue.setItemDamage(3);
    	carpetStackYellow.setItemDamage(4);
    	carpetStackLime.setItemDamage(5);
    	carpetStackPink.setItemDamage(6);
    	carpetStackGrey.setItemDamage(7);
    	carpetStackLightGrey.setItemDamage(8);
    	carpetStackCyan.setItemDamage(9);
    	carpetStackPurple.setItemDamage(10);
    	carpetStackBlue.setItemDamage(11);
    	carpetStackBrown.setItemDamage(12);
    	carpetStackGreen.setItemDamage(13);
    	carpetStackRed.setItemDamage(14);
    	carpetStackBlack.setItemDamage(15);
    	GameRegistry.addSmelting(carpetStackWhite, carpetStackOrange, 0.1f);
    	GameRegistry.addSmelting(carpetStackOrange, carpetStackMagenta, 0.1f);
    	GameRegistry.addSmelting(carpetStackMagenta, carpetStackLightBlue, 0.1f);
    	GameRegistry.addSmelting(carpetStackLightBlue, carpetStackYellow, 0.1f);
    	GameRegistry.addSmelting(carpetStackYellow, carpetStackLime, 0.1f);
    	GameRegistry.addSmelting(carpetStackLime, carpetStackPink, 0.1f);
    	GameRegistry.addSmelting(carpetStackPink, carpetStackGrey, 0.1f);
    	GameRegistry.addSmelting(carpetStackGrey, carpetStackLightGrey, 0.1f);
    	GameRegistry.addSmelting(carpetStackLightGrey, carpetStackCyan, 0.1f);
    	GameRegistry.addSmelting(carpetStackCyan, carpetStackPurple, 0.1f);
    	GameRegistry.addSmelting(carpetStackPurple, carpetStackBlue, 0.1f);
    	GameRegistry.addSmelting(carpetStackBlue, carpetStackBrown, 0.1f);
    	GameRegistry.addSmelting(carpetStackBrown, carpetStackGreen, 0.1f);
    	GameRegistry.addSmelting(carpetStackGreen, carpetStackRed, 0.1f);
    	GameRegistry.addSmelting(carpetStackRed, carpetStackBlack, 0.1f);
    	GameRegistry.addSmelting(carpetStackBlack, carpetStackWhite, 0.1f);
    //wool smelting
    	ItemStack woolStackWhite = new ItemStack(Blocks.wool);
    	ItemStack woolStackOrange = new ItemStack(Blocks.wool);
    	ItemStack woolStackMagenta = new ItemStack(Blocks.wool);
    	ItemStack woolStackLightBlue = new ItemStack(Blocks.wool);
    	ItemStack woolStackYellow = new ItemStack(Blocks.wool);
    	ItemStack woolStackLime = new ItemStack(Blocks.wool);
    	ItemStack woolStackPink = new ItemStack(Blocks.wool);
    	ItemStack woolStackGrey = new ItemStack(Blocks.wool);
    	ItemStack woolStackLightGrey = new ItemStack(Blocks.wool);
    	ItemStack woolStackCyan = new ItemStack(Blocks.wool);
    	ItemStack woolStackPurple = new ItemStack(Blocks.wool);
    	ItemStack woolStackBlue = new ItemStack(Blocks.wool);
    	ItemStack woolStackBrown = new ItemStack(Blocks.wool);
    	ItemStack woolStackGreen = new ItemStack(Blocks.wool);
    	ItemStack woolStackRed = new ItemStack(Blocks.wool);
    	ItemStack woolStackBlack = new ItemStack(Blocks.wool);
    	woolStackWhite.setItemDamage(0);
    	woolStackOrange.setItemDamage(1);
    	woolStackMagenta.setItemDamage(2);
    	woolStackLightBlue.setItemDamage(3);
    	woolStackYellow.setItemDamage(4);
    	woolStackLime.setItemDamage(5);
    	woolStackPink.setItemDamage(6);
    	woolStackGrey.setItemDamage(7);
    	woolStackLightGrey.setItemDamage(8);
    	woolStackCyan.setItemDamage(9);
    	woolStackPurple.setItemDamage(10);
    	woolStackBlue.setItemDamage(11);
    	woolStackBrown.setItemDamage(12);
    	woolStackGreen.setItemDamage(13);
    	woolStackRed.setItemDamage(14);
    	woolStackBlack.setItemDamage(15);
    	GameRegistry.addSmelting(woolStackWhite, woolStackOrange, 0.1f);
    	GameRegistry.addSmelting(woolStackOrange, woolStackMagenta, 0.1f);
    	GameRegistry.addSmelting(woolStackMagenta, woolStackLightBlue, 0.1f);
    	GameRegistry.addSmelting(woolStackLightBlue, woolStackYellow, 0.1f);
    	GameRegistry.addSmelting(woolStackYellow, woolStackLime, 0.1f);
    	GameRegistry.addSmelting(woolStackLime, woolStackPink, 0.1f);
    	GameRegistry.addSmelting(woolStackPink, woolStackGrey, 0.1f);
    	GameRegistry.addSmelting(woolStackGrey, woolStackLightGrey, 0.1f);
    	GameRegistry.addSmelting(woolStackLightGrey, woolStackCyan, 0.1f);
    	GameRegistry.addSmelting(woolStackCyan, woolStackPurple, 0.1f);
    	GameRegistry.addSmelting(woolStackPurple, woolStackBlue, 0.1f);
    	GameRegistry.addSmelting(woolStackBlue, woolStackBrown, 0.1f);
    	GameRegistry.addSmelting(woolStackBrown, woolStackGreen, 0.1f);
    	GameRegistry.addSmelting(woolStackGreen, woolStackRed, 0.1f);
    	GameRegistry.addSmelting(woolStackRed, woolStackBlack, 0.1f);
    	GameRegistry.addSmelting(woolStackBlack, woolStackWhite, 0.1f);
    	//horse armor rotation
    	GameRegistry.addSmelting(Items.golden_horse_armor, new ItemStack(Items.iron_horse_armor), 10.0f);
    	GameRegistry.addSmelting(Items.iron_horse_armor, new ItemStack(Items.diamond_horse_armor), 10.0f);
    	GameRegistry.addSmelting(Items.diamond_horse_armor, new ItemStack(Items.golden_horse_armor), 10.0f);
    	//American Ingot
    	GameRegistry.addSmelting(BlockManager.AmericanOre, new ItemStack(ItemManager.americanIngot), 10.0f);
    	
    	RenderingRegistry.registerEntityRenderingHandler(CustomMob.class, new RenderCustomBiped(new ModelJoe(), 0.5f));
    	RenderingRegistry.registerEntityRenderingHandler(CatCow.class, new RenderCatCow(new ModelCatCow(), 0.5f));
    	RenderingRegistry.registerEntityRenderingHandler(GiantSkeleton.class, new RenderGiantSkeleton(new ModelGiantSkeleton(), 0.5f));
    	GameRegistry.registerWorldGenerator(new OrangeWorldGenerator(), 10);
    	
    	// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
        
        
        
        if(event.getSide() == Side.CLIENT)
        {
            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
 
            renderItem.getItemModelMesher().register(ItemManager.customItem, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.customItem.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.customHelmet, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.customHelmet.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.customChestplate, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.customChestplate.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.customLeggings, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.customLeggings.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.customBoots, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.customBoots.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.debugHelmet, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.debugHelmet.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.debugChestplate, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.debugChestplate.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.debugLeggings, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.debugLeggings.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.debugBoots, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.debugBoots.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.lightningOrb, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.lightningOrb.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.customPickaxe, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.customPickaxe.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.customAxe, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.customAxe.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.customHoe, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.customHoe.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.customShovel, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.customShovel.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.customSword, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.customSword.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.americanSword, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.americanSword.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.americanIngot, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.americanIngot.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.trainboyItem, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.trainboyItem.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.enderBackpack, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.enderBackpack.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.cakeItem, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.cakeItem.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.eraser, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.eraser.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.diamondMultiTool, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.diamondMultiTool.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.goldMultiTool, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.goldMultiTool.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.ironMultiTool, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.ironMultiTool.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.stoneMultiTool, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.stoneMultiTool.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.woodenMultiTool, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.woodenMultiTool.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.customMultiTool, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.customMultiTool.name, "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.splatoonBlock), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.splatoonBlock.name, "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.customCake), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.customCake.name, "inventory"));
         //   renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.coloredWood), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.coloredWood.name, "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.oneTimeBlock), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.oneTimeBlock.name, "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.smashBlock), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.smashBlock.name, "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.AmericanOre), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.AmericanOre.name, "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.customPortalBlock), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.customPortalBlock.name, "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.deathBlock), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.deathBlock.name, "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.choonsterBlock), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.choonsterBlock.name, "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.trampolineBlock), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.trampolineBlock.name, "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.blockPig), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.blockPig.name, "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.commandBlock), 0, new ModelResourceLocation(this.MODID + ":" + "command_block", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.customSponge), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.customSponge.name, "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.slipperyBlock), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.slipperyBlock.name, "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.poweredSlipperyBlock), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.poweredSlipperyBlock.nameOn, "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.testBlock), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.testBlock.name, "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.oreBlock), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.oreBlock.name, "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.endBlock), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.endBlock.name, "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.netherBlock), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.netherBlock.name, "inventory"));
         //   renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.specialBlock), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.specialBlock.name, "inventory"));
           // registerBlockItemModel(BlockManager.bitBlock, "minecraft:white_wool");
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.bitBlock), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.bitBlock.name+"0", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.bitBlock), 1, new ModelResourceLocation(this.MODID + ":" + BlockManager.bitBlock.name+"1", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.bitBlock), 2, new ModelResourceLocation(this.MODID + ":" + BlockManager.bitBlock.name+"2", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.bitBlock), 3, new ModelResourceLocation(this.MODID + ":" + BlockManager.bitBlock.name+"3", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.bitBlock), 4, new ModelResourceLocation(this.MODID + ":" + BlockManager.bitBlock.name+"4", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.bitBlock), 5, new ModelResourceLocation(this.MODID + ":" + BlockManager.bitBlock.name+"5", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.bitBlock), 6, new ModelResourceLocation(this.MODID + ":" + BlockManager.bitBlock.name+"6", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.bitBlock), 7, new ModelResourceLocation(this.MODID + ":" + BlockManager.bitBlock.name+"7", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.bitBlock), 8, new ModelResourceLocation(this.MODID + ":" + BlockManager.bitBlock.name+"8", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.bitBlock), 9, new ModelResourceLocation(this.MODID + ":" + BlockManager.bitBlock.name+"9", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.bitBlock), 10, new ModelResourceLocation(this.MODID + ":" + BlockManager.bitBlock.name+"10", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.bitBlock), 11, new ModelResourceLocation(this.MODID + ":" + BlockManager.bitBlock.name+"11", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.bitBlock), 12, new ModelResourceLocation(this.MODID + ":" + BlockManager.bitBlock.name+"12", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.bitBlock), 13, new ModelResourceLocation(this.MODID + ":" + BlockManager.bitBlock.name+"13", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.bitBlock), 14, new ModelResourceLocation(this.MODID + ":" + BlockManager.bitBlock.name+"14", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.bitBlock), 15, new ModelResourceLocation(this.MODID + ":" + BlockManager.bitBlock.name+"15", "inventory"));
//            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.bitBlock), 16, new ModelResourceLocation(this.MODID + ":" + BlockManager.bitBlock.name+"16", "inventory"));
  //          renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.bitBlock), 17, new ModelResourceLocation(this.MODID + ":" + BlockManager.bitBlock.name+"17", "inventory"));
    //        renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.bitBlock), 18, new ModelResourceLocation(this.MODID + ":" + BlockManager.bitBlock.name+"18", "inventory"));
            
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.coloredWood), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.coloredWood.name+"0", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.coloredWood), 1, new ModelResourceLocation(this.MODID + ":" + BlockManager.coloredWood.name+"1", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.coloredWood), 2, new ModelResourceLocation(this.MODID + ":" + BlockManager.coloredWood.name+"2", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.coloredWood), 3, new ModelResourceLocation(this.MODID + ":" + BlockManager.coloredWood.name+"3", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.coloredWood), 4, new ModelResourceLocation(this.MODID + ":" + BlockManager.coloredWood.name+"4", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.coloredWood), 5, new ModelResourceLocation(this.MODID + ":" + BlockManager.coloredWood.name+"5", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.coloredWood), 6, new ModelResourceLocation(this.MODID + ":" + BlockManager.coloredWood.name+"6", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.coloredWood), 7, new ModelResourceLocation(this.MODID + ":" + BlockManager.coloredWood.name+"7", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.coloredWood), 8, new ModelResourceLocation(this.MODID + ":" + BlockManager.coloredWood.name+"8", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.coloredWood), 9, new ModelResourceLocation(this.MODID + ":" + BlockManager.coloredWood.name+"9", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.coloredWood), 10, new ModelResourceLocation(this.MODID + ":" + BlockManager.coloredWood.name+"10", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.coloredWood), 11, new ModelResourceLocation(this.MODID + ":" + BlockManager.coloredWood.name+"11", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.coloredWood), 12, new ModelResourceLocation(this.MODID + ":" + BlockManager.coloredWood.name+"12", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.coloredWood), 13, new ModelResourceLocation(this.MODID + ":" + BlockManager.coloredWood.name+"13", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.coloredWood), 14, new ModelResourceLocation(this.MODID + ":" + BlockManager.coloredWood.name+"14", "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.coloredWood), 15, new ModelResourceLocation(this.MODID + ":" + BlockManager.coloredWood.name+"15", "inventory"));
            
            DimensionManager.registerProviderType(2,CustomWorldProvider.class, false);
            DimensionManager.registerDimension(2,2);
        }
        

        
        
        /*int biomeId = getEmptyBiomeID();
        customBiome = new CustomBiome(biomeId, true).setBiomeName("Firestone").setHeight(new Height(0.1f, 0.2f));
        BiomeEntry customEntry = new BiomeEntry(customBiome, 1500);
        BiomeManager.addBiome(BiomeType.WARM, customEntry);
        BiomeManager.addSpawnBiome(customBiome);*/
     // Register village creation classes
        VillagerRegistry.instance().registerVillageCreationHandler(new CustomVillagePiece());
        MapGenStructureIO.registerStructureComponent(TestGen.class, "cm:testgen");
        
        
        VillagerRegistry.instance().registerVillageCreationHandler(new CustomHouseGen());
        MapGenStructureIO.registerStructureComponent(CustomHouse.class, "cm:customhouse");
        
        
        
        addSpawn(CustomMob.class, 1000, 3, 7, EnumCreatureType.MONSTER);
        //addSpawn(CustomMob.class, 10, 30, 50, EnumCreatureType.AMBIENT);
  //      VillagerRegistry.instance().registerVillageCreationHandler(new CustomVillagePiece2());
    //    MapGenStructureIO.registerStructureComponent(CustomOceanMonument.class, "cm:oceanmonument");
    }
    
    
    
    
    @EventHandler
    public static void PostLoad(FMLPostInitializationEvent PostEvent) {
    	WorldType TEST = new WorldTypeTest(6, "test");
 
    }
    
    public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor) {
        int entityId = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(entityClass, entityName, entityId);
        EntityList.entityEggs.put(Integer.valueOf(entityId), new EntityList.EntityEggInfo(entityId, solidColor, spotColor));
    }
    
    public static void addSpawn(Class entityClass, int probability, int min, int max, EnumCreatureType type) {
        for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++) {
            if (BiomeGenBase.getBiomeGenArray()[i] != null) {
                EntityRegistry.addSpawn(entityClass, probability, min, max, type, BiomeGenBase.getBiomeGenArray()[i]);
            }
        }
    }

}
