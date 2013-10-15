package org.atg.rootscience;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.Property;

public abstract class RSItems {
	
	private RSItems(){};
	
	public static Item 
	waterBox,
	gemRuby,
	gemSapphire, 
	gemCorundum
	;
	
	public static ItemSword
	swordRuby , 
	swordSapphire , 
	swordCorundum
	;
	
	public static ItemTool 
	pickaxeRuby , 
	pickaxeSapphire , 
	pickaxeCorundum , 
	shovelRuby ,
	shovelSapphire ,
	shovelCorundum ,
	axeRuby , 
	axeSapphire , 
	axeCorundum
	;
	
	public static EnumToolMaterial rubyToolEnum;
	public static EnumToolMaterial sapphireToolEnum;
	public static EnumToolMaterial corundumToolEnum;
	static
	{
	}
	
	
    public static void preInit(FMLPreInitializationEvent event , Configuration configuration) {
	
		rubyToolEnum = EnumHelper.addToolMaterial("Ruby", EnumToolMaterial.IRON.getHarvestLevel() , EnumToolMaterial.EMERALD.getMaxUses()/3, EnumToolMaterial.EMERALD.getEfficiencyOnProperMaterial(), EnumToolMaterial.EMERALD.getDamageVsEntity(), EnumToolMaterial.EMERALD.getEnchantability());
		//rubyToolEnum.customCraftingMaterial = ;
		sapphireToolEnum = EnumHelper.addToolMaterial("Sapphire", EnumToolMaterial.IRON.getHarvestLevel() , EnumToolMaterial.EMERALD.getMaxUses()/3, EnumToolMaterial.EMERALD.getEfficiencyOnProperMaterial(), EnumToolMaterial.EMERALD.getDamageVsEntity(), EnumToolMaterial.EMERALD.getEnchantability());
		//sapphireToolEnum.customCraftingMaterial = ;
		corundumToolEnum = EnumHelper.addToolMaterial("Corundum", EnumToolMaterial.IRON.getHarvestLevel() , EnumToolMaterial.EMERALD.getMaxUses()/3, EnumToolMaterial.EMERALD.getEfficiencyOnProperMaterial(), EnumToolMaterial.EMERALD.getDamageVsEntity(), EnumToolMaterial.EMERALD.getEnchantability());
		//corundumToolEnum.customCraftingMaterial = ;
    	
    	Property waterBoxID = configuration.get("items" , "WaterBox.id", DefaultIDs.waterBox);
    	
    	Property gemRubyID = configuration.get("gems" , "Ruby.id", DefaultIDs.gemRuby);
    	Property gemSapphireID = configuration.get("gems" , "Sapphire.id", DefaultIDs.gemSapphire);
    	Property gemCorundumID = configuration.get("gems" , "Corundum.id", DefaultIDs.gemCorundum);
    	
    	Property rubyPickaxeID = configuration.get("tools" , "RubyPickaxe.id", DefaultIDs.rubyPickaxe);
    	Property rubyShovelID = configuration.get("tools" , "RubyShovel.id", DefaultIDs.rubyShovel);
    	Property rubyAxeID = configuration.get("tools" , "RubyAxe.id", DefaultIDs.rubyAxe);
    	Property rubySwordID = configuration.get("tools" , "RubySword.id", DefaultIDs.rubySword);
    	Property sapphirePickaxeID = configuration.get("tools" , "SapphirePickaxe.id", DefaultIDs.sapphirePickaxe);
    	Property sapphireShovelID = configuration.get("tools" , "SapphireShovel.id", DefaultIDs.sapphireShovel);
    	Property sapphireAxeID = configuration.get("tools" , "SapphireAxe.id", DefaultIDs.sapphireAxe);
    	Property sapphireSwordID = configuration.get("tools" , "SapphireSword.id", DefaultIDs.sapphireSword);
    	Property corundumPickaxeID = configuration.get("tools" , "CorundumPickaxe.id", DefaultIDs.corundumPickaxe);
    	Property corundumShovelID = configuration.get("tools" , "CorundumShovel.id", DefaultIDs.corundumShovel);
    	Property corundumAxeID = configuration.get("tools" , "CorundumAxe.id", DefaultIDs.corundumAxe);
    	Property corundumSwordID = configuration.get("tools" , "CorundumSword.id", DefaultIDs.corundumSword);
    	
    	waterBox = new Item(waterBoxID.getInt()).
			setCreativeTab(CreativeTabs.tabAllSearch).
			setUnlocalizedName("waterBox").
			setTextureName(RootScienceCore.domain + ":waterBox");
    	gemRuby = new Item(gemRubyID.getInt()).
			setCreativeTab(CreativeTabs.tabAllSearch).
			setUnlocalizedName("gemRuby").
			setTextureName(RootScienceCore.domain + ":gemRuby");
    	gemSapphire = new Item(gemSapphireID.getInt()).
			setCreativeTab(CreativeTabs.tabAllSearch).
			setUnlocalizedName("gemSapphire").
			setTextureName(RootScienceCore.domain + ":gemSapphire");
    	gemCorundum = new Item(gemCorundumID.getInt()).
			setCreativeTab(CreativeTabs.tabAllSearch).
			setUnlocalizedName("gemCorundum").
			setTextureName(RootScienceCore.domain + ":gemCorundum");
    	
    	pickaxeRuby = (ItemTool)new ItemPickaxe(rubyPickaxeID.getInt(), rubyToolEnum).setUnlocalizedName("pickaxeRuby").setCreativeTab(CreativeTabs.tabTools).setTextureName(RootScienceCore.domain + ":rubyPickaxe");
    	shovelRuby = (ItemTool)new ItemSpade(rubyShovelID.getInt(), rubyToolEnum).setUnlocalizedName("shovelRuby").setCreativeTab(CreativeTabs.tabTools).setTextureName(RootScienceCore.domain + ":rubyShovel");;
    	axeRuby = (ItemTool)new ItemAxe(rubyAxeID.getInt(), rubyToolEnum).setUnlocalizedName("axeRuby").setCreativeTab(CreativeTabs.tabTools).setTextureName(RootScienceCore.domain + ":rubyAxe");;
    	swordRuby = (ItemSword)new ItemSword(rubySwordID.getInt(), rubyToolEnum).setUnlocalizedName("swordRuby").setCreativeTab(CreativeTabs.tabTools).setTextureName(RootScienceCore.domain + ":rubySword");;
    	pickaxeSapphire = (ItemTool)new ItemPickaxe(sapphirePickaxeID.getInt(), sapphireToolEnum).setUnlocalizedName("pickaxeSapphire").setCreativeTab(CreativeTabs.tabTools).setTextureName(RootScienceCore.domain + ":sapphirePickaxe");;
    	shovelSapphire = (ItemTool)new ItemSpade(sapphireShovelID.getInt(), sapphireToolEnum).setUnlocalizedName("shovelSapphire").setCreativeTab(CreativeTabs.tabTools).setTextureName(RootScienceCore.domain + ":sapphireShovel");;
    	axeSapphire = (ItemTool)new ItemAxe(sapphireAxeID.getInt(), sapphireToolEnum).setUnlocalizedName("axeSapphire").setCreativeTab(CreativeTabs.tabTools).setTextureName(RootScienceCore.domain + ":sapphireAxe");;
    	swordSapphire = (ItemSword)new ItemSword(sapphireSwordID.getInt(), sapphireToolEnum).setUnlocalizedName("swordSapphire").setCreativeTab(CreativeTabs.tabTools).setTextureName(RootScienceCore.domain + ":sapphireSword");;
    	pickaxeCorundum = (ItemTool)new ItemPickaxe(corundumPickaxeID.getInt(), corundumToolEnum).setUnlocalizedName("pickaxeCorundum").setCreativeTab(CreativeTabs.tabTools).setTextureName(RootScienceCore.domain + ":corundumPickaxe");;
    	shovelCorundum = (ItemTool)new ItemSpade(corundumShovelID.getInt(), corundumToolEnum).setUnlocalizedName("shovelCorundum").setCreativeTab(CreativeTabs.tabTools).setTextureName(RootScienceCore.domain + ":corundumShovel");;
    	axeCorundum = (ItemTool)new ItemAxe(corundumAxeID.getInt(), corundumToolEnum).setUnlocalizedName("axeCorundum").setCreativeTab(CreativeTabs.tabTools).setTextureName(RootScienceCore.domain + ":corundumAxe");;
    	swordCorundum = (ItemSword)new ItemSword(corundumSwordID.getInt(), corundumToolEnum).setUnlocalizedName("swordCorundum").setCreativeTab(CreativeTabs.tabTools).setTextureName(RootScienceCore.domain + ":corundumSword");;
    	
    	
    	GameRegistry.registerItem(waterBox, "WaterBox");
    	GameRegistry.registerItem(gemRuby, "Ruby");
    	GameRegistry.registerItem(gemSapphire, "Sapphire");
    	GameRegistry.registerItem(gemCorundum, "Corundum");
    	
    	GameRegistry.registerItem(pickaxeRuby, "RubyPickaxe");
    	GameRegistry.registerItem(shovelRuby, "RubyShovel");
    	GameRegistry.registerItem(axeRuby, "RubyAxe");
    	GameRegistry.registerItem(swordRuby, "RubySword");
    	GameRegistry.registerItem(pickaxeSapphire, "SapphirePickaxe");
    	GameRegistry.registerItem(shovelSapphire, "SapphireShovel");
    	GameRegistry.registerItem(axeSapphire, "SapphireAxe");
    	GameRegistry.registerItem(swordSapphire, "SapphireSword");
    	GameRegistry.registerItem(pickaxeCorundum, "CorundumPickaxe");
    	GameRegistry.registerItem(shovelCorundum, "CorundumShovel");
    	GameRegistry.registerItem(axeCorundum, "CorundumAxe");
    	GameRegistry.registerItem(swordCorundum, "CorundumSword");
    	
    	rubyToolEnum.customCraftingMaterial = gemRuby;
    	sapphireToolEnum.customCraftingMaterial = gemSapphire;
    	corundumToolEnum.customCraftingMaterial = gemCorundum;
    	
    }
    
    public static void init(FMLInitializationEvent event) {
        LanguageRegistry.addName(waterBox, "Water Box");
        LanguageRegistry.addName(gemRuby, "Ruby");
        LanguageRegistry.addName(gemSapphire, "Sapphire");
        LanguageRegistry.addName(gemCorundum, "Corundum");
        
    	LanguageRegistry.addName(pickaxeRuby, "Ruby Pickaxe");
    	LanguageRegistry.addName(shovelRuby, "Ruby Shovel");
    	LanguageRegistry.addName(axeRuby, "Ruby Axe");
    	LanguageRegistry.addName(swordRuby, "Ruby Sword");
    	LanguageRegistry.addName(pickaxeSapphire, "Sapphire Pickaxe");
    	LanguageRegistry.addName(shovelSapphire, "Sapphire Shovel");
    	LanguageRegistry.addName(axeSapphire, "Sapphire Axe");
    	LanguageRegistry.addName(swordSapphire, "Sapphire Sword");
    	LanguageRegistry.addName(pickaxeCorundum, "Corundum Pickaxe");
    	LanguageRegistry.addName(shovelCorundum, "Corundum Shovel");
    	LanguageRegistry.addName(axeCorundum, "Corundum Axe");
    	LanguageRegistry.addName(swordCorundum, "Corundum Sword");
    }
}
