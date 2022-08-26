package com.github.vfyjxf.recipegraphs.gui;

import com.github.vfyjxf.recipegraphs.api.gui.IGraphFactory;
import com.github.vfyjxf.recipegraphs.api.gui.texture.IGuiTexture;
import com.github.vfyjxf.recipegraphs.api.gui.widget.IGraphContentNode;
import com.github.vfyjxf.recipegraphs.api.gui.widget.IGraphListNode;
import com.github.vfyjxf.recipegraphs.gui.widget.graph.*;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.ingredients.IIngredientHelper;
import mezz.jei.api.ingredients.IIngredientRenderer;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import org.eclipse.elk.graph.ElkNode;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class GraphFactory implements IGraphFactory {

    private final IIngredientManager ingredientManager;

    public GraphFactory(IIngredientManager ingredientManager) {
        this.ingredientManager = ingredientManager;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> @NotNull IGraphContentNode<T> createContentNode(@NotNull ElkNode elkGraph, int width, int height, @NotNull String nodeName, @NotNull IGuiTexture background, @NotNull T content) {
        if (content instanceof ItemStack itemStack) {
            return (IGraphContentNode<T>) new ItemContentNode(elkGraph, width, height, nodeName, background, itemStack);
        } else if (content instanceof FluidStack fluidStack) {
            return (IGraphContentNode<T>) new FluidContentNode(elkGraph, width, height, nodeName, background, fluidStack);
        }
        return new ContentNode(elkGraph, width, height, nodeName, background, content);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> @NotNull IGraphListNode<T> createListNode(@NotNull ElkNode elkGraph, int width, int height, @NotNull String nodeName, @NotNull IGuiTexture background, @NotNull List<T> contents, @NotNull IIngredientType<T> ingredientType) {

        if (ingredientType == VanillaTypes.ITEM_STACK){
            return (IGraphListNode<T>) new ItemContentListNode(elkGraph,width,height,nodeName,background,(List<ItemStack>) contents);
        }else if (ingredientType == ForgeTypes.FLUID_STACK){
            return (IGraphListNode<T>) new FluidContentListNode(elkGraph,width,height,nodeName,background,(List<FluidStack>) contents);
        }
        IIngredientRenderer<T> ingredientRenderer = ingredientManager.getIngredientRenderer(ingredientType);
        IIngredientHelper<T> ingredientHelper = ingredientManager.getIngredientHelper(ingredientType);
        return new ContentListNode<>(elkGraph, width, height, nodeName, background, contents, ingredientRenderer, ingredientHelper);
    }

    @Override
    public @NotNull IGraphListNode createMixedListNode(@NotNull ElkNode elkGraph, int width, int height, @NotNull String nodeName, @NotNull IGuiTexture background, List<?> contents) {
        return new MixedGraphListNode(elkGraph, width, height, nodeName, background, contents);
    }
}
