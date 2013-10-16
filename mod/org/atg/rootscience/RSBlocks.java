package org.atg.rootscience;

import org.atg.rootscience.block.BlockWaterServer;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class RSBlocks {
	
	private RSBlocks(){};
	
	
	public static Block 
		waterServer,
		oreFe2O3,
		oreCopper,
		oreTin , 
		oreSilver , 
		oreRuby , 
		oreSapphire , 
		oreCorundum;
	
	public static void preInit(FMLPreInitializationEvent event , Configuration configuration) 
	{
		Property waterServerID = configuration.get("blocks" , "WaterServer.id" , DefaultIDs.waterServer);
		Property oreFe2O3ID = configuration.get("blocks" , "OreFe2O3.id" , DefaultIDs.oreFe2O3);
		Property oreCopperID = configuration.get("blocks" , "OreCopper.id" , DefaultIDs.oreCopper);
		Property oreTinID = configuration.get("blocks" , "OreTin.id" , DefaultIDs.oreTin);
		Property oreSilverID = configuration.get("blocks" , "OreSilver.id" , DefaultIDs.oreSilver);
		Property oreRubyID = configuration.get("blocks" , "oreRuby.id" , DefaultIDs.oreRuby);
		Property oreSapphireID = configuration.get("blocks" , "oreSapphire.id" , DefaultIDs.oreSapphire);
		Property oreCorundumID = configuration.get("blocks" , "oreCorundum.id" , DefaultIDs.oreCorundum);
		
    	waterServer = new BlockWaterServer(waterServerID.getInt(), Material.rock);
		
		oreFe2O3 = new BlockOre(oreFe2O3ID.getInt()).
				setTextureName(RootScienceCore.domain + ":OreFe2O3").
				setHardness(2.0F).
				setResistance(5.0F).
				setUnlocalizedName("Hematite").
				setStepSound(Block.soundStoneFootstep);
		oreCopper = new BlockOre(oreCopperID.getInt()).
				setTextureName(RootScienceCore.domain + ":OreCopper").
				setHardness(3.0F).
				setResistance(5.0F).
				setUnlocalizedName("Coper").
				setStepSound(Block.soundStoneFootstep);
		
		oreTin = new BlockOre(oreTinID.getInt()).
				setTextureName(RootScienceCore.domain + ":OreTin").
				setHardness(3.0F).
				setResistance(5.0F).
				setUnlocalizedName("Tin").
				setStepSound(Block.soundStoneFootstep);
		
		oreSilver = new BlockOre(oreSilverID.getInt()).
				setTextureName(RootScienceCore.domain + ":OreSilver").
				setHardness(3.0F).
				setResistance(5.0F).
				setUnlocalizedName("Silver").
				setStepSound(Block.soundStoneFootstep);
						
		oreRuby = new BlockOre(oreRubyID.getInt()).
				//setTextureName(StartUpBoosterCore.domain + ":OreRuby").
				setTextureName(RootScienceCore.domain + ":OreRuby").
				setHardness(3.0F).
				setResistance(5.0F).
				setUnlocalizedName("Ruby").
				setStepSound(Block.soundStoneFootstep);
		oreSapphire = new BlockOre(oreSapphireID.getInt()).
				//setTextureName(StartUpBoosterCore.domain + ":OreSapphire").
				setTextureName(RootScienceCore.domain + ":OreSapphire").
				setHardness(3.0F).
				setResistance(5.0F).
				setUnlocalizedName("Sapphire").
				setStepSound(Block.soundStoneFootstep);
		oreCorundum = new BlockOre(oreCorundumID.getInt()).
				//setTextureName(StartUpBoosterCore.domain + ":OreCorundum").
				setTextureName(RootScienceCore.domain + ":OreCorundum").
				setHardness(3.0F).
				setResistance(5.0F).
				setUnlocalizedName("Corundum").
				setStepSound(Block.soundStoneFootstep);
		
		GameRegistry.registerBlock(waterServer, "WaterServer");
		GameRegistry.registerBlock(oreFe2O3, "OreFe2O3");
		GameRegistry.registerBlock(oreCopper, "OreCopper");
		GameRegistry.registerBlock(oreTin, "OreTin");
		GameRegistry.registerBlock(oreSilver, "OreSilver");
		GameRegistry.registerBlock(oreRuby, "OreRuby");
		GameRegistry.registerBlock(oreSapphire, "OreSapphire");
		GameRegistry.registerBlock(oreCorundum, "OreCorundum");
		
		
		OreDictionary.registerOre("oreCopper", oreCopper);
		OreDictionary.registerOre("oreTin", oreTin);
		OreDictionary.registerOre("oreSilver", oreSilver);
		
		OreDictionary.registerOre("oreRuby", oreRuby);
		OreDictionary.registerOre("oreSapphire", oreSapphire);
		OreDictionary.registerOre("oreCorundum", oreCorundum);
		
	}
	
	
	public static void init(FMLInitializationEvent event) 
	{
		LanguageRegistry.addName(waterServer, "Water Server");
		LanguageRegistry.addName(oreFe2O3, "Hematite Ore");
		LanguageRegistry.addName(oreCopper, "Copper Ore");
		LanguageRegistry.addName(oreTin, "Tin Ore");
		LanguageRegistry.addName(oreSilver, "Silver Ore");
		LanguageRegistry.addName(oreRuby, "Ruby Ore");
		LanguageRegistry.addName(oreSapphire, "Sapphire Ore");
		LanguageRegistry.addName(oreCorundum, "Corundum Ore");
		
		MinecraftForge.setBlockHarvestLevel(waterServer, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(oreFe2O3, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(oreCopper, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(oreTin, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(oreRuby, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(oreSapphire, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(oreCorundum, "pickaxe", 2);
	}

}
