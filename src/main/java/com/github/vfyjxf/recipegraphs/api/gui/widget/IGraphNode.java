package com.github.vfyjxf.recipegraphs.api.gui.widget;

import com.mojang.blaze3d.vertex.PoseStack;

import java.util.List;

public interface IGraphNode extends IGraphNameable {

    int getPosX();

    int getPosY();

    int getWidth();

    int getHeight();

    void setPosition(int posX, int posY);

    void setSize(int width, int height);

    IGraphNode getParent();

    List<IGraphNode> getChildren();

    void render(PoseStack poseStack, int mouseX, int mouseY);

}
