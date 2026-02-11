package com.santiagom123.minewiki.handler;

import com.santiagom123.minewiki.proxy.ClientProxy;
import com.santiagom123.minewiki.utils.ModData;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

import java.io.File;
import java.io.IOException;

public class HandlerGetID {


    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger("MineWiki");


    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onKeyInGui(GuiScreenEvent.KeyboardInputEvent.Pre event) {

        if (Keyboard.getEventKeyState() && Keyboard.getEventKey() == ClientProxy.keyGetID.getKeyCode()) {

            if (event.getGui() instanceof GuiContainer) {
                GuiContainer gui = (GuiContainer) event.getGui();

                Slot slot = gui.getSlotUnderMouse();

                if (slot != null && slot.getHasStack()) {

                    ResourceLocation itemLoc = slot.getStack().getItem().getRegistryName();

                    if (itemLoc != null) {
                        int meta = slot.getStack().getMetadata();

                        ModData.actItemID.SetID("ITEM:" + itemLoc + ":" + meta);

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

