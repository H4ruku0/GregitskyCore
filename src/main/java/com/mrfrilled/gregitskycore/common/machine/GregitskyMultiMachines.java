package com.mrfrilled.gregitskycore.common.machine;

import com.mrfrilled.gregitskycore.common.data.GregitskyRecipeTypes;
import com.mrfrilled.gregitskycore.common.data.block.GregitskyBlocks;
import com.mrfrilled.gregitskycore.common.machine.multiblock.steam.WeakSteamParallelMultiBlockMachine;
import com.mrfrilled.gregitskycore.common.machine.multiblock.primitive.CoagulationTankMachine;
import com.mrfrilled.gregitskycore.gregitskycore;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Blocks;

import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_BRONZE_BRICKS;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_STEEL_SOLID;
import static com.mrfrilled.gregitskycore.common.registry.GregitskyRegistry.REGISTRATE;

public class GregitskyMultiMachines {

    static {
        REGISTRATE.creativeModeTab(() -> gregitskycore.GREGITSKY_CREATIVE_TAB);
    }

    /// ELECTRIC GREENHOUSE
    public static final MultiblockMachineDefinition GREENHOUSE = REGISTRATE
            .multiblock("greenhouse", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .tooltips(Component.translatable("gregitsky.multiblock.greenhouse_tooltip0"))
            .recipeType(GregitskyRecipeTypes.GREENHOUSE_RECIPES)
            .appearanceBlock(CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("CCC", "CGC", "CGC", "CLC", "CCC")
                    .aisle("CMC", "GSG", "G#G", "LIL", "CCC")
                    .aisle("CKC", "CGC", "CGC", "CLC", "CCC")
                    .where('K', controller(blocks(definition.getBlock())))
                    .where('M', blocks(Blocks.MOSS_BLOCK)
                            .or(blocks(Blocks.DIRT))
                            .or(blocks(Blocks.GRASS_BLOCK)))
                    .where('G', blocks(GTBlocks.CASING_TEMPERED_GLASS.get()))
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
                    .where('L', blocks(GTBlocks.CASING_STEEL_GEARBOX.get()))
                    .where('C', blocks(CASING_STEEL_SOLID.get())
                            .or(Predicates.autoAbilities(definition.getRecipeTypes())))
                    .where('#', Predicates.air())
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    GTCEu.id("block/multiblock/implosion_compressor"))
            .hasBER(true)
            .register();
    /// PRIMITIVE GREENHOUSE
    public static final MultiblockMachineDefinition PRIMITIVE_GREENHOUSE = REGISTRATE
            .multiblock("primitive_greenhouse", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .tooltips(Component.translatable("gregitsky.multiblock.primitive_greenhouse_tooltip0"))
            .recipeType(GregitskyRecipeTypes.GREENHOUSE_RECIPES)
            .appearanceBlock(CASING_BRONZE_BRICKS)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("CCC", "CGC", "CGC", "CLC", "CCC")
                    .aisle("CMC", "GSG", "G#G", "LIL", "CCC")
                    .aisle("CKC", "CGC", "CGC", "CLC", "CCC")
                    .where('K', controller(blocks(definition.getBlock())))
                    .where('M', blocks(Blocks.MOSS_BLOCK)
                            .or(blocks(Blocks.DIRT))
                            .or(blocks(Blocks.GRASS_BLOCK)))
                    .where('G', blocks(Blocks.GLASS))
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
                    .where('L', blocks(GTBlocks.CASING_BRONZE_GEARBOX.get()))
                    .where('C', blocks(CASING_BRONZE_BRICKS.get())
                            .or(Predicates.autoAbilities(definition.getRecipeTypes())))
                    .where('#', Predicates.air())
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"),
                    GTCEu.id("block/multiblock/implosion_compressor"))
            .hasBER(true)
            .register();

    /// PRIMITIVE ORE MINER
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
                    .where('C', Predicates.blocks(GTBlocks.CASING_BRONZE_BRICKS.get()).setMinGlobalLimited(3)
                            .setPreviewCount(11)
                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setMaxGlobalLimited(1)
                                    .setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.STEAM).setMaxGlobalLimited(1).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setMaxGlobalLimited(1)
                                    .setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS).setMaxGlobalLimited(1)
                                    .setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setMaxGlobalLimited(1)
                                    .setPreviewCount(1)))
                    .where('D', frames(GTMaterials.Bronze))
                    .where('A', Predicates.blocks(CASING_BRONZE_BRICKS.get()))
                    .where('H', Predicates.controller(Predicates.blocks(definition.get())))
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"),
                    GTCEu.id("block/multiblock/implosion_compressor"))
            .register();

        ///  COAGULATION TANK
    public static final MultiblockMachineDefinition COAGULATION_TANK = REGISTRATE
            .multiblock("coagulation_tank", CoagulationTankMachine::new)
            .langValue("Coagulation Tank").tooltips(Component.translatable("gregitsky.multiblock.coagulation_tank_tooltip0"))
            .rotationState(RotationState.ALL)
            .recipeType(GregitskyRecipeTypes.COAGULATION_TANK_RECIPES)
            .appearanceBlock(GregitskyBlocks.REINFORCER_TREATED_WOOD_CASING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("CCC", "CCC", "CCC")
                    .aisle("CCC", "C C", "CCC")
                    .aisle("CCC", "CHC", "CCC")
                    .where(' ', Predicates.any())
                    .where('C', Predicates.blocks(GregitskyBlocks.REINFORCER_TREATED_WOOD_CASING.get()).setMinGlobalLimited(23)
                            .setPreviewCount(27)
                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setMaxGlobalLimited(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setMaxGlobalLimited(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS).setMaxGlobalLimited(1))
                            .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setMaxGlobalLimited(1)))
                    .where('H', Predicates.controller(Predicates.blocks(definition.get())))
                    .build())
            .workableCasingModel(gregitskycore.id("block/casings/machine_casing_reinforced_treated_wood"),
                    GTCEu.id("block/multiblock/primitive_pump"))
            .register();

    public static void init() {}
}
