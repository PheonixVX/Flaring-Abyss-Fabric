package com.remodstudios.flabyss.client;

import com.remodstudios.flabyss.FlaringAbyssMain;
import com.remodstudios.flabyss.blocks.BlockRegistry;
import com.remodstudios.flabyss.items.ItemRegistry;
import com.swordglowsblue.artifice.api.Artifice;
import net.fabricmc.api.ClientModInitializer;

import java.io.IOException;

public class FlaringAbyssClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Artifice.registerAssetPack(FlaringAbyssMain.id("artifice_rp"), pack -> {
            ItemRegistry.INSTANCE.generateAssets(pack);
            BlockRegistry.INSTANCE.generateAssets(pack);

            try {
                pack.dumpResources("artifice.dbg", "assets");
            } catch (IOException ioe) {
                FlaringAbyssMain.LOGGER.error("BRUH! Artifice failed to dump!");
                ioe.printStackTrace();
            }
        });
    }
}