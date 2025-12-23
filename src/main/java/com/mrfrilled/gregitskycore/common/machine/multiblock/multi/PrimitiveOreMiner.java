package com.mrfrilled.gregitskycore.common.machine.multiblock.multi;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GCYMBlocks;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.mrfrilled.gregitskycore.common.data.GregitskyRecipeTypes;
import com.mrfrilled.gregitskycore.common.machine.multiblock.steam.WeakSteamParallelMultiBlockMachine;

import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.mrfrilled.gregitskycore.common.registry.GregitskyRegistry.REGISTRATE;

public class PrimitiveOreMiner {

    public static final MultiblockMachineDefinition PRIMITIVE_ORE_MINER = REGISTRATE
            .multiblock("primitive_ore_miner", WeakSteamParallelMultiBlockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(GregitskyRecipeTypes.PRIMITIVE_ORE_MINER)
            .appearanceBlock(CASING_STEEL_SOLID)
            .recipeModifier(WeakSteamParallelMultiBlockMachine::recipeModifier, true)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("BCCCB", "BBCBB", "BBCBB", "BBBBB", "BBBBB")
                    .aisle("CDDDC", "BDBDB", "BDEDB", "BBDBB", "BBBBB")
                    .aisle("CDDDC", "CBBBC", "CEFEC", "BDDDB", "BBGBB")
                    .aisle("CDDDC", "BDBDB", "BDEDB", "BBDBB", "BBBBB")
                    .aisle("BCCCB", "BBHBB", "BBCBB", "BBBBB", "BBBBB")
                    .where('B', Predicates.any())
                    .where('C', Predicates.blocks(GTBlocks.CASING_BRONZE_BRICKS.get()).setMinGlobalLimited(10)
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setMaxGlobalLimited(1))
                            .or(Predicates.abilities(PartAbility.STEAM).setMaxGlobalLimited(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setMaxGlobalLimited(1)))
                    .where('D', Predicates.blocks(GCYMBlocks.CASING_INDUSTRIAL_STEAM.get()))
                    .where('E', Predicates.blocks(GTBlocks.BRONZE_BRICKS_HULL.get()))
                    .where('F', Predicates.blocks(GTBlocks.FIREBOX_BRONZE.get()))
                    .where('G', Predicates.blocks(GTBlocks.BRONZE_HULL.get()))
                    .where('H', Predicates.controller(Predicates.blocks(definition.get())))
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_solid_steel"), GTCEu.id("block/multiblock/implosion_compressor"))
            .register();
    public static void init() {}
}
