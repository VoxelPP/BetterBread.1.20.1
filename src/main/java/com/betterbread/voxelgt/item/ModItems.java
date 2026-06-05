package com.betterbread.voxelgt.item;

import com.betterbread.voxelgt.BetterBread;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.minecraft.registry.Registry;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item BREAD = registerItem("bread", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.7F).build())));
    public static final Item TOAST = registerItem("toast", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(7).saturationModifier(0.9F).build())));
    public static final Item BURNED_TOAST = registerItem("burned_toast", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1F).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 2), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 2), 1.0F).build())));

    private static void addItemsToFood_And_DrinksItemGroup(FabricItemGroupEntries entries) {
        entries.add(BREAD);
        entries.add(TOAST);
        entries.add(BURNED_TOAST);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(
                Registries.ITEM,
                new Identifier(BetterBread.MOD_ID, name),
                item
        );
    }

    public static void registerModItems() {
        BetterBread.LOGGER.info("Registering Mod Items for " + BetterBread.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFood_And_DrinksItemGroup);
    }
}