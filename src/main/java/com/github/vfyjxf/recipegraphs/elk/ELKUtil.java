package com.github.vfyjxf.recipegraphs.elk;

import org.eclipse.elk.alg.layered.LayeredLayoutProvider;
import org.eclipse.elk.core.util.NullElkProgressMonitor;
import org.eclipse.elk.graph.ElkNode;
import org.eclipse.elk.graph.util.ElkGraphUtil;

public class ELKUtil {

//    public static ElkNode createExampleGraph() {
//
//    }

    public static ElkNode createNodeWithSize(String text, ElkNode elkGraph, int width, int height) {
        ElkNode node = ElkGraphUtil.createNode(elkGraph);
        ElkGraphUtil.createLabel(text, node);
        node.setWidth(width);
        node.setHeight(height);
        return node;
    }
}
