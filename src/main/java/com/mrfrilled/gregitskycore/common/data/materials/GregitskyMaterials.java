package com.mrfrilled.gregitskycore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlag;
import com.mrfrilled.gregitskycore.gregitskycore;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;

public class GregitskyMaterials {

    public static Material Latex;


    public static void register() {
        Latex = new Material.Builder(
                gregitskycore.id("latex"))
                .langValue("Latex")
                .dust()
                .fluid()
                .flags(DISABLE_MATERIAL_RECIPES)
                // .element(GregitskyElements.AD)
                .color(0xebeb93).secondaryColor(0xffff4d)
                // .flags(NO_ORE_SMELTING, NO_SMELTING)
                .iconSet(SAND)
                .buildAndRegister();
    }

    public static void init() {}
}
