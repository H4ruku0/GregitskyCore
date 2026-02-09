package com.mrfrilled.gregitskycore.common.data.materials;

import com.gregtechceu.gtceu.api.GTValues;
import com.mrfrilled.gregitskycore.gregitskycore;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.data.GTElements;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty.GasTier.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class GregitskyMaterials {

    public static Material Unknown;
    public static Material Latex;
    public static Material HighPurityCarbon;
    public static Material CobaltMatte;
    public static Material PigIron;
    public static Material Limestone;
    public static Material SyntheticCarbonAdditive;
    public static Material Ferroxium;
    public static Material CalcinedClay;
    public static Material Anorthite;
    public static Material SodiumAluminateSolution;
    public static Material AluminiumHydroxide;
    public static Material Alumina;
    public static Material CarbonTrioxide;

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
                .color(0x121212).secondaryColor(0x262626)
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
        Limestone = new Material.Builder(
                gregitskycore.id("limestone"))
                .langValue("Limestone")
                .dust()
                .components(GTMaterials.Calcium, 1, GTMaterials.Carbon, 1, GTMaterials.Oxygen, 3)
                .formula("CaCO3")
                .flags(DISABLE_MATERIAL_RECIPES)
                .color(0xb7ad95).secondaryColor(0xbeb8a8)
                .iconSet(ROUGH)
                .buildAndRegister();
        SyntheticCarbonAdditive = new Material.Builder(
                gregitskycore.id("synthetic_carbon_additive"))
                .langValue("Synthetic Carbon Additive")
                .dust()
                .components(GTMaterials.Carbon, 1, GregitskyMaterials.Limestone, 1).formula("(C)(?)")
                .flags(DISABLE_DECOMPOSITION)
                .color(0x2E2F2B).secondaryColor(0x4A5146)
                .iconSet(ROUGH)
                .buildAndRegister();
        Ferroxium = new Material.Builder(
                gregitskycore.id("ferroxium"))
                .langValue("Ferroxium")
                .ingot()
                .components(GTMaterials.Steel, 1, GregitskyMaterials.Limestone, 2).formula("Fe?2")
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME,
                        GENERATE_BOLT_SCREW, GENERATE_DENSE, GENERATE_SMALL_GEAR, GENERATE_SPRING, GENERATE_GEAR)
                .color(0x666666).secondaryColor(0x002080)
                .iconSet(METALLIC)
                .buildAndRegister();
        CalcinedClay = new Material.Builder(
                gregitskycore.id("calcined_clay"))
                .langValue("Calcined Clay")
                .dust()
                .components(Sodium, 2, Lithium, 1, Aluminium, 2, Silicon, 2, Oxygen, 6)
                .formula("Na2LiAl2Si2O6")
                .flags(DISABLE_DECOMPOSITION)
                .color(0x657186).secondaryColor(0x7d564f)
                .iconSet(ROUGH)
                .buildAndRegister();
        Anorthite = new Material.Builder(
                gregitskycore.id("anorthite"))
                .langValue("Anorthite")
                .gem()
                .components(Calcium, 1, Aluminium, 2, Silicon, 2, Oxygen, 8)
                .flags(DISABLE_DECOMPOSITION)
                .formula("CaAl2Si2O8")
                .color(0xf0960f).secondaryColor(0xa8690b)
                .iconSet(QUARTZ)
                .buildAndRegister();
        SodiumAluminateSolution = new Material.Builder(
                gregitskycore.id("sodium_aluminate_solution"))
                .langValue("Sodium Aluminate Solution")
                .liquid(420)
                .components(Sodium, 1, Aluminium, 1, Oxygen, 2)
                .formula("NaAlO2")
                .flags(DISABLE_DECOMPOSITION)
                .color(0xffffff).secondaryColor(0x4dcba1)
                .iconSet(QUARTZ)
                .buildAndRegister();
        AluminiumHydroxide = new Material.Builder(
                gregitskycore.id("aluminium_hydroxide"))
                .langValue("Aluminium Hydroxide")
                .dust()
                .components(Aluminium, 1, Oxygen, 3, Hydrogen, 3)
                .formula("Al(OH)3")
                .flags(DISABLE_DECOMPOSITION)
                .color(0xffffff).secondaryColor(0x53c6c6)
                .iconSet(METALLIC)
                .buildAndRegister();
        Alumina = new Material.Builder(
                gregitskycore.id("alumina"))
                .langValue("Alumina")
                .dust()
                //.blastTemp(1200, LOW, GTValues.VA[GTValues.MV], 20*60)
                .components(Aluminium, 2, Oxygen, 3)
                .formula("Al2O3")
                .flags(DISABLE_DECOMPOSITION)
                .color(0x53c6c6).secondaryColor(0xffffff)
                .iconSet(METALLIC)
                .buildAndRegister();
        CarbonTrioxide = new Material.Builder(
                gregitskycore.id("carbon_trioxide"))
                .langValue("Carbon Trioxide")
                .gas(293)
                .components(Carbon, 1, Oxygen, 3)
                .formula("CO3")
                .color(0x00b3b3)
                .iconSet(ROUGH)
                .buildAndRegister();
    }

    public static void init() {}
}
