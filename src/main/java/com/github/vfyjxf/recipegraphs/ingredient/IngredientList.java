package com.github.vfyjxf.recipegraphs.ingredient;

import com.github.vfyjxf.recipegraphs.api.ingredients.IGraphContent;
import com.github.vfyjxf.recipegraphs.api.ingredients.IGraphIngredient;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class IngredientList<T> extends AbstractIngredient<Collection<T>>{

    public IngredientList(Collection<T> ingredient, long amount, int percent) {
        super(ingredient, amount, percent);
    }

    public IngredientList(IGraphIngredient<Collection<T>> graphIngredient) {
        super(graphIngredient);
    }

    @Override
    public <C extends IGraphContent<Collection<T>>> boolean merge(@NotNull C c1, @NotNull C c2) {
        return false;
    }

}
