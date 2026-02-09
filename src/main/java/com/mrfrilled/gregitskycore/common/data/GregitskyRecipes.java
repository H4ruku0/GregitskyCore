package com.mrfrilled.gregitskycore.common.data;

import com.mrfrilled.gregitskycore.common.data.recipes.*;
import com.mrfrilled.gregitskycore.common.data.recipes.multiblocks.*;
import com.mrfrilled.gregitskycore.common.data.recipes.singleblock.*;

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
        MaterialRecipes.init(provider);
        ReactionFurnaceRecipes.init(provider);
        RandomRecipes.init(provider);
        GregitskyCustomLines.init(provider);
    }
}
