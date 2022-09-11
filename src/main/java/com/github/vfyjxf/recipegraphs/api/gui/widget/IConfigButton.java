package com.github.vfyjxf.recipegraphs.api.gui.widget;

import com.github.vfyjxf.recipegraphs.api.config.IConfigCategory;

public interface IConfigButton extends IGraphButton {

    boolean isFocus();

    IConfigCategory getConfigCategory();

}
