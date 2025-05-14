package com.github.pashockerr.flipit.eventhandlers;

import com.github.pashockerr.flipit.AnimationState;
import com.github.pashockerr.flipit.Flipit;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import org.lwjgl.glfw.GLFW;

import static com.github.pashockerr.flipit.eventhandlers.ClientRegisterEventHandler.*;

@EventBusSubscriber(modid = Flipit.MODID)
@OnlyIn(Dist.CLIENT)
public class ClientEventHandler {
    private static final int L_KEY_CODE = flipLKeymap.getKey().getValue();
    private static final int R_KEY_CODE = flipRKeymap.getKey().getValue();
    private static final int LR_KEY_CODE = flipLRKeymap.getKey().getValue();

    @SubscribeEvent
    public static void render(ClientTickEvent.Pre clientTickEvent) {
        AnimationState.lRotation += AnimationState.lAnimationRunning ? AnimationState.ANGULAR_SPEED : 0;
        AnimationState.rRotation += AnimationState.rAnimationRunning ? AnimationState.ANGULAR_SPEED : 0;
    }

    @SubscribeEvent
    public static void keyInput(InputEvent.Key keyInputEvent) {
        if (keyInputEvent.getAction() == GLFW.GLFW_PRESS) {
           var keyCode = keyInputEvent.getKey();

           if(keyCode == L_KEY_CODE)
               AnimationState.startLAnimation();
           if(keyCode == R_KEY_CODE)
               AnimationState.startRAnimation();
           if(keyCode == LR_KEY_CODE)
               AnimationState.startLRAnimation();
        }
    }
}
