package com.github.vfyjxf.recipegraphs.gui.widget.graph;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;

public class FluidContentListNode extends AbstractGraphListNode<FluidStack> {

    public FluidContentListNode(int posX, int posY, int width, int height, String nodeName, List<FluidStack> contents) {
        super(posX, posY, width, height, nodeName, contents);
    }

    public FluidContentListNode(int posX, int posY, int width, int height, List<FluidStack> contents) {
        super(posX, posY, width, height, contents);
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY) {

    }

}
