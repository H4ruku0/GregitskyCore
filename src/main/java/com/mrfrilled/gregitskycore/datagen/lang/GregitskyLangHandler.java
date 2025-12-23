package com.mrfrilled.gregitskycore.datagen.lang;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class GregitskyLangHandler {

    public static void init(RegistrateLangProvider provider) {}

    protected static void multiLang(RegistrateLangProvider provider, String key, String... values) {
        for (var i = 0; i < values.length; i++) {
            provider.add(getSubKey(key, i), values[i]);
        }
    }

    protected static String getSubKey(String key, int index) {
        return key + "." + index;
    }
}
