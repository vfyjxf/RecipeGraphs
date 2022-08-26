package com.github.vfyjxf.recipegraphs.gui.widget.graph;

import com.github.vfyjxf.recipegraphs.api.gui.texture.IGuiTexture;
import com.github.vfyjxf.recipegraphs.api.gui.widget.IGraphNode;
import com.github.vfyjxf.recipegraphs.api.gui.widget.IGraphNodeGroup;
import com.mojang.blaze3d.vertex.PoseStack;
import org.eclipse.elk.graph.ElkNode;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GraphNodeGroup extends AbstractGraphNode implements IGraphNodeGroup {

    protected final List<IGraphNode> groupNodes;

    public GraphNodeGroup(ElkNode elkGraph, int width, int height, String nodeName, IGuiTexture background) {
        super(elkGraph, width, height, nodeName, background);
        this.groupNodes = new ArrayList<>();
    }

    @Override
    public void render(@NotNull PoseStack poseStack, int mouseX, int mouseY,float partialTick) {
        for (IGraphNode node : groupNodes) {
            node.render(poseStack, mouseX, mouseY,partialTick);
        }
    }

    @Override
    public List<IGraphNode> getGroupNode() {
        return groupNodes;
    }

    @Override
    public void addToGroup(@NotNull IGraphNode node) {
        if (node instanceof IGraphNodeGroup group) {
            groupNodes.addAll(group.getGroupNode());
        } else {
            groupNodes.add(node);
        }
    }

}
