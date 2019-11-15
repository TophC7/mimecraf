package com.mimecraf.fudgemod.blocks.fludgwer;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityFludgwer extends TileEntity{

	public int MAX_MANA = 1000;
	private int mana = 0; 

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setInteger("mana", mana);
		return super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		mana = compound.getInteger("mana");
		super.readFromNBT(compound);
	}

	public int getMana() {
		return mana;
	}
	
	public void incrementMana() {
		mana++;
		markDirty();
	}
	
	public void decrementMana() {
		mana--;
		markDirty();
	}

	public void incrementMana(int amount) {
		
		if (mana + amount >= MAX_MANA) {
			mana = MAX_MANA;

		} else if (mana <= MAX_MANA - amount) {
			mana += amount;
		} 
				
		markDirty();
	}

	public void decrementMana(int amount) {
		mana -= amount;
		markDirty();
	}

}