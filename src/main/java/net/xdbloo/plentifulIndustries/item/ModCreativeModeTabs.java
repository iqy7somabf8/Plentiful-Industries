package net.xdbloo.plentifulIndustries.item;


import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.xdbloo.plentifulIndustries.PlentifulIndustries;
import net.xdbloo.plentifulIndustries.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PlentifulIndustries.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BLOOTONIUM_ITEMS_TAB = CREATIVE_MODE_TABS.register("blootonium_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BLOOTONIUM.get()))
                    .title(Component.translatable("creativetab.plentifulindustries.blootonium_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                      output.accept(ModItems.BLOOTONIUM.get());
                      output.accept(ModItems.RAW_BLOOTONIUM.get());

                      output.accept(ModItems.CHISEL.get());

                      output.accept(ModItems.KOHLRABI.get());
                      output.accept(ModItems.CATALYST.get());

                      output.accept(ModItems.BLOOTONIUM_SWORD.get());
                      output.accept(ModItems.BLOOTONIUM_PICKAXE.get());
                      output.accept(ModItems.BLOOTONIUM_SHOVEL.get());
                      output.accept(ModItems.BLOOTONIUM_AXE.get());
                      output.accept(ModItems.BLOOTONIUM_HOE.get());

                    }).build());
    public static final RegistryObject<CreativeModeTab> BLOOTONIUM_BLOCKS_TAB = CREATIVE_MODE_TABS.register("blootonium_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BLOOTONIUM_BLOCK.get()))
                    .withTabsBefore(BLOOTONIUM_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.plentifulindustries.blootonium_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                      output.accept(ModBlocks.BLOOTONIUM_BLOCK.get());
                      output.accept(ModBlocks.RAW_BLOOTONIUM_BLOCK.get());

                      output.accept(ModBlocks.BLOOTONIUM_ORE.get());
                      output.accept(ModBlocks.BLOOTONIUM_DEEPSLATE_ORE.get());

                      output.accept(ModBlocks.CONVERTER_BLOCK.get());

                      output.accept(ModBlocks.BLOOTONIUM_STAIRS.get());
                      output.accept(ModBlocks.BLOOTONIUM_SLAB.get());

                      output.accept(ModBlocks.BLOOTONIUM_PRESSURE_PLATE.get());
                      output.accept(ModBlocks.BLOOTONIUM_BUTTON.get());

                      output.accept(ModBlocks.BLOOTONIUM_WALL.get());
                      output.accept(ModBlocks.BLOOTONIUM_FENCE.get());
                      output.accept(ModBlocks.BLOOTONIUM_FENCE_GATE.get());


                      output.accept(ModBlocks.BLOOTONIUM_DOOR.get());
                      output.accept(ModBlocks.BLOOTONIUM_TRAPDOOR.get());

                      output.accept(ModBlocks.BLOOTONIUM_LAMP.get());


                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register((eventBus));
    }

}
