package com.github.vfyjxf.recipegraphs.recipe;

import com.github.vfyjxf.recipegraphs.mixin.RecipeLayoutBuilderAccessor;
import com.github.vfyjxf.recipegraphs.mixin.RecipeSlotBuilderAccessor;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.ingredients.ITypedIngredient;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.gui.recipes.builder.RecipeLayoutBuilder;
import mezz.jei.gui.recipes.builder.RecipeSlotBuilder;
import mezz.jei.ingredients.IIngredientSupplier;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public final class RecipeUtils {

    public RecipeUtils() {

    }

    public <T> List<List<ITypedIngredient<?>>> mergeInputs(IIngredientSupplier supplier) {
        List<List<ITypedIngredient<?>>> mergedInputs = new ArrayList<>();

        List<? extends IIngredientType<?>> ingredientTypes = supplier.getIngredientTypes(RecipeIngredientRole.INPUT).toList();
        if (supplier instanceof RecipeLayoutBuilder builder) {
            List<Pair<Boolean, Set<ITypedIngredient<?>>>> slotIngredients = getIngredients(builder, RecipeIngredientRole.INPUT);
            for (Pair<Boolean, Set<ITypedIngredient<?>>> slotPair : slotIngredients) {
                if (slotPair.getLeft()) {

                } else {

                }
            }
        }

        return mergedInputs;
    }

    private List<Pair<Boolean, Set<ITypedIngredient<?>>>> getIngredients(RecipeLayoutBuilder builder, RecipeIngredientRole role) {
        return ((RecipeLayoutBuilderAccessor) builder).callSlotStream()
                .filter(slot -> slot.getRole() == role && slot instanceof RecipeSlotBuilder)
                .map(slot -> {
                    boolean simpleSlot = slot.getIngredientTypes().count() == 1;
                    return Pair.of(simpleSlot, ((RecipeSlotBuilderAccessor) slot).getIngredients().getAllIngredients());
                })
                .map(pair -> Pair.of(pair.getLeft(),
                        pair.getRight().parallelStream()
                                .flatMap(Optional::stream)
                                .collect(Collectors.toSet()))

                )
                .filter(pair -> !pair.getRight().isEmpty())
                .collect(Collectors.toList());
    }


}
