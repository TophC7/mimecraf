package com.mimecraf.fudgemod.blocks.fludgwer;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/*/
 * TileEntityFludgwer /
 * 
 * Actual tile entity for Fludgwer.
 * Reads and writes to NBT tags.
 * Holds finals
/*/
public class TileEntityFludgwer extends TileEntity{

	public static final int MAX_CHOCO = 1000;
	public static final int CHOCO_STEP = 5;
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
	
	//Makes sure fludgwer doesnt go over max choco (mana)
	//and where it to techically do set it to MAX_CHOCO (max mana)
	public void incrementChoco(int amount) {
		if (choco + amount >= MAX_CHOCO) {
			choco = MAX_CHOCO;

		} else if (choco <= MAX_CHOCO - amount) {
			choco += amount;
		} 
				
		markDirty(); //makes tag dirty aka tells forge changes have been made update

	}

	public void decrementChoco(int amount) {
		choco -= amount;
		markDirty();

	}

   /*/ 
    * one step changes
    *
	* public void incrementChoco() {
	* 	choco++;
	* 	markDirty();
	* 
	* }
	* 
	* public void decrementChoco() {
	* 	choco--;
	* 	markDirty();
	* 
	* }
   /*/
}