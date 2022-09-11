package com.github.vfyjxf.recipegraphs.ingredient.converter;

import com.github.vfyjxf.recipegraphs.api.ingredients.IGraphIngredient;
import com.github.vfyjxf.recipegraphs.api.ingredients.IGraphStackConverter;
import com.github.vfyjxf.recipegraphs.api.ingredients.IGraphTag;
import com.github.vfyjxf.recipegraphs.ingredient.FluidIngredient;
import com.github.vfyjxf.recipegraphs.ingredient.tag.FluidTagContent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITagManager;

import java.util.function.Function;
import java.util.function.Supplier;

public class FluidStackConverter implements IGraphStackConverter<FluidStack, Fluid> {
    @Override
    public Class<FluidStack> getContext() {
        return FluidStack.class;
    }

    @Override
    public Class<Fluid> getTagContext() {
        return Fluid.class;
    }

    @Override
    public IGraphIngredient<Fluid> convert(FluidStack content, long amount, int percent) {
        return new FluidIngredient(content, percent);
    }

    @Override
    public Supplier<ITagManager<Fluid>> getTagSupplier() {
        return ForgeRegistries.FLUIDS::tags;
    }

    @Override
    public Function<FluidStack, Fluid> getStackConverter() {
        return FluidStack::getFluid;
    }

    @Override
    public IGraphTag<Fluid> convertTag(TagKey<Fluid> tagKey, long amount, int percent) {
        return new FluidTagContent(tagKey, amount, percent);
    }

}
