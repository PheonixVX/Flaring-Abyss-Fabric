package com.remodstudios.flabyss.blocks;

import com.remodstudios.flabyss.FlaringAbyssMain;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegistry extends com.remodstudios.yarnandneedles.blocks.BlockRegistry {
    public static final BlockRegistry INSTANCE = new BlockRegistry();

    // "cube-things go here" - LePichu
    /// Registry not registery, and blocks - PheonixVX
    public final Block WILTSLATE = add("wiltslate", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public final Block WILTSLATE_BRICKS = add("wiltslate_bricks", new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public final Block BASALT_IRON_ORE = add("basalt_iron_ore", new Block(FabricBlockSettings.copyOf(Blocks.BASALT)));

    /**
     * @param namespace A string instance used to construct the BlockRegistry of Yarn and Needles.
     * @see com.remodstudios.yarnandneedles.blocks.BlockRegistry
     */
    public BlockRegistry (String namespace) {
        super(namespace);
    }

    /**
     * This constructor calls the constructor of Yarn and Needles BlockRegistry with the Flaring Abyss' mod Identifier.
     * @see com.remodstudios.yarnandneedles.blocks.BlockRegistry
     */
    public BlockRegistry () {
        super(FlaringAbyssMain.MOD_ID);
    }

    /***
     * This method returns a Block object according to a pre-configured Block and name.
     *
     * @param block A block instance, with pre-configured Block Settings
     * @param name A string instance, denoting the name used for Identifiers/ResourceLocations.
     */
    private static Block register(Block block, String name) {
        return Registry.register(Registry.BLOCK, new Identifier(FlaringAbyssMain.MOD_ID, name), block);
    }
}