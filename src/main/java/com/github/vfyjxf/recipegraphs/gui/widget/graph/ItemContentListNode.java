package com.github.vfyjxf.recipegraphs.gui.widget.graph;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class ItemContentListNode extends AbstractGraphListNode<ItemStack> {


    public ItemContentListNode(int posX, int posY, int width, int height, String nodeName, List<ItemStack> contents) {
        super(posX, posY, width, height, nodeName, contents);
    }

    public ItemContentListNode(int posX, int posY, int width, int height, List<ItemStack> contents) {
        super(posX, posY, width, height, contents);
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY) {

    }

}
