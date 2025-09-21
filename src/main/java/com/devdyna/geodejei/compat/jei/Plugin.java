package com.devdyna.geodejei.compat.jei;

import com.devdyna.geodejei.init.recipe.zRecipeTypes;
import com.devdyna.geodejei.utils.x;

import mezz.jei.api.*;
import mezz.jei.api.registration.*;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

@SuppressWarnings({ "null" })
@JeiPlugin
public class Plugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return x.rl("jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration event) {

        var guiHelper = event.getJeiHelpers().getGuiHelper();

        event.addRecipeCategories(
                new BuddingRecipeCategory(guiHelper));
    }

    @Override
    public void registerRecipes(IRecipeRegistration event) {

        RecipeManager recipes = Minecraft.getInstance().level.getRecipeManager();

        event.addRecipes(BuddingRecipeCategory.TYPE, recipes.getAllRecipesFor(zRecipeTypes.GEODE_JEI_RECIPE.getType())
                .stream().map(RecipeHolder::value).toList());

    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration event) {

    }

}
