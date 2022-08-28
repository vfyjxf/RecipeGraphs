package com.github.vfyjxf.recipegraphs.api.ingredients;

import net.minecraft.tags.TagKey;
import org.jetbrains.annotations.NotNull;

public interface IGraphTag<T> extends IGraphContent<TagKey<T>> {

    TagKey<T> getTagKey();

    @SuppressWarnings("unchecked")
    @Override
    default <C extends IGraphContent<TagKey<T>>> boolean merge(@NotNull C c1, @NotNull C c2) {
        return merge((IGraphTag<T>) c1, (IGraphTag<T>) c2);
    }

    <C extends IGraphTag<T>> boolean merge(C c1, C c2);

    <C extends IGraphTag<T>> boolean mergeFuzzy(C c1, C c2);

}
