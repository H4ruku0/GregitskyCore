package com.mrfrilled.gregitskycore.common.data;

import com.mrfrilled.gregitskycore.common.data.recipes.*;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class GregitskyRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        MiscRecipeLoader.init(provider);
        Greenhouse_Recipes.init(provider);
        PrimitiveOreMiner_Recipes.init(provider);
    }
}
