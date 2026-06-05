package com.betterbread.voxelgt.block;

import com.betterbread.voxelgt.BetterBread;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.Instrument;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;

public class ModBlocks {


    public static final Block BREAD_BLOCK = registerBlock("bread_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).instrument(Instrument.PLING).strength(0.1F,0.1F)));



    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(
                Registries.ITEM,
                new Identifier(BetterBread.MOD_ID, name),
                new BlockItem(block, new Item.Settings())
        );
    }

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(
                Registries.BLOCK,
                new Identifier(BetterBread.MOD_ID, name),
                block
        );
    }
    public static void registerModBlocks(){
        BetterBread.LOGGER.info("Registering ModBlocks for " + BetterBread.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register(entries -> entries.add(BREAD_BLOCK));
    }
}
