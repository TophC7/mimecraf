package com.mimecraf.fudgemod.init;

import java.util.ArrayList;
import java.util.List;

// import com.mimecraf.fudgemod.blocks.BlockBase;
import com.mimecraf.fudgemod.blocks.FudgeBlock;
import com.mimecraf.fudgemod.blocks.FudgeOre;
import com.mimecraf.fudgemod.blocks.fludgwer.BushFludgwer;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ModBlocks {

    // Fudge
    public static final List<Block> BLOCKS = new ArrayList<Block>();
    public static final Block FUDGE_BLOCK = new FudgeBlock("fudge_block", Material.CLAY, CreativeTabs.DECORATIONS);
    public static final Block FUDGE_ORE = new FudgeOre("fudge_ore", Material.ROCK, CreativeTabs.BUILDING_BLOCKS);

    // Choco (Mana)
    public static final Block FLUDGWER = new BushFludgwer("fludgwer", Material.GRASS, CreativeTabs.COMBAT);
}