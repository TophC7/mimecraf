package com.mimecraf.fudgemod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * ModRecipes
 * 
 * Holds mod's non-json recipies
 */
public class ModRecipes {

    public static void init(){
        GameRegistry.addSmelting(ModBlocks.FUDGE_ORE, new ItemStack(ModItems.FUDGE_BALL, 3), 0.5f);
        
    }

}