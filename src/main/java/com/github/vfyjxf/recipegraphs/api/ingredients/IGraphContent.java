package com.github.vfyjxf.recipegraphs.api.ingredients;

import com.github.vfyjxf.recipegraphs.ingredient.EmptyContent;
import net.minecraft.nbt.CompoundTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IGraphContent<T> {

    static <T> IGraphContent<T> empty() {
        return EmptyContent.EMPTY_CONTENT;
    }

    long getAmount();

    boolean isPercent();

    void setPercent(int percent);

    /**
     * Returns an integer from 0 to 1000.
     */
    int getPercent();

    @Nullable
    CompoundTag getTag();

    <C extends IGraphContent<T>> boolean merge(@NotNull C c1, @NotNull C c2);

}
