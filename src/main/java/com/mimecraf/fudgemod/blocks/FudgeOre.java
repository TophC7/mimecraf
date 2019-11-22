package com.mimecraf.fudgemod.blocks;

import com.mimecraf.fudgemod.Main;
import com.mimecraf.fudgemod.init.ModBlocks;
import com.mimecraf.fudgemod.init.ModItems;
import com.mimecraf.fudgemod.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

/**
 * FudgeOre
 */
public class FudgeOre extends Block implements IHasModel {

    public FudgeOre(final String name, final Material material) {
        super(material);

        setRegistryName(name);
        setUnlocalizedName(this.getRegistryName().toString());
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        setSoundType(SoundType.STONE);
        setHardness(2.0f);
        setResistance(13.0f);
        setHarvestLevel("pickaxe", 0);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

    }

   /*/
    * Optional Overrides to drop set amount of fudgeballs instead of block itself
    *
    * @Override
    * public Item getItemDropped(IBlockState state, Random rand, int fortune) {
    *     return ModItems.FUDGE_BALL;
    * }
    * 
    * @Override
    * public int quantityDropped(Random random) {
    * return new Random().nextInt(4) + 1;
    * }
   /*/
}
