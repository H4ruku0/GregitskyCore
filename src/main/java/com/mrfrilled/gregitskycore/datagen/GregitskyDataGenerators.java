package com.mrfrilled.gregitskycore.datagen;

import com.gregtechceu.gtceu.api.registry.registrate.SoundEntryBuilder;

import com.mrfrilled.gregitskycore.datagen.lang.GregitskyLangHandler;
import com.mrfrilled.gregitskycore.gregitskycore;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import com.tterrag.registrate.providers.ProviderType;

import static com.mrfrilled.gregitskycore.common.registry.GregitskyRegistry.REGISTRATE;

@SuppressWarnings("all")
public class GregitskyDataGenerators {

    public static void init() {
        REGISTRATE.addDataGenerator(ProviderType.LANG, GregitskyLangHandler::init);
    }

    @Mod.EventBusSubscriber(modid = gregitskycore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public class ExampleDataGenerators {

        @SubscribeEvent
        public static void gatherData(GatherDataEvent event) {
            PackOutput packOutput = event.getGenerator().getPackOutput();

            if (event.includeClient()) {
                event.getGenerator().addProvider(
                        true,
                        new SoundEntryBuilder.SoundEntryProvider(packOutput, gregitskycore.MOD_ID));
            }
        }
    }
}