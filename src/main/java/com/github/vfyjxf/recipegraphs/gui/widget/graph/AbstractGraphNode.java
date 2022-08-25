package com.github.vfyjxf.recipegraphs.gui.widget.graph;

import com.github.vfyjxf.recipegraphs.api.gui.widget.IGraphNode;

import java.awt.*;
import java.util.List;

public abstract class AbstractGraphNode implements IGraphNode {

    protected int posX;
    protected int posY;
    protected int width;
    protected int height;
    protected String nodeName;
    protected IGraphNode parent;
    protected List<IGraphNode> children;

    public AbstractGraphNode(int posX, int posY, int width, int height, String nodeName) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.nodeName = nodeName;
    }

    public AbstractGraphNode(int posX, int posY, int width, int height) {
        this(posX, posY, width, height, "");
    }

    public AbstractGraphNode(Rectangle rectangle, String nodeName) {
        this(rectangle.x, rectangle.y, rectangle.width, rectangle.height, nodeName);
    }

    public AbstractGraphNode(Rectangle rectangle) {
        this(rectangle, "");
    }

    @Override
    public int getPosX() {
        return posX;
    }

    @Override
    public int getPosY() {
        return posY;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setPosition(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public IGraphNode getParent() {
        return parent;
    }

    @Override
    public List<IGraphNode> getChildren() {
        return children;
    }

    @Override
    public String getName() {
        return nodeName;
    }
}
