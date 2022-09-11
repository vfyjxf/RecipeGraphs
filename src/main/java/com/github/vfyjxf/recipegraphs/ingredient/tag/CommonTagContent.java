package com.github.vfyjxf.recipegraphs.ingredient.tag;

import com.github.vfyjxf.recipegraphs.api.ingredients.IGraphTag;

public class CommonTagContent<T> extends AbstractTagContent<T> {

    private final TagContext<T> tagContext;

    public CommonTagContent(TagContext<T> tagContext, long amount, int percent) {
        super(tagContext.tagKey(), amount, percent);
        this.tagContext = tagContext;
    }

    @Override
    public <C extends IGraphTag<T>> boolean merge(C c1, C c2) {
        return false;
    }

    @Override
    public <C extends IGraphTag<T>> boolean mergeFuzzy(C c1, C c2) {
        return false;
    }
}
