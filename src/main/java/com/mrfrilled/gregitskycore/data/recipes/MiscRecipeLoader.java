package com.mrfrilled.gregitskycore.data.recipes;

import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

import static com.mrfrilled.gregitskycore.common.data.multiblocks.GreenHouse.GREENHOUSE;
import static net.minecraft.world.item.Items.*;

public class MiscRecipeLoader {

    public static void init(Consumer<FinishedRecipe> provider) {
        GTMultiMachines_Recipes(provider);


        //if (GTCEu.Mods.isAE2Loaded()) {
        //    createAE2Recipes(provider);
        //}
    }

    private static void GTMultiMachines_Recipes(Consumer<FinishedRecipe> provider) {

        // LV
        VanillaRecipeHelper.addShapedRecipe(provider, "greenhouse", GREENHOUSE.asStack(),
                "C",
                "P",
                "P",
                'C', SAND,
                'P', IRON_INGOT);

        //ASSEMBLER_RECIPES.recipeBuilder("battery_hull_lv")
        //        .inputItems(cableGtSingle, Tin)
        //        .inputItems(plate, BatteryAlloy)
        //        .inputFluids(Polyethylene.getFluid(L))
        //        .outputItems(BATTERY_HULL_LV)
        //        .duration(400).EUt(1).save(provider);

    }
}