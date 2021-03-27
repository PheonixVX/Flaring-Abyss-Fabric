package com.remodstudios.flabyss.items;

import com.remodstudios.flabyss.FlaringAbyssMain;
import com.remodstudios.flabyss.blocks.BlockRegistry;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unused")
// You know... if you renamed the Registry classes, we would not have this problem. Try `RegistryItem` for a change. -PheonixVX
public class ItemRegistry extends com.remodstudios.yarnandneedles.items.ItemRegistry {
    public static final ItemRegistry INSTANCE = new ItemRegistry();
    public static final BlockRegistry BLOCKS = new BlockRegistry();

    private static final ItemGroup GROUP = FabricItemGroupBuilder.build(new Identifier(FlaringAbyssMain.MOD_ID,"group"), () -> new ItemStack(BLOCKS.WILTSLATE));

    // "Items go here" - LePichu
    public final Item SCYTHE = add("scythe", new SwordItem(ToolMaterials.NETHERITE, 8, -2.4F, new Item.Settings().group(GROUP).maxCount(1)));
    public final Item CRYSTAL_METH = add("crystal_meth", new Item(new Item.Settings().food(new FoodComponent.Builder().build()).group(GROUP)));
    public final Item SUCCUBUS_MILK = add("succubus_milk", new Item( new Item.Settings().food(new FoodComponent.Builder().alwaysEdible().snack().hunger(10).saturationModifier(10F).build()).group(GROUP)));
    public final Item STYGIAN_IRON_SWORD = add("stygian_iron_sword", new StygianSword(ToolMaterials.IRON, 4, -2.4F, new Item.Settings().group(GROUP).maxCount(1)));
    public final Item STYGIAN_IRON_AXE = add("stygian_iron_axe", new StygianAxe(ToolMaterials.IRON, 4, -2.4F, new Item.Settings().group(GROUP).maxCount(1)));
    public final Item STYGIAN_IRON_PICKAXE = add("stygian_iron_pickaxe", new StygianPickaxe(ToolMaterials.IRON, 4, -2.4F, new Item.Settings().group(GROUP).maxCount(1)));
    public final Item STYGIAN_IRON_SHOVEL = add("stygian_iron_shovel", new StygianShovel(ToolMaterials.IRON, 4, -2.4F, new Item.Settings().group(GROUP).maxCount(1)));
    public final Item STYGIAN_IRON_HOE = add("stygian_iron_hoe", new StygianHoe(ToolMaterials.IRON, 4, -2.4F, new Item.Settings().group(GROUP).maxCount(1)));

    // "Block Items go blocky @ here" - LePichu, again
    public static final Item WILTSLATE = register(BLOCKS.WILTSLATE, "wiltslate", new Item.Settings().group(GROUP));
    public static final Item WILTSLATE_BRICKS = register(BLOCKS.WILTSLATE_BRICKS, "wiltslate_bricks.json", new Item.Settings().group(GROUP));
    public static final Item BASALT_IRON_ORE = register(BLOCKS.BASALT_IRON_ORE, "basalt_iron_ore", new Item.Settings().group(GROUP));

    public ItemRegistry (String namespace) {
        super(FlaringAbyssMain.MOD_ID);
    }

    public ItemRegistry () {
        super(FlaringAbyssMain.MOD_ID);
    }

    /**
     * This method returns and registers an Item instance.
     *
     * @param item Item is used for settings, and other Item-based things
     * @param name Name is used as as apart of the Identifier/ResourceLocation for registration.
     * @return Returns an instance of Item with pre-configured settings.
     */
    private static Item register(Item item, String name) {
        return Registry.register(Registry.ITEM, new Identifier(FlaringAbyssMain.MOD_ID, name), item);
    }

    /**
     * This method registers BlockItems with pre-configured settings.
     *
     * @param block Block is used to register a BlockItem, according to the Block's settings.
     * @param name Name is used as as apart of the Identifier/ResourceLocation for registration.
     * @param settings Settings are used for configuring the BlockItem, in different ways than a Block would be.
     * @return Returns an Item instance, with pre-configured settings for BlockItems.
     *
     * @see BlockRegistry
     */
    private static Item register(Block block, String name, Item.Settings settings) {
        return register(new BlockItem(block, settings), name);
    }
}