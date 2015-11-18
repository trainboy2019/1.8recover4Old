package com.camp.proxy;


//import com.camp.client.cape.CapeEventHandler;

//import com.choonster.testmod3.client.cape.CapeEventHandler;
//import com.choonster.testmod3.client.model.ModModelManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

	private final Minecraft minecraft = Minecraft.getMinecraft();

	public void preInit() {
		super.preInit();
		//MinecraftForge.EVENT_BUS.register(new CapeEventHandler());
	}
	
	public void init(){
		super.init();
//		Item itemBlockSimple = GameRegistry.findItem("minecraftbyexample", "mbe21_tesr_block");
	//    ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("minecraftbyexample:mbe21_tesr_block", "inventory");
	  //  final int DEFAULT_ITEM_SUBTYPE = 0;
	    //Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockSimple, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

	//    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEndBlock.class, new TileEntityEndBlockRenderer());
		
	}

	
}
