/* by Google */
package com.santiagom123.minewiki.debug;

import com.santiagom123.minewiki.utils.ModData;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class MensajeAutomatico {

    private int tickCounter = 0;

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            tickCounter++;

            if (tickCounter >= 200) {
                tickCounter = 0;

                Minecraft mc = Minecraft.getMinecraft();
                if (mc.player != null) {
                    String id = ModData.actItemID.getID();

                    if (id != null && !id.isEmpty()) {
                        mc.player.sendMessage(new TextComponentString(id));
                    }
                }
            }
        }
    }
}
