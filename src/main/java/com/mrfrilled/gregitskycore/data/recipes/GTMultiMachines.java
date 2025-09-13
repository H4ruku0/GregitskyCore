package com.mrfrilled.gregitskycore.data.recipes;

import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

import static com.mrfrilled.gregitskycore.common.machine.GreenHouse.GREENHOUSE;

public class GTMultiMachines {
    private static void GTMultiMachines_Recipes(Consumer<FinishedRecipe> provider) {

        // LV
        VanillaRecipeHelper.addShapedRecipe(provider, "greenhouse", GREENHOUSE.asStack(),
                "C",
                "P",
                "P",
                'C', new ItemStack(Blocks.SAND),
                'P', new ItemStack(Items.IRON_INGOT));

        //ASSEMBLER_RECIPES.recipeBuilder("battery_hull_lv")
        //        .inputItems(cableGtSingle, Tin)
        //        .inputItems(plate, BatteryAlloy)
        //        .inputFluids(Polyethylene.getFluid(L))
        //        .outputItems(BATTERY_HULL_LV)
        //        .duration(400).EUt(1).save(provider);

    }
}