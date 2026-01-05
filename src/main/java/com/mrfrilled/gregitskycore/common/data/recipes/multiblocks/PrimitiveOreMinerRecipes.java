package com.mrfrilled.gregitskycore.common.data.recipes.multiblocks;

public class PrimitiveOreMinerRecipes {

    // public static void init(Consumer<FinishedRecipe> provider) {
    // register(provider);
    // }
    //
    // private record OreRecipe(Item input, Item output) {}
    // private static final List<OreRecipe> ORES = List.of(
    // new OreRecipe(Items.RAW_GOLD, Items.GOLD_INGOT),
    // new OreRecipe(Items.RAW_COPPER, Items.COPPER_INGOT),
    // new OreRecipe(Items.RAW_IRON, Items.IRON_INGOT));
    //
    // private record OreRecipe_Test(Material material, ItemStack input, ItemStack output) {}
    // private static final List<OreRecipe_Test> ORES_TEST = List.of(
    // new OreRecipe_Test(GTMaterials.Iron ,ChemicalHelper.get(TagPrefix.rawOre, Iron),
    // ChemicalHelper.get(TagPrefix.rawOreBlock, Iron)),
    // new OreRecipe_Test(GTMaterials.Tin ,ChemicalHelper.get(TagPrefix.rawOre, GTMaterials.Tin),
    // ChemicalHelper.get(TagPrefix.rawOreBlock, GTMaterials.Tin)),
    // new OreRecipe_Test(GTMaterials.Realgar ,ChemicalHelper.get(TagPrefix.rawOre, GTMaterials.Realgar),
    // ChemicalHelper.get(TagPrefix.rawOreBlock, GTMaterials.Realgar)));
    //
    // private static void register(Consumer<FinishedRecipe> provider) {
    // for (OreRecipe ore : ORES) {
    // PRIMITIVE_ORE_MINER.recipeBuilder(ore.input().toString())
    // .EUt(GTValues.VA[GTValues.LV])
    // .inputItems(ore.input(), 4)
    // .inputFluids(GTMaterials.Water.getFluid(1000))
    // .outputItems(ore.output(), 16)
    // .duration(20 * 5)
    // .circuitMeta(1)
    // .addMaterialInfo(true)
    // .save(provider);
    // }
    // for (OreRecipe_Test ore_test : ORES_TEST) {
    // PRIMITIVE_ORE_MINER.recipeBuilder(ore_test.material().toString())
    // .EUt(GTValues.VA[GTValues.LV])
    // .inputItems(ore_test.input(), 4)
    // .inputFluids(GTMaterials.Water.getFluid(1000))
    // .outputItems(ore_test.output(), 16)
    // .duration(20 * 5)
    // // .circuitMeta(1)
    // .addMaterialInfo(true)
    // .save(provider);
    // }
    // }
}
