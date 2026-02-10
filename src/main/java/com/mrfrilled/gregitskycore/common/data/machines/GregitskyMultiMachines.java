package com.mrfrilled.gregitskycore.common.data.machines;

import com.mrfrilled.gregitskycore.common.data.GregitskyRecipeTypes;
import com.mrfrilled.gregitskycore.common.data.block.GregitskyBlocks;
import com.mrfrilled.gregitskycore.common.data.machines.multiblock.primitive.CoagulationTankMachine;
import com.mrfrilled.gregitskycore.common.data.machines.multiblock.steam.WeakSteamParallelMultiBlockMachine;
import com.mrfrilled.gregitskycore.gregitskycore;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.client.renderer.machine.DynamicRenderHelper;
import com.gregtechceu.gtceu.common.block.BoilerFireboxType;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.models.GTMachineModels;
import com.gregtechceu.gtceu.common.machine.multiblock.steam.SteamParallelMultiblockMachine;
import com.gregtechceu.gtceu.utils.GTUtil;

import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Blocks;

import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.mrfrilled.gregitskycore.common.registry.GregitskyRegistry.REGISTRATE;
import static net.minecraft.world.level.block.Blocks.*;

public class GregitskyMultiMachines {

    static {
        REGISTRATE.creativeModeTab(() -> gregitskycore.GREGITSKY_CREATIVE_TAB);
    }

    /// ELECTRIC GREENHOUSE ///
    public static final MultiblockMachineDefinition GREENHOUSE = REGISTRATE
            .multiblock("greenhouse", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .tooltips(Component.translatable("gregitsky.machine.electric.greenhouse_tooltip.0"))
            .tooltipBuilder((stack, tooltip) -> {
                if (GTUtil.isCtrlDown()) {
                    tooltip.add(Component.empty());
                    tooltip.add(Component.translatable("gregitsky.machine.electric.greenhouse_tooltip.1"));
                    tooltip.add(Component.empty());
                } else {
                    tooltip.add(Component.translatable("gregitsky.machine.tooltip.hold_ctrl"));
                }
            })
            .recipeType(GregitskyRecipeTypes.GREENHOUSE_RECIPES)
            .appearanceBlock(CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("CCCCC", "CCCCC", "GGGGG", "GGGGG", "CCCCC", "CCCCC")
                    .aisle("CCCCC", "CMMMC", "G###G", "G###G", "CIIIC", "CCCCC")
                    .aisle("CCCCC", "CMMMC", "G###G", "G###G", "CIIIC", "CCCCC")
                    .aisle("CCCCC", "CMMMC", "G###G", "G###G", "CIIIC", "CCCCC")
                    .aisle("CCCCC", "CCKCC", "GGGGG", "GGGGG", "CCCCC", "CCCCC")
                    .where('K', controller(blocks(definition.getBlock())))
                    .where('M', blocks(Blocks.MOSS_BLOCK)
                            .or(blocks(Blocks.DIRT))
                            .or(blocks(Blocks.GRASS_BLOCK)))
                    .where('G', blocks(GTBlocks.CASING_TEMPERED_GLASS.get()))
                    .where('I', blocks(GLOWSTONE))
                    .where('C', blocks(CASING_STEEL_SOLID.get())
                            .or(Predicates.autoAbilities(definition.getRecipeTypes()))
                            .or(Predicates.abilities(PartAbility.MAINTENANCE).setExactLimit(1)))
                    .where('#', Predicates.any())
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    GTCEu.id("block/multiblock/implosion_compressor"))
            .register();
    /// PRIMITIVE GREENHOUSE ///
    public static final MultiblockMachineDefinition PRIMITIVE_GREENHOUSE = REGISTRATE
            .multiblock("primitive_greenhouse", WeakSteamParallelMultiBlockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .tooltips(Component.translatable("gregitsky.machine.primitive.greenhouse_tooltip.0"))
            .recipeType(GregitskyRecipeTypes.GREENHOUSE_RECIPES)
            .appearanceBlock(CASING_BRONZE_BRICKS)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("CCCCC", "CCCCC", "GGGGG", "GGGGG", "CCCCC", "CCCCC")
                    .aisle("CCCCC", "CMMMC", "G###G", "G###G", "CIIIC", "CCCCC")
                    .aisle("CCCCC", "CMMMC", "G###G", "G###G", "CIIIC", "CCCCC")
                    .aisle("CCCCC", "CMMMC", "G###G", "G###G", "CIIIC", "CCCCC")
                    .aisle("CCCCC", "CCKCC", "GGGGG", "GGGGG", "CCCCC", "CCCCC")
                    .where('K', controller(blocks(definition.getBlock())))
                    .where('M', blocks(Blocks.MOSS_BLOCK)
                            .or(blocks(Blocks.DIRT))
                            .or(blocks(Blocks.GRASS_BLOCK)))
                    .where('G', blocks(GLASS))
                    .where('I', blocks(GLOWSTONE))
                    .where('C', blocks(CASING_BRONZE_BRICKS.get())
                            .or(Predicates.autoAbilities(definition.getRecipeTypes())))
                    .where('#', Predicates.any())
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"),
                    GTCEu.id("block/multiblock/implosion_compressor"))
            .register();

    /// STEAM ALLOY SMELTER ///
    public static final MultiblockMachineDefinition STEAM_ALLOY_SMELTER = REGISTRATE
            .multiblock("steam_foundry", SteamParallelMultiblockMachine::new)
            .rotationState(RotationState.ALL)
            .appearanceBlock(CASING_BRONZE_BRICKS)
            .recipeType(GTRecipeTypes.ALLOY_SMELTER_RECIPES)
            .recipeModifier(SteamParallelMultiblockMachine::recipeModifier, true)
            .addOutputLimit(ItemRecipeCapability.CAP, 1)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("FFF", "XXX", "XXX")
                    .aisle("FFF", "X#X", "XXX")
                    .aisle("FFF", "XSX", "XXX")
                    .where('S', Predicates.controller(blocks(definition.getBlock())))
                    .where('F', blocks(FIREBOX_BRONZE.get())
                            .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1)))
                    .where('#', Predicates.air())
                    .where(' ', Predicates.any())
                    .where('X', blocks(CASING_BRONZE_BRICKS.get()).setMinGlobalLimited(6)
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1)))
                    .build())
            .model(GTMachineModels.createWorkableCasingMachineModel(
                    GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"),
                    GTCEu.id("block/machines/alloy_smelter"))
                    .andThen(b -> b.addDynamicRenderer(() -> DynamicRenderHelper
                            .makeBoilerPartRender(BoilerFireboxType.BRONZE_FIREBOX, CASING_BRONZE_BRICKS))))
            .tooltips(Component.translatable("gregitsky.machine.steam_alloy_smelter.tooltip.0"))
            .register();

    /// STEAM SEPARATOR ///
    public static final MultiblockMachineDefinition STEAM_CENTRIFUGE = REGISTRATE
            .multiblock("steam_separator", WeakSteamParallelMultiBlockMachine::new)
            .rotationState(RotationState.ALL)
            .appearanceBlock(CASING_BRONZE_BRICKS)
            .recipeType(GTRecipeTypes.CENTRIFUGE_RECIPES)
            .recipeModifier(SteamParallelMultiblockMachine::recipeModifier, true)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("XXX", "XXX", " X ")
                    .aisle("XXX", "X#X", "XXX")
                    .aisle("XXX", "XSX", " X ")
                    .where('S', Predicates.controller(blocks(definition.getBlock())))
                    .where('#', Predicates.air())
                    .where(' ', Predicates.any())
                    .where('X', blocks(CASING_BRONZE_BRICKS.get()).setMinGlobalLimited(6)
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1)))
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"),
                    GTCEu.id("block/machines/centrifuge"))
            .tooltips(Component.translatable("gregitsky.machine.steam_separator.tooltip.0"))
            .tooltipBuilder((stack, tooltip) -> {
                if (GTUtil.isCtrlDown()) {
                    tooltip.add(Component.empty());
                    tooltip.add(Component.translatable("gregitsky.machine.steam_separator.tooltip.1"));
                    tooltip.add(Component.empty());
                } else {
                    tooltip.add(Component.translatable("gregitsky.machine.tooltip.hold_ctrl"));
                }
            })
            .register();

    /// COAGULATION TANK ///
    public static final MultiblockMachineDefinition COAGULATION_TANK = REGISTRATE
            .multiblock("coagulation_tank", CoagulationTankMachine::new)
            .langValue("Coagulation Tank")
            .tooltips(Component.translatable("gregitsky.machine.coagulation_tank_tooltip.0"))
            .rotationState(RotationState.ALL)
            .recipeType(GregitskyRecipeTypes.COAGULATION_TANK_RECIPES)
            .appearanceBlock(GregitskyBlocks.REINFORCED_TREATED_WOOD_CASING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("CCC", "CCC", "CCC")
                    .aisle("CCC", "C C", "CCC")
                    .aisle("CCC", "CHC", "CCC")
                    .where(' ', Predicates.any())
                    .where('C',
                            Predicates.blocks(GregitskyBlocks.REINFORCED_TREATED_WOOD_CASING.get())
                                    .setMinGlobalLimited(21)
                                    .setPreviewCount(25)
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
