package com.mrfrilled.gregitskycore.common.machine;

import com.mrfrilled.gregitskycore.common.data.GregitskyRecipeTypes;
import com.mrfrilled.gregitskycore.gregitskycore;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.SimpleTieredMachine;
import com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties;
import com.gregtechceu.gtceu.api.pattern.util.RelativeDirection;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import it.unimi.dsi.fastutil.Pair;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.defaultTankSizeFunction;
import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.workableTiered;
import static com.mrfrilled.gregitskycore.common.machine.GregitskyMachineUtils.*;
import static com.mrfrilled.gregitskycore.common.machine.GregitskyMachineUtils.ALL_TIERS;
import static com.mrfrilled.gregitskycore.common.registry.GregitskyRegistry.REGISTRATE;

public class GregitskyMachines {

    static {
        REGISTRATE.creativeModeTab(() -> gregitskycore.GREGITSKY_CREATIVE_TAB);
    }

    /// ELECTRIC MACHINES

    public static final MachineDefinition[] LATEX_COLLECTOR = registerTieredMachines("latex_collector",
            (holder, tier) -> new SimpleTieredMachine(holder, tier, defaultTankSizeFunction), (tier, builder) -> builder
                    .langValue("%s Latex Collector %s".formatted(VLVH[tier], VLVT[tier]))
                    .editableUI(SimpleTieredMachine.EDITABLE_UI_CREATOR.apply(GTCEu.id("latex_collector"),
                            GregitskyRecipeTypes.LATEX_COLLECTOR_RECIPES))
                    .rotationState(RotationState.NON_Y_AXIS)
                    .recipeType(GregitskyRecipeTypes.LATEX_COLLECTOR_RECIPES)
                    .recipeModifier(GTRecipeModifiers.OC_NON_PERFECT)
                    .workableTieredHullModel(GTCEu.id("block/machines/air_scrubber"))
                    .tooltips(workableTiered(tier, GTValues.V[tier], GTValues.V[tier] * 64,
                            GregitskyRecipeTypes.LATEX_COLLECTOR_RECIPES, defaultTankSizeFunction.applyAsInt(tier),
                            true))
                    .register(),
            LV, MV, HV);
    public static final MachineDefinition[] VULCANIZER = registerTieredMachines("vulcanizer",
            (holder, tier) -> new SimpleTieredMachine(holder, tier, defaultTankSizeFunction), (tier, builder) -> builder
                    .langValue("%s Vulcanizer %s".formatted(VLVH[tier], VLVT[tier]))
                    .editableUI(SimpleTieredMachine.EDITABLE_UI_CREATOR.apply(GTCEu.id("vulcanizer"),
                            GregitskyRecipeTypes.VULCANIZER_RECIPES))
                    .rotationState(RotationState.NON_Y_AXIS)
                    .recipeType(GregitskyRecipeTypes.VULCANIZER_RECIPES)
                    .recipeModifier(GTRecipeModifiers.OC_NON_PERFECT)
                    .workableTieredHullModel(GTCEu.id("block/machines/furnace"))
                    .tooltips(workableTiered(tier, GTValues.V[tier], GTValues.V[tier] * 64,
                            GregitskyRecipeTypes.VULCANIZER_RECIPES, defaultTankSizeFunction.applyAsInt(tier), true))
                    .register(),
            LV, MV, HV);
    public static final MachineDefinition[] REACTION_FURNACE = registerTieredMachines("reaction_furnace",
            (holder, tier) -> new SimpleTieredMachine(holder, tier, defaultTankSizeFunction), (tier, builder) -> builder
                    .langValue("%s Reaction Furnace %s".formatted(VLVH[tier], VLVT[tier]))
                    .editableUI(SimpleTieredMachine.EDITABLE_UI_CREATOR.apply(GTCEu.id("reaction_furnace"),
                            GregitskyRecipeTypes.REACTION_FURNACE_RECIPES))
                    .rotationState(RotationState.NON_Y_AXIS)
                    .recipeType(GregitskyRecipeTypes.REACTION_FURNACE_RECIPES)
                    .recipeModifier(GTRecipeModifiers.OC_NON_PERFECT)
                    .workableTieredHullModel(GTCEu.id("block/machines/chemical_reactor"))
                    .tooltips(workableTiered(tier, GTValues.V[tier], GTValues.V[tier] * 64,
                            GregitskyRecipeTypes.REACTION_FURNACE_RECIPES, defaultTankSizeFunction.applyAsInt(tier),
                            true))
                    .register(),
            ELECTRIC_TIERS);
    public static final MachineDefinition[] VACCUM_CHAMBER = registerTieredMachines("vaccum_chamber",
            (holder, tier) -> new SimpleTieredMachine(holder, tier, defaultTankSizeFunction), (tier, builder) -> builder
                    .langValue("%s Vaccum Chamber %s".formatted(VLVH[tier], VLVT[tier]))
                    .editableUI(SimpleTieredMachine.EDITABLE_UI_CREATOR.apply(GTCEu.id("vaccum_chamber"),
                            GregitskyRecipeTypes.VACCUM_CHAMBER_RECIPES))
                    .rotationState(RotationState.NON_Y_AXIS)
                    .recipeType(GregitskyRecipeTypes.VACCUM_CHAMBER_RECIPES)
                    .recipeModifier(GTRecipeModifiers.OC_NON_PERFECT)
                    .workableTieredHullModel(GTCEu.id("block/machines/air_scrubber"))
                    .tooltips(workableTiered(tier, GTValues.V[tier], GTValues.V[tier] * 64,
                            GregitskyRecipeTypes.VACCUM_CHAMBER_RECIPES, defaultTankSizeFunction.applyAsInt(tier),
                            true))
                    .register(),
            ELECTRIC_TIERS);

    /// STEAM MACHINES ///

    // public static final Pair<MachineDefinition, MachineDefinition> STEAM_REACTION_FURNACE =
    // registerSimpleSteamMachines(
    // "reaction_furnace", GregitskyRecipeTypes.REACTION_FURNACE_RECIPES);
    public static final Pair<MachineDefinition, MachineDefinition> STEAM_VULCANIZER = registerSteamMachines(
            "steam_vulcanizer", WeakSimpleSteamMachine::new, (pressure, builder) -> builder
                    .rotationState(RotationState.NON_Y_AXIS)
                    .recipeType(GregitskyRecipeTypes.VULCANIZER_RECIPES)
                    .recipeModifier(WeakSimpleSteamMachine::recipeModifier)
                    // .addOutputLimit(ItemRecipeCapability.CAP, 1)
                    .modelProperty(GTMachineModelProperties.VENT_DIRECTION, RelativeDirection.BACK)
                    .workableSteamHullModel(pressure, GTCEu.id("block/machines/furnace"))
                    .register());
    public static final Pair<MachineDefinition, MachineDefinition> STEAM_REACTION_FURNACE = registerSteamMachines(
            "steam_reaction_furnace", WeakSimpleSteamMachine::new, (pressure, builder) -> builder
                    .rotationState(RotationState.NON_Y_AXIS)
                    .recipeType(GregitskyRecipeTypes.REACTION_FURNACE_RECIPES)
                    .recipeModifier(WeakSimpleSteamMachine::recipeModifier)
                    .modelProperty(GTMachineModelProperties.VENT_DIRECTION, RelativeDirection.BACK)
                    .workableSteamHullModel(pressure, GTCEu.id("block/machines/chemical_reactor"))
                    .register());
    public static final Pair<MachineDefinition, MachineDefinition> STEAM_MIXER = registerSteamMachines(
            "steam_mixer", WeakSimpleSteamMachine::new, (pressure, builder) -> builder
                    .rotationState(RotationState.NON_Y_AXIS)
                    .recipeType(GTRecipeTypes.MIXER_RECIPES)
                    .recipeModifier(WeakSimpleSteamMachine::recipeModifier)
                    .modelProperty(GTMachineModelProperties.VENT_DIRECTION, RelativeDirection.BACK)
                    .workableSteamHullModel(pressure, GTCEu.id("block/machines/mixer"))
                    .register());
    public static final Pair<MachineDefinition, MachineDefinition> STEAM_LATEX_COLLECTOR = registerSteamMachines(
            "steam_latex_collector", WeakSimpleSteamMachine::new, (pressure, builder) -> builder
                    .rotationState(RotationState.NON_Y_AXIS)
                    .recipeType(GregitskyRecipeTypes.LATEX_COLLECTOR_RECIPES)
                    .recipeModifier(WeakSimpleSteamMachine::recipeModifier)
                    .modelProperty(GTMachineModelProperties.VENT_DIRECTION, RelativeDirection.BACK)
                    .workableSteamHullModel(pressure, GTCEu.id("block/machines/air_scrubber"))
                    .register());
    public static final Pair<MachineDefinition, MachineDefinition> STEAM_VACCUM_CHAMBER = registerSteamMachines(
            "steam_vaccum_chamber", WeakSimpleSteamMachine::new, (pressure, builder) -> builder
                    .rotationState(RotationState.NON_Y_AXIS)
                    .recipeType(GregitskyRecipeTypes.STEAM_VACCUM_CHAMBER)
                    .recipeModifier(WeakSimpleSteamMachine::recipeModifier)
                    .modelProperty(GTMachineModelProperties.VENT_DIRECTION, RelativeDirection.BACK)
                    .workableSteamHullModel(pressure, GTCEu.id("block/machines/air_scrubber"))
                    .register());

    public static void init() {}
}
