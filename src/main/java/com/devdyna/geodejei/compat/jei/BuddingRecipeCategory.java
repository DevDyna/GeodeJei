package com.devdyna.geodejei.compat.jei;

import org.jetbrains.annotations.Nullable;

import com.devdyna.geodejei.Main;
import com.devdyna.geodejei.init.recipe.BuddingRecipe;
import com.devdyna.geodejei.init.recipe.zRecipeTypes;
import com.devdyna.geodejei.utils.x;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;

@SuppressWarnings("null")
public class BuddingRecipeCategory implements IRecipeCategory<BuddingRecipe> {

    private IGuiHelper helper;

    public static final RecipeType<BuddingRecipe> TYPE = new RecipeType<>(
            x.rl(zRecipeTypes.GEODE_JEI_RECIPE.getId()),
            BuddingRecipe.class);

    public BuddingRecipeCategory(IGuiHelper guiHelper) {
        this.helper = guiHelper;
    }

    @Override
    public RecipeType<BuddingRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable(Main.CATEGORY_TRASLKEY);
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return SimpleIcon.of(helper, Items.AMETHYST_CLUSTER);
    }

    @Override
    public @Nullable IDrawable getBackground() {
        return helper.createDrawable(x.rl("textures/gui/jei/geode.png"), 0, 0, 142, 78);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, BuddingRecipe recipe, IFocusGroup focuses) {

        builder.addInputSlot(3, 3).addIngredients(recipe.getBudding());

        recipe.getClusters().forEach(i -> {
            var index = recipe.getClusters().indexOf(i);
            builder.addSlot(RecipeIngredientRole.CATALYST, 45, 3 + (17 * index)).addIngredients(i);
        });

        recipe.getBlockDrops().forEach(i -> {
            var index = recipe.getBlockDrops().indexOf(i);
            builder.addOutputSlot(86 + (index % 3 * 17), 3 + (index > 2 ? 17 : 0)).addIngredients(i);
        });
    }

}
