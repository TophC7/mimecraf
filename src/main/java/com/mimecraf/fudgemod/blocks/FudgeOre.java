package com.mimecraf.fudgemod.blocks;

import java.util.Random;

import com.mimecraf.fudgemod.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class FudgeOre extends BlockBase {

    public FudgeOre(String name, Material material, CreativeTabs tab) {
        super(name, material, tab);

        setSoundType(SoundType.STONE);
        setHardness(2.0f);
        setResistance(13.0f);
        setHarvestLevel("pickaxe", 0);

    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ModItems.FUDGE_BALL;
    }

    @Override
    public int quantityDropped(Random random) {
        return new Random().nextInt(4) + 1;
    }

}
