package com.remodstudios.flabyss;

import com.remodstudios.flabyss.blocks.BlockRegistry;
import com.remodstudios.flabyss.items.ItemRegistry;
import com.swordglowsblue.artifice.api.Artifice;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class FlaringAbyssMain implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "flabyss";
    public static final String MOD_NAME = "Flaring Abyss";

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        //TODO: Initializer
        Artifice.registerDataPack(id("artifice_rp"), pack -> {
            ItemRegistry.INSTANCE.generateData(pack);
            BlockRegistry.INSTANCE.generateData(pack);

            try {
                pack.dumpResources("artifice.dbg", "data");
            } catch (IOException ioe) {
                LOGGER.error("BRUH! Artifice failed to dump!");
                ioe.printStackTrace();
            }
        });
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}