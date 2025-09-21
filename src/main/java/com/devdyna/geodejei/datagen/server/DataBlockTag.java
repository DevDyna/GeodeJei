package com.devdyna.geodejei.datagen.server;

import static com.devdyna.geodejei.Main.ID;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

@SuppressWarnings("null")

public class DataBlockTag extends BlockTagsProvider {

    public DataBlockTag(PackOutput o, CompletableFuture<Provider> l, ExistingFileHelper f) {
        super(o, l, ID, f);
    }

    @Override
    protected void addTags(Provider p) {
        // tag(BlockTag.LEAVES)
        //         .addTag(BlockTags.LEAVES);

    }

}