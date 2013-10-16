package org.atg.rootscience;

import org.atg.util.FluidLib;

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

	FluidTank tank = new FluidTank(FluidContainerRegistry.BUCKET_VOLUME);
	private static int canDrainPerTick = 10;
	
	public TileEntityWaterServer()
	{
		tank.fill(new FluidStack(FluidRegistry.WATER,1000), true);
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
        return tank.drain(resource.amount, false);
    }

    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain)
    {
        return tank.drain((maxDrain > canDrainPerTick) ? canDrainPerTick : maxDrain, false);
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
		FluidLib.pushFluidToNeighbors(worldObj, xCoord, yCoord, zCoord, tank, tank.getCapacity(), true);
	}

	@Override
    public FluidTankInfo[] getTankInfo(ForgeDirection from)
    {
        return new FluidTankInfo[] { tank.getInfo() };
    }
}
