package com.mrfrilled.gregitskycore.common.machine;

import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.mrfrilled.gregitskycore.gregitskycore;
import it.unimi.dsi.fastutil.Pair;

import static com.mrfrilled.gregitskycore.common.machine.GregitskyMachineUtils.registerSimpleSteamMachines;
import static com.mrfrilled.gregitskycore.common.registry.GregitskyRegistry.REGISTRATE;

public class GregitskyMachines {

    static {
        REGISTRATE.creativeModeTab(() -> gregitskycore.GREGITSKY_CREATIVE_TAB);
    }
        /// STEAM MACHINES ///
    public static final Pair<MachineDefinition, MachineDefinition> STEAM_EXTRACTOR_TESTING = registerSimpleSteamMachines(
            "extractor", GTRecipeTypes.EXTRACTOR_RECIPES);

    public static void init() {}

}
