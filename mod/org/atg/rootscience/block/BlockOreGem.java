package org.atg.rootscience.block;

import java.util.Random;

import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;

public class BlockOreGem extends BlockOre{
	
	private int dropID , dropQuantity;

	public BlockOreGem(int par1 , int dropItemID , int dropQuantity) {
		super(par1);
		this.dropID = dropItemID;
		this.dropQuantity = dropQuantity;
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return dropID;
	}
	
	
	


}
