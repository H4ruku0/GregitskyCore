package com.mrfrilled.gregitskycore.common.data;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;

import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class GregitskyRecipeTypes {

    public static GTRecipeType GREENHOUSE_RECIPES;
    // public static GTRecipeType ANTIPROTONIC_RECIPES;
    public static GTRecipeType PRIMITIVE_ORE_MINER;
    public static GTRecipeType REACTION_FURNACE_RECIPES;
    public static GTRecipeType VULCANIZER_RECIPES;
    public static GTRecipeType LATEX_COLLECTOR_RECIPES;
    public static GTRecipeType STEAM_VACCUM_CHAMBER;
    public static GTRecipeType VACCUM_CHAMBER_RECIPES;

    public static void init() {
        /// MULTIBLOCK ///

        GREENHOUSE_RECIPES = register("greenhouse", MULTIBLOCK)
                .setMaxIOSize(3, 4, 1, 0)
                .setEUIO(IO.IN)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.BATH);
        // ANTIPROTONIC_RECIPES = register("antiprotonic", MULTIBLOCK)
        // .setMaxIOSize(3, 3, 1, 1)
        // .setEUIO(IO.IN)
        // .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
        // .setSound(GTSoundEntries.COOLING);

        PRIMITIVE_ORE_MINER = register("primitive_ore_miner", MULTIBLOCK)
                .setMaxIOSize(6, 9, 3, 3)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.BATH);

        /// SINGLE-BLOCK ///

        REACTION_FURNACE_RECIPES = register("reaction_furnace", ELECTRIC)
                .setMaxIOSize(3, 2, 2, 3)
                .setEUIO(IO.IN)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.CHEMICAL);
        VULCANIZER_RECIPES = register("vulcanizer", ELECTRIC)
                .setMaxIOSize(4, 2, 0, 0)
                .setEUIO(IO.IN)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.FURNACE);
        LATEX_COLLECTOR_RECIPES = register("latex_collector", ELECTRIC)
                .setMaxIOSize(0, 2, 1, 2)
                .setEUIO(IO.IN)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.FURNACE);
        STEAM_VACCUM_CHAMBER = register("steam_vaccum_chamber", ELECTRIC)
                .setMaxIOSize(4, 2, 0, 0)
                .setEUIO(IO.IN)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.COOLING);
        VACCUM_CHAMBER_RECIPES = register("vaccum_chamber", ELECTRIC)
                .setMaxIOSize(4, 2, 2, 0)
                .setEUIO(IO.IN)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.COOLING);
    }
}
