package com.github.vfyjxf.recipegraphs.api.gui.widget;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface IGraphListNode<T> extends IGraphContentNode<T> {

    boolean isFocus();

    void setFocus(boolean isFocus);

    List<T> getContents();

    void setContents(@NotNull List<T> contents);

}
