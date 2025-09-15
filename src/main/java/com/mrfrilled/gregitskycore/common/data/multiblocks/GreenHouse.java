package com.mrfrilled.gregitskycore.common.data.multiblocks;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTBlocks;

import com.gregtechceu.gtceu.common.data.models.GTMachineModels;
import com.mrfrilled.gregitskycore.common.data.machine.GreenHousetest;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Blocks;


import com.mrfrilled.gregitskycore.common.data.GregitskyRecipeTypes;
import org.joml.Vector3f;

import java.util.List;

import static com.gregtechceu.gtceu.api.pattern.Predicates.blocks;
import static com.gregtechceu.gtceu.api.pattern.Predicates.controller;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_STEEL_SOLID;
import static com.mrfrilled.gregitskycore.api.registries.GregitskyRegistration.REGISTRATE;


public class GreenHouse {

    public static final MultiblockMachineDefinition GREENHOUSE = REGISTRATE
            .multiblock("greenhouse", GreenHousetest::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .tooltips(Component.translatable("gregitsky.multiblock.greenhouse_test.tooltip"))
            .recipeType(GregitskyRecipeTypes.GREENHOUSE_RECIPES)
            .appearanceBlock(CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("CCC", "CGC", "CGC", "CLC", "CCC")
                    .aisle("CMC", "GSG", "G#G", "LIL", "COC")
                    .aisle("CKC", "CGC", "CGC", "CLC", "CNC")
                    .where('K', controller(blocks(definition.getBlock())))
                    .where('M', blocks(Blocks.MOSS_BLOCK)
                            .or(blocks(Blocks.DIRT))
                            .or(blocks(Blocks.GRASS_BLOCK)))
                    .where('G', blocks(GTBlocks.CLEANROOM_GLASS.get()))
                    .where('S', blocks(Blocks.OAK_SAPLING)
                            .or(blocks(Blocks.DARK_OAK_SAPLING))
                            .or(blocks(Blocks.SPRUCE_SAPLING))
                            .or(blocks(Blocks.BIRCH_SAPLING))
                            .or(blocks(Blocks.JUNGLE_SAPLING))
                            .or(blocks(Blocks.ACACIA_SAPLING))
                            .or(blocks(Blocks.AZALEA))
                            .or(blocks(Blocks.FLOWERING_AZALEA))
                            .or(blocks(Blocks.MANGROVE_PROPAGULE))
                            .or(blocks(GTBlocks.RUBBER_SAPLING.get())))
                    .where('I', blocks(Blocks.GLOWSTONE))
                    .where('L', blocks(GTBlocks.CASING_GRATE.get()))
                    .where('C', blocks(CASING_STEEL_SOLID.get())
                            .or(Predicates.autoAbilities(definition.getRecipeTypes())))
                    .where('O', Predicates.abilities(PartAbility.MUFFLER)
                            .setExactLimit(1))
                    .where('N', Predicates.abilities(PartAbility.MAINTENANCE))
                    .where('#', Predicates.air())
                    .build())
            .modelProperty(GTMachineModelProperties.RECIPE_LOGIC_STATUS, RecipeLogic.Status.IDLE)
            .model(GTMachineModels.createWorkableCasingMachineModel(GTCEu.id("block/casings/solid/machine_casing_solid_steel"), GTCEu.id("block/multiblock/implosion_compressor"))
                    .andThen(b -> b.addDynamicRenderer(() -> GTDynamicRenders.makeGrowingPlantRender(List.of(new Vector3f(0, 1, -1))))))
            .hasBER(true)
            .register();
    public static void init() {}
}