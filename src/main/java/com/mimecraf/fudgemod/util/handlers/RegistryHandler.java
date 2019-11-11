package com.mimecraf.fudgemod.util.handlers;

import javax.annotation.Nonnull;

import com.mimecraf.fudgemod.blocks.fludgwer.TileEntityFludgwer;
import com.mimecraf.fudgemod.init.ModBlocks;
import com.mimecraf.fudgemod.init.ModItems;
import com.mimecraf.fudgemod.util.IHasModel;
import com.mimecraf.fudgemod.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler{

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item [0]));
    }


    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event){
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block [0]));
        registerTileEntity(TileEntityFludgwer.class, ModBlocks.FLUDGWER.getRegistryName().toString());
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event){
        for (Item item : ModItems.ITEMS) {
            if(item instanceof IHasModel){
                ((IHasModel)item).registerModels();

            }
        }

        for (Block block : ModBlocks.BLOCKS) {
            if (block instanceof IHasModel) {
                ((IHasModel)block).registerModels();

            }
        }
    }

    private static void registerTileEntity(@Nonnull final Class<? extends TileEntity> clazz, @Nonnull final String name) {
        GameRegistry.registerTileEntity(clazz, new ResourceLocation(Reference.MOD_ID, name));
    }

}