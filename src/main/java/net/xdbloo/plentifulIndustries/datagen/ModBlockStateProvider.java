package net.xdbloo.plentifulIndustries.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.xdbloo.plentifulIndustries.PlentifulIndustries;
import net.xdbloo.plentifulIndustries.block.ModBlocks;
import net.xdbloo.plentifulIndustries.block.custom.BlootoniumLampBlock;

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
        pressurePlateBlock(ModBlocks.BLOOTONIUM_PRESSURE_PLATE.get(), blockTexture(ModBlocks.BLOOTONIUM_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.BLOOTONIUM_DOOR.get(), modLoc("block/blootonium_door_bottom"), modLoc("block/blootonium_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.BLOOTONIUM_TRAPDOOR.get(), modLoc("block/blootonium_trapdoor"), true, "cutout");


        blockItem(ModBlocks.BLOOTONIUM_STAIRS);
        blockItem(ModBlocks.BLOOTONIUM_SLAB);
        blockItem(ModBlocks.BLOOTONIUM_PRESSURE_PLATE);
        blockItem(ModBlocks.BLOOTONIUM_FENCE_GATE);
        blockItem(ModBlocks.BLOOTONIUM_TRAPDOOR, "_bottom");

        customLamp();
    }

    public void customLamp(){
        getVariantBuilder(ModBlocks.BLOOTONIUM_LAMP.get()).forAllStates(state -> {
            if(state.getValue(BlootoniumLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("blootonium_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(PlentifulIndustries.MOD_ID, "block/" + "blootonium_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("blootonium_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(PlentifulIndustries.MOD_ID, "block/" + "blootonium_lamp_on")))};
            }
        });
        simpleBlockItem(ModBlocks.BLOOTONIUM_LAMP.get(), models().cubeAll("blootonium_lamp_on",
                ResourceLocation.fromNamespaceAndPath(PlentifulIndustries.MOD_ID, "block/" + "blootonium_lamp_on")));
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
