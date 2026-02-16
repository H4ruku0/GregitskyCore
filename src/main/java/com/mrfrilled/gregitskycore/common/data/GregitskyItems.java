package com.mrfrilled.gregitskycore.common.data;

import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.common.item.CoverPlaceBehavior;
import com.gregtechceu.gtceu.common.item.TooltipBehavior;
import com.mrfrilled.gregitskycore.gregitskycore;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.gregtechceu.gtceu.common.data.GTItems.attach;
import static com.mrfrilled.gregitskycore.common.registry.GregitskyRegistry.REGISTRATE;

public class GregitskyItems {

    static {
        REGISTRATE.creativeModeTab(() -> gregitskycore.GREGITSKY_CREATIVE_TAB);
    }

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            gregitskycore.MOD_ID);

    // public static final ItemEntry<Item> GREGITSKY_LOGO = REGISTRATE
    // .item("gregitsky_logo", Item::new)
    // .register();

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static ItemEntry<ComponentItem> COVER_INFINITE_COBBLESTONE = REGISTRATE
            .item("infinite_cobblestone_cover", ComponentItem::create)
            .lang("Infinite Cobblestone Cover")
            .onRegister(item -> {
                item.attachComponents(
                        new TooltipBehavior(lines -> {
                            lines.add(Component.translatable("gregitsky.machine.infinite_cobblestone_cover.tooltip.1"));
                            lines.add(Component.translatable("gregitsky.machine.item_production.tooltip.1", 1));
                        }),
                        new CoverPlaceBehavior(GregitskyCovers.INFINITE_COBBLESTONE)
                );
            })
            .register();

}
