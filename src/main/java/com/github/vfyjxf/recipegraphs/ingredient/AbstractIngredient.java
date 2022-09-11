package com.github.vfyjxf.recipegraphs.ingredient;

import com.github.vfyjxf.recipegraphs.api.ingredients.IGraphIngredient;
import net.minecraft.nbt.CompoundTag;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractIngredient<T> implements IGraphIngredient<T> {

    protected T ingredient;
    protected long amount;
    protected boolean isPercent;
    protected int percent;

    public AbstractIngredient(T ingredient, long amount, int percent) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.percent = percent;
        this.isPercent = percent >= 1000;
    }

    public AbstractIngredient(IGraphIngredient<T> graphIngredient) {
        this(graphIngredient.get(), graphIngredient.getAmount(), graphIngredient.getPercent());
    }

    @Override
    public long getAmount() {
        return amount;
    }

    @Override
    public boolean isPercent() {
        return isPercent;
    }

    @Override
    public void setPercent(int percent) {
        this.percent = percent;
        this.isPercent = percent >= 1000;
    }

    @Override
    public int getPercent() {
        return percent;
    }

    @Override
    public T get() {
        return ingredient;
    }

    @Override
    public @Nullable CompoundTag getTag() {
        return null;
    }

}
