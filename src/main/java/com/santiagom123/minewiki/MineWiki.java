package com.santiagom123.minewiki;


import com.santiagom123.minewiki.handler.HandlerEXT;
import com.santiagom123.minewiki.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = MineWiki.MODID, name = MineWiki.NAME, version = MineWiki.VERSION)
public class MineWiki {
    public static final String MODID = "minewiki";
    public static final String NAME = "MineWiki";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @SidedProxy(
            clientSide = "com.santiagom123.minewiki.proxy.ClientProxy",
            serverSide = "com.santiagom123.minewiki.proxy.CommonProxy"
    )

    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();

        proxy.preInit();

        HandlerEXT.extractJar(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }
}
