package com.mimecraf.fudgemod.blocks.fludgwer;

import com.mimecraf.fudgemod.blocks.BlockTileEntity;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

/**
 * BlockFludgwer
 */
public class BlockFludgwer extends BlockTileEntity<TileEntityFludgwer> {

    public BlockFludgwer(String name, Material material, CreativeTabs tab) {
        super(name, material, tab);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
			TileEntityFludgwer tile = getTileEntity(world, pos);
			if (facing == EnumFacing.DOWN) {
				tile.decrementCount();
			} else if (facing == EnumFacing.UP) {
				tile.incrementCount();
			}
			player.sendStatusMessage(new TextComponentString("Count: " + tile.getCount()), false);
		}
        return true;
    }

    @Override
    public Class<TileEntityFludgwer> getTileEntityClass() {
        // TODO Auto-generated method stub
        return TileEntityFludgwer.class;
    }

    @Override
    public TileEntityFludgwer createTileEntity(World world, IBlockState state) {
        // TODO Auto-generated method stub
        return new TileEntityFludgwer();
    }

    
}