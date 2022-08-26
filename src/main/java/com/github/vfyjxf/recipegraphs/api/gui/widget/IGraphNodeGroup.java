package com.github.vfyjxf.recipegraphs.api.gui.widget;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * A group of IGraphNode
 */
public interface IGraphNodeGroup extends IGraphNode {

    /**
     * @return All nodes in the group.
     */
    List<IGraphNode> getGroupNode();

    void addToGroup(@NotNull IGraphNode node);

}
