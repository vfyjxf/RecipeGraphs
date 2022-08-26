package com.github.vfyjxf.recipegraphs.gui.widget.graph;

import com.github.vfyjxf.recipegraphs.api.gui.texture.IGuiTexture;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraftforge.fluids.FluidStack;
import org.eclipse.elk.graph.ElkNode;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FluidContentListNode extends AbstractGraphListNode<FluidStack> {

    public FluidContentListNode(ElkNode elkGraph, int width, int height, String nodeName, IGuiTexture background, List<FluidStack> contents) {
        super(elkGraph, width, height, nodeName, background, contents);
    }

    @Override
    public void render(@NotNull PoseStack poseStack, int mouseX, int mouseY, float partialTick) {

    }

}
