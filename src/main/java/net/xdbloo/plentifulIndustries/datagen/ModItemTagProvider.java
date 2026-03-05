package net.xdbloo.plentifulIndustries.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.xdbloo.plentifulIndustries.PlentifulIndustries;
import net.xdbloo.plentifulIndustries.item.ModItems;
import net.xdbloo.plentifulIndustries.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> providerCompletableFuture, CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, providerCompletableFuture, lookupCompletableFuture, PlentifulIndustries.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.BLOOTONIUM.get())
                .add(ModItems.RAW_BLOOTONIUM.get())
                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.COMPASS);
    }
}
