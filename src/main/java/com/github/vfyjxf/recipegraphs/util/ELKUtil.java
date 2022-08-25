package com.github.vfyjxf.recipegraphs.util;

import org.eclipse.elk.alg.layered.LayeredLayoutProvider;
import org.eclipse.elk.core.util.NullElkProgressMonitor;
import org.eclipse.elk.graph.ElkNode;
import org.eclipse.elk.graph.util.ElkGraphUtil;

public class ELKUtil {

    public static ElkNode createExampleGraph(){
        ElkNode elkGraph = ElkGraphUtil.createGraph();
        ElkNode nodeA = ELKUtil.createNodeWithSize("A",elkGraph,16,16);
        ElkNode nodeB = ELKUtil.createNodeWithSize("B",elkGraph,16,16);
        ElkNode nodeC = ELKUtil.createNodeWithSize("C",elkGraph,16,16);
        ElkNode nodeD = ELKUtil.createNodeWithSize("D",elkGraph,16,16);
        ElkNode nodeE = ELKUtil.createNodeWithSize("E",elkGraph,16,16);
        ElkNode nodeF = ELKUtil.createNodeWithSize("F",elkGraph,16,16);
        ElkNode nodeG = ELKUtil.createNodeWithSize("G",elkGraph,16,16);
        ElkGraphUtil.createSimpleEdge(nodeA,nodeC);
        ElkGraphUtil.createSimpleEdge(nodeD,nodeA);
        ElkGraphUtil.createSimpleEdge(nodeD,nodeB);
        ElkGraphUtil.createSimpleEdge(nodeE,nodeD);
        ElkGraphUtil.createSimpleEdge(nodeB,nodeC);
        LayeredLayoutProvider provider = new LayeredLayoutProvider();
        provider.layout(elkGraph,new NullElkProgressMonitor());
        return elkGraph;
    }
    public static ElkNode createNodeWithSize(String text,ElkNode elkGraph,int width,int height){
        ElkNode node = ElkGraphUtil.createNode(elkGraph);
        ElkGraphUtil.createLabel(text,node);
        node.setWidth(width);
        node.setHeight(height);
        return node;
    }
}
