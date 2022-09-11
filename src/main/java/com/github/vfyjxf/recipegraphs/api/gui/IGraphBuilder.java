package com.github.vfyjxf.recipegraphs.api.gui;

import com.github.vfyjxf.recipegraphs.api.config.IBuilderMode;
import com.github.vfyjxf.recipegraphs.api.gui.theme.IGraphTheme;
import com.github.vfyjxf.recipegraphs.api.gui.widget.IGraphNode;
import org.eclipse.elk.core.IGraphLayoutEngine;

import java.util.List;

/**
 * A builder that constructs a Graph for a specific type.
 */
public interface IGraphBuilder<T> {

    IGraphBuilder<T> setLayoutEngine(IGraphLayoutEngine layoutEngine);

    IGraphBuilder<T> setRootValue(T rootValue);

    IGraphBuilder<T> setMode(IBuilderMode mode);

    IGraphBuilder<T> setTheme(IGraphTheme theme);

    List<IGraphNode> build();

}
