package com.betterbread.voxelgt;

import com.betterbread.voxelgt.block.ModBlocks;
import com.betterbread.voxelgt.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterBread implements ModInitializer {
	public static final String MOD_ID = "betterbread";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}