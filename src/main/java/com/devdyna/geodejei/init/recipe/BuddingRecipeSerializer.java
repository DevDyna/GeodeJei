package com.devdyna.geodejei.init.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class BuddingRecipeSerializer implements RecipeSerializer<BuddingRecipe> {

    public static final MapCodec<BuddingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC.fieldOf("budding").forGetter(BuddingRecipe::getBudding),
            Ingredient.LIST_CODEC_NONEMPTY.fieldOf("clusters").forGetter(BuddingRecipe::getClusters),
            Ingredient.LIST_CODEC_NONEMPTY.fieldOf("clusterdrop").forGetter(BuddingRecipe::getBlockDrops)
            ).apply(inst, BuddingRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, BuddingRecipe> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC, BuddingRecipe::getBudding,
            Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.list()), BuddingRecipe::getClusters,
            Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.list()), BuddingRecipe::getBlockDrops,
            BuddingRecipe::new);

    @Override
    public MapCodec<BuddingRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, BuddingRecipe> streamCodec() {
        return STREAM_CODEC;
    }

}
