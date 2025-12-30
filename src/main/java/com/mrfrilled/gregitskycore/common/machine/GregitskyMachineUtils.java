package com.mrfrilled.gregitskycore.common.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties;
import com.gregtechceu.gtceu.api.machine.steam.SimpleSteamMachine;
import com.gregtechceu.gtceu.api.pattern.util.RelativeDirection;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import it.unimi.dsi.fastutil.Pair;

import com.mrfrilled.gregitskycore.common.machine.WeakSimpleSteamMachine;

import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.registerSteamMachines;
import static com.mrfrilled.gregitskycore.common.registry.GregitskyRegistry.REGISTRATE;

public class GregitskyMachineUtils {

        /// STEAM MACHINES ///
    public static Pair<MachineDefinition, MachineDefinition> registerSimpleSteamMachines(String name,
                                                                                         GTRecipeType recipeType) {
        return registerSimpleSteamMachines(REGISTRATE, name, recipeType);
    }

    public static Pair<MachineDefinition, MachineDefinition> registerSimpleSteamMachines(GTRegistrate registrate,
                                                                                         String name,
                                                                                         GTRecipeType recipeType) {
        return registerSteamMachines(registrate, "steam_" + name, WeakSimpleSteamMachine::new,
                (pressure, builder) -> builder
                        .rotationState(RotationState.ALL)
                        .recipeType(recipeType)
                        .recipeModifier(WeakSimpleSteamMachine::recipeModifier)
                        .modelProperty(GTMachineModelProperties.VENT_DIRECTION, RelativeDirection.BACK)
                        .workableSteamHullModel(pressure, GTCEu.id("block/machines/" + name))
                        .register());
    }
    public static void init() {}
}