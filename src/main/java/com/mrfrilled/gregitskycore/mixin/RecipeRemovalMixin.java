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

        // Removing multiple recipes
        String[] GregitskyRemovalRecipes = {
                // "gtceu:macerator/cobblestone",
                // "minecraft:golden_hoe"
        };

        for (String id : GregitskyRemovalRecipes) {
            // Separa modid y path
            String[] partes = id.split(":");
            if (partes.length == 2) {
                map.remove(ResourceLocation.fromNamespaceAndPath(partes[0], partes[1]));
            }
        }
    }
}
