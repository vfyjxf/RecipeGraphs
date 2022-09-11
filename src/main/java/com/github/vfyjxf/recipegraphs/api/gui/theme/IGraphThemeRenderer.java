package com.github.vfyjxf.recipegraphs.api.gui.theme;

import com.github.vfyjxf.recipegraphs.api.gui.widget.IGraphButton;
import com.github.vfyjxf.recipegraphs.api.gui.widget.IGraphNode;
import com.mojang.blaze3d.vertex.PoseStack;

/**
 * This Renderer is only responsible for rendering the
 * background and the link lines between Nodes and such things.
 */
public interface IGraphThemeRenderer {

    void renderLink(PoseStack poseStack, int mouseX, int mouseY);

    void renderLinks(PoseStack poseStack, int mouseX, int mouseY);

    void renderNode(IGraphNode node, PoseStack poseStack, int mouseX, int mouseY);

    void renderButton(IGraphButton button, PoseStack poseStack, int mouseX, int mouseY);

}
