package com.mimecraf.fudgemod.items;

import com.mimecraf.fudgemod.Main;
import com.mimecraf.fudgemod.init.ModItems;
import com.mimecraf.fudgemod.util.IHasModel;

import net.minecraft.item.ItemFood;

/**
 * ItemFoodBase
 */
public class ItemFoodBase extends ItemFood implements IHasModel {

    public ItemFoodBase(String name, int amount, float Saturation, boolean forWolf){
        super(amount, Saturation, forWolf);
        
        setRegistryName(name);
        setUnlocalizedName(this.getRegistryName().toString());
        
        ModItems.ITEMS.add(this);
        
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");

    }

}
