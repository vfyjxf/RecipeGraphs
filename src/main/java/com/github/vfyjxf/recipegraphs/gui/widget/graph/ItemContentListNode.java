package com.github.vfyjxf.recipegraphs.gui.widget.graph;

import com.github.vfyjxf.recipegraphs.api.gui.texture.IGuiTexture;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.item.ItemStack;
import org.eclipse.elk.graph.ElkNode;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ItemContentListNode extends AbstractGraphListNode<ItemStack> {


    public ItemContentListNode(ElkNode elkGraph, int width, int height, String nodeName, IGuiTexture background, List<ItemStack> contents) {
        super(elkGraph, width, height, nodeName, background, contents);
    }

    @Override
    public void render(@NotNull PoseStack poseStack, int mouseX, int mouseY, float partialTick) {

    }

}
