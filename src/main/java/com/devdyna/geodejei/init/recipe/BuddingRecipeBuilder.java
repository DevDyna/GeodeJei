package com.devdyna.geodejei.init.recipe;

import static com.devdyna.geodejei.Main.ID;

import java.util.*;

import javax.annotation.Nullable;

import com.devdyna.geodejei.utils.DataGenUtil;
import com.devdyna.geodejei.utils.x;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

@SuppressWarnings("null")
public class BuddingRecipeBuilder implements RecipeBuilder {

    private final Map<String, Criterion<?>> criteria;

    private Ingredient budding;
    private List<Ingredient> clusters;
    private List<Ingredient> blockDrops;

    public BuddingRecipeBuilder() {
        this.criteria = new LinkedHashMap<String, Criterion<?>>();
    }

    public static BuddingRecipeBuilder of() {
        return new BuddingRecipeBuilder();
    }

    public BuddingRecipeBuilder setBudding(Ingredient i) {
        this.budding = i;
        return this;
    }

    private List<Ingredient> universalInput(List<?> l) {
        List<Ingredient> ingredients = new ArrayList<>();
        for (Object o : l) {
            if (o instanceof Item item)
                ingredients.add(x.ingredient(item));
            else if (o instanceof Block b)
                ingredients.add(x.ingredient(x.item(b)));
            else if (o instanceof DeferredHolder<?, ?> holder) {
                Object val = holder.value();
                if (val instanceof Item it)
                    ingredients.add(x.ingredient(it));

                if (val instanceof Block b)
                    ingredients.add(x.ingredient(x.item(b)));

            }
        }

        if (ingredients.isEmpty())
            throw new IllegalStateException("Invalid List "+l.toString());

        return ingredients;
    }

    public BuddingRecipeBuilder setClusters(List<?> i) {
        this.clusters = universalInput(i);
        return this;
    }

    public BuddingRecipeBuilder setBlockDrop(List<?> i) {
        this.blockDrops = universalInput(i);
        return this;
    }

    @Override
    public Item getResult() {
        return Items.AIR;
    }

    @Override
    public BuddingRecipeBuilder group(@Nullable String arg0) {
        return this;
    }

    public BuddingRecipeBuilder unlockedBy() {
        return unlockedBy(ID, InventoryChangeTrigger.TriggerInstance
                .hasItems(this.budding.getItems()[0].getItem()));
    }

    public BuddingRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    public void save(RecipeOutput recipeOutput, String extra) {
        this.save(recipeOutput, x.rl("jei/geode/" + extra));
    }

    public void save(RecipeOutput recipeOutput, String extra, String modid) {
        this.save(recipeOutput.withConditions(DataGenUtil.isModLoaded(modid)), x.rl("jei/geode/" +modid+ extra));
    }

    // @Override
    // public void save(RecipeOutput recipeOutput) {
    // save(recipeOutput, "");
    // }

    public void save(RecipeOutput pRecipeOutput, ResourceLocation pId) {
        if (this.criteria.isEmpty())
            throw new IllegalStateException("Missing/Null Criteria " + String.valueOf(pId));
        Advancement.Builder advancement = pRecipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pId))
                .rewards(AdvancementRewards.Builder.recipe(pId))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancement::addCriterion);
        BuddingRecipe shapelessrecipe = new BuddingRecipe(budding, clusters, blockDrops);
        pRecipeOutput.accept(pId, shapelessrecipe,
                advancement.build(pId.withPrefix("recipes/" + RecipeCategory.MISC.getFolderName() + "/")));
    }

}
