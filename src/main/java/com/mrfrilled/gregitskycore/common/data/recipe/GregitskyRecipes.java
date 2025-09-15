package com.mrfrilled.gregitskycore.common.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;

import com.mrfrilled.gregitskycore.data.recipes.MiscRecipeLoader;

import java.util.function.Consumer;

public class GregitskyRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        MiscRecipeLoader.init(provider);
    }

}
