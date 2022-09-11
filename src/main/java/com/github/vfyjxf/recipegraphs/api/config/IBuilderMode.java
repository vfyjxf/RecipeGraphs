package com.github.vfyjxf.recipegraphs.api.config;

import net.minecraft.resources.ResourceLocation;

/**
 * Used to instruct the IGraphBuilder to build the Graph in specific details,
 * e.g: we can expand all the recipes,
 * or we can let the player choose the recipes to expand.
 */
@FunctionalInterface
public interface IBuilderMode {

    ResourceLocation getUid();

}
