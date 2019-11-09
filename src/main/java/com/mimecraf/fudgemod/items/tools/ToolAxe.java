package com.mimecraf.fudgemod.items.tools;

import com.mimecraf.fudgemod.Main;
import com.mimecraf.fudgemod.init.ModItems;
import com.mimecraf.fudgemod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe; 

public class ToolAxe extends ItemAxe implements IHasModel {

    public ToolAxe(String name,ToolMaterial material) {
        super(material, 6.0f, -3.2f);
        setRegistryName(name);
        setUnlocalizedName(this.getRegistryName().toString());
        setCreativeTab(CreativeTabs.COMBAT);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
    
}
