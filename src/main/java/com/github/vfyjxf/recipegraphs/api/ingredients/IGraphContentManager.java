package com.github.vfyjxf.recipegraphs.api.ingredients;

import net.minecraftforge.registries.IForgeRegistryEntry;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

public interface IGraphContentManager {

    <T> void registerConverter(Class<T> context, IGraphContentConverter<T, ?> converter);

    <T> void registerConverter(Class<T> context, IGraphStackConverter<T, ?> converter);

    <T> void registerInfoProvider(Class<T> context, IIngredientInfoProvider<T> provider);

    @Nullable
    <T,R> IGraphContentConverter<T,R> getConverter(Class<T> context);

    @Nullable
    <T,R> IGraphContentConverter<T,R> getStackConverter(Class<T> context);

    @Nullable
    <T> IIngredientInfoProvider<T> getProvider(Class<T> context);

    @Nullable
    <T> IIngredientInfoProvider<T> getProvider(T ingredient);

    default <T> IGraphContent<T> from(T content, long amount, int percent) {
        if (content instanceof IGraphTag.TagContext<?> tagContext) {
            return (IGraphContent<T>) createTag(tagContext, amount, percent);
        } else if (content instanceof List<?> list) {
            return (IGraphContent<T>) createList(list, amount, percent);
        }
        return createIngredient(content, amount, percent);
    }

    default <T> IGraphContent<T> from(T content, long amount) {
        return from(content, amount, 1000);
    }

    <T> IGraphTag<T> createTag(IGraphTag.TagContext<T> tagContext, long amount, int percent);

    /**
     * Create matching {@link IGraphTag}s for the given ingredients, which can usually be thought of as all the tags accepted by a slot.
     */
    <T, V extends IForgeRegistryEntry<V>> List<IGraphTag<V>> createTags(List<T> ingredients, Class<V> context, long amount, int percent);

    <T, V extends IForgeRegistryEntry<V>> List<IGraphTag<V>> convertTags(List<IGraphContent<T>> contents, Class<V> context, long amount, int percent);

    default <T> IGraphTag<T> createTag(IGraphTag.TagContext<T> tagContext, long amount) {
        return createTag(tagContext, amount, 1000);
    }

    <T> IGraphIngredient<T> createIngredient(T ingredient, long amount, int percent);

    default <T> IGraphIngredient<T> createIngredient(T ingredient, long amount) {
        return createIngredient(ingredient, amount, 1000);
    }

    /**
     * For recipes that don't use tag.
     */
    <T> IIngredientList<T> createList(Collection<T> ingredients, long amount, int percent);

    default <T> IIngredientList<T> createList(Collection<T> ingredients, long amount) {
        return createList(ingredients, amount, 1000);
    }


}
