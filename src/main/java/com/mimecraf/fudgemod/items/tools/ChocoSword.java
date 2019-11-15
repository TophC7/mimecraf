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

public class ChocoSword extends ItemSword implements IHasModel {

    public final int MAX_CHOCO = 100;

    public ChocoSword(String name, ToolMaterial material) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(this.getRegistryName().toString());
        setCreativeTab(CreativeTabs.COMBAT);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(1, TextFormatting.DARK_RED + "Choco: " + TextFormatting.RESET + getChoco(stack));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
        
    public void incrementChoco(ItemStack stack) {
        NBTTagCompound tag = stack.getOrCreateSubCompound("fm");
        int choco = tag.getInteger("choco");
        tag.setInteger("choco", choco + 1);
    }
	
	public void decrementChoco(ItemStack stack) {
        NBTTagCompound tag = stack.getOrCreateSubCompound("fm");
        int choco = tag.getInteger("choco");
        tag.setInteger("choco", choco - 1);
    }


	public int getChoco(ItemStack stack) {
        NBTTagCompound tag = stack.getOrCreateSubCompound("fm");
        int choco = tag.getInteger("choco");
        return choco;
	}

}
