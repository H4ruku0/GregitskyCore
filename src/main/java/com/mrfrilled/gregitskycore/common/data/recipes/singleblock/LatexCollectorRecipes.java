package com.mrfrilled.gregitskycore.common.data.recipes.singleblock;

import com.mrfrilled.gregitskycore.common.data.materials.GregitskyMaterials;

import com.gregtechceu.gtceu.common.data.GTBlocks;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.mrfrilled.gregitskycore.common.data.GregitskyRecipeTypes.LATEX_COLLECTOR_RECIPES;

public class LatexCollectorRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        LatexCollection(provider);
    }

    private static void LatexCollection(Consumer<FinishedRecipe> provider) {
        LATEX_COLLECTOR_RECIPES.recipeBuilder("extracting_latex_with_water")
                .notConsumableFluid(Water.getFluid(25))
                .adjacentBlocks(GTBlocks.RUBBER_LOG.get())
                .outputFluids(GregitskyMaterials.Latex.getFluid(100))
                .duration(20 * 2).EUt(7).save(provider);
        LATEX_COLLECTOR_RECIPES.recipeBuilder("extracting_latex_with_distwater")
                .notConsumableFluid(DistilledWater.getFluid(100))
                .adjacentBlocks(GTBlocks.RUBBER_LOG.get())
                .outputFluids(GregitskyMaterials.Latex.getFluid(125))
                .duration(20 * 2).EUt(7).save(provider);
    }
}
