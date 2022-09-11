package com.github.vfyjxf.recipegraphs.api.config;

import net.minecraftforge.common.ForgeConfigSpec;

@FunctionalInterface
public interface IGraphConfigBuilder {
    IConfigCategory build(ForgeConfigSpec.Builder builder);
}
