package net.xdbloo.plentifulIndustries.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.xdbloo.plentifulIndustries.PlentifulIndustries;
import net.xdbloo.plentifulIndustries.item.ModItems;

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
    }
}