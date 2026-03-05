package net.xdbloo.plentifulIndustries.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.xdbloo.plentifulIndustries.PlentifulIndustries;
import net.xdbloo.plentifulIndustries.block.ModBlocks;
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
                .add(ModBlocks.RAW_BLOOTONIUM_BLOCK.get())
                .add(ModBlocks.BLOOTONIUM_BLOCK.get())
                .add(ModBlocks.BLOOTONIUM_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.BLOOTONIUM_DEEPSLATE_ORE.get())
                .add(ModBlocks.CONVERTER_BLOCK.get());
    }
}
