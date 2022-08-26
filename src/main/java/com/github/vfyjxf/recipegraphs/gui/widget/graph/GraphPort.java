package com.github.vfyjxf.recipegraphs.gui.widget.graph;

import com.github.vfyjxf.recipegraphs.api.gui.widget.IGraphNode;
import com.github.vfyjxf.recipegraphs.api.gui.widget.IGraphPort;

public class GraphPort implements IGraphPort {

    private final IGraphNode parent;
    private String name;

    public GraphPort(IGraphNode parent, String name) {
        this.parent = parent;
        this.name = name;
    }

    public GraphPort(IGraphNode parent) {
        this(parent, "");
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public IGraphNode getParent() {
        return parent;
    }
}
