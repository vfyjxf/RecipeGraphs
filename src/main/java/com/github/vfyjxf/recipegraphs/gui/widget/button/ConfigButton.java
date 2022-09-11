package com.github.vfyjxf.recipegraphs.gui.widget.button;

import com.github.vfyjxf.recipegraphs.api.config.IConfigCategory;
import com.github.vfyjxf.recipegraphs.api.gui.widget.IConfigButton;
import com.mojang.blaze3d.vertex.PoseStack;

public class ConfigButton implements IConfigButton {

    private final IConfigCategory category;
    private boolean isFocus;

    public ConfigButton(IConfigCategory category) {
        this.category = category;
    }


    @Override
    public boolean isFocus() {
        return isFocus;
    }

    @Override
    public IConfigCategory getConfigCategory() {
        return category;
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY) {

    }

    @Override
    public boolean onMouseClicked(int mouseX, int mouseY) {
        return false;
    }
}
