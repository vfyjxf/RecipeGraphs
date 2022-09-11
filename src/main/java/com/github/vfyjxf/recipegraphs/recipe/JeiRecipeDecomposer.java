package com.github.vfyjxf.recipegraphs.recipe;

import com.github.vfyjxf.recipegraphs.api.ingredients.IGraphContent;
import com.github.vfyjxf.recipegraphs.api.recipe.IRecipeDecomposer;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class JeiRecipeDecomposer implements IRecipeDecomposer<Object> {

    @Override
    public @NotNull List<IGraphContent<?>> decomposeRecipe(@NotNull Object recipe) {
        return Collections.emptyList();
    }

    @Override
    public @NotNull List<IGraphContent<?>> decomposeRecipe(@NotNull List<IGraphContent<?>> inputs) {
        return null;
    }
}
