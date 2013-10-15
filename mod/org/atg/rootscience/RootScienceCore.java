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
 
/**
 * Sample Mod クラス.
 * 
 * Modアノテーションをつけるだけで、Modクラスとして認識される。
 * クラス名は自由に決めることができ、他のクラスを継承する必要もない。
 * なお、Modアノテーションの必須項目は modid のみで、その他は外部ファイルから設定することができ、省略することも可能。
 * 
 * また、NetworkMod は不要であれば省略してもよい。
 * 
 */
@Mod(modid = "RootScience", version = "Rev.001", name = "RootScience", dependencies="after:Railcraft;after:GregTech-Addon")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class RootScienceCore {
	
	public static final String domain = "rootscience";
	
	public static Configuration configuration;
	
	public static OreGenerator oreGenerator = new OreGenerator();
	
	public static boolean generateCloth = false , generateKnife = false;
	public static int clothWeight  = 20, knifeWeight = 8;
	
	
    /**
     * 指定したIDのModのインスタンス.
     * 
     * フィールド名、アクセス指定子はなんでもよい。不要であれば省略可能。
     * 自身のインスタンスがインジェクションされる。
     */
    @Instance("S.U.B.")
    protected static RootScienceCore instance;
 
    /**
     * サーバー、クライアントで異なる処理を行わせる場合に用いるプロキシークラス.
     * 
     * フィールド名、はなんでもよい。不要であれば省略可能。(public以外のアクセス指定子が使えるかは不明)
     * 実行環境にあわせて、どちらかのインスタンスがインジェクションされる。
     */
    
    /*@SideProxy(
        clientSide = "mods.sample.ClientProxy",
        serverSide = "mods.sample.ServerProxy")
    public static SampleProxy proxy;
 */
    /**
     * 初期化前処理.
     * 
     * メソッド名はなんでもよい。不要であれば省略可能。
     * 
     * @param event
     *         FMLの初期化前処理イベント
     */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
		
		configuration = new Configuration(new java.io.File(event.getModConfigurationDirectory(), "RootScience.cfg"));

		RSItems.preInit(event, configuration);
		RSBlocks.preInit(event, configuration);
		
    	configuration.save();
    	
    }
   
 
    /**
     * 初期化処理.
     * 
     * メソッド名はなんでもよい。不要であれば省略可能。
     * 
     * @param event
     *         FMLの初期化処理イベント
     */
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