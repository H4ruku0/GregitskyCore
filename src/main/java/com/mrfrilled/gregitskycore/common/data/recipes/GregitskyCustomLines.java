package com.mrfrilled.gregitskycore.common.data.recipes;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static com.mrfrilled.gregitskycore.common.data.GregitskyRecipeTypes.*;
import static com.mrfrilled.gregitskycore.common.data.materials.GregitskyMaterials.*;

public class GregitskyCustomLines {
    public static void init(Consumer<FinishedRecipe> provider) {
        AnorthiteLine(provider); // For Aluminium in LV
    }

    private static void AnorthiteLine(Consumer<FinishedRecipe> provider) {
        ///  Anorthite Line for Aluminium in LV ///
        REACTION_FURNACE_RECIPES.recipeBuilder("calcined_clay_in_reaction_furnace")
                .inputItems(TagPrefix.dust, Clay, 9)
                .inputItems(TagPrefix.dust, Limestone, 5)
                .outputItems(TagPrefix.dust, CalcinedClay, 3)
                .outputItems(TagPrefix.dust, Quicklime, 1)
                .outputFluids(Steam.getFluid(6000))
                .outputFluids(CarbonDioxide.getFluid(1000))
                .EUt(GTValues.VA[GTValues.LV])
                .duration(20 * 20).save(provider);
        MIXER_RECIPES.recipeBuilder("anorthite_in_mixer")
                .inputItems(TagPrefix.dust, CalcinedClay, 3)
                .inputItems(TagPrefix.dust, Quicklime, 1)
                .outputItems(TagPrefix.gem, Anorthite, 4)
                .EUt(GTValues.VA[GTValues.LV])
                .duration(20 * 7).save(provider);
        REACTION_FURNACE_RECIPES.recipeBuilder("anorthite_naoh_attack")
                .inputItems(TagPrefix.dust, Anorthite, 4)
                .inputItems(TagPrefix.dust, SodiumHydroxide, 2)
                .outputFluids(SodiumAluminateSolution.getFluid(2000))
                .outputFluids(Water.getFluid(1000))
                .outputItems(TagPrefix.dust, SiliconDioxide, 2)
                .outputItems(TagPrefix.dust, Quicklime, 1)
                .EUt(GTValues.VA[GTValues.LV])
                .duration(20 * 8).save(provider);
        REACTION_FURNACE_RECIPES.recipeBuilder("anorthite_co2_precipitation")
                .inputFluids(SodiumAluminateSolution.getFluid(1000))
                .inputFluids(CarbonDioxide.getFluid(1000))
                .inputFluids(Water.getFluid(3000))
                .outputItems(TagPrefix.dust, SodaAsh, 1)
                .outputItems(TagPrefix.dust, AluminiumHydroxide, 2)
                .EUt(GTValues.VA[GTValues.LV])
                .duration(20 * 30).save(provider);
        PRIMITIVE_BLAST_FURNACE_RECIPES.recipeBuilder("anorthite_calcination_pbf")
                .inputItems(TagPrefix.dust, AluminiumHydroxide, 8)
                .outputItems(TagPrefix.dust, Alumina, 4)
                .duration(20 * 60).save(provider);
        BLAST_RECIPES.recipeBuilder("anorthite_calcination_ebf")
                .inputItems(TagPrefix.dust, AluminiumHydroxide, 8)
                .outputItems(TagPrefix.dust, Alumina, 4)
                .EUt(GTValues.VA[GTValues.LV])
                .duration(20 * 45).save(provider);
        BLAST_RECIPES.recipeBuilder("anorthite_calcination_ebf")
                .inputItems(TagPrefix.dust, Alumina, 1)
                .inputItems(TagPrefix.dust, Carbon, 1)
                .outputItems(TagPrefix.ingot, Aluminium, 2)
                .outputFluids(CarbonTrioxide.getFluid(1000))
                .EUt(GTValues.VA[GTValues.MV])
                .duration(20 * 60).save(provider);
    }
}
