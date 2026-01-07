package com.mrfrilled.gregitskycore.common.data.materials;

import com.mrfrilled.gregitskycore.gregitskycore;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.data.GTElements;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;

public class GregitskyMaterials {

    public static Material Unknown;
    public static Material Latex;
    public static Material HighPurityCarbon;
    public static Material CobaltMatte;
    public static Material PigIron;

    public static void register() {
        Unknown = new Material.Builder(
                gregitskycore.id("unknown"))
                .langValue("Unknown")
                .element(GregitskyElements.UK)
                .color(0xffffff)
                .buildAndRegister();
        Latex = new Material.Builder(
                gregitskycore.id("latex"))
                .langValue("Latex")
                .dust()
                .fluid()
                .flags(DISABLE_MATERIAL_RECIPES)
                .color(0xebeb93).secondaryColor(0xefef76)
                .iconSet(SAND)
                .buildAndRegister();
        HighPurityCarbon = new Material.Builder(
                gregitskycore.id("high_purity_carbon"))
                .langValue("High Purity Carbon")
                .dust()
                .gem()
                .element(GTElements.C)
                .color(0x121212).secondaryColor(0x404040)
                .iconSet(ROUGH)
                .buildAndRegister();
        CobaltMatte = new Material.Builder(
                gregitskycore.id("cobalt_matte"))
                .langValue("Cobalt Matte")
                .ingot()
                .flags(NO_SMELTING)
                .components(GTMaterials.Cobalt, 1, GregitskyMaterials.Unknown, 1).formula("(Co)(?)")
                .color(0x6c89e0).secondaryColor(0x5778db)
                .iconSet(METALLIC)
                .buildAndRegister();
        PigIron = new Material.Builder(
                gregitskycore.id("pig_iron"))
                .langValue("Pig Iron")
                .ingot()
                .flags(NO_SMELTING)
                .components(GTMaterials.Iron, 1, GregitskyMaterials.Unknown, 1).formula("(Fe)(?)")
                .color(0xcf9696).secondaryColor(0xbf7373)
                .iconSet(METALLIC)
                .buildAndRegister();
    }

    public static void init() {}
}
