package com.github.vfyjxf.recipegraphs.api.gui.theme;

import net.minecraft.resources.ResourceLocation;

public interface IGraphTheme {

    ResourceLocation uid();

    /**
     * @return The default size of a node, which does not affect those special nodes.
     */
    int getNodeSize();

}
