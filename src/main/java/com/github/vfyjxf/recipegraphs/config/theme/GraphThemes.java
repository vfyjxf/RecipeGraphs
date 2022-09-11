package com.github.vfyjxf.recipegraphs.config.theme;

import com.github.vfyjxf.recipegraphs.api.gui.theme.IGraphTheme;
import net.minecraft.resources.ResourceLocation;

public final class GraphThemes {

    public static final IGraphTheme SIMPLE_RAINBOW = new SimpleRainbowTheme(new ResourceLocation("theme:simple_rainbow"));
    public static final IGraphTheme SINGLE_COLOR = new SingleColorTheme(new ResourceLocation("theme:single_color"));
    public static final IGraphTheme VANILLA = new VanillaTheme(new ResourceLocation("theme:vanilla"));

    private record SimpleRainbowTheme(ResourceLocation uid) implements IGraphTheme {

        @Override
        public int getNodeSize() {
            return 20;
        }
    }

    private record SingleColorTheme(ResourceLocation uid) implements IGraphTheme {

        @Override
        public int getNodeSize() {
            return 20;
        }
    }

    private record VanillaTheme(ResourceLocation uid) implements IGraphTheme {

        @Override
        public int getNodeSize() {
            return 20;
        }
    }

}
