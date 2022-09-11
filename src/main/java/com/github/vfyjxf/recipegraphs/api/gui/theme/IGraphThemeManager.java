package com.github.vfyjxf.recipegraphs.api.gui.theme;

import net.minecraft.resources.ResourceLocation;

public interface IGraphThemeManager {

    void register(IGraphTheme theme, IGraphThemeRenderer renderer);

    IGraphThemeRenderer getRenderer(IGraphTheme theme);

    IGraphThemeRenderer getRenderer(ResourceLocation uid);

}
