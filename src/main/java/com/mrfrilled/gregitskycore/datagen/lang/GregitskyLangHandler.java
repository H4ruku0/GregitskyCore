package com.mrfrilled.gregitskycore.datagen.lang;

import com.tterrag.registrate.providers.RegistrateLangProvider;

import static com.gregtechceu.gtceu.data.lang.LangHandler.replace;

public class GregitskyLangHandler {

    public static void init(RegistrateLangProvider provider) {
        /// Recipe types & Categories ///
        // replace(provider, "gtceu.", "");
        replace(provider, "gtceu.reaction_furnace", "Reaction Furnace");
        replace(provider, "gtceu.vacuum_chamber", "Vacuum Chamber");
        replace(provider, "gtceu.steam_vacuum_chamber", "Vacuum Chamber");
        replace(provider, "gtceu.latex_collector", "Latex Collector");
        replace(provider, "gtceu.vulcanizer", "Vulcanizer");
        replace(provider, "gtceu.primitive_ore_miner", "Primitive Ore Miner");
        replace(provider, "gtceu.greenhouse", "Greenhouse");
        replace(provider, "gtceu.coagulation_tank", "Coagulation Tank");

        /// Tooltip ///
        // provider.add("", "");
        // replace(provider, "", "");
        replace(provider, "gregitsky.machine.tooltip.hold_ctrl", "§8Hold §7[§fCtrlt§7] §8for details");
        // ELECTRIC GREENHOUSE
        replace(provider, "gregitsky.machine.electric.greenhouse_tooltip.0",
                "§7This multiblock is capable of creating the perfect environment for growing plants all year round");
        replace(provider, "gregitsky.machine.electric.greenhouse_tooltip.1", "");
        // PRIMITIVE GREENHOUSE
        replace(provider, "gregitsky.machine.primitive.greenhouse_tooltip.0",
                "§7This multiblock can create a near-perfect growing environment");
        // COAGULATION TANK
        replace(provider, "gregitsky.machine.coagulation_tank_tooltip.0",
                "§7The sealed objects inside will coagulate, solidifying and creating new components");
        // STEAM ALLOY SMELTER
        replace(provider, "gregitsky.machine.steam_alloy_smelter.tooltip.0",
                "§7Also not to be confused with the Multi-Smelter");
        // STEAM SEPARATOR
        replace(provider, "gregitsky.machine.steam_separator.tooltip.0",
                "§7Perfect for getting the most out of your dusts");
        replace(provider, "gregitsky.machine.steam_separator.tooltip.1", "With fluid processing");
        // STEAM FORGE HAMMER
        // COVER INFINITE COBBLESTONE
        replace(provider, "gregitsky.machine.infinite_cobblestone_cover.tooltip.1", "§7Fills attached containers with§r Cobblestone §7as§r Cover");
        // ITEM PRODUCTION "DARK AQUA"
        replace(provider, "gregitsky.machine.item_production.tooltip.1", "§3Produces: §f%d item/t");

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
