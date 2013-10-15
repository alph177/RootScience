package org.atg.util;

import org.atg.rootscience.TileEntityWaterServer;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
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

}
