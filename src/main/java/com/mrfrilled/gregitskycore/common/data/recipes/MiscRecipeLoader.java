package com.mrfrilled.gregitskycore.common.data.recipes;

import com.mrfrilled.gregitskycore.common.data.block.GregitskyBlocks;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static com.mrfrilled.gregitskycore.common.data.GregitskyItems.*;
import static com.mrfrilled.gregitskycore.common.data.machines.GregitskyMultiMachines.*;

public class MiscRecipeLoader {

    public static void init(Consumer<FinishedRecipe> provider) {
        GregitskyMultiMachinesRecipes(provider);
        // GregitskyMachinesRecipes(provider);
        GregitskyCoversRecipes(provider);

        // if (GTCEu.Mods.isAE2Loaded()) {
        // createAE2Recipes(provider);
        // }
    }

    private static void GregitskyMultiMachinesRecipes(Consumer<FinishedRecipe> provider) {
        /// ELECTRIC GREENHOUSE
        VanillaRecipeHelper.addShapedRecipe(provider, "greenhouse", GREENHOUSE.asStack(),
                "BCB", "BCB", "DAD",
                'A', GTBlocks.CASING_STEEL_SOLID,
                'B', GTBlocks.CASING_TEMPERED_GLASS,
                'C', GTItems.ELECTRIC_PUMP_HV,
                'D', CustomTags.HV_CIRCUITS);
        /// PRIMITIVE GREENHOUSE
        VanillaRecipeHelper.addShapedRecipe(provider, "primitive_greenhouse", PRIMITIVE_GREENHOUSE.asStack(),
                "BCB", "BCB", "DAD",
                'A', GTBlocks.CASING_BRONZE_BRICKS,
                'B', Tags.Blocks.GLASS,
                'C', GTItems.ELECTRIC_PUMP_LV,
                'D', CustomTags.LV_CIRCUITS);
        /// STEAM ALLOY SMELTER
        VanillaRecipeHelper.addShapedRecipe(provider, "steam_separator", STEAM_CENTRIFUGE.asStack(),
                "PGP", "PTP", "PGP",
                'P', GTBlocks.CASING_BRONZE_BRICKS,
                'G', new MaterialEntry(gear, Steel),
                'T', new MaterialEntry(rotor, GTMaterials.Tin));
        /// STEAM SEPARATOR
        VanillaRecipeHelper.addShapedRecipe(provider, "steam_alloy_smelter", STEAM_ALLOY_SMELTER.asStack(),
                "PGP", "PTP", "PGP",
                'P', GTBlocks.CASING_BRONZE_BRICKS,
                'G', new MaterialEntry(gear, Bronze),
                'T', GTMachines.ALLOY_SMELTER[GTValues.LV]);
        /// COAGULATION TANK
        VanillaRecipeHelper.addShapedRecipe(provider, "coagulation_tank", COAGULATION_TANK.asStack(),
                "ADA", "EBC", "AFA",
                'A', GregitskyBlocks.REINFORCED_TREATED_WOOD_CASING,
                'B', new MaterialEntry(TagPrefix.pipeLargeFluid, GTMaterials.TreatedWood),
                'C', CustomTags.HAMMERS,
                'D', new MaterialEntry(rotor, Steel),
                'E', CustomTags.SAWS,
                'F', new MaterialEntry(TagPrefix.bolt, Steel));
    }

    private static void GregitskyMachinesRecipes(Consumer<FinishedRecipe> provider) {
        /// SINGLEBLOCK ///
        // VanillaRecipeHelper.addShapedRecipe(provider, true, "steam_extractor_bronze",
        // STEAM_EXTRACTOR_TESTING.left().asStack(), "XXX", "PMG", "XXX",
        // 'M', GTBlocks.BRONZE_HULL.asStack(),
        // 'X', new MaterialEntry(TagPrefix.pipeSmallFluid, GTMaterials.Bronze),
        // 'P', CustomTags.PISTONS,
        // 'G', new ItemStack(Blocks.GLASS));
        // ASSEMBLER_RECIPES.recipeBuilder("battery_hull_lv")
        // .inputItems(cableGtSingle, Tin)
        // .inputItems(plate, BatteryAlloy)
        // .inputFluids(Polyethylene.getFluid(L))
        // .outputItems(BATTERY_HULL_LV)
        // .duration(400).EUt(1).save(provider);
    }

    private static void GregitskyCoversRecipes(Consumer<FinishedRecipe> provider) {
        ASSEMBLER_RECIPES.recipeBuilder("infinite_cobblestone_cover")
                .inputItems(GTItems.ROBOT_ARM_HV, 2)
                .inputItems(GTMachines.SUPER_CHEST[GTValues.LV])
                .inputItems(CustomTags.HV_CIRCUITS, 6)
                .outputItems(COVER_INFINITE_COBBLESTONE)
                .duration(20*20)
                .EUt(GTValues.VA[GTValues.HV*2]).save(provider);


    }
}
