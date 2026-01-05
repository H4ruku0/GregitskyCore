package com.mrfrilled.gregitskycore.datagen.lang;

import com.tterrag.registrate.providers.RegistrateLangProvider;

import static com.gregtechceu.gtceu.data.lang.LangHandler.replace;

public class GregitskyLangHandler {

    public static void init(RegistrateLangProvider provider) {
        /// ///
        /// Recipe types/ Categories ///
        /// ///
        // replace(provider, "gtceu.", "");
        replace(provider, "gtceu.reaction_furnace", "Reaction Furnace");
        replace(provider, "gtceu.vacuum_chamber", "Vacuum Chamber");
        replace(provider, "gtceu.steam_vacuum_chamber", "Vacuum Chamber");
        replace(provider, "gtceu.latex_collector", "Latex Collector");
        replace(provider, "gtceu.vulcanizer", "Vulcanizer");
        replace(provider, "gtceu.primitive_ore_miner", "Primitive Ore Miner");
        replace(provider, "gtceu.greenhouse", "Greenhouse");
        replace(provider, "gtceu.coagulation_tank", "Coagulation Tank");

        /// ///
        /// Tooltip ///
        /// ///
        // provider.add("", "");
        replace(provider, "gregitsky.multiblock.greenhouse_tooltip0",
                "§7This multiblock is capable of creating the perfect environment for growing plants all year round");
        replace(provider, "gregitsky.multiblock.primitive_greenhouse_tooltip0",
                "§7This multiblock can create a near-perfect growing environment");
        replace(provider, "gregitsky.multiblock.coagulation_tank_tooltip0",
                "§7The sealed objects inside will coagulate, solidifying and creating new components");
    }

    protected static void multiLang(RegistrateLangProvider provider, String key, String... values) {
        for (var i = 0; i < values.length; i++) {
            provider.add(getSubKey(key, i), values[i]);
        }
    }

    protected static String getSubKey(String key, int index) {
        return key + "." + index;
    }
}
