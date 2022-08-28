package com.github.vfyjxf.recipegraphs.ingredient.tag;

import com.github.vfyjxf.recipegraphs.api.ingredients.IGraphTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.TagKey;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractTagContent<T> implements IGraphTag<T> {

    protected long amount;
    protected boolean isPercent;
    protected int percent;
    protected TagKey<T> tagKey;

    public AbstractTagContent(TagKey<T> tagKey, long amount, int percent) {
        this.tagKey = tagKey;
        this.amount = amount;
        this.percent = percent;
    }

    public AbstractTagContent(TagKey<T> tagKey, long amount) {
        this(tagKey, amount, 1000);
    }

    public AbstractTagContent(IGraphTag<T> graphTag) {
        this(graphTag.getTagKey(), graphTag.getAmount(), graphTag.getPercent());
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
    public @Nullable CompoundTag getTag() {
        return null;
    }

    @Override
    public TagKey<T> getTagKey() {
        return tagKey;
    }

}
