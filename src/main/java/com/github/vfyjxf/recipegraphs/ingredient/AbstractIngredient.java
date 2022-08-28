package com.github.vfyjxf.recipegraphs.ingredient;

import com.github.vfyjxf.recipegraphs.api.ingredients.IGraphIngredient;
import net.minecraft.nbt.CompoundTag;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractIngredient<T> implements IGraphIngredient<T> {

    protected T content;
    protected long amount;
    protected boolean isPercent;
    protected int percent;

    public AbstractIngredient(T content, long amount, int percent) {
        this.content = content;
        this.amount = amount;
        this.percent = percent;
        this.isPercent = percent >= 1000;
    }

    public AbstractIngredient(T content, long amount) {
        this(content, amount, 1000);
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
        return content;
    }

    @Override
    public @Nullable CompoundTag getTag() {
        return null;
    }

}
