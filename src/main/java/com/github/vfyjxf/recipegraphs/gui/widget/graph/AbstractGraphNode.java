package com.github.vfyjxf.recipegraphs.gui.widget.graph;

import com.github.vfyjxf.recipegraphs.api.gui.texture.IGuiTexture;
import com.github.vfyjxf.recipegraphs.api.gui.widget.IGraphNode;
import com.github.vfyjxf.recipegraphs.api.gui.widget.IGraphPort;
import org.eclipse.elk.graph.ElkNode;
import org.eclipse.elk.graph.util.ElkGraphUtil;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGraphNode implements IGraphNode {

    private ElkNode elkNode;
    protected int posX;
    protected int posY;
    protected int width;
    protected int height;
    protected boolean visible = true;
    protected String nodeName;
    protected IGraphNode parent;
    protected final List<IGraphNode> children;
    protected final List<IGraphPort> ports;
    protected final IGuiTexture background;

    public AbstractGraphNode(ElkNode elkGraph, int width, int height, String nodeName, IGuiTexture background) {
        this.elkNode = ElkGraphUtil.createNode(elkGraph);
        this.width = width;
        this.height = height;
        this.nodeName = nodeName;
        this.children = new ArrayList<>();
        this.ports = new ArrayList<>();
        this.background = background;
    }

    /*
    public AbstractGraphNode(Rectangle rectangle, String nodeName) {
        this(rectangle.x, rectangle.y, rectangle.width, rectangle.height, nodeName);
    }

    public AbstractGraphNode(Rectangle rectangle) {
        this(rectangle, "");
    }

     */

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
    public IGraphNode addNode(@NotNull IGraphNode node) {
        this.children.add(node);
        return this;
    }

    @Override
    public IGraphNode clearNodes() {
        this.children.clear();
        return this;
    }

    @Override
    public List<IGraphPort> getPorts() {
        return ports;
    }

    @Override
    public IGraphNode clearPorts() {
        this.ports.clear();
        return this;
    }

    @Override
    public boolean isMouseOver(int mouseX, int mouseY) {
        return this.visible &&
                mouseX >= this.posX &&
                mouseY >= this.posY &&
                mouseX < this.posX + this.width &&
                mouseY < this.posY + this.height;
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    @Override
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public String getName() {
        return nodeName;
    }
}
