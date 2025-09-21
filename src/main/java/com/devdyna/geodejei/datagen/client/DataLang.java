package com.devdyna.geodejei.datagen.client;

import static com.devdyna.geodejei.Main.*;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class DataLang extends LanguageProvider {

    public DataLang(PackOutput o) {
        super(o, ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(CATEGORY_TRASLKEY, "Geode Jei Category");
    }

}
