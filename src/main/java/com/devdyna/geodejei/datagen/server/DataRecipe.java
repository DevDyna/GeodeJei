package com.devdyna.geodejei.datagen.server;

import static com.devdyna.geodejei.Main.ID;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.devdyna.geodejei.init.recipe.BuddingRecipeBuilder;
import com.devdyna.geodejei.init.recipe.ItemTags;
import com.devdyna.geodejei.utils.x;
import com.direwolf20.justdirethings.JustDireThings;
import com.direwolf20.justdirethings.setup.Registration;
import com.glodblock.github.extendedae.common.EAESingletons;
import com.shynieke.geore.Reference;
import com.shynieke.geore.registry.GeOreRegistry;

import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.AEItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import xyz.milosworks.phasoritenetworks.init.PNBlocks;
import xyz.milosworks.phasoritenetworks.init.PNItems;
import appeng.core.AppEng;
import com.glodblock.github.extendedae.ExtendedAE;
import xyz.milosworks.phasoritenetworks.PhasoriteNetworks;

@SuppressWarnings("null")
public class DataRecipe extends RecipeProvider {

        public DataRecipe(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
                super(output, completableFuture);
        }

        @Override
        protected void buildRecipes(RecipeOutput c) {

                BuddingRecipeBuilder.of()
                                .setBudding(x.ingredient(ItemTags.AMETHYST_BUDDINGS))
                                .setClusters(List.of(
                                                Items.AMETHYST_CLUSTER,
                                                Items.LARGE_AMETHYST_BUD,
                                                Items.MEDIUM_AMETHYST_BUD,
                                                Items.SMALL_AMETHYST_BUD))
                                .setBlockDrop(List.of(Items.AMETHYST_SHARD))
                                .group(ID)
                                .unlockedBy()
                                .save(c, "minecraft/amethyst");

                GeOreRegistry.getGeOres().forEach(b -> BuddingRecipeBuilder.of()
                                .setBudding(x.ingredient(x.item(b.getBudding())))
                                .setClusters(List.of(
                                                b.getCluster(),
                                                b.getLargeBud(),
                                                b.getMediumBud(),
                                                b.getSmallBud()))
                                .setBlockDrop(List.of(b.getShard()))
                                .group(ID)
                                .unlockedBy()
                                .save(c, "/" + b.getName(), Reference.MOD_ID));

                BuddingRecipeBuilder.of()
                                .setBudding(x.ingredient(ItemTags.CERTUS_BUDDINGS))
                                .setClusters(List.of(
                                                AEBlocks.QUARTZ_CLUSTER.asItem(),
                                                AEBlocks.LARGE_QUARTZ_BUD.asItem(),
                                                AEBlocks.MEDIUM_QUARTZ_BUD.asItem(),
                                                AEBlocks.SMALL_QUARTZ_BUD.asItem()))
                                .setBlockDrop(List.of(AEItems.CERTUS_QUARTZ_CRYSTAL.asItem(),
                                                AEItems.CERTUS_QUARTZ_DUST.asItem()))
                                .group(ID)
                                .unlockedBy()
                                .save(c, "/certus", AppEng.MOD_ID);

                BuddingRecipeBuilder.of()
                                .setBudding(x.ingredient(ItemTags.ENTRO_BUDDINGS))
                                .setClusters(List.of(
                                                EAESingletons.ENTRO_CLUSTER.asItem(),
                                                EAESingletons.ENTRO_BUD_LARGE.asItem(),
                                                EAESingletons.ENTRO_BUD_MEDIUM.asItem(),
                                                EAESingletons.ENTRO_BUD_SMALL.asItem()))
                                .setBlockDrop(List.of(
                                                EAESingletons.ENTRO_CRYSTAL.asItem(),
                                                EAESingletons.ENTRO_SHARD.asItem()))
                                .group(ID)
                                .unlockedBy()
                                .save(c, "/entro" , ExtendedAE.MODID);

                BuddingRecipeBuilder.of()
                                .setBudding(x.ingredient(ItemTags.PHASORITE_BUDDINGS))
                                .setClusters(List.of(
                                                PNBlocks.INSTANCE.getPHASORITE_CLUSTER().asItem(),
                                                PNBlocks.INSTANCE.getLARGE_PHASORITE_BUD().asItem(),
                                                PNBlocks.INSTANCE.getMEDIUM_PHASORITE_BUD().asItem(),
                                                PNBlocks.INSTANCE.getSMALL_PHASORITE_BUD().asItem()))
                                .setBlockDrop(List.of(
                                                PNItems.INSTANCE.getCHARGED_PHASORITE_CRYSTAL().asItem(),
                                                PNItems.INSTANCE.getPHASORITE_CRYSTAL().asItem(),
                                                PNItems.INSTANCE.getPHASORITE_DUST().asItem()

                                ))
                                .group(ID)
                                .unlockedBy()
                                .save(c, "/phasorite" , PhasoriteNetworks.ID);

                BuddingRecipeBuilder.of()
                                .setBudding(x.ingredient(ItemTags.TIME_BUDDINGS))
                                .setClusters(List.of(
                                                Registration.TimeCrystalCluster,
                                                Registration.TimeCrystalCluster_Large,
                                                Registration.TimeCrystalCluster_Medium,
                                                Registration.TimeCrystalCluster_Small))
                                .setBlockDrop(List.of(
                                                Registration.TimeCrystal))
                                .group(ID)
                                .unlockedBy()
                                .save(c, "/time" , JustDireThings.MODID);

        }

}