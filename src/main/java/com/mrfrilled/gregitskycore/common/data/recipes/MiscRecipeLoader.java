package com.mrfrilled.gregitskycore.common.data.recipes;

import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.mrfrilled.gregitskycore.common.machine.GregitskyMachines.*;
import static com.mrfrilled.gregitskycore.common.machine.multiblock.multi.GreenHouse.GREENHOUSE;
import static com.mrfrilled.gregitskycore.common.machine.multiblock.multi.PrimitiveOreMiner.PRIMITIVE_ORE_MINER;
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
        // GreenHouse
        VanillaRecipeHelper.addShapedRecipe(provider, "greenhouse", GREENHOUSE.asStack(),
                "C", "P", "P",
                'C', SAND,
                'P', IRON_INGOT);

        // PrimitiveOreMiner
        VanillaRecipeHelper.addShapedRecipe(provider, "primitive_ore_miner", PRIMITIVE_ORE_MINER.asStack(),
                "C", "P", "P",
                'C', SAND,
                'P', IRON_INGOT);

        /// SINGLEBLOCK ///
        // VanillaRecipeHelper.addShapedRecipe(provider, true, "steam_extractor_bronze",
        // STEAM_EXTRACTOR_TESTING.left().asStack(), "XXX", "PMG", "XXX",
        // 'M', GTBlocks.BRONZE_HULL.asStack(),
        // 'X', new MaterialEntry(TagPrefix.pipeSmallFluid, GTMaterials.Bronze), 'P', CustomTags.PISTONS,
        // 'G', new ItemStack(Blocks.GLASS));
        // ASSEMBLER_RECIPES.recipeBuilder("battery_hull_lv")
        // .inputItems(cableGtSingle, Tin)
        // .inputItems(plate, BatteryAlloy)
        // .inputFluids(Polyethylene.getFluid(L))
        // .outputItems(BATTERY_HULL_LV)
        // .duration(400).EUt(1).save(provider);
    }
}
