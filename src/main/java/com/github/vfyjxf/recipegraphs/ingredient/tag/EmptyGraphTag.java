package com.github.vfyjxf.recipegraphs.ingredient.tag;

import com.github.vfyjxf.recipegraphs.api.ingredients.IGraphTag;

public class EmptyGraphTag extends AbstractTagContent{

    public static final EmptyGraphTag EMPTY_TAG = new EmptyGraphTag();

    private EmptyGraphTag() {
        super(null, 0, 0);
    }

    @Override
    public boolean merge(IGraphTag c1, IGraphTag c2) {
        return false;
    }

    @Override
    public boolean mergeFuzzy(IGraphTag c1, IGraphTag c2) {
        return false;
    }
}
