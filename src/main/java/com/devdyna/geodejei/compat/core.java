package com.devdyna.geodejei.compat;

import net.neoforged.fml.ModList;

public class core {

    public static void registerCompat() {
        if (checkMod("modname")){}
    }

    public static boolean checkMod(String s) {
        return ModList.get().isLoaded(s);
    }
}