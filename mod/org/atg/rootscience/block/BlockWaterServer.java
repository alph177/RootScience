package org.atg.rootscience.block;

import org.atg.rootscience.RootScienceCore;
import org.atg.rootscience.TileEntityWaterServer;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
	public boolean onBlockActivated(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
			float par8, float par9) {
		if(par5EntityPlayer.inventory.getCurrentItem().getItem() == Item.bucketWater)
		{
            if (!par5EntityPlayer.capabilities.isCreativeMode)
            {
            	TileEntity entity = par1World.getBlockTileEntity(par2, par3, par4);
            	if(entity != null && entity instanceof TileEntityWaterServer && ((TileEntityWaterServer)(entity)).waterRequired())
            	{
            		((TileEntityWaterServer)entity).pollWater();
            		par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, new ItemStack(Item.bucketEmpty));
            	}
                
            }
		}
		return super.onBlockActivated( par1World,  par2,  par3,
				 par4,  par5EntityPlayer,  par6,  par7,
				 par8,  par9);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityWaterServer();
	}
	
	
}
