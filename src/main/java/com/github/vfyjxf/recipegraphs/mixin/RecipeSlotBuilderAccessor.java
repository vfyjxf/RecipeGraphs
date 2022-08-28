package com.github.vfyjxf.recipegraphs.mixin;

import mezz.jei.gui.recipes.builder.RecipeSlotBuilder;
import mezz.jei.ingredients.IngredientAcceptor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = RecipeSlotBuilder.class,remap = false)
public interface RecipeSlotBuilderAccessor {
    @Accessor
    IngredientAcceptor getIngredients();
}
