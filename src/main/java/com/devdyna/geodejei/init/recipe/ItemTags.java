package com.devdyna.geodejei.init.recipe;

import static com.devdyna.geodejei.Main.ID;

import com.devdyna.justdynathings.registry.Material;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ItemTags {
    public static final TagKey<Item> AMETHYST_BUDDINGS = Material.tagItem(ID, "buddingtype/amethyst");
    public static final TagKey<Item> TIME_BUDDINGS = Material.tagItem(ID, "buddingtype/time");
    public static final TagKey<Item> PHASORITE_BUDDINGS = Material.tagItem(ID, "buddingtype/phasorite");
    public static final TagKey<Item> CERTUS_BUDDINGS = Material.tagItem(ID, "buddingtype/certus");
    public static final TagKey<Item> ENTRO_BUDDINGS = Material.tagItem(ID, "buddingtype/entro");
}
