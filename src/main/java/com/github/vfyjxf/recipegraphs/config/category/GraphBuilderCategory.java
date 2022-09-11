package com.github.vfyjxf.recipegraphs.config.category;

import com.github.vfyjxf.recipegraphs.config.BuilderModes;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class GraphBuilderCategory extends AbstractConfigCategory {

    private final ForgeConfigSpec.ConfigValue<ResourceLocation> builderMode;

    public GraphBuilderCategory(ForgeConfigSpec.Builder builder) {
        super(ConfigCategories.GRAPH_BUILDER_CATEGORY);
        this.configValues.addAll(List.of(
                builderMode = builder.comment("The mode of current Graph Builder").define("BuilderMode", BuilderModes.EXPAND_ALL.getUid())
//                builder.comment("The layout algorithm of current Graph Builder").define()
        ));

    }

    public ForgeConfigSpec.ConfigValue<ResourceLocation> getBuilderMode() {
        return builderMode;
    }
}
