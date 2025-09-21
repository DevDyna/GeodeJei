package com.devdyna.geodejei.init.recipe;

import static com.devdyna.geodejei.Main.ID;

import com.devdyna.geodejei.api.zRecipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class zRecipeTypes {
        // ------------------------------------------------------------------------------------------------------------------------------------//
        public static void register(IEventBus bus) {
                SERIALIZERS.register(bus);
                TYPES.register(bus);
        }

        // ------------------------------------------------------------------------------------------------------------------------------------//
        public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister
                        .create(Registries.RECIPE_SERIALIZER, ID);
        public static final DeferredRegister<RecipeType<?>> TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, ID);
        // ------------------------------------------------------------------------------------------------------------------------------------//
        public static final zRecipe<BuddingRecipe> GEODE_JEI_RECIPE = new zRecipe<BuddingRecipe>(
                        "geode_jei", BuddingRecipeSerializer::new,
                        () -> new RecipeType<BuddingRecipe>() {
                                @Override
                                public String toString() {
                                        return GEODE_JEI_RECIPE.getId();
                                }
                        });

        // ------------------------------------------------------------------------------------------------------------------------------------//
}
