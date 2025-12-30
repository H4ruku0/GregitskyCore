package com.mrfrilled.gregitskycore.common.data;

import com.mrfrilled.gregitskycore.common.data.recipes.*;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class GregitskyRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        MiscRecipeLoader.init(provider);
        GREENHOUSE_RECIPES.init(provider);
        //PRIMITIVE_ORE_MINER_RECIPES.init(provider);
    }
}
