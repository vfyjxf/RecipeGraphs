package com.github.vfyjxf.recipegraphs.api.ingredients;

public interface IGraphContentConverter<T, V> {

    Class<T> getContext();

    IGraphIngredient<V> convert(T content, long amount, int percent);

    default IGraphIngredient<V> convert(T content, long amount) {
        return convert(content, amount, 1000);
    }

}
