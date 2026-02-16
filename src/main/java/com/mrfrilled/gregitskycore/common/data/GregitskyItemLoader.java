package com.mrfrilled.gregitskycore.common.data;

import static com.mrfrilled.gregitskycore.common.registry.GregitskyRegistry.REGISTRATE;
import static com.mrfrilled.gregitskycore.gregitskycore.GREGITSKY_CREATIVE_TAB;

public class GregitskyItemLoader {

    static {
        REGISTRATE.creativeModeTab(() -> GREGITSKY_CREATIVE_TAB);
    }

    public static void init() {}
}
