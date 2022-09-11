package com.github.vfyjxf.recipegraphs.mixin;

import mezz.jei.ingredients.Ingredients;
import mezz.jei.ingredients.IngredientsForType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@SuppressWarnings("deprecation")
@Mixin(Ingredients.class)
public interface IngredientsAccessor {
    @Accessor
    List<IngredientsForType<?>> getInputs();

    @Accessor
    List<IngredientsForType<?>> getOutputs();
}
