package com.mrfrilled.gregitskycore.common.data.recipes.singleblock;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class RandomRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        GregitskyMixerRecipes(provider);
    }

    private static void GregitskyMixerRecipes(Consumer<FinishedRecipe> provider) {}
}
