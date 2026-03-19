package net.xdbloo.plentifulIndustries.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.xdbloo.plentifulIndustries.PlentifulIndustries;
import net.xdbloo.plentifulIndustries.block.ModBlocks;
import net.xdbloo.plentifulIndustries.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> BLOOTONIUM_SMELTABLES = List.of(ModItems.RAW_BLOOTONIUM.get(),
                ModBlocks.BLOOTONIUM_ORE.get(), ModBlocks.BLOOTONIUM_DEEPSLATE_ORE.get());


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOOTONIUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.BLOOTONIUM.get())
                .unlockedBy(getHasName(ModItems.BLOOTONIUM.get()), has(ModItems.BLOOTONIUM.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_BLOOTONIUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RAW_BLOOTONIUM.get())
                .unlockedBy(getHasName(ModItems.RAW_BLOOTONIUM.get()), has(ModItems.RAW_BLOOTONIUM.get()))
                .save(pRecipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLOOTONIUM.get(), 9)
                .requires(ModBlocks.BLOOTONIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.BLOOTONIUM_BLOCK.get()), has(ModBlocks.BLOOTONIUM_BLOCK.get()))
                .save(pRecipeOutput, PlentifulIndustries.MOD_ID + ":blootonium_from_blootonium_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_BLOOTONIUM.get(), 9)
                .requires(ModBlocks.RAW_BLOOTONIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_BLOOTONIUM_BLOCK.get()), has(ModBlocks.RAW_BLOOTONIUM_BLOCK.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLOOTONIUM.get(), 32)
                .requires(ModBlocks.CONVERTER_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.CONVERTER_BLOCK.get()), has(ModBlocks.CONVERTER_BLOCK.get()))
                .save(pRecipeOutput, PlentifulIndustries.MOD_ID + ":blootonium_from_converter_block");


        oreSmelting(pRecipeOutput, BLOOTONIUM_SMELTABLES, RecipeCategory.MISC, ModItems.BLOOTONIUM.get(), 0.5f, 200, "blootonium");
        oreBlasting(pRecipeOutput, BLOOTONIUM_SMELTABLES, RecipeCategory.MISC, ModItems.BLOOTONIUM.get(), 0.5f, 100, "blootonium");

        stairBuilder(ModBlocks.BLOOTONIUM_STAIRS.get(), Ingredient.of(ModItems.BLOOTONIUM.get())).group("blootonium")
                        .unlockedBy(getHasName(ModItems.BLOOTONIUM.get()), has(ModItems.BLOOTONIUM.get())).save(pRecipeOutput);

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLOOTONIUM_SLAB.get(), ModItems.BLOOTONIUM.get());

        buttonBuilder(ModBlocks.BLOOTONIUM_BUTTON.get(), Ingredient.of(ModItems.BLOOTONIUM.get())).group("blootonium")
                .unlockedBy(getHasName(ModItems.BLOOTONIUM.get()), has(ModItems.BLOOTONIUM.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.BLOOTONIUM_PRESSURE_PLATE.get(), ModItems.BLOOTONIUM.get());

        fenceBuilder(ModBlocks.BLOOTONIUM_FENCE.get(), Ingredient.of(ModItems.BLOOTONIUM.get())).group("blootonium")
                .unlockedBy(getHasName(ModItems.BLOOTONIUM.get()), has(ModItems.BLOOTONIUM.get())).save(pRecipeOutput);

        fenceGateBuilder(ModBlocks.BLOOTONIUM_FENCE_GATE.get(), Ingredient.of(ModItems.BLOOTONIUM.get())).group("blootonium")
                .unlockedBy(getHasName(ModItems.BLOOTONIUM.get()), has(ModItems.BLOOTONIUM.get())).save(pRecipeOutput);

        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLOOTONIUM_WALL.get(), ModItems.BLOOTONIUM.get());

        doorBuilder(ModBlocks.BLOOTONIUM_DOOR.get(), Ingredient.of(ModItems.BLOOTONIUM.get())).group("blootonium")
                .unlockedBy(getHasName(ModItems.BLOOTONIUM.get()), has(ModItems.BLOOTONIUM.get())).save(pRecipeOutput);

        trapdoorBuilder(ModBlocks.BLOOTONIUM_TRAPDOOR.get(), Ingredient.of(ModItems.BLOOTONIUM.get())).group("blootonium")
                .unlockedBy(getHasName(ModItems.BLOOTONIUM.get()), has(ModItems.BLOOTONIUM.get())).save(pRecipeOutput);

    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, PlentifulIndustries.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }


}
