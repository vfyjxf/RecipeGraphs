package com.github.vfyjxf.recipegraphs.gui.widget.graph;

import com.github.vfyjxf.recipegraphs.api.gui.widget.IGraphContentNode;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraftforge.fluids.FluidStack;

public class FluidContentNode extends AbstractGraphNode implements IGraphContentNode<FluidStack> {

    private final FluidStack content;

    public FluidContentNode(int posX, int posY, int width, int height, String nodeName, FluidStack content) {
        super(posX, posY, width, height, nodeName);
        this.content = content;
    }

    public FluidContentNode(int posX, int posY, int width, int height, FluidStack content) {
        super(posX, posY, width, height);
        this.content = content;
    }

    @Override
    public FluidStack getContent() {
        return content;
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY) {

    }

}
