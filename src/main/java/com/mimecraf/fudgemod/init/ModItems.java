package com.mimecraf.fudgemod.init;

import java.util.ArrayList;
import java.util.List;

//import com.mimecraf.fudgemod.items.ItemBase;
import com.mimecraf.fudgemod.items.ItemFoodBase;

import net.minecraft.item.Item;

public class ModItems {

    public static final List<Item> ITEMS = new ArrayList<Item> ();
    public static final Item FUDGE_BALL = new ItemFoodBase("fudge_ball", 2, 0.2f, false);
    public static final Item FUDGE_CAKE_SLICE = new ItemFoodBase("fudge_cake_slice", 5, 0.4f, false);

}