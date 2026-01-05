package com.mrfrilled.gregitskycore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.mrfrilled.gregitskycore.gregitskycore;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;

public class GregitskyMaterials {

    public static Material LATEX;

    public static void register() {
        LATEX = new Material.Builder(
                gregitskycore.id("latex"))
                .langValue("Latex")
                .dust()
                //.element(GregitskyElements.AD)
                .color(0xebeb93).secondaryColor(0xffffb3)
                //.flags(NO_ORE_SMELTING, NO_SMELTING)
                .iconSet(SAND)
                .buildAndRegister();
    }
    public static void init() {}
}
