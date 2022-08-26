package com.github.vfyjxf.recipegraphs.gui.widget.graph;

import com.github.vfyjxf.recipegraphs.api.gui.texture.IGuiTexture;
import com.mojang.blaze3d.vertex.PoseStack;
import mezz.jei.api.ingredients.IIngredientHelper;
import mezz.jei.api.ingredients.IIngredientRenderer;
import org.eclipse.elk.graph.ElkNode;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * A generic ContentNode to store which ingredient are not vanilla,it relies on Jei's api driver.
 */
public class ContentListNode<T> extends AbstractGraphListNode<T> {

    private final IIngredientRenderer<T> ingredientRenderer;
    private final IIngredientHelper<T> ingredientHelper;

    public ContentListNode(ElkNode elkGraph, int width, int height, String nodeName, IGuiTexture background, List<T> contents, IIngredientRenderer<T> ingredientRenderer, IIngredientHelper<T> ingredientHelper) {
        super(elkGraph, width, height, nodeName, background, contents);
        this.ingredientRenderer = ingredientRenderer;
        this.ingredientHelper = ingredientHelper;
    }

    @Override
    public void render(@NotNull PoseStack poseStack, int mouseX, int mouseY, float partialTick) {

    }

}
