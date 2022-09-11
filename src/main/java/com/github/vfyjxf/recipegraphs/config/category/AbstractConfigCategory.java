package com.github.vfyjxf.recipegraphs.config.category;

import com.github.vfyjxf.recipegraphs.api.config.IConfigCategory;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConfigCategory implements IConfigCategory {

    protected final String categoryName;
    protected final List<ForgeConfigSpec.ConfigValue<?>> configValues;

    public AbstractConfigCategory(String categoryName) {
        this.categoryName = categoryName;
        this.configValues = new ArrayList<>();
    }

    @Override
    public String getCategoryName() {
        return categoryName;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> ForgeConfigSpec.ConfigValue<T> getConfigValue(String name) {
        for (ForgeConfigSpec.ConfigValue<?> configValue : getAllValues()) {
            if (name.equals(configValue.getPath().get(0))) {
                return (ForgeConfigSpec.ConfigValue<T>) configValue;
            }
        }
        throw new IllegalArgumentException("Can't find config value :" + name + "  in " + categoryName);
    }

    @Override
    public List<ForgeConfigSpec.ConfigValue<?>> getAllValues() {
        return configValues;
    }

}
