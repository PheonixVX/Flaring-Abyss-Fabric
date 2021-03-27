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
    public static final Block WILTSLATE = register(new Block(FabricBlockSettings.copyOf(Blocks.STONE)),"wiltslate");
    public static final Block WILTSLATE_BRICKS = register(new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)), "wiltslate_bricks.json");
    public static final Block BASALT_IRON_ORE = register(new Block(FabricBlockSettings.copyOf(Blocks.BASALT)), "basalt_iron_ore");

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