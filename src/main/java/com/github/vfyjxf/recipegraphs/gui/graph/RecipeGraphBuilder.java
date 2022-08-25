package com.github.vfyjxf.recipegraphs.gui.graph;

import com.github.vfyjxf.recipegraphs.mixin.RecipeLayoutAccessor;
import mezz.jei.gui.recipes.RecipeLayout;
import mezz.jei.ingredients.IIngredientSupplier;
import mezz.jei.ingredients.RegisteredIngredients;
import mezz.jei.recipes.IngredientSupplierHelper;
import net.minecraft.client.gui.components.Widget;
import org.eclipse.elk.core.IGraphLayoutEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecipeGraphBuilder {

    private RecipeLayout<?> recipeLayout;
    private RegisteredIngredients registeredIngredients;
    private IGraphLayoutEngine layoutEngine;

    public RecipeGraphBuilder() {

    }

    public RecipeGraphBuilder setRecipe(RecipeLayout<?> recipeLayout) {
        this.recipeLayout = recipeLayout;
        this.registeredIngredients = ((RecipeLayoutAccessor) recipeLayout).getRegisteredIngredients();
        return this;
    }

    public RecipeGraphBuilder setLayoutEngine(IGraphLayoutEngine layoutEngine) {
        this.layoutEngine = layoutEngine;
        return this;
    }

    public List<Widget> build() {
        return Collections.emptyList();
    }

    @SuppressWarnings("unchecked")
    private <T> List<Widget> layout() {
        List<Widget> widgets = new ArrayList<>();
        RecipeLayout<T> recipe = (RecipeLayout<T>) recipeLayout;
        IIngredientSupplier supplier = IngredientSupplierHelper.getIngredientSupplier(recipe.getRecipe(), recipe.getRecipeCategory(), registeredIngredients);
        return widgets;
    }

}
