package com.github.vfyjxf.recipegraphs.api.ingredients;

import net.minecraft.tags.TagKey;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.tags.ITagManager;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public interface IGraphStackConverter<T, V extends IForgeRegistryEntry<V>> extends IGraphContentConverter<T, V> {

    Class<V> getTagContext();

    default  Supplier<ITagManager<V>> getTagSupplier() {
        throw new UnsupportedOperationException("The convert of " + getContext().getCanonicalName() + " doesn't has a tag supplier!");
    }


    /**
     * For some Ingredient, they may be similar to ItemStack in that they have a shared "Item",
     * and we use this Function to convert the Stack to an "Item".
     */
    default Function<T, V> getStackConverter() {
        throw new UnsupportedOperationException("The convert of " + getContext().getCanonicalName() + " doesn't has a stack converter!");
    }

    default IGraphTag<V> convertTag(TagKey<V> tagKey, long amount, int percent) {
        throw new UnsupportedOperationException("The convert of " + getContext().getCanonicalName() + " has not implemented the convertTag method!");
    }

    default List<IGraphTag<V>> convertTags(List<T> ingredients, long amount, int percent) {
        throw new UnsupportedOperationException("The convert of " + getContext().getCanonicalName() + " has not implemented the convertTag method!");
    }

}
