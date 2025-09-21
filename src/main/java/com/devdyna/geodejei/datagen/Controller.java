package com.devdyna.geodejei.datagen;

import static com.devdyna.geodejei.Main.ID;

import java.util.concurrent.CompletableFuture;

import net.minecraft.data.PackOutput;
import com.devdyna.geodejei.datagen.client.DataLang;
import com.devdyna.geodejei.datagen.server.DataBlockTag;
import com.devdyna.geodejei.datagen.server.DataItemTag;
import com.devdyna.geodejei.datagen.server.DataRecipe;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = ID)
public class Controller {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent e) {
        DataGenerator g = e.getGenerator();
        PackOutput po = g.getPackOutput();
        ExistingFileHelper f = e.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> pr = e.getLookupProvider();

        // client
        providerGen(e, g, new DataLang(po));

        // server
        DataBlockTag blocktag = new DataBlockTag(po, pr, f);
        providerGen(e, g, blocktag);
        providerGen(e, g, new DataItemTag(po, pr,blocktag.contentsGetter()));
        providerGen(e, g, new DataRecipe(po, pr));

    }

    private static <T extends DataProvider> void providerGen(GatherDataEvent e, DataGenerator g, T f) {
        g.addProvider(e.includeClient(), f);
    }

}
