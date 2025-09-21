package com.devdyna.geodejei.init.recipe;

import java.util.List;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

@SuppressWarnings("null")
public class BuddingRecipe implements Recipe<MonoItemInput> {

    private final Ingredient budding;
    private final List<Ingredient> clusters;
    private final List<Ingredient> blockDrops;

    public BuddingRecipe(Ingredient budding, List<Ingredient> clusters, List<Ingredient> blockDrops) {
        this.blockDrops = blockDrops;
        this.budding = budding;
        this.clusters = clusters;
    }

    public boolean matches(MonoItemInput r, Level l) {
        return true;
    }

    public ItemStack assemble(MonoItemInput i, HolderLookup.Provider r) {
        return ItemStack.EMPTY;
    }

    public boolean canCraftInDimensions(int xz, int y) {
        return false;
    }

    public RecipeType<?> getType() {
        return zRecipeTypes.GEODE_JEI_RECIPE.getType();
    }

    public ItemStack getToastSymbol() {
        return new ItemStack(Blocks.AMETHYST_CLUSTER);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return zRecipeTypes.GEODE_JEI_RECIPE.getSerializer();
    }

    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.copyOf(List.of(this.budding));
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registryAccess) {
        return this.budding.getItems()[0];
    }

    public Ingredient getBudding() {
        return budding;
    }

    public List<Ingredient> getBlockDrops() {
        return blockDrops;
    }

    public List<Ingredient> getClusters() {
        return clusters;
    }
}
