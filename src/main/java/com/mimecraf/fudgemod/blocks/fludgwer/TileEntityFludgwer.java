package com.mimecraf.fudgemod.blocks.fludgwer;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityFludgwer extends TileEntity{

	private int count;
	public long lastChangeTime;


	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setInteger("count", count);
		return super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		// lastChangeTime = compound.getLong("lastChangeTime");
		count = compound.getInteger("count");
		super.readFromNBT(compound);
	 }

	// public ItemStackHandler inventory = new ItemStackHandler(1) {
	// @Override 
	// public void  onContentsChanged(int slot)
	// 	{
	// 		if (!world.isRemote)
	// 		{
	// 			lastChangeTime = world.getWorldTime();

	// 		}
	// 	}
	// };

	public int getCount() {
		return count;
	}
	
	public void incrementCount() {
		count++;
		markDirty();
	}
	
	public void decrementCount() {
		count--;
		markDirty();
	}

}