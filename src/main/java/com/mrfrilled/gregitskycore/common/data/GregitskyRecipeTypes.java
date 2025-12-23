package com.mrfrilled.gregitskycore.common.data;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.MULTIBLOCK;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.register;

public class GregitskyRecipeTypes {

    public static GTRecipeType GREENHOUSE_RECIPES;
    //public static GTRecipeType ANTIPROTONIC_RECIPES;
    public static GTRecipeType PRIMITIVE_ORE_MINER;

    public static void init() {
            GREENHOUSE_RECIPES = register("greenhouse", MULTIBLOCK)
            .setMaxIOSize(3, 3, 1, 1)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.BATH);

            //ANTIPROTONIC_RECIPES = register("antiprotonic", MULTIBLOCK)
            //        .setMaxIOSize(3, 3, 1, 1)
            //        .setEUIO(IO.IN)
            //        .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            //        .setSound(GTSoundEntries.COOLING);
            //
            PRIMITIVE_ORE_MINER = register("primitive_ore_miner", MULTIBLOCK)
                .setMaxIOSize(6, 9, 3, 3)
                //.setEUIO(IO.IN)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.BATH);


    }
}