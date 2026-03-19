package net.xdbloo.plentifulIndustries.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.animal.horse.SkeletonHorse;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.xdbloo.plentifulIndustries.PlentifulIndustries;
import net.xdbloo.plentifulIndustries.item.custom.ChiselItem;
import net.xdbloo.plentifulIndustries.item.custom.FuelItem;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PlentifulIndustries.MOD_ID);

    public static final RegistryObject<Item> BLOOTONIUM = ITEMS.register("blootonium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_BLOOTONIUM = ITEMS.register("raw_blootonium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));

    public static final RegistryObject<Item> KOHLRABI = ITEMS.register("kohlrabi",
            () -> new Item(new Item.Properties().food(ModFoodProperties.KOHLRABI)) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.plentifulindustries.kohlrabi"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static final RegistryObject<Item> CATALYST = ITEMS.register("catalyst",
            () -> new FuelItem(new Item.Properties(), 1200));

    public static final RegistryObject<Item> BLOOTONIUM_SWORD = ITEMS.register("blootonium_sword",
            () -> new SwordItem(ModToolTiers.BLOOTONIUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.BLOOTONIUM, 3, -2.4f))));

    public static final RegistryObject<Item> BLOOTONIUM_PICKAXE = ITEMS.register("blootonium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.BLOOTONIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.BLOOTONIUM, 1, -2.8f))));

    public static final RegistryObject<Item> BLOOTONIUM_AXE = ITEMS.register("blootonium_axe",
            () -> new AxeItem(ModToolTiers.BLOOTONIUM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.BLOOTONIUM, 6, -3.2f))));

    public static final RegistryObject<Item> BLOOTONIUM_SHOVEL = ITEMS.register("blootonium_shovel",
            () -> new ShovelItem(ModToolTiers.BLOOTONIUM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.BLOOTONIUM, 1.5f, -3.0f))));

    public static final RegistryObject<Item> BLOOTONIUM_HOE = ITEMS.register("blootonium_hoe",
            () -> new HoeItem(ModToolTiers.BLOOTONIUM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.BLOOTONIUM, 0, -3.0f))));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
