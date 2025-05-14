package com.github.pashockerr.flipit;

import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

@Mod(value = Flipit.MODID, dist = Dist.CLIENT)
public class Flipit {
    public static final String MODID = "flipit";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Flipit(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }
}
