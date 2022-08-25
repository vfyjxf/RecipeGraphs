package com.github.vfyjxf.recipegraphs.gui.widget.graph;

import com.github.vfyjxf.recipegraphs.api.gui.widget.IGraphListNode;
import com.github.vfyjxf.recipegraphs.gui.widget.CycleTimer;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public abstract class AbstractGraphListNode<T> extends AbstractGraphNode implements IGraphListNode<T> {

    private final int cycleOffset = (int) ((Math.random() * 10000) % Integer.MAX_VALUE);
    private final CycleTimer cycleTimer = new CycleTimer(cycleOffset);

    protected List<T> contents;
    protected boolean isFocus;

    public AbstractGraphListNode(int posX, int posY, int width, int height, String nodeName, List<T> contents) {
        super(posX, posY, width, height, nodeName);
        this.contents = contents;
    }

    public AbstractGraphListNode(int posX, int posY, int width, int height, List<T> contents) {
        super(posX, posY, width, height);
        this.contents = contents;
    }

    @Override
    public T getContent() {
        return cycleTimer.getCycledContent(contents);
    }

    @Override
    public boolean isFocus() {
        return isFocus;
    }

    @Override
    public void setFocus(boolean isFocus) {
        this.isFocus = isFocus;
    }

    @Override
    public List<T> getContents() {
        return contents;
    }

    @Override
    public void setContents(@NotNull List<T> contents) {
        this.contents = contents;
    }

}
