package net.galaxygameryt.cultivation_mastery;

import net.fabricmc.api.ClientModInitializer;
import net.galaxygameryt.cultivation_mastery.event.KeyInputHandler;

public class CultivationMasteryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
    }
}
