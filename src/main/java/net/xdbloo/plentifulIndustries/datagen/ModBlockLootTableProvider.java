package net.xdbloo.plentifulIndustries.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.xdbloo.plentifulIndustries.block.ModBlocks;
import net.xdbloo.plentifulIndustries.item.ModItems;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.BLOOTONIUM_BLOCK.get());
        dropSelf(ModBlocks.RAW_BLOOTONIUM_BLOCK.get());
        dropSelf(ModBlocks.CONVERTER_BLOCK.get());


        dropSelf(ModBlocks.BLOOTONIUM_STAIRS.get());
        this.add(ModBlocks.BLOOTONIUM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BLOOTONIUM_SLAB.get()));


        dropSelf(ModBlocks.BLOOTONIUM_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.BLOOTONIUM_BUTTON.get());
        dropSelf(ModBlocks.BLOOTONIUM_WALL.get());
        dropSelf(ModBlocks.BLOOTONIUM_FENCE.get());
        dropSelf(ModBlocks.BLOOTONIUM_FENCE_GATE.get());
        dropSelf(ModBlocks.BLOOTONIUM_TRAPDOOR.get());
        dropSelf(ModBlocks.BLOOTONIUM_LAMP.get());


        this.add(ModBlocks.BLOOTONIUM_DOOR.get(),
                block -> createDoorTable(ModBlocks.BLOOTONIUM_DOOR.get()));
        this.add(ModBlocks.BLOOTONIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.BLOOTONIUM_ORE.get(), ModItems.RAW_BLOOTONIUM.get()));
        this.add(ModBlocks.BLOOTONIUM_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.BLOOTONIUM_DEEPSLATE_ORE.get(), ModItems.RAW_BLOOTONIUM.get(), 2,5));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
