package com.github.pashockerr.flipit;

public class AnimationState {
    public static float lRotation;
    public static float rRotation;
    public static boolean lAnimationRunning;
    public static boolean rAnimationRunning;
    public static final float ANGULAR_SPEED = 6.28f / 12.0f;    // Radian/tick (12 ticks for 1 rotation)

    public static void startLAnimation(){
        lRotation = 0;
        lAnimationRunning = true;
    }

    public static void startRAnimation(){
        rRotation = 0;
        rAnimationRunning = true;
    }

    public static void startLRAnimation(){
        startLAnimation();
        startRAnimation();
    }
}
