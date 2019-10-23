package com.mimecraf.fudgemod.init;

import java.util.ArrayList;
import java.util.List;

import com.mimecraf.fudgemod.blocks.BlockBase;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ModBlocks {

    public static final List<Block> BLOCKS = new ArrayList<Block>();
    public static final Block FUDGE_BLOCK = new BlockBase("fudge_block", Material.CLAY, CreativeTabs.DECORATIONS);

}