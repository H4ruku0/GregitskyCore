package com.mrfrilled.gregitskycore.common.data.recipes;

import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

import static com.mrfrilled.gregitskycore.common.machine.GregitskyMachines.*;
import static com.mrfrilled.gregitskycore.common.machine.GregitskyMultiMachines.*;
import static net.minecraft.world.item.Items.*;

public class MiscRecipeLoader {

    public static void init(Consumer<FinishedRecipe> provider) {
        GTMultiMachines_Recipes(provider);

        // if (GTCEu.Mods.isAE2Loaded()) {
        // createAE2Recipes(provider);
        // }
    }

    private static void GTMultiMachines_Recipes(Consumer<FinishedRecipe> provider) {
        /// CONTROLLERS ///
        // ELECTRIC GREENHOUSE
        VanillaRecipeHelper.addShapedRecipe(provider, "greenhouse", GREENHOUSE.asStack(),
                "BCB", "BCB", "DAD",
                'A', GTBlocks.CASING_STEEL_SOLID,
                'B', GTBlocks.CASING_TEMPERED_GLASS,
                'C', GTItems.ELECTRIC_PUMP_MV,
                'D', CustomTags.MV_CIRCUITS);
        /// PRIMITIVE GREENHOUSE
        VanillaRecipeHelper.addShapedRecipe(provider, "primitive_greenhouse", PRIMITIVE_GREENHOUSE.asStack(),
                "BCB", "BCB", "DAD",
                'A', GTBlocks.CASING_BRONZE_BRICKS,
                'B', Tags.Blocks.GLASS,
                'C', GTItems.ELECTRIC_PUMP_LV,
                'D', CustomTags.LV_CIRCUITS);
        // PRIMITIVE ORE MINER
        VanillaRecipeHelper.addShapedRecipe(provider, "primitive_ore_miner", PRIMITIVE_ORE_MINER.asStack(),
                "BFB", "DED", "CAC",
                'A', GTBlocks.BRONZE_HULL,
                'B', new MaterialEntry(TagPrefix.pipeNormalFluid, GTMaterials.Bronze),
                'C', CustomTags.LV_CIRCUITS,
                'D', new MaterialEntry(TagPrefix.frameGt, GTMaterials.Bronze),
                'E', new MaterialEntry(TagPrefix.pipeLargeItem, GTMaterials.Tin),
                'F', GTItems.ELECTRIC_PUMP_LV);

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
}
