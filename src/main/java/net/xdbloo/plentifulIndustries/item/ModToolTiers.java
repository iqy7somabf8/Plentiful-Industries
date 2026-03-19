package net.xdbloo.plentifulIndustries.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.xdbloo.plentifulIndustries.util.ModTags;

public class ModToolTiers {
    public static final Tier BLOOTONIUM = new ForgeTier(1400, 4, 3f, 20,
            ModTags.Blocks.NEEDS_BLOOTONIUM_TOOL, () -> Ingredient.of(ModItems.BLOOTONIUM.get()),
            ModTags.Blocks.INCORRECT_FOR_BLOOTONIUM_TOOL);

}
