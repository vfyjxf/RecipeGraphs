package com.github.vfyjxf.recipegraphs.api.ingredients;

import java.util.List;

public interface IIngredientList<T> extends IGraphContent<T> {

    List<IGraphIngredient<T>> getIngredients();



}
