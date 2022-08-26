package com.github.vfyjxf.recipegraphs.gui.widget.graph;

import com.github.vfyjxf.recipegraphs.api.gui.texture.IGuiTexture;
import com.github.vfyjxf.recipegraphs.api.gui.widget.IGraphContentNode;
import com.github.vfyjxf.recipegraphs.jei.RecipeGraphsPlugin;
import com.mojang.blaze3d.vertex.PoseStack;
import mezz.jei.api.ingredients.IIngredientRenderer;
import org.eclipse.elk.graph.ElkNode;
import org.jetbrains.annotations.NotNull;

public class ContentNode extends AbstractGraphNode implements IGraphContentNode {

    private final Object content;
    private final IIngredientRenderer<?> ingredientRenderer;

    public ContentNode(ElkNode elkGraph, int width, int height, String nodeName, IGuiTexture background, Object content) {
        super(elkGraph, width, height, nodeName, background);
        this.content = content;
        this.ingredientRenderer = RecipeGraphsPlugin.ingredientManager.getIngredientRenderer(content);
    }

    @Override
    public Object getContent() {
        return content;
    }

    @Override
    public void render(@NotNull PoseStack poseStack, int mouseX, int mouseY, float partialTick) {

    }

}
