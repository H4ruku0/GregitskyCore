package com.mrfrilled.gregitskycore.common.data.recipes.multiblocks;

import com.mrfrilled.gregitskycore.common.data.materials.GregitskyMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.mrfrilled.gregitskycore.common.data.GregitskyRecipeTypes.COAGULATION_TANK_RECIPES;

public class CoagulationTankRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        CoagulationProcess(provider);
    }

    private static void CoagulationProcess(Consumer<FinishedRecipe> provider) {
        COAGULATION_TANK_RECIPES.recipeBuilder("coagulating_latex_with_sulfuric_acid")
                .inputFluids(SulfuricAcid.getFluid(125))
                .inputFluids(GregitskyMaterials.Latex.getFluid(1000))
                .outputItems(TagPrefix.dust, GregitskyMaterials.Latex, 1)
                .duration(20 * 4).save(provider);
        COAGULATION_TANK_RECIPES.recipeBuilder("coagulating_latex_with_acetic_acid")
                .inputFluids(AceticAcid.getFluid(250))
                .inputFluids(GregitskyMaterials.Latex.getFluid(1000))
                .outputItems(TagPrefix.dust, GregitskyMaterials.Latex, 1)
                .duration(20 * 2).save(provider);
        COAGULATION_TANK_RECIPES.recipeBuilder("coagulating_latex_with_fe")
                .notConsumable(TagPrefix.rod, Iron, 1)
                .inputFluids(GregitskyMaterials.Latex.getFluid(1000))
                .outputItems(TagPrefix.dust, GregitskyMaterials.Latex, 1)
                .duration(20 * 8).save(provider);
        COAGULATION_TANK_RECIPES.recipeBuilder("coagulating_latex_with_ch")
                .notConsumable(TagPrefix.dust, CalciumChloride, 2)
                .inputFluids(GregitskyMaterials.Latex.getFluid(1000))
                .outputItems(TagPrefix.dust, GregitskyMaterials.Latex, 1)
                .duration(20 * 8).save(provider);
    }
}
