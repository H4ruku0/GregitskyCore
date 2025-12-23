package com.mrfrilled.gregitskycore.common.data;

import com.mrfrilled.gregitskycore.common.data.recipes.Greenhouse_Recipes;
import net.minecraft.data.recipes.FinishedRecipe;

import com.mrfrilled.gregitskycore.common.data.recipes.MiscRecipeLoader;

import java.util.function.Consumer;

public class GregitskyRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        MiscRecipeLoader.init(provider);
        Greenhouse_Recipes.init(provider);
    }

}
