package com.mrfrilled.gregitskycore.common.data.recipes;

import com.mrfrilled.gregitskycore.common.data.materials.GregitskyMaterials;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraftforge.fluids.FluidStack;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static com.mrfrilled.gregitskycore.common.data.GregitskyRecipeTypes.*;
import static com.mrfrilled.gregitskycore.common.data.materials.GregitskyMaterials.*;

public class MaterialRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        GregitskyMaterialsRecipes(provider);
    }

    private static void GregitskyMaterialsRecipes(Consumer<FinishedRecipe> provider) {
        /// Ferroxium ///
        ALLOY_SMELTER_RECIPES.recipeBuilder("ferroxium_ingot_in_alloy_smelter")
                .inputItems(TagPrefix.ingot, GTMaterials.Steel, 1)
                .inputItems(TagPrefix.dust, GregitskyMaterials.SyntheticCarbonAdditive, 2)
                .outputItems(TagPrefix.ingot, GregitskyMaterials.Ferroxium, 2)
                .EUt(GTValues.VA[GTValues.LV])
                .duration(20 * 16).save(provider);
        MIXER_RECIPES.recipeBuilder("ferroxium_dust_in_mixer")
                .inputItems(TagPrefix.dust, GTMaterials.Steel, 1)
                .inputItems(TagPrefix.dust, GregitskyMaterials.SyntheticCarbonAdditive, 2)
                .outputItems(TagPrefix.dust, GregitskyMaterials.Ferroxium, 2)
                .EUt(GTValues.VA[GTValues.LV])
                .duration(20 * 16).save(provider);
        /// Synthetic Carbon Additive ///
        MIXER_RECIPES.recipeBuilder("synthetic_carbon_additive_in_mixer")
                .inputItems(TagPrefix.dust, Limestone, 1)
                .inputItems(TagPrefix.dust, GTMaterials.Coke, 1)
                .outputItems(TagPrefix.dust, GregitskyMaterials.SyntheticCarbonAdditive, 1)
                .EUt(GTValues.VA[GTValues.LV])
                .duration(20 * 8).save(provider);
    }
}
