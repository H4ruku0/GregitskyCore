package com.mrfrilled.gregitskycore.common.data;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.widget.SlotWidget;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.RecipeCondition;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import com.gregtechceu.gtceu.common.recipe.condition.AdjacentBlockCondition;
import com.gregtechceu.gtceu.integration.xei.handlers.item.CycleItemStackHandler;

import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;

import net.minecraft.core.HolderSet;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class GregitskyRecipeTypes {

    public static GTRecipeType GREENHOUSE_RECIPES;
    // public static GTRecipeType ANTIPROTONIC_RECIPES;
    public static GTRecipeType PRIMITIVE_ORE_MINER;
    public static GTRecipeType REACTION_FURNACE_RECIPES;
    public static GTRecipeType VULCANIZER_RECIPES;
    public static GTRecipeType LATEX_COLLECTOR_RECIPES;
    public static GTRecipeType STEAM_VACUUM_CHAMBER;
    public static GTRecipeType VACUUM_CHAMBER_RECIPES;
    public static GTRecipeType COAGULATION_TANK_RECIPES;

    public static void init() {
        /// MULTIBLOCK ///

        // ANTIPROTONIC_RECIPES = register("antiprotonic", MULTIBLOCK)
        // .setMaxIOSize(3, 3, 1, 1)
        // .setEUIO(IO.IN)
        // .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
        // .setSound(GTSoundEntries.COOLING);
        GREENHOUSE_RECIPES = register("greenhouse", MULTIBLOCK)
                .setMaxIOSize(4, 6, 2, 2)
                .setEUIO(IO.IN)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.BATH);
        PRIMITIVE_ORE_MINER = register("primitive_ore_miner", MULTIBLOCK)
                .setMaxIOSize(4, 9, 2, 2)
                .setEUIO(IO.IN)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.MINER);
        COAGULATION_TANK_RECIPES = register("coagulation_tank", MULTIBLOCK)
                .setMaxIOSize(2, 2, 2, 2)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.FURNACE);

        /// SINGLE-BLOCK ///

        REACTION_FURNACE_RECIPES = register("reaction_furnace", ELECTRIC)
                .setMaxIOSize(3, 3, 3, 3)
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
                .setUiBuilder((recipe, widgetGroup) -> {

                    List<List<ItemStack>> items = new ArrayList<>();

                    for (RecipeCondition condition : recipe.conditions) {
                        if (condition instanceof AdjacentBlockCondition adjacent) {

                            List<ItemStack> stacks = new ArrayList<>();

                            for (HolderSet<Block> set : adjacent.getBlocks()) {
                                set.forEach(holder -> stacks.add(new ItemStack(holder.value())));
                            }

                            if (!stacks.isEmpty()) {
                                items.add(stacks);
                            }
                        }
                    }

                    if (items.isEmpty()) return;

                    widgetGroup.addWidget(new SlotWidget(
                            new CycleItemStackHandler(items),
                            0,
                            widgetGroup.getSize().width - 52,
                            widgetGroup.getSize().height - 32,
                            false,
                            false));
                })
                .setSound(GTSoundEntries.FURNACE);
        STEAM_VACUUM_CHAMBER = register("steam_vacuum_chamber", ELECTRIC)
                .setMaxIOSize(4, 2, 0, 0)
                .setEUIO(IO.IN)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.COOLING);
        VACUUM_CHAMBER_RECIPES = register("vacuum_chamber", ELECTRIC)
                .setMaxIOSize(4, 2, 2, 0)
                .setEUIO(IO.IN)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
                .setSound(GTSoundEntries.COOLING);
    }
}
