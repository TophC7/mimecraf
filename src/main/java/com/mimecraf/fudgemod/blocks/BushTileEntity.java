package com.mimecraf.fudgemod.blocks;

import javax.annotation.Nullable;

import com.mimecraf.fudgemod.Main;
import com.mimecraf.fudgemod.init.ModBlocks;
import com.mimecraf.fudgemod.init.ModItems;
import com.mimecraf.fudgemod.util.IHasModel;

import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * BushTileEntity /
 * 
 * Ties togheter the bush block and the fludgwer tile entity.
 * Sort of like a base class for both of them.
 */
public abstract class BushTileEntity<TE extends TileEntity> extends BlockBush implements IHasModel{

    public BushTileEntity(String name, Material material, CreativeTabs tab) {

        setRegistryName(name);
        setUnlocalizedName(this.getRegistryName().toString());
        setCreativeTab(tab);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

    }

    public abstract Class<TE> getTileEntityClass();

    @SuppressWarnings("unchecked") //ignores java warning for line 41
    public TE getTileEntity(IBlockAccess world, BlockPos pos){
        return (TE)world.getTileEntity(pos);

    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
        
    }

    @Nullable
    @Override
    public abstract TE createTileEntity(World world, IBlockState state);

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

    }
}