package com.mrfrilled.gregitskycore.common.data.recipe;

import com.mrfrilled.gregitskycore.data.recipes.GREENHOUSE_RECIPES;
import net.minecraft.data.recipes.FinishedRecipe;

import com.mrfrilled.gregitskycore.data.recipes.MiscRecipeLoader;

import java.util.function.Consumer;

public class GregitskyRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        MiscRecipeLoader.init(provider);
        GREENHOUSE_RECIPES.init(provider);
    }

}
