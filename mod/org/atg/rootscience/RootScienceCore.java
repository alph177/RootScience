package org.atg.rootscience;

import org.atg.rootscience.TileEntityWaterServer;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.InstanceFactory;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
 
@Mod(modid = "RootScience", version = "Rev.001", name = "RootScience", dependencies="after:Railcraft;after:GregTech-Addon")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class RootScienceCore {
	
	public static final String domain = "rootscience";
	
	public static Configuration configuration;
	
	public static OreGenerator oreGenerator = new OreGenerator();
	
	public static boolean generateCloth = false , generateKnife = false;
	public static int clothWeight  = 20, knifeWeight = 8;
	

    @Instance("RootScience")
    protected static RootScienceCore instance;

    
    /*@SideProxy(
        clientSide = "mods.sample.ClientProxy",
        serverSide = "mods.sample.ServerProxy")
    public static SampleProxy proxy;
 */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
		
		configuration = new Configuration(new java.io.File(event.getModConfigurationDirectory(), "RootScience.cfg"));

		RSItems.preInit(event, configuration);
		RSBlocks.preInit(event, configuration);
		
    	configuration.save();
    	
    }
   
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	
		RSItems.init(event);
		RSBlocks.init(event);
		RSRecipes.init(event);

		GameRegistry.registerWorldGenerator(new OreGenerator());
		GameRegistry.registerTileEntity(TileEntityWaterServer.class, "TileEntityWaterServer");
		

    }

    @InstanceFactory
    public static RootScienceCore instance() {
        return new RootScienceCore();
    }
    
    
}