package com.github.pashockerr.flipit;

import com.github.pashockerr.flipit.config.ModConfig;
import net.neoforged.fml.common.Mod;

public class AnimationState {
    public static int lRotationTime;
    public static int rRotationTime;
    public static boolean lAnimationRunning;
    public static boolean rAnimationRunning;
//    public static final float ANGULAR_SPEED =

    public static void startLAnimation(){
        lRotationTime = 0;
        lAnimationRunning = true;
    }

    public static void startRAnimation(){
        rRotationTime = 0;
        rAnimationRunning = true;
    }

    public static void startLRAnimation(){
        startLAnimation();
        startRAnimation();
    }

    public static float getAngularSpeed(){
        return (float)ModConfig.CONFIG.ROTATIONS.getAsInt() * (6.28f / ((float)ModConfig.CONFIG.ROTATION_TICKS.getAsInt()));
    }

    public static float getLinearSpeed(){
        return 6.28f / (float)ModConfig.CONFIG.ROTATION_TICKS.getAsInt();
    }

    public static int getlRotationTime(){
        return ModConfig.CONFIG.ROTATION_TICKS.getAsInt();
    }
}
