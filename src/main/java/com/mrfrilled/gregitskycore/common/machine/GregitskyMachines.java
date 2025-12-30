package com.mrfrilled.gregitskycore.common.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties;
import com.gregtechceu.gtceu.api.pattern.util.RelativeDirection;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.mrfrilled.gregitskycore.common.data.GregitskyRecipeTypes;
import com.mrfrilled.gregitskycore.gregitskycore;
import it.unimi.dsi.fastutil.Pair;

import static com.mrfrilled.gregitskycore.common.machine.GregitskyMachineUtils.registerSimpleSteamMachines;
import static com.mrfrilled.gregitskycore.common.machine.GregitskyMachineUtils.registerSteamMachines;
import static com.mrfrilled.gregitskycore.common.registry.GregitskyRegistry.REGISTRATE;

public class GregitskyMachines {

    static {
        REGISTRATE.creativeModeTab(() -> gregitskycore.GREGITSKY_CREATIVE_TAB);
    }
        /// STEAM MACHINES ///
    public static final Pair<MachineDefinition, MachineDefinition> STEAM_REACTION_FURNACE = registerSimpleSteamMachines(
            "reaction_furnace", GregitskyRecipeTypes.REACTION_FURNACE_RECIPES);
    public static final Pair<MachineDefinition, MachineDefinition> STEAM_VULCANIZER = registerSteamMachines(
            "steam_vulcanizer", WeakSimpleSteamMachine::new, (pressure, builder) -> builder
                    .rotationState(RotationState.NON_Y_AXIS)
                    .recipeType(GregitskyRecipeTypes.VULCANIZER_RECIPES)
                    .recipeModifier(WeakSimpleSteamMachine::recipeModifier)
                    //.addOutputLimit(ItemRecipeCapability.CAP, 1)
                    .modelProperty(GTMachineModelProperties.VENT_DIRECTION, RelativeDirection.BACK)
                    .workableSteamHullModel(pressure, GTCEu.id("block/machines/chemical_reactor"))
                    .register());

    public static void init() {}

}
