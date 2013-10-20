package org.atg.rootscience.block;

import org.atg.rootscience.RootScienceCore;
import org.atg.rootscience.TileEntityWaterServer;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockWaterServer extends BlockContainer {

	public BlockWaterServer(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(5F);
		this.setStepSound(Block.soundStoneFootstep);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityWaterServer();
	}
	
	
}
