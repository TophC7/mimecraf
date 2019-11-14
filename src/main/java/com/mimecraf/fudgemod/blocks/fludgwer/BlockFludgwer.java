package com.mimecraf.fudgemod.blocks.fludgwer;

import com.mimecraf.fudgemod.blocks.BlockTileEntity;
import com.mimecraf.fudgemod.init.ModItems;
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
			if (facing == EnumFacing.DOWN && player.getHeldItemMainhand().getItem().equals(ModItems.MANA_SWORD)) {
                ModItems.MANA_SWORD.decrementMana();
			} else if (facing == EnumFacing.UP && player.getHeldItemMainhand().getItem().equals(ModItems.MANA_SWORD)) {
                tile.incrementCount();
                ModItems.MANA_SWORD.incrementMana();
                
			}
			player.sendStatusMessage(new TextComponentString("Count: " + ModItems.MANA_SWORD.getMana()), false);
		}
        return true;
    }

    @Override
    public Class<TileEntityFludgwer> getTileEntityClass() {
        return TileEntityFludgwer.class;
    }

    @Override
    public TileEntityFludgwer createTileEntity(World world, IBlockState state) {
        return new TileEntityFludgwer();
    }

    
}