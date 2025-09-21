package com.devdyna.geodejei.compat.jei;

import com.devdyna.geodejei.utils.x;

import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

@SuppressWarnings("null")
public class SimpleIcon {

    public static IDrawable of(IGuiHelper guiHelper, Item item) {
        return guiHelper.createDrawableItemStack(x.item(item));
    }

    // TODO dont work , require to investigate why
    public static IDrawable of(IGuiHelper guiHelper, ResourceLocation rl, int x, int y) {
        return new IDrawable() {

            @Override
            public int getWidth() {
                return x;
            }

            @Override
            public int getHeight() {
                return y;
            }

            @Override
            public void draw(GuiGraphics guiGraphics, int xOffset, int yOffset) {
                guiGraphics.blitSprite(rl, 0, 0, x, y);
            }

        };
    }

}
