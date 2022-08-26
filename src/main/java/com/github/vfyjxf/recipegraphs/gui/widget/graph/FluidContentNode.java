package com.github.vfyjxf.recipegraphs.gui.widget.graph;

import com.github.vfyjxf.recipegraphs.api.gui.texture.IGuiTexture;
import com.github.vfyjxf.recipegraphs.api.gui.widget.IGraphContentNode;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraftforge.fluids.FluidStack;
import org.eclipse.elk.graph.ElkNode;
import org.jetbrains.annotations.NotNull;

public class FluidContentNode extends AbstractGraphNode implements IGraphContentNode<FluidStack> {

    private final FluidStack content;

    public FluidContentNode(ElkNode elkGraph, int width, int height, String nodeName, IGuiTexture background, FluidStack content) {
        super(elkGraph, width, height, nodeName, background);
        this.content = content;
    }

    @Override
    public FluidStack getContent() {
        return content;
    }

    @Override
    public void render(@NotNull PoseStack poseStack, int mouseX, int mouseY, float partialTick) {

    }

}
