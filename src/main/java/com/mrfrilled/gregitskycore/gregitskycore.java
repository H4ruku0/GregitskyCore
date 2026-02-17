package com.mrfrilled.gregitskycore;

import com.mrfrilled.gregitskycore.common.data.GregitskyCovers;
import com.mrfrilled.gregitskycore.common.data.item.GregitskyItemLoader;
import com.mrfrilled.gregitskycore.common.data.item.GregitskyItems;
import com.mrfrilled.gregitskycore.common.data.GregitskyRecipeTypes;
import com.mrfrilled.gregitskycore.common.data.block.GregitskyBlocks;
import com.mrfrilled.gregitskycore.common.data.machines.GregitskyMachineUtils;
import com.mrfrilled.gregitskycore.common.data.machines.GregitskyMachines;
import com.mrfrilled.gregitskycore.common.data.machines.GregitskyMultiMachines;
import com.mrfrilled.gregitskycore.common.data.materials.GregitskyMaterials;
import com.mrfrilled.gregitskycore.datagen.GregitskyDataGenerators;
import com.mrfrilled.gregitskycore.datagen.lang.GregitskyLangHandler;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.sound.SoundEntry;
import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.util.entry.RegistryEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.mrfrilled.gregitskycore.common.registry.GregitskyRegistry.REGISTRATE;

@Mod(gregitskycore.MOD_ID)
@SuppressWarnings("removal")
public class gregitskycore {

    public static final String MOD_ID = "gregitskycore";
    public static final Logger LOGGER = LogManager.getLogger();

    static {
        REGISTRATE.addDataGenerator(ProviderType.LANG, GregitskyLangHandler::init);
    }
    public static RegistryEntry<CreativeModeTab> GREGITSKY_CREATIVE_TAB = REGISTRATE
            .defaultCreativeTab(gregitskycore.MOD_ID,
                    builder -> builder
                            .displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator(gregitskycore.MOD_ID,
                                    REGISTRATE))
                            .title(REGISTRATE.addLang("itemGroup", gregitskycore.id("creative_tab"), "GregitskyCore"))
                            .icon(GregitskyBlocks.REINFORCED_TREATED_WOOD_CASING::asStack)
                            .build())
            .register();

    public static void init() {
        GregitskyItemLoader.init();
        GregitskyBlocks.init();
    }

    public gregitskycore() {
        GregitskyDataGenerators.init();

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        GregitskyItems.register(modEventBus);

        modEventBus.addGenericListener(com.gregtechceu.gtceu.api.cover.CoverDefinition.class, this::registerCovers);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        modEventBus.addListener(this::addMaterialRegistries);
        modEventBus.addListener(this::addMaterials);
        modEventBus.addListener(this::modifyMaterials);

        modEventBus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
        modEventBus.addGenericListener(MachineDefinition.class, this::registerMachines);
        modEventBus.addGenericListener(SoundEntry.class, this::registerSounds);

        // Most other events are fired on Forge's bus.
        // If we want to use annotations to register event listeners,
        // we need to register our object like this!
        MinecraftForge.EVENT_BUS.register(this);

        REGISTRATE.registerRegistrate();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            LOGGER.info("Hello from common setup! This is *after* registries are done, so we can do this:");
            LOGGER.info("Look, I found a {}!", Items.DIAMOND);

        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("Hey, we're on Minecraft version {}!", Minecraft.getInstance().getLaunchedVersion());
    }

    /**
     * Create a ResourceLocation in the format "modid:path"
     *
     * @param path
     * @return ResourceLocation with the namespace of your mod
     */
    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    /**
     * Create a material manager for your mod using GT's API.
     * You MUST have this if you have custom materials.
     * Remember to register them not to GT's namespace, but your own.
     * 
     * @param event
     */
    private void addMaterialRegistries(MaterialRegistryEvent event) {
        GTCEuAPI.materialManager.createRegistry(gregitskycore.MOD_ID);
    }

    /**
     * You will also need this for registering custom materials
     * Call init() from your Material class(es) here
     * 
     * @param event
     */
    private void addMaterials(MaterialEvent event) {
        GregitskyMaterials.register();
        GregitskyMaterials.init();
    }

    /**
     * (Optional) Used to modify pre-existing materials from GregTech
     * 
     * @param event
     */
    private void modifyMaterials(PostMaterialEvent event) {
        // CustomMaterials.modify();
    }

    /**
     * Used to register your own new RecipeTypes.
     * Call init() from your RecipeType class(es) here
     * 
     * @param event
     */
    private void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        // CustomRecipeTypes.init();
        GregitskyRecipeTypes.init();
    }

    /**
     * Used to register your own new machines.
     * Call init() from your Machine class(es) here
     * 
     * @param event
     */
    private void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        // CustomMachines.init();
        GregitskyMachines.init();
        GregitskyMachineUtils.init();
        GregitskyMultiMachines.init();
    }

    /**
     * Registro de Covers personalizado
     */
    private void registerCovers(GTCEuAPI.RegisterEvent<ResourceLocation, com.gregtechceu.gtceu.api.cover.CoverDefinition> event) {
        GregitskyCovers.init();
    }

    /**
     * Used to register your own new sounds
     * Call init from your Sound class(es) here
     * 
     * @param event
     */
    public void registerSounds(GTCEuAPI.RegisterEvent<ResourceLocation, SoundEntry> event) {
        // CustomSounds.init();
    }
}
