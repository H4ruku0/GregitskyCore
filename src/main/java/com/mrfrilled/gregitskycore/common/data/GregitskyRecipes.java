package com.mrfrilled.gregitskycore.common.data;

import com.mrfrilled.gregitskycore.common.data.recipes.*;

import com.mrfrilled.gregitskycore.common.data.recipes.multiblocks.CoagulationTankRecipes;
import com.mrfrilled.gregitskycore.common.data.recipes.multiblocks.GreenhouseRecipes;
import com.mrfrilled.gregitskycore.common.data.recipes.singleblock.LatexCollectorRecipes;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class GregitskyRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        // PRIMITIVE_ORE_MINER_RECIPES.init(provider);
        MiscRecipeLoader.init(provider);
        GreenhouseRecipes.init(provider);
        CoagulationTankRecipes.init(provider);
        LatexCollectorRecipes.init(provider);
        BlocksRecipes.init(provider);

    }
}
