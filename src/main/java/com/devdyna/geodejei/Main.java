package com.devdyna.geodejei;

import com.devdyna.geodejei.compat.core;
import com.devdyna.geodejei.init.recipe.zRecipeTypes;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(Main.ID)
public class Main {

    public static final String ID = "geodejei";

    public static final String CATEGORY_TRASLKEY = ID + ".jei.geode";

    public Main(IEventBus bus, ModContainer mc) {

        // new LogUtil();

        zRecipeTypes.register(bus);
        core.registerCompat();

    }
}
