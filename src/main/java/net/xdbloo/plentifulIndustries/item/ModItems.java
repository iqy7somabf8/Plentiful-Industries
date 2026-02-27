package net.xdbloo.plentifulIndustries.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.xdbloo.plentifulIndustries.PlentifulIndustries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PlentifulIndustries.MOD_ID);

    public static final RegistryObject<Item> Blootonium = ITEMS.register("blootonium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Raw_Blootonium = ITEMS.register("raw_blootonium",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
