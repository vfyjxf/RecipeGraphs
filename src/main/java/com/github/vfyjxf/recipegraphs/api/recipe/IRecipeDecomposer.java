package com.github.vfyjxf.recipegraphs.api.recipe;

import com.github.vfyjxf.recipegraphs.api.ingredients.IGraphContent;

import java.util.List;

/**
 *A decomposer that breaks down a recipe or incoming recipe components into the lowest level materials.
 */
public interface IRecipeDecomposer<R> {

    List<IGraphContent<?>> decomposeRecipe(R recipe);

    List<IGraphContent<?>> decomposeRecipe(List<IGraphContent<?>> inputs);

}
