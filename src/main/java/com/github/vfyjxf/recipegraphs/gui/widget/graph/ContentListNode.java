package com.github.vfyjxf.recipegraphs.gui.widget.graph;

import com.mojang.blaze3d.vertex.PoseStack;
import mezz.jei.api.ingredients.IIngredientHelper;
import mezz.jei.api.ingredients.IIngredientRenderer;

import java.util.List;

/**
 * A generic ContentNode to store which ingredient are not vanilla,it relies on Jei's api driver.
 */
public class ContentListNode<T> extends AbstractGraphListNode<T> {

    private final IIngredientRenderer<T> ingredientRenderer;
    private final IIngredientHelper<T> ingredientHelper;

    public ContentListNode(int posX, int posY, int width, int height, String nodeName, List<T> contents, IIngredientRenderer<T> ingredientRenderer, IIngredientHelper<T> ingredientHelper) {
        super(posX, posY, width, height, nodeName, contents);
        this.ingredientRenderer = ingredientRenderer;
        this.ingredientHelper = ingredientHelper;
    }

    public ContentListNode(int posX, int posY, int width, int height, List<T> contents, IIngredientRenderer<T> ingredientRenderer, IIngredientHelper<T> ingredientHelper) {
        super(posX, posY, width, height, contents);
        this.ingredientRenderer = ingredientRenderer;
        this.ingredientHelper = ingredientHelper;
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY) {

    }

}
