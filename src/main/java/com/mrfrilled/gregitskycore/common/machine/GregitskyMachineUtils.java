package com.mrfrilled.gregitskycore.common.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.SimpleTieredMachine;
import com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties;
import com.gregtechceu.gtceu.api.pattern.util.RelativeDirection;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;
import com.gregtechceu.gtceu.common.data.GTMedicalConditions;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.utils.FormattingUtil;

import it.unimi.dsi.fastutil.Pair;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;

import java.util.Locale;
import java.util.function.BiFunction;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.*;
import static com.gregtechceu.gtceu.utils.FormattingUtil.toEnglishName;
import static com.mrfrilled.gregitskycore.common.registry.GregitskyRegistry.REGISTRATE;

public class GregitskyMachineUtils {

    public static final int[] ALL_TIERS = GTValues.tiersBetween(ULV, GTCEuAPI.isHighTier() ? MAX : UHV);
    public static final int[] ELECTRIC_TIERS = GTValues.tiersBetween(LV, GTCEuAPI.isHighTier() ? OpV : UV);
    public static final int[] LOW_TIERS = GTValues.tiersBetween(LV, EV);
    public static final int[] HIGH_TIERS = GTValues.tiersBetween(IV, GTCEuAPI.isHighTier() ? OpV : UHV);
    public static final int[] MULTI_HATCH_TIERS = GTValues.tiersBetween(EV, GTCEuAPI.isHighTier() ? MAX : UHV);
    public static final int[] DUAL_HATCH_TIERS = GTValues.tiersBetween(LuV, GTCEuAPI.isHighTier() ? MAX : UHV);

    public static MachineDefinition[] registerSimpleMachines(String name, GTRecipeType recipeType,
                                                             Int2IntFunction tankScalingFunction,
                                                             boolean hasPollutionDebuff) {
        return registerSimpleMachines(REGISTRATE, name, recipeType, tankScalingFunction, hasPollutionDebuff);
    }

    public static MachineDefinition[] registerSimpleMachines(GTRegistrate registrate, String name,
                                                             GTRecipeType recipeType,
                                                             Int2IntFunction tankScalingFunction,
                                                             boolean hasPollutionDebuff) {
        return registerSimpleMachines(registrate, name, recipeType, tankScalingFunction, hasPollutionDebuff,
                ELECTRIC_TIERS);
    }

    public static MachineDefinition[] registerSimpleMachines(String name, GTRecipeType recipeType,
                                                             Int2IntFunction tankScalingFunction) {
        return registerSimpleMachines(REGISTRATE, name, recipeType, tankScalingFunction);
    }

    public static MachineDefinition[] registerSimpleMachines(GTRegistrate registrate, String name,
                                                             GTRecipeType recipeType,
                                                             Int2IntFunction tankScalingFunction) {
        return registerSimpleMachines(registrate, name, recipeType, tankScalingFunction, false);
    }

    public static MachineDefinition[] registerSimpleMachines(String name, GTRecipeType recipeType) {
        return registerSimpleMachines(REGISTRATE, name, recipeType);
    }

    public static MachineDefinition[] registerSimpleMachines(GTRegistrate registrate, String name,
                                                             GTRecipeType recipeType) {
        return registerSimpleMachines(registrate, name, recipeType, defaultTankSizeFunction);
    }

    public static MachineDefinition[] registerSimpleMachines(GTRegistrate registrate,
                                                             String name,
                                                             GTRecipeType recipeType,
                                                             Int2IntFunction tankScalingFunction,
                                                             boolean hasPollutionDebuff,
                                                             int... tiers) {
        return registerTieredMachines(registrate, name,
                (holder, tier) -> new SimpleTieredMachine(holder, tier, tankScalingFunction), (tier, builder) -> {
                    if (hasPollutionDebuff) {
                        builder.recipeModifiers(GTRecipeModifiers.ENVIRONMENT_REQUIREMENT
                                                .apply(GTMedicalConditions.CARBON_MONOXIDE_POISONING, 100 * tier),
                                        GTRecipeModifiers.OC_NON_PERFECT)
                                .conditionalTooltip(defaultEnvironmentRequirement(),
                                        ConfigHolder.INSTANCE.gameplay.environmentalHazards);
                    } else {
                        builder.recipeModifier(GTRecipeModifiers.OC_NON_PERFECT);
                    }
                    return builder
                            .langValue("%s %s %s".formatted(VLVH[tier], toEnglishName(name), VLVT[tier]))
                            .editableUI(SimpleTieredMachine.EDITABLE_UI_CREATOR.apply(GTCEu.id(name), recipeType))
                            .rotationState(RotationState.NON_Y_AXIS)
                            .recipeType(recipeType)
                            .workableTieredHullModel(GTCEu.id("block/machines/" + name))
                            .tooltips(workableTiered(tier, GTValues.V[tier], GTValues.V[tier] * 64, recipeType,
                                    tankScalingFunction.applyAsInt(tier), true))
                            .register();
                },
                tiers);
    }

    public static MachineDefinition[] registerTieredMachines(String name,
                                                             BiFunction<IMachineBlockEntity, Integer, MetaMachine> factory,
                                                             BiFunction<Integer, MachineBuilder<MachineDefinition>, MachineDefinition> builder,
                                                             int... tiers) {
        return registerTieredMachines(REGISTRATE, name, factory, builder, tiers);
    }

    public static MachineDefinition[] registerTieredMachines(GTRegistrate registrate,
                                                             String name,
                                                             BiFunction<IMachineBlockEntity, Integer, MetaMachine> factory,
                                                             BiFunction<Integer, MachineBuilder<MachineDefinition>, MachineDefinition> builder,
                                                             int... tiers) {
        MachineDefinition[] definitions = new MachineDefinition[GTValues.TIER_COUNT];
        for (int tier : tiers) {
            var register = registrate
                    .machine(GTValues.VN[tier].toLowerCase(Locale.ROOT) + "_" + name,
                            holder -> factory.apply(holder, tier))
                    .tier(tier);
            definitions[tier] = builder.apply(tier, register);
        }
        return definitions;
    }

    public static Pair<MachineDefinition, MachineDefinition> registerSteamMachines(String name,
                                                                                   BiFunction<IMachineBlockEntity, Boolean, MetaMachine> factory,
                                                                                   BiFunction<Boolean, MachineBuilder<MachineDefinition>, MachineDefinition> builder) {
        return registerSteamMachines(REGISTRATE, name, factory, builder);
    }

    public static Pair<MachineDefinition, MachineDefinition> registerSteamMachines(GTRegistrate registrate, String name,
                                                                                   BiFunction<IMachineBlockEntity, Boolean, MetaMachine> factory,
                                                                                   BiFunction<Boolean, MachineBuilder<MachineDefinition>, MachineDefinition> builder) {
        MachineDefinition lowTier = builder.apply(false,
                registrate.machine("lp_%s".formatted(name), holder -> factory.apply(holder, false))
                        .langValue("Low Pressure " + toEnglishName(name))
                        .tier(0));
        MachineDefinition highTier = builder.apply(true,
                registrate.machine("hp_%s".formatted(name), holder -> factory.apply(holder, true))
                        .langValue("High Pressure " + toEnglishName(name))
                        .tier(1));
        return Pair.of(lowTier, highTier);
    }

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
