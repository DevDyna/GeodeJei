package com.devdyna.geodejei.utils;

import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

public class DataGenUtil {

     public static ICondition[] isModLoaded(String modid) {
        return new ICondition[] { new ModLoadedCondition(modid) };
    }
}
