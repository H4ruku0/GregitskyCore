package com.mrfrilled.gregitskycore.common.data.block;

import com.mrfrilled.gregitskycore.gregitskycore;

import com.gregtechceu.gtceu.data.recipe.CustomTags;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiFunction;

import static com.mrfrilled.gregitskycore.common.registry.GregitskyRegistry.REGISTRATE;

public class GregitskyBlocks {

    static {
        REGISTRATE.creativeModeTab(() -> gregitskycore.GREGITSKY_CREATIVE_TAB);
    }

    private static BlockEntry<Block> createSidedCasingBlock(String name, String id, String texture,
                                                            NonNullBiFunction<Block, Item.Properties, ? extends BlockItem> func) {
        return REGISTRATE
                .block(id, Block::new)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> p.isValidSpawn((state, level, post, ent) -> false))
                .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(),
                        prov.models().cubeAll(ctx.getName(), gregitskycore.id("block/" + texture))))
                .tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH)
                .lang(name)
                .item(func)
                .build()
                .register();
    }

    public static final BlockEntry<Block> HUMIDITY_FILTER_CASING = createSidedCasingBlock(
            "Humidity Filter Casing", "humidity_filter_casing",
            "casings/machine_casing_humidity_filter", BlockItem::new);
    public static final BlockEntry<Block> REINFORCED_TREATED_WOOD_CASING = createSidedCasingBlock(
            "Reinforced Treated Wood Casing", "reinforced_treated_wood_casing",
            "casings/machine_casing_reinforced_treated_wood", BlockItem::new);

    public static void init() {}
}
