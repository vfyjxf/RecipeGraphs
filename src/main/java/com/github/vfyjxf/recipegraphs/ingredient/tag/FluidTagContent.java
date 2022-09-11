package com.github.vfyjxf.recipegraphs.ingredient.tag;

import com.github.vfyjxf.recipegraphs.api.ingredients.IGraphTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.Nullable;

public class FluidTagContent extends AbstractTagContent<Fluid> {

    public FluidTagContent(TagKey<Fluid> tagKey, long amount, int percent) {
        super(tagKey, amount, percent);
    }

    public FluidTagContent(IGraphTag<Fluid> graphTag) {
        super(graphTag);
    }

    @Override
    public @Nullable CompoundTag getTag() {
        return null;
    }

    @Override
    public <C extends IGraphTag<Fluid>> boolean merge(C c1, C c2) {
        return false;
    }

    @Override
    public <C extends IGraphTag<Fluid>> boolean mergeFuzzy(C c1, C c2) {
        return false;
    }

}
