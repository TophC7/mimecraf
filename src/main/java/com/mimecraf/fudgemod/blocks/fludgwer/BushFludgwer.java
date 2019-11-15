package com.mimecraf.fudgemod.blocks.fludgwer;

import com.mimecraf.fudgemod.blocks.BushTileEntity;
import com.mimecraf.fudgemod.init.ModBlocks;
import com.mimecraf.fudgemod.init.ModItems;
import com.mimecraf.fudgemod.items.tools.ChocoSword;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

/**
 * BlockFludgwer
 */
public class BushFludgwer extends BushTileEntity<TileEntityFludgwer> {

    public BushFludgwer(String name, Material material, CreativeTabs tab) {
        super(name, material, tab);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {

            //temp vars for easy use
            TileEntityFludgwer tile = getTileEntity(world, pos);
            ChocoSword chocoSword = ModItems.CHOCO_SWORD;
            ItemStack heldItem = player.getHeldItemMainhand();

            BlockPos directions [] = {
                pos.north(),
                pos.south(),
                pos.west(),
                pos.east(),
                pos.north().west(),
                pos.north().east(),
                pos.south().west(),
                pos.south().east()
            };

            if (tile.getChoco() < tile.MAX_CHOCO && heldItem.isEmpty()) {
                for (BlockPos blockPos : directions) {
                    net.minecraft.block.Block tempBlock = world.getBlockState(blockPos).getBlock();

                    if ((tempBlock.equals(Blocks.COAL_BLOCK) || tempBlock.equals(ModBlocks.FUDGE_BLOCK)) && tile.getChoco() < tile.MAX_CHOCO) {
                        tile.incrementChoco(100);
                        world.setBlockState(blockPos, Blocks.FIRE.getDefaultState(), 2);

                    }                    
                }

                player.sendStatusMessage(new TextComponentString("Available Choco: " + tile.getChoco()), false);

            } else if (heldItem.isEmpty()) {
                player.sendStatusMessage(new TextComponentString("Available Choco: " + tile.getChoco()), false);
                
            }

            if (tile.getChoco() > 0 && chocoSword.getChoco(heldItem) < chocoSword.MAX_CHOCO && heldItem.getItem().equals(ModItems.CHOCO_SWORD)) {
                tile.decrementChoco();
                chocoSword.incrementChoco(heldItem);
                player.sendStatusMessage(new TextComponentString("Available Choco: " + tile.getChoco()), false);

            } else if (chocoSword.getChoco(heldItem) == chocoSword.MAX_CHOCO) {
                player.sendStatusMessage(new TextComponentString("Sword maxed out"), false);

            } else if (tile.getChoco() == 0 && heldItem.getItem().equals(ModItems.CHOCO_SWORD)) {
                player.sendStatusMessage(new TextComponentString("No Choco"), false);

            } 
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