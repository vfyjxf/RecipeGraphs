package com.github.vfyjxf.recipegraphs.api;

import com.github.vfyjxf.recipegraphs.api.config.IGraphConfigBuilder;
import com.github.vfyjxf.recipegraphs.api.gui.layout.ILayoutEngineManager;
import com.github.vfyjxf.recipegraphs.api.gui.theme.IGraphThemeManager;
import com.github.vfyjxf.recipegraphs.api.ingredients.IGraphContentManager;
import com.github.vfyjxf.recipegraphs.api.recipe.IRecipeParser;
import com.github.vfyjxf.recipegraphs.api.recipe.IRecipeParserManager;

import java.util.Collection;
import java.util.Collections;

public interface IGraphPlugin {

    default Collection<IGraphConfigBuilder> getConfigBuilder() {
        return Collections.emptyList();
    }

    default void registerTheme(IGraphThemeManager manager) {
    }

    default void registerRecipeParser(IRecipeParserManager manager) {
    }

    default void registerLayoutEngine(ILayoutEngineManager manager) {
    }

    default void registerContentConverter(IGraphContentManager manager) {
    }

}
