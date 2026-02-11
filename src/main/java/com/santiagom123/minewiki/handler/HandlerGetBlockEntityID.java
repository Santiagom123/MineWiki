package com.santiagom123.minewiki.handler;

import com.santiagom123.minewiki.proxy.ClientProxy;
import com.santiagom123.minewiki.utils.ModData;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

import java.io.File;
import java.io.IOException;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = "minewiki")
public class HandlerGetBlockEntityID {

    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger("MineWiki");


    @SubscribeEvent
    public static void onTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Minecraft mc = Minecraft.getMinecraft();

            if (mc.world != null && ClientProxy.keyGetID.isPressed()) {
                if (mc.world != null && mc.objectMouseOver != null) {
                    RayTraceResult result = mc.objectMouseOver;

                    if (result.typeOfHit == RayTraceResult.Type.ENTITY) {
                        Entity entity = result.entityHit;

                        ResourceLocation resLoc = EntityList.getKey(entity);

                        if (resLoc != null) {

                            String id = "ENTITY:" + resLoc + ":0";

                            ModData.actItemID.SetID(id);

                            try {
                                File jarFile = new File("MineWikiEXT.jar").getAbsoluteFile();

                                String javaPath = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
                                logger.warn("Not a bad, seaching in: {}", jarFile.getAbsolutePath());

                                if (!jarFile.exists()) {
                                    logger.debug("IO, jar not found (devEnv)");
                                    logger.error("IO, jar not found");
                                    return;
                                }

                                ProcessBuilder pb = new ProcessBuilder(javaPath, "-jar", jarFile.getAbsolutePath(), ModData.actItemID.getID());

                                pb.directory(new File("."));
                                pb.redirectErrorStream(true);
                                pb.start();

                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                    if (result.typeOfHit == RayTraceResult.Type.BLOCK) {

                        BlockPos blockPos = result.getBlockPos();
                        IBlockState blockState = mc.world.getBlockState(blockPos);
                        Block block = blockState.getBlock();

                        ResourceLocation resLoc = block.getRegistryName();

                        if (resLoc != null) {
                            ModData.actItemID.SetID("BLOCK:" + resLoc + ":" + block.getMetaFromState(blockState));

                            try {
                                File jarFile = new File("MineWikiEXT.jar").getAbsoluteFile();

                                String javaPath = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
                                logger.warn("Not a bad, seaching in: {}", jarFile.getAbsolutePath());

                                if (!jarFile.exists()) {
                                    logger.debug("IO, jar not found (devEnv)");
                                    logger.error("IO, jar not found");
                                    return;
                                }

                                ProcessBuilder pb = new ProcessBuilder(javaPath, "-jar", jarFile.getAbsolutePath(), ModData.actItemID.getID());

                                pb.directory(new File("."));
                                pb.redirectErrorStream(true);
                                pb.start();

                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }
            }


        }
    }
}
