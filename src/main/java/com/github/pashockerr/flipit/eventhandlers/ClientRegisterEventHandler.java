package com.github.pashockerr.flipit.eventhandlers;

import com.github.pashockerr.flipit.Flipit;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(modid = Flipit.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ClientRegisterEventHandler {
    public static final KeyMapping flipLKeymap = new KeyMapping(
            "key.flipit.flip_l",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_K,
            "key.categories.misc"
    );
    public static final KeyMapping flipRKeymap = new KeyMapping(
            "key.flipit.flip_r",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_R,
            "key.categories.misc"
    );
    public static final KeyMapping flipLRKeymap = new KeyMapping(
            "key.flipit.flip_lr",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_B,
            "key.categories.misc"
    );


    @SubscribeEvent
    public static void registerKeyBindings(RegisterKeyMappingsEvent registerKeyMappingsEvent) {
        registerKeyMappingsEvent.register(flipLKeymap);
        registerKeyMappingsEvent.register(flipRKeymap);
        registerKeyMappingsEvent.register(flipLRKeymap);
    }
}
