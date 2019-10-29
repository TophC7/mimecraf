package com.mimecraf.fudgemod;

import com.mimecraf.fudgemod.proxy.CommonProxy;
import com.mimecraf.fudgemod.util.Reference;
import com.mimecraf.fudgemod.world.WorldGen;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

    @Instance
    public static Main instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event){

        GameRegistry.registerWorldGenerator(new WorldGen(), 3);
        
    }
    
    @EventHandler
    public static void init(FMLInitializationEvent event){
        
    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent event){
        
    }
    
}