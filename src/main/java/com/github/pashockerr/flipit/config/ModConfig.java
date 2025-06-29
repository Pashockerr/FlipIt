package com.github.pashockerr.flipit.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ModConfig {
    public static final ModConfig CONFIG;
    public static final ModConfigSpec CONFIG_SPEC;

    public final ModConfigSpec.IntValue ROTATIONS;
    public final ModConfigSpec.IntValue ROTATION_TICKS;

    private ModConfig(ModConfigSpec.Builder builder){
        ROTATIONS = builder.defineInRange("rotations", 1, 1, 1000);
        ROTATION_TICKS = builder.defineInRange("rotation_ticks", 12, 1, 1000);
    }

    static{
        Pair<ModConfig, ModConfigSpec> pair =
                new ModConfigSpec.Builder().configure(ModConfig::new);

        CONFIG = pair.getLeft();
        CONFIG_SPEC = pair.getRight();
    }
}
