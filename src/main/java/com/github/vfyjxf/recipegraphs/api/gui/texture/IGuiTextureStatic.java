package com.github.vfyjxf.recipegraphs.api.gui.texture;

import com.mojang.blaze3d.vertex.PoseStack;

public interface IGuiTextureStatic extends IGuiTexture {

    void draw(PoseStack stack, int xOffset, int yOffset, int maskTop, int maskBottom, int maskLeft, int maskRight);

}
