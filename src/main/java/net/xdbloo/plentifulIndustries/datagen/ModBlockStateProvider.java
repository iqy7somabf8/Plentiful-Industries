package net.xdbloo.plentifulIndustries.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
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

        stairsBlock(ModBlocks.BLOOTONIUM_STAIRS.get(), blockTexture(ModBlocks.BLOOTONIUM_BLOCK.get()));
        slabBlock(ModBlocks.BLOOTONIUM_SLAB.get(), blockTexture(ModBlocks.BLOOTONIUM_BLOCK.get()), blockTexture(ModBlocks.BLOOTONIUM_BLOCK.get()));

        buttonBlock(ModBlocks.BLOOTONIUM_BUTTON.get(), blockTexture(ModBlocks.BLOOTONIUM_BLOCK.get()));
        fenceBlock(ModBlocks.BLOOTONIUM_FENCE.get(), blockTexture(ModBlocks.BLOOTONIUM_BLOCK.get()));

        fenceGateBlock(ModBlocks.BLOOTONIUM_FENCE_GATE.get(), blockTexture(ModBlocks.BLOOTONIUM_BLOCK.get()));
        wallBlock(ModBlocks.BLOOTONIUM_WALL.get(), blockTexture(ModBlocks.BLOOTONIUM_BLOCK.get()));
        buttonBlock(ModBlocks.BLOOTONIUM_BUTTON.get(), blockTexture(ModBlocks.BLOOTONIUM_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.BLOOTONIUM_DOOR.get(), modLoc("block/blootonium_door_bottom"), modLoc("block/blootonium_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.BLOOTONIUM_TRAPDOOR.get(), modLoc("block/blootonium_trapdoor"), true, "cutout");


        blockItem(ModBlocks.BLOOTONIUM_STAIRS);
        blockItem(ModBlocks.BLOOTONIUM_SLAB);
        blockItem(ModBlocks.BLOOTONIUM_PRESSURE_PLATE);
        blockItem(ModBlocks.BLOOTONIUM_FENCE_GATE);
        blockItem(ModBlocks.BLOOTONIUM_TRAPDOOR, "_bottom");
    }

    private void blocKWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject){
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("plentifulindustries:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("plentifulindustries:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

}
