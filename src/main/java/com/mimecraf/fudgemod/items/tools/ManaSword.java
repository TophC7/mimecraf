package com.mimecraf.fudgemod.items.tools;

import java.util.List;

import com.mimecraf.fudgemod.Main;
import com.mimecraf.fudgemod.init.ModItems;
import com.mimecraf.fudgemod.util.IHasModel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ManaSword extends ItemSword implements IHasModel {
    
    public final int MAX_MANA = 100;

    public ManaSword(String name,ToolMaterial material) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(this.getRegistryName().toString());
        setCreativeTab(CreativeTabs.COMBAT);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(1, TextFormatting.AQUA + "Mana: " + TextFormatting.RESET + getMana(stack));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
        
    public void incrementMana(ItemStack stack) {
        NBTTagCompound tag = stack.getOrCreateSubCompound("fm");
        int mana = tag.getInteger("mana");
        tag.setInteger("mana", mana + 1);
    }
	
	public void decrementMana(ItemStack stack) {
        NBTTagCompound tag = stack.getOrCreateSubCompound("fm");
        int mana = tag.getInteger("mana");
        tag.setInteger("mana", mana - 1);
    }


	public int getMana(ItemStack stack) {
        NBTTagCompound tag = stack.getOrCreateSubCompound("fm");
        int mana = tag.getInteger("mana");
        return mana;
	}

}
