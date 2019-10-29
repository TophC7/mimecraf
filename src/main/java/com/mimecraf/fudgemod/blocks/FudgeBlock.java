package com.mimecraf.fudgemod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class FudgeBlock extends BlockBase {

    public FudgeBlock(String name, Material material, CreativeTabs tab) {
        super(name, material, tab);

        setSoundType(SoundType.SLIME);
        setHardness(0);
        setHarvestLevel("sword", 1);
        setResistance(0.0f);

    }

}
