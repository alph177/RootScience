package org.atg.rootscience;

import org.atg.util.FluidLib;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class TileEntityWaterServer extends TileEntity implements IFluidHandler{

	FluidTank tank = new FluidTank(FluidContainerRegistry.BUCKET_VOLUME * 2);
	private static int canDrainPerTick = 10;
	
	private boolean water1Ready = false , water2Ready = false;
	
	public TileEntityWaterServer()
	{
		
	}
	
	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);
		this.water1Ready = par1nbtTagCompound.getBoolean("water1");
		this.water2Ready = par1nbtTagCompound.getBoolean("water2");
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		par1nbtTagCompound.setBoolean("water1", water1Ready);
		par1nbtTagCompound.setBoolean("water2", water2Ready);
	}


	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		return 0;
	}

    @Override
    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain)
    {
        if (resource == null || !resource.isFluidEqual(tank.getFluid()))
        {
            return null;
        }
        return tank.drain(resource.amount, doDrain);
    }

    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain)
    {
        return tank.drain((maxDrain > canDrainPerTick) ? canDrainPerTick : maxDrain, true);
    }

    @Override
    public boolean canFill(ForgeDirection from, Fluid fluid)
    {
        return false;
    }

    @Override
    public boolean canDrain(ForgeDirection from, Fluid fluid)
    {
        return true;
    }

    @Override
	public void updateEntity() {
		super.updateEntity();
		if(!waterRequired())
			tank.fill(new FluidStack(FluidRegistry.WATER, FluidContainerRegistry.BUCKET_VOLUME/40), true);
		if(tank.getFluidAmount() >= FluidContainerRegistry.BUCKET_VOLUME)
			FluidLib.pushFluidToNeighbors(worldObj, xCoord, yCoord, zCoord, tank, tank.getFluidAmount(), true);
	}

	@Override
    public FluidTankInfo[] getTankInfo(ForgeDirection from)
    {
        return new FluidTankInfo[] { tank.getInfo() };
    }

	public boolean waterRequired() {
		return !(water1Ready && water2Ready);
	}
	
	public boolean pollWater()
	{
		if(!water1Ready)water1Ready = true;
		else if (!water2Ready)water2Ready = true;
		else return false;
		return true;
	}
}
