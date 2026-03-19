package net.xdbloo.plentifulIndustries.datagen;

import net.minecraft.server.players.IpBanListEntry;
import net.minecraft.world.item.Item;
import net.xdbloo.plentifulIndustries.PlentifulIndustries;
import net.xdbloo.plentifulIndustries.block.ModBlocks;
import net.xdbloo.plentifulIndustries.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PlentifulIndustries.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.BLOOTONIUM.get());
        basicItem(ModItems.RAW_BLOOTONIUM.get());

        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.KOHLRABI.get());
        basicItem(ModItems.CATALYST.get());

        buttonItem(ModBlocks.BLOOTONIUM_BUTTON, ModBlocks.BLOOTONIUM_BLOCK);
        fenceItem(ModBlocks.BLOOTONIUM_FENCE, ModBlocks.BLOOTONIUM_BLOCK);
        wallItem(ModBlocks.BLOOTONIUM_WALL, ModBlocks.BLOOTONIUM_BLOCK);

        simpleBlockItem(ModBlocks.BLOOTONIUM_DOOR);


        handHeldItem(ModItems.BLOOTONIUM_SWORD);
        handHeldItem(ModItems.BLOOTONIUM_PICKAXE);
        handHeldItem(ModItems.BLOOTONIUM_AXE);
        handHeldItem(ModItems.BLOOTONIUM_SHOVEL);
        handHeldItem(ModItems.BLOOTONIUM_HOE);

    }

    private ItemModelBuilder handHeldItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(PlentifulIndustries.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void buttonItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(PlentifulIndustries.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void fenceItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(PlentifulIndustries.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(PlentifulIndustries.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<? extends Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(PlentifulIndustries.MOD_ID,"item/" + item.getId().getPath()));
    }

}