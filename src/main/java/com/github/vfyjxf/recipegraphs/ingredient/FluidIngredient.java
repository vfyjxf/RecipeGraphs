package com.github.vfyjxf.recipegraphs.ingredient;

import com.github.vfyjxf.recipegraphs.api.ingredients.IGraphContent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FluidIngredient extends AbstractIngredient<Fluid> {

    private final CompoundTag compoundTag;

    public FluidIngredient(@NotNull FluidStack fluidStack, int percent) {
        super(fluidStack.getFluid(), fluidStack.getAmount(), percent);
        this.compoundTag = fluidStack.getTag();
    }

    @Override
    public @Nullable CompoundTag getTag() {
        return compoundTag;
    }

    @Override
    public <C extends IGraphContent<Fluid>> boolean merge(@NotNull C c1, @NotNull C c2) {
        //TODO
        return false;
    }
}
