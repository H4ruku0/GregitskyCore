package com.mrfrilled.gregitskycore.common.data.recipes;

import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.mrfrilled.gregitskycore.common.data.block.GregitskyBlocks.*;

public class BlocksRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        GregitskyCasings(provider);
    }

    private static void GregitskyCasings(Consumer<FinishedRecipe> provider) {
        VanillaRecipeHelper.addShapedRecipe(provider, "reinforced_treated_wood_casing",
                REINFORCED_TREATED_WOOD_CASING.asStack(),
                "AEA", "CBD", "AEA",
                'A', GTBlocks.TREATED_WOOD_PLANK,
                'B', new MaterialEntry(TagPrefix.frameGt, GTMaterials.TreatedWood),
                'C', CustomTags.SAWS,
                'D', CustomTags.HAMMERS,
                'E', new MaterialEntry(TagPrefix.bolt, GTMaterials.Steel));
    }
}
