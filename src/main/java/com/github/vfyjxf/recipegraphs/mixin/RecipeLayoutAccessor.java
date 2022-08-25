package com.github.vfyjxf.recipegraphs.mixin;

import mezz.jei.gui.recipes.RecipeLayout;
import mezz.jei.ingredients.RegisteredIngredients;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = RecipeLayout.class, remap = false)
public interface RecipeLayoutAccessor {
    @Accessor
    RegisteredIngredients getRegisteredIngredients();
}
