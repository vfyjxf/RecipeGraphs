package com.github.vfyjxf.recipegraphs.api.gui.texture;

import com.mojang.blaze3d.vertex.PoseStack;

public interface IGuiTexture {

    int getWidth();

    int getHeight();

    default void draw(PoseStack poseStack) {
        draw(poseStack, 0, 0);
    }

    void draw(PoseStack poseStack, int xOffset, int yOffset);

}
