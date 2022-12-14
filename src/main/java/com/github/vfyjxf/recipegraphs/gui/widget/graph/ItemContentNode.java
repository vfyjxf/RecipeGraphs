package com.github.vfyjxf.recipegraphs.gui.widget.graph;

import com.github.vfyjxf.recipegraphs.api.gui.texture.IGuiTexture;
import com.github.vfyjxf.recipegraphs.api.gui.widget.IGraphContentNode;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.item.ItemStack;
import org.eclipse.elk.graph.ElkNode;
import org.jetbrains.annotations.NotNull;

public class ItemContentNode extends AbstractGraphNode implements IGraphContentNode<ItemStack> {

    private final ItemStack content;

    public ItemContentNode(ElkNode elkGraph, int width, int height, String nodeName, IGuiTexture background, ItemStack content) {
        super(elkGraph, width, height, nodeName, background);
        this.content = content;
    }

    @Override
    public ItemStack getContent() {
        return content;
    }

    @Override
    public void render(@NotNull PoseStack poseStack, int mouseX, int mouseY, float partialTick) {

    }

}
