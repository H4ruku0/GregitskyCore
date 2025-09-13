package com.mrfrilled.gregitskycore.common.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTBlocks;

import net.minecraft.world.level.block.Blocks;

import com.mrfrilled.gregitskycore.data.recipes.GREENHOUSE_RECIPES;
import com.mrfrilled.gregitskycore.common.data.GregitskyRecipeTypes;

import static com.mrfrilled.gregitskycore.common.registry.GregitskyRegistration.REGISTRATE;


public class GreenHouse {

    public static final MultiblockMachineDefinition GREENHOUSE = REGISTRATE
            .multiblock("greenhouse", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(GregitskyRecipeTypes.GREENHOUSE_RECIPES)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("CCC", "CGC", "CGC", "CLC", "CCC")
                    .aisle("CMC", "GSG", "G#G", "LIL", "COC")
                    .aisle("CKC", "CGC", "CGC", "CLC", "CNC")
                    .where('K', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('M', Predicates.blocks(Blocks.MOSS_BLOCK)
                            .or(Predicates.blocks(Blocks.DIRT))
                            .or(Predicates.blocks(Blocks.GRASS_BLOCK)))
                    .where('G', Predicates.blocks(GTBlocks.CLEANROOM_GLASS.get()))
                    .where('S', Predicates.blocks(Blocks.OAK_SAPLING)
                            .or(Predicates.blocks(Blocks.DARK_OAK_SAPLING))
                            .or(Predicates.blocks(Blocks.SPRUCE_SAPLING))
                            .or(Predicates.blocks(Blocks.BIRCH_SAPLING))
                            .or(Predicates.blocks(Blocks.JUNGLE_SAPLING))
                            .or(Predicates.blocks(Blocks.ACACIA_SAPLING))
                            .or(Predicates.blocks(Blocks.AZALEA))
                            .or(Predicates.blocks(Blocks.FLOWERING_AZALEA))
                            .or(Predicates.blocks(Blocks.MANGROVE_PROPAGULE))
                            .or(Predicates.blocks(GTBlocks.RUBBER_SAPLING.get())))
                    .where('I', Predicates.blocks(Blocks.GLOWSTONE))
                    .where('L', Predicates.blocks(GTBlocks.CASING_GRATE.get()))
                    .where('C', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.autoAbilities(definition.getRecipeTypes())))
                    .where('O', Predicates.abilities(PartAbility.MUFFLER)
                            .setExactLimit(1))
                    .where('N', Predicates.abilities(PartAbility.MAINTENANCE))
                    .where('#', Predicates.air())
                    .build())
            .workableCasingModel(
                    GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    GTCEu.id("gtceu:block/multiblock/implosion_compressor"))
            .register();
    public static void init() {}
}