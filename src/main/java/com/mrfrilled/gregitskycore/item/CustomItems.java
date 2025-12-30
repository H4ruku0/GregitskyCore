package com.mrfrilled.gregitskycore.item;

import com.mrfrilled.gregitskycore.gregitskycore;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CustomItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, gregitskycore.MOD_ID);

    public static final RegistryObject<Item> GREGITSKY_LOGO = ITEMS.register("gregitsky_logo",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
