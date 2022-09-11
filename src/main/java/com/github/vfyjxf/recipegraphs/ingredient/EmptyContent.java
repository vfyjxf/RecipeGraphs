package com.github.vfyjxf.recipegraphs.ingredient;

import com.github.vfyjxf.recipegraphs.api.ingredients.IGraphContent;
import net.minecraft.nbt.CompoundTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EmptyContent implements IGraphContent {

    public static final IGraphContent EMPTY_CONTENT = new EmptyContent();

    private EmptyContent(){

    }

    @Override
    public long getAmount() {
        return 0;
    }

    @Override
    public boolean isPercent() {
        return false;
    }

    @Override
    public void setPercent(int percent) {
        //do nothing
    }

    @Override
    public int getPercent() {
        return 0;
    }

    @Override
    public @Nullable CompoundTag getTag() {
        return null;
    }

    @Override
    public boolean merge(@NotNull IGraphContent c1, @NotNull IGraphContent c2) {
        return false;
    }
}
