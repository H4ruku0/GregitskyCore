package com.mrfrilled.gregitskycore.common.data.multiblocks;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GCYMBlocks;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.machine.multiblock.steam.SteamParallelMultiblockMachine;
import com.mrfrilled.gregitskycore.common.data.GregitskyRecipeTypes;
import com.mrfrilled.gregitskycore.common.data.machine.multiblock.steam.WeakSteamParallelMultiBlockMachine;

import static com.gregtechceu.gtceu.api.pattern.Predicates.blocks;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_STEEL_SOLID;
import static com.mrfrilled.gregitskycore.gregitskycore.REGISTRATE;

public class PrimitiveOreMiner {

    public static final MultiblockMachineDefinition PRIMITIVE_ORE_MINER = REGISTRATE
            .multiblock("primitive_ore_miner", (holder) -> new WeakSteamParallelMultiBlockMachine(holder, 4))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(GregitskyRecipeTypes.PRIMITIVE_ORE_MINER)
            .appearanceBlock(CASING_STEEL_SOLID)
            .recipeModifier((machine, recipe) -> WeakSteamParallelMultiBlockMachine.recipeModifier(machine, recipe), true)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("V###V", "V###V", "CCCCC", "#####", "#####", "#####", "#####", "#####", "#####", "#####", "#####")
                    .aisle("#####", "#####", "CCCCC", "#DED#", "##E##", "##E##", "##E##", "#####", "#####", "#####", "#####")
                    .aisle("#####", "#####", "CCCCC", "#ECE#", "#ECE#", "#ECE#", "#ECE#", "##E##", "##E##", "##E##", "##E##")
                    .aisle("#####", "#####", "CCCCC", "#DED#", "##E##", "##E##", "##E##", "#####", "#####", "#####", "#####")
                    .aisle("V###V", "V###V", "CCHCC", "#####", "#####", "#####", "#####", "#####", "#####", "#####", "#####")
                    .where('#', Predicates.any())
                    .where('C', blocks(GTBlocks.CASING_BRONZE_BRICKS.get()).setMinGlobalLimited(10)
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setMaxGlobalLimited(1))
                            .or(Predicates.abilities(PartAbility.STEAM).setMaxGlobalLimited(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setMaxGlobalLimited(1)))
                    .where('V', blocks(ChemicalHelper.getBlock(TagPrefix.frameGt, GTMaterials.Invar)))
                    .where('D', blocks(GTBlocks.FIREBOX_BRONZE.get()))
                    .where('E', blocks(GTBlocks.BRONZE_HULL.get()))
                    .where('H', Predicates.controller(blocks(definition.get())))
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_solid_steel"), GTCEu.id("block/multiblock/implosion_compressor"))
            .hasBER(true)
            .register();
    public static void init() {}
}
