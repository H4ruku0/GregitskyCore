package com.mrfrilled.gregitskycore.common.data;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

import static com.mrfrilled.gregitskycore.common.registry.GregitskyRegistry.REGISTRATE;
import static com.mrfrilled.gregitskycore.gregitskycore.GREGITSKY_CREATIVE_TAB;

public class GregitskyItems {

    static {
        REGISTRATE.creativeModeTab(()-> GREGITSKY_CREATIVE_TAB);
    }

    public static ItemEntry<Item> createBasicItem = REGISTRATE
            .item("bronze_gearbox" ,Item::new)
            .model((ctx, prov)-> {
                prov.withExistingParent(ctx.getName(), prov.mcLoc("item/generated"))
                        .texture("layer0", prov.modLoc("item/" + ctx.getName()));
                    })
            .register();
    public static void init() {}
}
