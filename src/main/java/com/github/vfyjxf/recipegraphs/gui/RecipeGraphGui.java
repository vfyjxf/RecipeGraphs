package com.github.vfyjxf.recipegraphs.gui;

import com.github.vfyjxf.recipegraphs.elk.ELKUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import mezz.jei.gui.recipes.RecipeLayout;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TextComponent;
import org.eclipse.elk.graph.ElkNode;
import org.jetbrains.annotations.NotNull;

public class RecipeGraphGui extends Screen {

    private Screen parentScreen;

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

    }

    public void resetWidget() {

    }


    public void displayGraph(RecipeLayout<?> recipeLayout) {

    }

    private void open() {
        if (minecraft != null) {
            if (!isOpen()) {
                parentScreen = minecraft.screen;
            }
            minecraft.setScreen(this);
        }
    }

    public boolean isOpen() {
        return minecraft != null && minecraft.screen == this;
    }

    @Override
    public void onClose() {
        if (isOpen() && minecraft != null) {
            minecraft.setScreen(parentScreen);
            parentScreen = null;
            return;
        }
        super.onClose();
    }

}
