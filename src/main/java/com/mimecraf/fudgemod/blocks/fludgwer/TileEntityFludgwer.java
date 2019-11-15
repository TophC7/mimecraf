package com.mimecraf.fudgemod.blocks.fludgwer;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityFludgwer extends TileEntity{

	public int MAX_CHOCO = 1000;
	private int choco = 0; 

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setInteger("choco", choco);
		return super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		choco = compound.getInteger("choco");
		super.readFromNBT(compound);
	}

	public int getChoco() {
		return choco;
	}
	
	public void incrementChoco() {
		choco++;
		markDirty();
	}
	
	public void decrementChoco() {
		choco--;
		markDirty();
	}

	public void incrementChoco(int amount) {
		
		if (choco + amount >= MAX_CHOCO) {
			choco = MAX_CHOCO;

		} else if (choco <= MAX_CHOCO - amount) {
			choco += amount;
		} 
				
		markDirty();
	}

	public void decrementChoco(int amount) {
		choco -= amount;
		markDirty();
	}

}