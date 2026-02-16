package com.mrfrilled.gregitskycore.common.data;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.client.renderer.cover.ICoverRenderer;
import com.gregtechceu.gtceu.client.renderer.cover.SimpleCoverRenderer;
import com.mrfrilled.gregitskycore.common.cover.InfiniteCobblestoneCover;
import com.mrfrilled.gregitskycore.gregitskycore;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public class GregitskyCovers {

    public static CoverDefinition INFINITE_COBBLESTONE;

    ///////////////////////////////////////////////
    // *********** UTIL METHODS ***********//
    ///////////////////////////////////////////////

    private static CoverDefinition register(String id, CoverDefinition.CoverBehaviourProvider behaviorCreator) {
        return register(id, behaviorCreator, () -> () -> new SimpleCoverRenderer(gregitskycore.id("block/cover/" + id)));
    }

    private static CoverDefinition register(String id, CoverDefinition.CoverBehaviourProvider behaviorCreator,
                                            Supplier<Supplier<ICoverRenderer>> coverRenderer) {
        return register(GTCEu.id(id), behaviorCreator, coverRenderer);
    }

    public static CoverDefinition register(ResourceLocation id, CoverDefinition.CoverBehaviourProvider behaviorCreator,
                                           Supplier<Supplier<ICoverRenderer>> coverRenderer) {
        var definition = new CoverDefinition(id, behaviorCreator, coverRenderer);
        GTRegistries.COVERS.register(definition.getId(), definition);
        return definition;
    }

    public static void init() {
        if (INFINITE_COBBLESTONE == null) {
            INFINITE_COBBLESTONE = register("infinite_cobblestone_cover", InfiniteCobblestoneCover::new);
        }
    }
}
