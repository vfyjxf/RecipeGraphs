package com.github.vfyjxf.recipegraphs.api.gui.widget;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Widget;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface IGraphNode extends IGraphNameable , Widget {

    boolean isVisible();

    void setVisible(boolean visible);

    int getPosX();

    int getPosY();

    int getWidth();

    int getHeight();

    void setPosition(int posX, int posY);

    void setSize(int width, int height);

    IGraphNode getParent();

    List<IGraphNode> getChildren();

    IGraphNode addNode(@NotNull IGraphNode node);

    IGraphNode clearNodes();

    List<IGraphPort> getPorts();

    IGraphNode clearPorts();

    boolean isMouseOver(int mouseX, int mouseY);

    void render(@NotNull PoseStack poseStack, int mouseX, int mouseY, float partialTick);

}
