package com.mrfrilled.gregitskycore.common.machine.multiblock.multi;

import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.mrfrilled.gregitskycore.common.data.GregitskyRecipeTypes;
import com.mrfrilled.gregitskycore.common.machine.multiblock.steam.WeakSteamParallelMultiBlockMachine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GCYMBlocks;
import com.gregtechceu.gtceu.common.data.GTBlocks;

import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.mrfrilled.gregitskycore.common.registry.GregitskyRegistry.REGISTRATE;

public class PrimitiveOreMiner {

    public static final MultiblockMachineDefinition PRIMITIVE_ORE_MINER = REGISTRATE
            .multiblock("primitive_ore_miner", WeakSteamParallelMultiBlockMachine::new)
            .langValue("Primitive Ore Miner")
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(GregitskyRecipeTypes.PRIMITIVE_ORE_MINER)
            .appearanceBlock(GTBlocks.CASING_BRONZE_BRICKS)
            .recipeModifier(WeakSteamParallelMultiBlockMachine::recipeModifier, true)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("CCC", " D ", " D ", " D ", "   ", "   ", "   ")
                    .aisle("CCC", "DAD", "DAD", "DAD", " D ", " D ", " D ")
                    .aisle("CHC", " D ", " D ", " D ", "   ", "   ", "   ")
                    .where(' ', Predicates.any())
                    .where('C', Predicates.blocks(GTBlocks.CASING_BRONZE_BRICKS.get()).setMinGlobalLimited(3).setPreviewCount(11)
                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setMaxGlobalLimited(1).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.STEAM).setMaxGlobalLimited(1).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setMaxGlobalLimited(1).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS).setMaxGlobalLimited(1).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setMaxGlobalLimited(1).setPreviewCount(1)))
                    .where('D', frames(GTMaterials.Bronze))
                    .where('A', Predicates.blocks(CASING_BRONZE_BRICKS.get()))
                    .where('H', Predicates.controller(Predicates.blocks(definition.get())))
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"),
                    GTCEu.id("block/multiblock/implosion_compressor"))
            .register();

    public static void init() {}
}
