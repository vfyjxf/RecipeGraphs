package com.github.vfyjxf.recipegraphs.api.gui.widget;

import com.mojang.blaze3d.vertex.PoseStack;

public interface IGraphButton {

    void render(PoseStack poseStack, int mouseX, int mouseY);

    boolean onMouseClicked(int mouseX, int mouseY);

}
