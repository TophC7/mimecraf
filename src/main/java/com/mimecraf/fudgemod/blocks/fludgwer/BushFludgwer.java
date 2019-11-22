package com.mimecraf.fudgemod.blocks.fludgwer;

import com.mimecraf.fudgemod.blocks.BushTileEntity;
import com.mimecraf.fudgemod.init.ModBlocks;
import com.mimecraf.fudgemod.init.ModItems;
import com.mimecraf.fudgemod.items.tools.ChocoSword;

import net.minecraft.block.Block;
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

/*/
 * BlockFludgwer /
 * 
 * Actual block for Fludgwer w/ tile entity attached.
/*/
public class BushFludgwer extends BushTileEntity<TileEntityFludgwer> {

    public BushFludgwer(String name, Material material, CreativeTabs tab) {
        super(name, material, tab);

    }

    @Override //called when the block is rigth clicked
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) { //verifies if in player client and not in server

            //temp vars for easy use
            TileEntityFludgwer tile = getTileEntity(world, pos);
            ChocoSword chocoSword = ModItems.CHOCO_SWORD;
            ItemStack heldItem = player.getHeldItemMainhand();

            // all directions in a 3*3*1 radius
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

            if (tile.getChoco() < tile.MAX_CHOCO && heldItem.isEmpty()) { //if choco (mana) not at max and empty handed
                for (BlockPos blockPos : directions) { //for each direction
                    //current block saved in easy to use var
                    Block tempBlock = world.getBlockState(blockPos).getBlock();

                    //if block is a fudge block or a coal block and not at max choco (mana)
                    if ((tempBlock.equals(Blocks.COAL_BLOCK) || tempBlock.equals(ModBlocks.FUDGE_BLOCK)) && tile.getChoco() < tile.MAX_CHOCO) {
                        tile.incrementChoco(100);
                        world.setBlockState(blockPos, Blocks.FIRE.getDefaultState(), 2); //changes the Block at current position to a fire

                    }                    
                }

                //send to chat available choco (mana) once done with logic
                player.sendStatusMessage(new TextComponentString("Available Choco: " + tile.getChoco()), false);

            } else if (heldItem.isEmpty()) { //else no consumable blocks around so just send the current choco (mana)
                player.sendStatusMessage(new TextComponentString("Available Choco: " + tile.getChoco()), false);
                
            }

            //if held item is a chocoSword and not at max choco (mana)
            if (tile.getChoco() > 0 && chocoSword.getChoco(heldItem) < chocoSword.MAX_CHOCO && heldItem.getItem().equals(ModItems.CHOCO_SWORD)) {
                tile.decrementChoco(TileEntityFludgwer.CHOCO_STEP); //take the set amount of choco (mana) from the flugwer
                chocoSword.incrementChoco(heldItem, TileEntityFludgwer.CHOCO_STEP); //and give it to the player's chocoSword the set amount of choco (mana)

                //send to chat available choco (mana)
                player.sendStatusMessage(new TextComponentString("Available Choco: " + tile.getChoco()), false);

            } else if (chocoSword.getChoco(heldItem) == chocoSword.MAX_CHOCO) { //else if sword is at max choco (mana)
                player.sendStatusMessage(new TextComponentString("Sword maxed out"), false); //send to chat so

            } else if (tile.getChoco() == 0 && heldItem.getItem().equals(ModItems.CHOCO_SWORD)) { //otherwise if holding sword but no mana available in fludgwer
                player.sendStatusMessage(new TextComponentString("No Choco"), false); //send to chat so

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