package com.github.vfyjxf.recipegraphs.gui.widget.graph;

import com.github.vfyjxf.recipegraphs.api.gui.texture.IGuiTexture;
import com.github.vfyjxf.recipegraphs.api.gui.widget.IGraphListNode;
import com.github.vfyjxf.recipegraphs.gui.widget.CycleTimer;
import com.github.vfyjxf.recipegraphs.jei.RecipeGraphsPlugin;
import com.mojang.blaze3d.vertex.PoseStack;
import mezz.jei.api.ingredients.IIngredientRenderer;
import mezz.jei.api.runtime.IIngredientManager;
import org.eclipse.elk.graph.ElkNode;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A special ListNode that can hold many types of ingredient.
 */
@SuppressWarnings("rawtypes")
public class MixedGraphListNode extends AbstractGraphNode implements IGraphListNode {

    private final IIngredientManager ingredientManager = RecipeGraphsPlugin.ingredientManager;
    private final Map<Class<?>, IIngredientRenderer> rendererMap = new HashMap<>();
    private final int cycleOffset = (int) ((Math.random() * 10000) % Integer.MAX_VALUE);
    private final CycleTimer cycleTimer = new CycleTimer(cycleOffset);
    private List<?> contents;
    protected boolean isFocus;

    public MixedGraphListNode(ElkNode elkGraph, int width, int height, String nodeName, IGuiTexture background, List<?> contents) {
        super(elkGraph, width, height, nodeName, background);
        this.contents = contents;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void render(@NotNull PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        Object content = getContent();
        IIngredientRenderer renderer = rendererMap.get(content.getClass());
        if (renderer == null) {
            renderer = ingredientManager.getIngredientRenderer(content);
            rendererMap.put(content.getClass(), renderer);
        }
        poseStack.pushPose();
        {
            poseStack.translate(this.posX, this.posY, 0);
            renderer.render(poseStack, content);
        }
        poseStack.popPose();

    }

    @Override
    public Object getContent() {
        return cycleTimer.getCycledContent(contents);
    }

    @Override
    public boolean isFocus() {
        return isFocus;
    }

    @Override
    public void setFocus(boolean isFocus) {
        this.isFocus = isFocus;
    }

    @Override
    public List<?> getContents() {
        return contents;
    }

    @Override
    public void setContents(@NotNull List contents) {
        this.contents = contents;
    }

}
