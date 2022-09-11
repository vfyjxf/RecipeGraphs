package com.github.vfyjxf.recipegraphs.config;

import com.github.vfyjxf.recipegraphs.api.config.IBuilderMode;
import net.minecraft.resources.ResourceLocation;

public final class BuilderModes {

    public static final IBuilderMode EXPAND_ALL = () -> new ResourceLocation("builder:expand_all");
    public static final IBuilderMode SELECTIVE_EXPANSION = () -> new ResourceLocation("builder:selective_expansion");

}
