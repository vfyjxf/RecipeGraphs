package com.github.vfyjxf.recipegraphs.gui.graph;

import com.github.vfyjxf.recipegraphs.api.gui.IGraphBuilder;
import com.github.vfyjxf.recipegraphs.api.gui.widget.IGraphListNode;
import com.github.vfyjxf.recipegraphs.api.gui.widget.IGraphNode;
import com.github.vfyjxf.recipegraphs.gui.GraphFactory;
import com.github.vfyjxf.recipegraphs.gui.texture.GraphTextures;
import com.github.vfyjxf.recipegraphs.mixin.RecipeLayoutAccessor;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.runtime.IIngredientManager;
import mezz.jei.gui.recipes.RecipeLayout;
import mezz.jei.ingredients.IIngredientSupplier;
import mezz.jei.ingredients.RegisteredIngredients;
import mezz.jei.recipes.IngredientSupplierHelper;
import mezz.jei.util.RecipeErrorUtil;
import net.minecraft.client.gui.components.Widget;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.elk.core.IGraphLayoutEngine;
import org.eclipse.elk.graph.ElkNode;
import org.eclipse.elk.graph.util.ElkGraphUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Output -> inputs -> catalyst -> the input of inputs
 * and a loop
 */
public class JeiRecipeGraphBuilder extends AbstractGraphBuilder<RecipeLayout<?>> {

    private static final Logger LOGGER = LogManager.getLogger();

    private RegisteredIngredients registeredIngredients;
    private final GraphTextures textures;
    private final IIngredientManager ingredientManager;
    private final GraphFactory graphFactory;
    private IGraphLayoutEngine layoutEngine;
    private ElkNode elkGraph;

    public JeiRecipeGraphBuilder(IIngredientManager ingredientManager) {
        this.ingredientManager = ingredientManager;
        this.graphFactory = new GraphFactory(ingredientManager);
        this.textures = GraphTextures.getInstance();

    }


    @Override
    public IGraphBuilder<RecipeLayout<?>> setRootValue(RecipeLayout<?> rootValue) {
        super.setRootValue(rootValue);
        this.registeredIngredients = ((RecipeLayoutAccessor) rootValue).getRegisteredIngredients();
        return this;
    }

    public JeiRecipeGraphBuilder setLayoutEngine(IGraphLayoutEngine layoutEngine) {
        this.layoutEngine = layoutEngine;
        return this;
    }


    public List<IGraphNode> build() {
        return Collections.emptyList();
    }

    @SuppressWarnings("unchecked")
    private <T> List<Widget> createLayout() {
        List<Widget> widgets = new ArrayList<>();
        RecipeLayout<T> recipe = (RecipeLayout<T>) rootValue;
        //Start!
        IIngredientSupplier supplier = IngredientSupplierHelper.getIngredientSupplier(recipe.getRecipe(), recipe.getRecipeCategory(), registeredIngredients);
        if (supplier == null) {
            LOGGER.error("Failed to get ingredients from recipe:{}", RecipeErrorUtil.getNameForRecipe(recipe.getRecipe()));
            return Collections.emptyList();
        }
        List<? extends IIngredientType<?>> outputTypes = supplier.getIngredientTypes(RecipeIngredientRole.OUTPUT).toList();
        if (outputTypes.isEmpty()) {
            LOGGER.error("Failed to get outputs from recipe:{}", RecipeErrorUtil.getNameForRecipe(recipe.getRecipe()));
            return Collections.emptyList();
        }

        elkGraph = ElkGraphUtil.createGraph();
        List<?> outputs = supplier.getIngredientTypes(RecipeIngredientRole.OUTPUT)
                .map(type -> supplier.getIngredientStream(type, RecipeIngredientRole.OUTPUT).toList())
                .flatMap(Collection::stream)
                .toList();
        //We will start counting from this Node.
        IGraphListNode<?> targetListNode;
        if (outputTypes.size() > 1) {
            targetListNode = graphFactory.createMixedListNode(elkGraph, 32, 32, textures.getGraphIcon(), outputs);
        } else {
            targetListNode = graphFactory.createListNode(elkGraph, 32, 32, textures.getGraphIcon(), (List<T>) outputs, (IIngredientType<T>) outputTypes.get(0));
        }



        return widgets;
    }



}
