package com.mimecraf.fudgemod.items.tools;

import com.mimecraf.fudgemod.Main;
import com.mimecraf.fudgemod.init.ModItems;
import com.mimecraf.fudgemod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

public class ToolHoe extends ItemHoe implements IHasModel {

    public ToolHoe(String name,ToolMaterial material) {
        super(material);
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
