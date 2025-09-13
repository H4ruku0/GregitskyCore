package com.mrfrilled.gregitskycore.data.recipes;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.mrfrilled.gregitskycore.common.machine.GreenHouse;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.MV;
import static com.gregtechceu.gtceu.common.data.GTItems.FERTILIZER;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Water;
import static com.mrfrilled.gregitskycore.common.data.GregitskyRecipeTypes.GREENHOUSE_RECIPES;

public class GREENHOUSE_RECIPES {

    private static void greenhouseHelper(Consumer<FinishedRecipe> provider, String id, Item input, ItemStack output_normal, ItemStack output_boosted) {
        greenhouseHelper(provider, id, input, List.of(output_normal), List.of(output_boosted));

    }

    private static void greenhouseHelper(Consumer<FinishedRecipe> provider, String id, Item input, List<ItemStack> output_normal, List<ItemStack> output_boosted) {

        GREENHOUSE_RECIPES.recipeBuilder(id)
                .circuitMeta(2)
                .notConsumable(input)
                .inputItems(FERTILIZER.get(), 4)
                .inputFluids(Water, 1000)
                .outputItems(output_normal)
                .duration(320)
                .EUt(MV)
                .save(provider);
        GREENHOUSE_RECIPES.recipeBuilder(id + "_boosted")
                .circuitMeta(1)
                .notConsumable(input)
                .inputFluids(Water, 1000)
                .outputItems(output_boosted)
                .duration(320)
                .EUt(MV)
                .save(provider);
    }


    private static void loadGreenhouseRecipes(Consumer<FinishedRecipe> provider) {
        VanillaRecipeHelper.addShapedRecipe(provider, true, GTCEu.id("greenhouse"),
                GreenHouse.GREENHOUSE.asStack(),
                "AWA",
                "ASA",
                "WAW",
                "A", CustomTags.MV_CIRCUITS,
                "W", ChemicalHelper.get(TagPrefix.wireGtSingle, GTMaterials.Copper),
                "S", GTBlocks.CASING_STEEL_SOLID.asItem());

        // Rubber
        greenhouseHelper(provider, "rubber_sapling", GTBlocks.RUBBER_SAPLING.asItem(),
                List.of(new ItemStack(GTBlocks.RUBBER_LOG.get(), 64), new ItemStack(GTItems.STICKY_RESIN.get(), 8), new ItemStack(GTBlocks.RUBBER_SAPLING.asItem(), 4)),
                List.of(new ItemStack(GTBlocks.RUBBER_LOG.get(), 64), new ItemStack(GTItems.STICKY_RESIN.get(), 16), new ItemStack(GTBlocks.RUBBER_SAPLING.asItem(), 4)));

        // Oak
        greenhouseHelper(provider, "oak_sapling", Blocks.OAK_SAPLING.asItem(),
                List.of(new ItemStack(Blocks.OAK_LOG, 64), new ItemStack(Blocks.OAK_SAPLING.asItem(), 4)),
                List.of(new ItemStack(Blocks.OAK_LOG, 64), new ItemStack(Blocks.OAK_LOG, 64), new ItemStack(Blocks.OAK_SAPLING.asItem(), 4)));

        // Dark Oak
        greenhouseHelper(provider, "dark_oak_sapling", Blocks.DARK_OAK_SAPLING.asItem(),
                List.of(new ItemStack(Blocks.DARK_OAK_LOG, 64), new ItemStack(Blocks.DARK_OAK_SAPLING.asItem(), 4)),
                List.of(new ItemStack(Blocks.DARK_OAK_LOG, 64), new ItemStack(Blocks.DARK_OAK_LOG, 64), new ItemStack(Blocks.DARK_OAK_SAPLING.asItem(), 4)));

        // Spruce
        greenhouseHelper(provider, "spruce_sapling", Blocks.SPRUCE_SAPLING.asItem(),
                List.of(new ItemStack(Blocks.SPRUCE_LOG, 64), new ItemStack(Blocks.SPRUCE_SAPLING.asItem(), 4)),
                List.of(new ItemStack(Blocks.SPRUCE_LOG, 64), new ItemStack(Blocks.SPRUCE_LOG, 64), new ItemStack(Blocks.SPRUCE_SAPLING.asItem(), 4)));

        // Birch
        greenhouseHelper(provider, "birch_sapling", Blocks.BIRCH_SAPLING.asItem(),
                List.of(new ItemStack(Blocks.BIRCH_LOG, 64), new ItemStack(Blocks.BIRCH_SAPLING.asItem(), 4)),
                List.of(new ItemStack(Blocks.BIRCH_LOG, 64), new ItemStack(Blocks.BIRCH_LOG, 64), new ItemStack(Blocks.BIRCH_SAPLING.asItem(), 4)));

        // Acacia
        greenhouseHelper(provider, "acacia_sapling", Blocks.ACACIA_SAPLING.asItem(),
                List.of(new ItemStack(Blocks.ACACIA_LOG, 64), new ItemStack(Blocks.ACACIA_SAPLING.asItem(), 4)),
                List.of(new ItemStack(Blocks.ACACIA_LOG, 64), new ItemStack(Blocks.ACACIA_LOG, 64), new ItemStack(Blocks.ACACIA_SAPLING.asItem(), 4)));

        // Jungle
        greenhouseHelper(provider, "jungle_sapling", Blocks.JUNGLE_SAPLING.asItem(),
                List.of(new ItemStack(Blocks.JUNGLE_LOG, 64), new ItemStack(Blocks.JUNGLE_SAPLING.asItem(), 4)),
                List.of(new ItemStack(Blocks.JUNGLE_LOG, 64), new ItemStack(Blocks.JUNGLE_LOG, 64), new ItemStack(Blocks.JUNGLE_SAPLING.asItem(), 4)));


        // Azalea
        greenhouseHelper(provider, "azalea_sapling", Blocks.AZALEA.asItem(),
                List.of(new ItemStack(Blocks.OAK_LOG, 64), new ItemStack(Blocks.AZALEA.asItem(), 4)),
                List.of(new ItemStack(Blocks.OAK_LOG, 64), new ItemStack(Blocks.OAK_LOG, 64), new ItemStack(Blocks.AZALEA.asItem(), 4)));


        // Flowering Azalea
        greenhouseHelper(provider, "flowering_azalea", Blocks.FLOWERING_AZALEA.asItem(),
                List.of(new ItemStack(Blocks.OAK_LOG, 64), new ItemStack(Blocks.FLOWERING_AZALEA.asItem(), 4)),
                List.of(new ItemStack(Blocks.OAK_LOG, 64), new ItemStack(Blocks.OAK_LOG, 64), new ItemStack(Blocks.AZALEA.asItem(), 4)));

        // Mangrove
        greenhouseHelper(provider, "mangrove_propagule", Blocks.MANGROVE_PROPAGULE.asItem(),
                List.of(new ItemStack(Blocks.MANGROVE_LOG, 64), new ItemStack(Blocks.MANGROVE_PROPAGULE.asItem(), 4)),
                List.of(new ItemStack(Blocks.MANGROVE_LOG, 64), new ItemStack(Blocks.MANGROVE_LOG, 64), new ItemStack(Blocks.MANGROVE_PROPAGULE.asItem(), 4)));


        ////// Crops //////

        // Sugarcane
        greenhouseHelper(provider, "sugar_cane", Items.SUGAR_CANE, new ItemStack(Items.SUGAR_CANE, 24), new ItemStack(Items.SUGAR_CANE, 48));

        // Kelp
        greenhouseHelper(provider, "kelp", Items.KELP, new ItemStack(Items.KELP, 24), new ItemStack(Items.KELP, 48));

        // Bamboo
        greenhouseHelper(provider, "bamboo", Items.BAMBOO, new ItemStack(Items.BAMBOO, 24), new ItemStack(Items.BAMBOO, 48));

        // Cactus
        greenhouseHelper(provider, "cactus", Items.CACTUS, new ItemStack(Items.CACTUS, 24), new ItemStack(Items.CACTUS, 48));

        // Wheat
        greenhouseHelper(provider, "wheat", Items.WHEAT_SEEDS, new ItemStack(Items.WHEAT, 24), new ItemStack(Items.WHEAT, 48));

        // Carrot
        greenhouseHelper(provider, "carrot", Items.CARROT, new ItemStack(Items.CARROT, 24), new ItemStack(Items.CARROT, 48));

        // Potato
        greenhouseHelper(provider, "potato", Items.POTATO, new ItemStack(Items.POTATO, 24), new ItemStack(Items.POTATO, 48));

        // Beetroot
        greenhouseHelper(provider, "beetroot", Items.BEETROOT_SEEDS, new ItemStack(Items.BEETROOT, 24), new ItemStack(Items.BEETROOT, 48));

        // Mellon
        greenhouseHelper(provider, "melon", Items.MELON_SEEDS, new ItemStack(Items.MELON, 12), new ItemStack(Items.MELON, 24));

        // Pumpkin
        greenhouseHelper(provider, "pumpkin", Items.PUMPKIN_SEEDS, new ItemStack(Items.PUMPKIN, 12), new ItemStack(Items.PUMPKIN, 24));

        // Nether Wart
        greenhouseHelper(provider, "nether_wart", Items.NETHER_WART, new ItemStack(Items.NETHER_WART, 12), new ItemStack(Items.NETHER_WART, 24));

        // Red Mushroom
        greenhouseHelper(provider, "red_mushroom", Items.RED_MUSHROOM, new ItemStack(Items.RED_MUSHROOM, 12), new ItemStack(Items.RED_MUSHROOM, 24));

        // Brown Mushroom
        greenhouseHelper(provider, "brown_mushroom", Items.BROWN_MUSHROOM, new ItemStack(Items.BROWN_MUSHROOM, 12), new ItemStack(Items.BROWN_MUSHROOM, 24));
    }
    public static void init() {}

}