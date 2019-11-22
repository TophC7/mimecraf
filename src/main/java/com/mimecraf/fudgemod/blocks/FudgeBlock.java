package com.mimecraf.fudgemod.blocks;

import com.mimecraf.fudgemod.Main;
import com.mimecraf.fudgemod.init.ModBlocks;
import com.mimecraf.fudgemod.init.ModItems;
import com.mimecraf.fudgemod.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

/**
 * FudgeBlock /
 * 
 * Class for fudge block.
 * Makes it a sticky block 
 * otherwise a basic block class
 */
public class FudgeBlock extends Block implements IHasModel{

    public FudgeBlock(String name, Material material) {
        super(material);

        setRegistryName(name);
        setUnlocalizedName(this.getRegistryName().toString());
        setCreativeTab(CreativeTabs.DECORATIONS);

        setSoundType(SoundType.SLIME);
        setHardness(0);
        setHarvestLevel("sword", 1);
        setResistance(0.0f);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

    }

    @Override
    public boolean isStickyBlock(IBlockState state) {
        return true;
        
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

    }

}
