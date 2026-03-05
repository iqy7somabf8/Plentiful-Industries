package net.xdbloo.plentifulIndustries.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.xdbloo.plentifulIndustries.PlentifulIndustries;
import net.xdbloo.plentifulIndustries.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PlentifulIndustries.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blocKWithItem(ModBlocks.BLOOTONIUM_BLOCK);
        blocKWithItem(ModBlocks.RAW_BLOOTONIUM_BLOCK);

        blocKWithItem(ModBlocks.BLOOTONIUM_ORE);
        blocKWithItem(ModBlocks.BLOOTONIUM_DEEPSLATE_ORE);

        blocKWithItem(ModBlocks.CONVERTER_BLOCK);
    }

    private void blocKWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
