package com.github.vfyjxf.recipegraphs.api.recipe;

import java.util.Collection;
import java.util.Map;

public interface IRecipeParser<R, T> {

    Class<R> getRecipeClass();

    <V> Map<RecipeRole, Collection<T>> parseRecipe(R recipe);

    default boolean isChanceRecipe(R recipe){
        return false;
    }

    default <V> Map<RecipeRole, Collection<ChanceIngredient<T>>> parseChanceRecipe(R recipe) {
        return Map.of();
    }

    record ChanceIngredient<T>(T ingredient, int percent) {
    }

}
