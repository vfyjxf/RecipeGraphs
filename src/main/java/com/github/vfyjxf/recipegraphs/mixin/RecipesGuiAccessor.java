package com.github.vfyjxf.recipegraphs.mixin;

import mezz.jei.gui.recipes.RecipeLayout;
import mezz.jei.gui.recipes.RecipesGui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(RecipesGui.class)
public interface RecipesGuiAccessor {
    @Accessor
    List<RecipeLayout<?>> getRecipeLayouts();
}
