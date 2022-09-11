package com.github.vfyjxf.recipegraphs.plguin.internal;

import com.github.vfyjxf.recipegraphs.api.GraphPlugin;
import com.github.vfyjxf.recipegraphs.api.IGraphPlugin;
import com.github.vfyjxf.recipegraphs.api.config.IGraphConfigBuilder;
import com.github.vfyjxf.recipegraphs.api.gui.layout.ILayoutEngineManager;
import com.github.vfyjxf.recipegraphs.api.gui.theme.IGraphThemeManager;
import com.github.vfyjxf.recipegraphs.api.ingredients.IGraphContentManager;
import com.github.vfyjxf.recipegraphs.api.recipe.IRecipeParserManager;
import com.github.vfyjxf.recipegraphs.config.category.GraphBuilderCategory;
import com.github.vfyjxf.recipegraphs.config.category.GraphThemeCategory;
import com.github.vfyjxf.recipegraphs.ingredient.converter.FluidStackConverter;
import com.github.vfyjxf.recipegraphs.ingredient.converter.ItemStackConverter;
import com.github.vfyjxf.recipegraphs.recipe.JeiRecipeParser;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@GraphPlugin
public class InternalPlugin implements IGraphPlugin {
    @Override
    public @NotNull Collection<IGraphConfigBuilder> getConfigBuilder() {
        List<IGraphConfigBuilder> builders = new ArrayList<>();
        builders.add(GraphBuilderCategory::new);
        builders.add(GraphThemeCategory::new);
        return builders;
    }

    @Override
    public void registerTheme(@NotNull IGraphThemeManager manager) {

    }

    @Override
    public void registerRecipeParser(@NotNull IRecipeParserManager manager) {

    }

    @Override
    public void registerLayoutEngine(@NotNull ILayoutEngineManager manager) {

    }

    @Override
    public void registerContentConverter(@NotNull IGraphContentManager manager) {
        manager.registerConverter(ItemStack.class, new ItemStackConverter());
        manager.registerConverter(FluidStack.class, new FluidStackConverter());
    }
}
