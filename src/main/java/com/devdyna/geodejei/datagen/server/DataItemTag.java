package com.devdyna.geodejei.datagen.server;

import java.util.concurrent.CompletableFuture;

import com.devdyna.geodejei.init.recipe.ItemTags;
import com.devdyna.geodejei.utils.x;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.direwolf20.justdirethings.setup.Registration;
import com.glodblock.github.extendedae.common.EAESingletons;

import appeng.core.definitions.AEBlocks;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import xyz.milosworks.phasoritenetworks.init.PNBlocks;

@SuppressWarnings("null")

public class DataItemTag extends ItemTagsProvider {

    public DataItemTag(PackOutput o, CompletableFuture<Provider> p, CompletableFuture<TagLookup<Block>> b) {
        super(o, p, b);
    }

    @Override
    protected void addTags(Provider p) {
        tag(ItemTags.AMETHYST_BUDDINGS)
                .add(Items.BUDDING_AMETHYST)
                .addOptional(x.rl(Main.ID,x.path(zBlocks.ECHOING_BUDDING_AMETHYST.get())));

        tag(ItemTags.CERTUS_BUDDINGS)
                .add(AEBlocks.FLAWLESS_BUDDING_QUARTZ.asItem(),
                        AEBlocks.FLAWED_BUDDING_QUARTZ.asItem(),
                        AEBlocks.CHIPPED_BUDDING_QUARTZ.asItem(),
                        AEBlocks.DAMAGED_BUDDING_QUARTZ.asItem())
                .addOptional(x.rl(Main.ID,x.path(com.devdyna.justdynathings.compat.ae2.init.AE2_POWERED.get())));

        tag(ItemTags.ENTRO_BUDDINGS).add(
                EAESingletons.HALF_ENTROIZED_FLUIX_BUDDING.asItem(),
                EAESingletons.HARDLY_ENTROIZED_FLUIX_BUDDING.asItem(),
                EAESingletons.MOSTLY_ENTROIZED_FLUIX_BUDDING.asItem(),
                EAESingletons.FULLY_ENTROIZED_FLUIX_BUDDING.asItem())
                .addOptional(x.rl(Main.ID,x.path(com.devdyna.justdynathings.compat.extendedae.init.EXTENDED_POWERED.get())));

        tag(ItemTags.PHASORITE_BUDDINGS).add(
                PNBlocks.INSTANCE.getBUDDING_PHASORITE_BLOCK().asItem())
                .addOptional(x.rl(Main.ID,x.path(com.devdyna.justdynathings.compat.phasorite.init.PHASORITE_POWERED.get())));

        tag(ItemTags.TIME_BUDDINGS).add(
                Registration.TimeCrystalBuddingBlock_ITEM.get())
                .addOptional(x.rl(Main.ID,x.path(zBlocks.ECHOING_BUDDING_TIME.get())));

    }

}