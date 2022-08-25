package com.github.vfyjxf.recipegraphs.gui.widget.graph;

import com.github.vfyjxf.recipegraphs.api.gui.widget.IGraphContentNode;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.item.ItemStack;

public class ItemContentNode extends AbstractGraphNode implements IGraphContentNode<ItemStack> {

    private final ItemStack content;

    public ItemContentNode(int posX, int posY, int width, int height, String nodeName, ItemStack content) {
        super(posX, posY, width, height, nodeName);
        this.content = content;
    }

    public ItemContentNode(int posX, int posY, int width, int height, ItemStack content) {
        super(posX, posY, width, height);
        this.content = content;
    }

    @Override
    public ItemStack getContent() {
        return content;
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY) {

    }

}
