package com.mimecraf.fudgemod.init;

import java.util.ArrayList;
import java.util.List;

import com.mimecraf.fudgemod.items.ItemFoodBase;
import com.mimecraf.fudgemod.items.armor.ArmorBase;
import com.mimecraf.fudgemod.items.tools.ChocoSword;
import com.mimecraf.fudgemod.items.tools.ToolAxe;
import com.mimecraf.fudgemod.items.tools.ToolHoe;
import com.mimecraf.fudgemod.items.tools.ToolPickaxe;
import com.mimecraf.fudgemod.items.tools.ToolShovel;
import com.mimecraf.fudgemod.items.tools.ToolSword;
import com.mimecraf.fudgemod.util.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

/**
 * ModItems /
 * 
 * Holds all the mod's custom items.
 * And a list to hold them.
 */
public class ModItems {

    public static final List<Item> ITEMS = new ArrayList<Item> ();

    //material
    public static final ToolMaterial FUDGE_MATERIAL = EnumHelper.addToolMaterial("fudge_material", 0, 45, 1.0f, 0.0f, 15);
    public static final ToolMaterial FORTIFIED_FUDGE_MATERIAL = EnumHelper.addToolMaterial("fortified_fudge_material", 2, 500, 6.0F, 2.0F, 14);
    public static final ArmorMaterial FUDGE_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("fudge_armor_material", Reference.MOD_ID + ":fudge", 14, new int[] {2, 7, 5, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f);
    
    //items
    public static final Item FUDGE_BALL = new ItemFoodBase("fudge_ball", 2, 0.2f, false);
    public static final Item FUDGE_CAKE_SLICE = new ItemFoodBase("fudge_cake_slice", 5, 0.4f, false);
    public static final Item FORTIFIED_FUDGE_BALL = new ItemFoodBase("fortified_fudge_ball", 2, 0.2f, false);

    //Tools
    public static final ItemSword FUDGE_SWORD = new ToolSword("fudge_sword", FUDGE_MATERIAL);
    public static final ItemHoe FUDGE_HOE = new ToolHoe("fudge_Hoe", FUDGE_MATERIAL);
    public static final ItemSpade FUDGE_SHOVEL = new ToolShovel("fudge_shovel", FUDGE_MATERIAL);
    public static final ItemAxe FUDGE_AXE = new ToolAxe("fudge_axe", FUDGE_MATERIAL);
    public static final ItemPickaxe FUDGE_PICKAXE = new ToolPickaxe("fudge_Pickaxe", FUDGE_MATERIAL);
    public static final ChocoSword CHOCO_SWORD = new ChocoSword("choco_sword", FORTIFIED_FUDGE_MATERIAL);

    //Armor
    public static final Item FUDGE_HELMET = new  ArmorBase("fudge_helmet", FUDGE_ARMOR_MATERIAL, 1, EntityEquipmentSlot.HEAD);
    public static final Item FUDGE_CHESTPLATE = new ArmorBase("fudge_chestplate", FUDGE_ARMOR_MATERIAL, 1, EntityEquipmentSlot.CHEST);
    public static final Item FUDGE_LEGGINGS = new ArmorBase("fudge_leggings", FUDGE_ARMOR_MATERIAL, 1, EntityEquipmentSlot.LEGS);
    public static final Item FUDGE_BOOTS = new ArmorBase("fudge_boots", FUDGE_ARMOR_MATERIAL, 1, EntityEquipmentSlot.FEET);

}