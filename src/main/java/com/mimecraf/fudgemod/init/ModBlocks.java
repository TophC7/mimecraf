package com.mimecraf.fudgemod.init;

import java.util.ArrayList;
import java.util.List;

import com.mimecraf.fudgemod.blocks.FudgeBlock;
import com.mimecraf.fudgemod.blocks.FudgeOre;
import com.mimecraf.fudgemod.blocks.fludgwer.BushFludgwer;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * ModBlocks /
 * 
 * Holds all the mod's custom blocks
 * And a list to hold them
 */
public class ModBlocks {

    public static final List<Block> BLOCKS = new ArrayList<Block>();
    
    // Fudge
    public static final Block FUDGE_BLOCK = new FudgeBlock("fudge_block", Material.CLAY);
    public static final Block FUDGE_ORE = new FudgeOre("fudge_ore", Material.ROCK);

    // Choco (Mana)
    public static final Block FLUDGWER = new BushFludgwer("fludgwer", Material.GRASS, CreativeTabs.COMBAT);
    
}