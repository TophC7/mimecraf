package com.mimecraf.fudgemod.items.tools;

import java.util.List;

import com.mimecraf.fudgemod.Main;
import com.mimecraf.fudgemod.blocks.fludgwer.TileEntityFludgwer;
import com.mimecraf.fudgemod.init.ModItems;
import com.mimecraf.fudgemod.util.IHasModel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/**
 * ChocoSword
 * 
 * Sword with choco (mana) and variable attack damage depending on choco
 * Subscribes an event to change attack damage on call
 */
@EventBusSubscriber //tells forge this class has events that need to be subscribed
public class ChocoSword extends ToolSword {

    public final int MAX_CHOCO = 100;

    public ChocoSword(String name, ToolMaterial material) {
        super(name, material);

    }

    @Override //adds current swords choco (mana) available to the swords toolTip
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(1, TextFormatting.DARK_RED + "Choco: " + TextFormatting.RESET + getChoco(stack));
        //as bonus changes the color to red just for extra glam

    }

    @SubscribeEvent //events that watches for any damage done to a living creature
    public static void onAttack(LivingDamageEvent event){
        if (event.getSource().getTrueSource() instanceof EntityPlayer) { //if the attacker (source) is the player
            //vars for easy access
            EntityPlayer player = (EntityPlayer)event.getSource().getTrueSource(); //casting source to player to acess player specific methods
            ChocoSword chocoSword = ModItems.CHOCO_SWORD;

            //set the events damage amount to the current swords attack amount + a 10% of the mana availabe in the sword
            event.setAmount(event.getAmount() + (0.10F * chocoSword.getChoco(player.getHeldItemMainhand())));

            if (chocoSword.getChoco(player.getHeldItemMainhand()) > 0) //for each attack decrease by a choco step (mana step)
                chocoSword.decrementChoco(player.getHeldItemMainhand(), TileEntityFludgwer.CHOCO_STEP);
            
            // player.sendStatusMessage(new TextComponentString("Damage Made:  " + event.getAmount()), false);
        }
    }
    
    //looks for the NBT tag and increments it by the amount given
    public void incrementChoco(ItemStack stack, int amount) {
        NBTTagCompound tag = stack.getOrCreateSubCompound("fm");
        int choco = tag.getInteger("choco");
        tag.setInteger("choco", choco + amount);

    }
	
	public void decrementChoco(ItemStack stack, int amount) {
        NBTTagCompound tag = stack.getOrCreateSubCompound("fm");
        int choco = tag.getInteger("choco");
        tag.setInteger("choco", choco - amount);

    }

    //looks for the NBT tag and returns its value
	public int getChoco(ItemStack stack) {
        NBTTagCompound tag = stack.getOrCreateSubCompound("fm");
        int choco = tag.getInteger("choco");
        return choco;
        
	}

}
