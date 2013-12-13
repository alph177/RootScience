package org.atg.util;

import org.atg.rootscience.TileEntityWaterServer;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.IFluidHandler;

public class FluidLib {
	
	
	
	public static void pushFluidToNeighbors(World worldObj , int x, int y , int z , FluidTank tank , int fluidAmount , boolean emulate)
	{
		byte bits = 0x00;
		byte counts = 0;
		for(ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS)
		{
			
			TileEntity tileEntity = worldObj.getBlockTileEntity(x+direction.offsetX, y + direction.offsetY, z + direction.offsetZ);
			if(
					(tileEntity != null) &&
					(tileEntity instanceof IFluidHandler)
			)
			{
				bits += 0x1 << direction.ordinal();
				counts++;
			}
		}
		
		if(counts == 0)
		{
			int cx , cy , cz;
			for(ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS)
			{
				cx = x + direction.offsetX;
				cy = y + direction.offsetY;
				cz = z + direction.offsetZ;
				if(
						worldObj.getBlockId(cx,cy,cz) == Block.cauldron.blockID &&
						(BlockCauldron.func_111045_h_(worldObj.getBlockMetadata(cx,cy,cz))) < 3 &&
						tank.getFluidAmount() > 1000
				)
				{
					fillCauldron(worldObj, cx, cy, cz);
					tank.drain(1000, true);
					break;
				}	
			}
		}
		
		for(int i = 0; i < ForgeDirection.VALID_DIRECTIONS.length; i++)
		{
			ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
			if((bits & (0x1 << i)) != 0)
			{
				IFluidHandler fluidHandler = (IFluidHandler)(worldObj.getBlockTileEntity(x+direction.offsetX, y + direction.offsetY, z + direction.offsetZ));
				if((tank.getFluidAmount() > 0) && fluidHandler.canFill(direction, tank.getFluid().getFluid()))
				{
					fluidAmount -= fluidHandler.fill(direction, tank.drain(fluidAmount/counts, !emulate), true);
				}
				Block.blocksList[worldObj.getBlockId(x, y, z)].onNeighborTileChange(worldObj, x+direction.offsetX, y + direction.offsetY, z + direction.offsetZ, x, y, z);
			}
		}
	}
	
	public static void fillCauldron(World par1World , int x , int y , int z)
	{
		int metadata;
		if(
				par1World.getBlockId(x, y, z) == Block.cauldron.blockID &&
				(metadata = BlockCauldron.func_111045_h_(par1World.getBlockMetadata(x, y, z))) < 3	
		)
		{
			par1World.setBlockMetadataWithNotify(x, y, z, metadata+1, 2);
            par1World.func_96440_m(x, y, z, Block.cauldron.blockID);
		}
	}

}
