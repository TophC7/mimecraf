package com.mimecraf.fudgemod.init;

import java.util.ArrayList;
import java.util.List;

//import com.mimecraf.fudgemod.items.ItemBase;
import com.mimecraf.fudgemod.items.ItemFoodBase;
import com.mimecraf.fudgemod.tools.ToolAxe;
import com.mimecraf.fudgemod.tools.ToolHoe;
import com.mimecraf.fudgemod.tools.ToolPickaxe;
import com.mimecraf.fudgemod.tools.ToolShovel;
import com.mimecraf.fudgemod.tools.ToolSword;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

    public static final List<Item> ITEMS = new ArrayList<Item> ();

    //material
    public static final ToolMaterial FUDGE_MATERIAL = EnumHelper.addToolMaterial("fudge_material", 0, 45, 1.0f, 0.0f, 15);
    // public static final ArmorMaterial ARMOR_MATERIAL = EnumHelper.addArmorMaterial("fudge_material", 0, 45, 1.0f, 0.0f, 15);
    

    //items
    
    public static final Item FUDGE_BALL = new ItemFoodBase("fudge_ball", 2, 0.2f, false);
    public static final Item FUDGE_CAKE_SLICE = new ItemFoodBase("fudge_cake_slice", 5, 0.4f, false);

    //Tools
    public static final ItemSword FUDGE_SWORD = new ToolSword("fudge_sword", FUDGE_MATERIAL);
    public static final ItemHoe FUDGE_HOE = new ToolHoe("fudge_Hoe", FUDGE_MATERIAL);
    public static final ItemSpade FUDGE_SHOVEL = new ToolShovel("fudge_shovel", FUDGE_MATERIAL);
    public static final ItemAxe FUDGE_AXE = new ToolAxe("fudge_axe", FUDGE_MATERIAL);
    public static final ItemPickaxe FUDGE_PICKAXE = new ToolPickaxe("fudge_Pickaxe", FUDGE_MATERIAL);



}