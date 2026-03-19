package net.xdbloo.plentifulIndustries.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.xdbloo.plentifulIndustries.PlentifulIndustries;
import net.xdbloo.plentifulIndustries.block.ModBlocks;
import net.xdbloo.plentifulIndustries.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, PlentifulIndustries.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BLOOTONIUM_BLOCK.get())
                .add(ModBlocks.RAW_BLOOTONIUM_BLOCK.get())
                .add(ModBlocks.BLOOTONIUM_ORE.get())
                .add(ModBlocks.BLOOTONIUM_DEEPSLATE_ORE.get())
                .add(ModBlocks.CONVERTER_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BLOOTONIUM_BLOCK.get())
                .add(ModBlocks.BLOOTONIUM_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RAW_BLOOTONIUM_BLOCK.get())
                .add(ModBlocks.BLOOTONIUM_DEEPSLATE_ORE.get())
                .add(ModBlocks.CONVERTER_BLOCK.get());

        tag(BlockTags.FENCES).add(ModBlocks.BLOOTONIUM_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.BLOOTONIUM_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.BLOOTONIUM_WALL.get());

        tag(ModTags.Blocks.NEEDS_BLOOTONIUM_TOOL)
                .add(ModBlocks.RAW_BLOOTONIUM_BLOCK.get())
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_BLOOTONIUM_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_BLOOTONIUM_TOOL);
    }
}
