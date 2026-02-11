package com.santiagom123.minewiki.proxy;

import com.santiagom123.minewiki.handler.HandlerGetID;
import com.santiagom123.minewiki.debug.MensajeAutomatico;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class ClientProxy extends CommonProxy {
    public static KeyBinding keyGetID = new KeyBinding("key.auto_search", Keyboard.KEY_X, "key.categories.minewiki");

    @Override
    public void init() {
        ClientRegistry.registerKeyBinding(keyGetID);

        net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(new HandlerGetID());

        net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(new MensajeAutomatico());

    }
}

