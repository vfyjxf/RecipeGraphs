package com.github.vfyjxf.recipegraphs.gui;

import com.github.vfyjxf.recipegraphs.util.ELKUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TextComponent;
import org.eclipse.elk.graph.ElkNode;
import org.jetbrains.annotations.NotNull;

public class RecipeGraphGui extends Screen {

    protected RecipeGraphGui() {
        super(new TextComponent("Recipes Data"));
    }

    @Override
    public void render(@NotNull PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    protected void init() {
        super.init();
        int guiLeft = 100;
        int guiTop =  21;
        for (ElkNode node : ELKUtil.createExampleGraph().getChildren()){
            this.addRenderableWidget(new Button((int)(guiLeft + node.getX()),(int)(guiTop + node.getY()),16,16,new TextComponent(node.getLabels().get(0).getText()),(b)->{}));
        }
    }

    public void resetWidget() {

    }
}
