package com.github.vfyjxf.recipegraphs.api.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

/**
 * Regarding the definition of ConfigValue, its path should be named using Pascal nomenclature.
 */
public interface IConfigCategory {

    String getCategoryName();

    <T> ForgeConfigSpec.ConfigValue<T> getConfigValue(String name);

    default <T> T getValue(String name) {
        return (T) getConfigValue(name).get();
    }

    List<ForgeConfigSpec.ConfigValue<?>> getAllValues();

}
