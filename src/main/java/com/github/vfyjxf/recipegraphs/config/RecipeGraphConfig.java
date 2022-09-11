package com.github.vfyjxf.recipegraphs.config;

import com.github.vfyjxf.recipegraphs.api.config.IConfigCategory;
import com.github.vfyjxf.recipegraphs.api.config.IGraphConfigBuilder;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RecipeGraphConfig {

    private final ForgeConfigSpec configSpec;
    private final Map<String, IConfigCategory> configCategoryMap;

    public RecipeGraphConfig(Collection<IGraphConfigBuilder> configBuilders) {
        Pair<List<IConfigCategory>, ForgeConfigSpec> specPair =  new ForgeConfigSpec.Builder().configure(
                builder -> configBuilders.stream()
                .map(configBuilder -> configBuilder.build(builder))
                .collect(Collectors.toList())
        );
        this.configSpec = specPair.getRight();
        this.configCategoryMap = new HashMap<>();
        for (IConfigCategory configCategory : specPair.getLeft()) {
            configCategoryMap.put(configCategory.getCategoryName(), configCategory);
        }
    }

    public ForgeConfigSpec getConfigSpec() {
        return configSpec;
    }

}
