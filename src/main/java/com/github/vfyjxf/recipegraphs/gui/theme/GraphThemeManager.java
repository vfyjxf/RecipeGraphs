package com.github.vfyjxf.recipegraphs.gui.theme;

import com.github.vfyjxf.recipegraphs.api.gui.theme.IGraphTheme;
import com.github.vfyjxf.recipegraphs.api.gui.theme.IGraphThemeManager;
import com.github.vfyjxf.recipegraphs.api.gui.theme.IGraphThemeRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GraphThemeManager implements IGraphThemeManager {

    private final Map<IGraphTheme, IGraphThemeRenderer> themeMap;

    public GraphThemeManager() {
        this.themeMap = new HashMap<>();
    }


    @Override
    public void register(IGraphTheme theme, IGraphThemeRenderer renderer) {
        Objects.requireNonNull(theme);
        Objects.requireNonNull(renderer);
        themeMap.put(theme, renderer);
    }

    @Override
    public IGraphThemeRenderer getRenderer(IGraphTheme theme) {
        IGraphThemeRenderer renderer = themeMap.get(theme);
        if (renderer == null) {
            throw new IllegalArgumentException("Unknown graph theme: " + theme.uid());
        }
        return renderer;
    }

    @Override
    public IGraphThemeRenderer getRenderer(ResourceLocation uid) {

        for (Map.Entry<IGraphTheme, IGraphThemeRenderer> entry : themeMap.entrySet()) {
            if (entry.getKey().uid().equals(uid)) {
                return entry.getValue();
            }
        }

        throw new IllegalArgumentException("Unknown graph theme: " + uid);

    }
}
