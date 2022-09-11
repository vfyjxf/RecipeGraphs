package com.github.vfyjxf.recipegraphs.gui.graph;

import com.github.vfyjxf.recipegraphs.api.config.IBuilderMode;
import com.github.vfyjxf.recipegraphs.api.gui.IGraphBuilder;
import com.github.vfyjxf.recipegraphs.api.gui.theme.IGraphTheme;
import org.eclipse.elk.core.IGraphLayoutEngine;

public abstract class AbstractGraphBuilder<T> implements IGraphBuilder<T> {

    protected IGraphLayoutEngine layoutEngine;
    protected T rootValue;
    protected IBuilderMode mode;
    protected IGraphTheme theme;

    @Override
    public IGraphBuilder<T> setLayoutEngine(IGraphLayoutEngine layoutEngine) {
        this.layoutEngine = layoutEngine;
        return this;
    }

    @Override
    public IGraphBuilder<T> setRootValue(T rootValue) {
        this.rootValue = rootValue;
        return this;
    }

    @Override
    public IGraphBuilder<T> setMode(IBuilderMode mode) {
        this.mode = mode;
        return this;
    }

    @Override
    public IGraphBuilder<T> setTheme(IGraphTheme theme) {
        this.theme = theme;
        return this;
    }

    public IGraphLayoutEngine getLayoutEngine() {
        return layoutEngine;
    }

    public T getRootValue() {
        return rootValue;
    }

    public IBuilderMode getMode() {
        return mode;
    }

    public IGraphTheme getTheme() {
        return theme;
    }

}
