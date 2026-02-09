package com.mrfrilled.gregitskycore.mixin;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.crafting.RecipeManager;

import com.google.gson.JsonElement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(RecipeManager.class)
public class RecipeRemovalMixin {

    @Inject(
            method = "apply(Ljava/util/Map;Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)V",
            at = @At("HEAD"))
    private void removeRecipes(Map<ResourceLocation, JsonElement> map, ResourceManager resourceManager,
                               ProfilerFiller profiler, CallbackInfo ci) {
        /// --- AQUÍ BORRAS TUS RECETAS --- ///

        // Removing with id
        // map.remove(ResourceLocation.fromNamespaceAndPath("gtceu", "compressor/iron_plate"));

        String[] GregitskyRemovalRecipes = {
                "gtceu:electric_blast_furnace/blast_aluminium_gas",
                "gtceu:electric_blast_furnace/blast_aluminium",
                "gtceu:electric_blast_furnace/aluminium_from"
        };

        map.keySet().removeIf(resourceLocation -> {
            String fullID = resourceLocation.toString(); // Esto devuelve "modid:path"

            for (String prefix : GregitskyRemovalRecipes) {
                if (fullID.startsWith(prefix)) {
                    return true;
                }
            }
            return false;
        });
    }
}
