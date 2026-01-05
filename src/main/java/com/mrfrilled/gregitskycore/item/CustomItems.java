package com.mrfrilled.gregitskycore.item;

import com.mrfrilled.gregitskycore.gregitskycore;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.mrfrilled.gregitskycore.common.registry.GregitskyRegistry.REGISTRATE;

public class CustomItems {

    static {
        REGISTRATE.creativeModeTab(() -> gregitskycore.GREGITSKY_CREATIVE_TAB);
    }

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            gregitskycore.MOD_ID);

    public static final ItemEntry<Item> GREGITSKY_LOGO = REGISTRATE
            .item("gregitsky_logo", Item::new)
            .register();

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
