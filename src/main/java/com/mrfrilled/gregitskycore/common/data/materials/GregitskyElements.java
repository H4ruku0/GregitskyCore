package com.mrfrilled.gregitskycore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.registry.GTRegistries;

public class GregitskyElements {

    public static final Element UK = createAndRegister(0, 98, -1, null, "unknown", "?", false);

    public static Element createAndRegister(long protons, long neutrons, long halfLifeSeconds, String decayTo,
                                            String name, String symbol, boolean isIsotope) {
        Element element = new Element(protons, neutrons, halfLifeSeconds, decayTo, name, symbol, isIsotope);
        GTRegistries.ELEMENTS.register(name, element);
        return element;
    }

    public static void init() {}
}
