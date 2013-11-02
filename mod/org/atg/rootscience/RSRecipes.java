package org.atg.rootscience;

import static org.atg.rootscience.RSItems.*;
import static org.atg.rootscience.RSBlocks.*;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public abstract class RSRecipes {
	
	public static void init(FMLInitializationEvent event) 
	{
        GameRegistry.addRecipe(new ItemStack(waterBox,1),
                new Object[]{"III", "IWI", "III" , 'I', Item.ingotIron , 'W', Item.bucketWater});
		GameRegistry.addRecipe(
				new ItemStack(waterServer,1),
				new Object[]{"SSS", "SWS", "SSS" , Character.valueOf('S') , Block.cobblestone , Character.valueOf('W') , RSItems.waterBox}
				);
		registerPickaxe(pickaxeRuby , gemRuby , Item.stick);
		registerPickaxe(pickaxeSapphire , gemSapphire , Item.stick);
		registerPickaxe(pickaxeCorundum , gemCorundum , Item.stick);
		registerShovel(shovelRuby , gemRuby , Item.stick);
		registerShovel(shovelSapphire , gemSapphire , Item.stick);
		registerShovel(shovelCorundum , gemCorundum , Item.stick);
		registerAxe(axeRuby , gemRuby , Item.stick);
		registerAxe(axeSapphire , gemSapphire , Item.stick);
		registerAxe(axeCorundum , gemCorundum , Item.stick);
		registerSword(swordRuby , gemRuby , Item.stick);
		registerSword(swordSapphire , gemSapphire , Item.stick);
		registerSword(swordCorundum , gemCorundum , Item.stick);
		
		GameRegistry.addSmelting(oreCopper.blockID, new ItemStack(ingotCopper), 0);
		GameRegistry.addSmelting(oreTin.blockID, new ItemStack(ingotTin), 0);
		GameRegistry.addSmelting(oreSilver.blockID, new ItemStack(ingotSilver), 0);
	}
	
	private static void registerPickaxe(Item out , Item head , Item stick)
	{
		GameRegistry.addRecipe(
				new ItemStack(out,1),
				new Object[]{"HHH", " S ", " S " , Character.valueOf('H') , head , Character.valueOf('S') , stick}
				);
	}
	
	private static void registerShovel(Item out , Item head , Item stick)
	{
		GameRegistry.addRecipe(
				new ItemStack(out,1),
				new Object[]{" H ", " S ", " S " , Character.valueOf('H') , head , Character.valueOf('S') , stick}
				);
	}
	
	private static void registerAxe(Item out , Item head , Item stick)
	{
		GameRegistry.addRecipe(
				new ItemStack(out,1),
				new Object[]{"HH ", "HS ", " S " , Character.valueOf('H') , head , Character.valueOf('S') , stick}
				);
	}
	private static void registerSword(Item out , Item head , Item stick)
	{
		GameRegistry.addRecipe(
				new ItemStack(out,1),
				new Object[]{" H ", " H ", " S " , Character.valueOf('H') , head , Character.valueOf('S') , stick}
				);
	}
}
