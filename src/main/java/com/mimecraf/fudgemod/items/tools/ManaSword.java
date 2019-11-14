package com.mimecraf.fudgemod.items.tools;

import com.mimecraf.fudgemod.Main;
import com.mimecraf.fudgemod.init.ModItems;
import com.mimecraf.fudgemod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ManaSword extends ItemSword implements IHasModel {
    
    public int mana;

    public ManaSword(String name,ToolMaterial material) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(this.getRegistryName().toString());
        setCreativeTab(CreativeTabs.COMBAT);
        mana=0;
        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

    public int getMana() {
		return mana;
	}
	
    public void incrementMana() {
		mana++;
		//markDirty();
	}
	
	public void decrementMana() {
		mana--;
		//markDirty();
	}

}
