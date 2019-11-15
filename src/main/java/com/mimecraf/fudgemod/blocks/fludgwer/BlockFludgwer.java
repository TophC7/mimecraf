package com.mimecraf.fudgemod.blocks.fludgwer;

import com.mimecraf.fudgemod.blocks.BlockTileEntity;
import com.mimecraf.fudgemod.init.ModItems;
import com.mimecraf.fudgemod.items.tools.ManaSword;

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
public class BlockFludgwer extends BlockTileEntity<TileEntityFludgwer> {

    // public final int MAX_MANA = 1000;

    public BlockFludgwer(String name, Material material, CreativeTabs tab) {
        super(name, material, tab);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {

            //temp vars for easy use
            TileEntityFludgwer tile = getTileEntity(world, pos);
            ManaSword Mana_Sword = ModItems.MANA_SWORD;
            ItemStack Held_Item = player.getHeldItemMainhand();

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

            if (tile.getMana() < tile.MAX_MANA && Held_Item.isEmpty()) {
                for (BlockPos blockPos : directions) {

                    net.minecraft.block.Block tempBlock = world.getBlockState(blockPos).getBlock();

                    if (tempBlock.equals(Blocks.COAL_BLOCK) && tile.getMana() < tile.MAX_MANA) {
                        
                        tile.incrementMana(100);
                        world.setBlockState(blockPos, Blocks.FIRE.getDefaultState(), 2);

                    }                    
                }

                player.sendStatusMessage(new TextComponentString("Available Mana: " + tile.getMana()), false);

            } else if (Held_Item.isEmpty()) {
                player.sendStatusMessage(new TextComponentString("Available Mana: " + tile.getMana()), false);
                
            }

            if (tile.getMana() > 0 && Mana_Sword.getMana(Held_Item) < Mana_Sword.MAX_MANA && Held_Item.getItem().equals(ModItems.MANA_SWORD)) {
                
                tile.decrementMana();
                Mana_Sword.incrementMana(Held_Item);

                player.sendStatusMessage(new TextComponentString("Available Mana: " + tile.getMana()), false);

            } else if (tile.getMana() == 0 && Held_Item.getItem().equals(ModItems.MANA_SWORD)) {

                player.sendStatusMessage(new TextComponentString("No Mana"), false);

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