package com.github.vfyjxf.recipegraphs.api.gui;

import com.github.vfyjxf.recipegraphs.api.gui.texture.IGuiTexture;
import com.github.vfyjxf.recipegraphs.api.gui.widget.IGraphContentNode;
import com.github.vfyjxf.recipegraphs.api.gui.widget.IGraphListNode;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.ingredients.IIngredientType;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import org.eclipse.elk.graph.ElkNode;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public interface IGraphFactory {

    <T> IGraphContentNode<T> createContentNode(ElkNode elkGraph, int width, int height, String nodeName, IGuiTexture background, T content);

    default <T> IGraphContentNode<T> createContentNode(ElkNode elkGraph, int width, int height, IGuiTexture background, T content) {
        return createContentNode(elkGraph, width, height, "", background, content);
    }

    <T> IGraphListNode<T> createListNode(ElkNode elkGraph, int width, int height, String nodeName, IGuiTexture background, List<T> contents, IIngredientType<T> ingredientType);

    default <T> IGraphListNode<T> createListNode(ElkNode elkGraph, int width, int height, IGuiTexture background, List<T> contents, IIngredientType<T> ingredientType) {
        return createListNode(elkGraph, width, height, "", background, contents, ingredientType);
    }

    default IGraphListNode<ItemStack> createItemListNode(ElkNode elkGraph, int width, int height, String nodeName, IGuiTexture background, List<ItemStack> contents) {
        return createListNode(elkGraph, width, height, nodeName, background, contents, VanillaTypes.ITEM_STACK);
    }

    default IGraphListNode<ItemStack> createItemListNode(ElkNode elkGraph, int width, int height, IGuiTexture background, List<ItemStack> contents) {
        return createItemListNode(elkGraph, width, height, "", background, contents);
    }

    default IGraphListNode<FluidStack> createFluidListNode(ElkNode elkGraph, int width, int height, String nodeName, IGuiTexture background, List<FluidStack> contents) {
        return createListNode(elkGraph, width, height, nodeName, background, contents, ForgeTypes.FLUID_STACK);
    }

    default IGraphListNode<FluidStack> createFluidListNode(ElkNode elkGraph, int width, int height, IGuiTexture background, List<FluidStack> contents) {
        return createFluidListNode(elkGraph, width, height, "", background, contents);
    }

    IGraphListNode createMixedListNode(ElkNode elkGraph, int width, int height, String nodeName, IGuiTexture background, List<?> contents);

    default IGraphListNode createMixedListNode(ElkNode elkGraph, int width, int height, IGuiTexture background, List<?> contents) {
        return createMixedListNode(elkGraph, width, height, "", background, contents);
    }

}
