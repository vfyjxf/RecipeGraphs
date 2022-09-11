package com.github.vfyjxf.recipegraphs.api.recipe;

import org.jetbrains.annotations.Nullable;

public interface IRecipeParserManager {

    void registerParser(IRecipeParser<?,?> recipeParser);

    @Nullable
    <R> IRecipeParser<R,?> getRecipeParser(R recipe);

    @Nullable
    <R> IRecipeParser<R,?> getRecipeParser(Class<R> recipeClass);

}
