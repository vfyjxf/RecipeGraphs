package com.github.vfyjxf.recipegraphs.ingredient;

import com.github.vfyjxf.recipegraphs.api.ingredients.*;
import com.github.vfyjxf.recipegraphs.ingredient.tag.CommonTagContent;
import net.minecraft.tags.TagKey;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.tags.ITag;
import net.minecraftforge.registries.tags.ITagManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class GraphContentManager implements IGraphContentManager {

    private static final Logger LOGGER = LogManager.getLogger();

    private final Map<Class<?>, IGraphContentConverter<?, ?>> contentConverterMap;
    private final Map<Class<?>, IGraphStackConverter<?, ?>> stackConverterMap;
    private final Map<Class<?>, IIngredientInfoProvider<?>> infoProviderMap;

    public GraphContentManager() {
        this.contentConverterMap = new HashMap<>();
        this.stackConverterMap = new HashMap<>();
        this.infoProviderMap = new HashMap<>();
    }

    @Override
    public <T> void registerConverter(Class<T> context, IGraphContentConverter<T, ?> converter) {
        Objects.requireNonNull(context);
        Objects.requireNonNull(converter);
        if (contentConverterMap.containsKey(context)) {
            throw new IllegalArgumentException("The converter for : " + context.getCanonicalName() + " has been registered!");
        }
        contentConverterMap.put(context, converter);
    }

    @Override
    public <T> void registerConverter(Class<T> context, IGraphStackConverter<T, ?> converter) {
        Objects.requireNonNull(context);
        Objects.requireNonNull(converter);
        if (stackConverterMap.containsKey(context)) {
            throw new IllegalArgumentException("The converter for : " + context.getCanonicalName() + " has been registered!");
        }
        stackConverterMap.put(context, converter);
    }

    @Override
    public <T> void registerInfoProvider(Class<T> context, IIngredientInfoProvider<T> provider) {
        Objects.requireNonNull(context);
        Objects.requireNonNull(provider);
        if (stackConverterMap.containsKey(context)) {
            throw new IllegalArgumentException("The provider for : " + context.getCanonicalName() + " has been registered!");
        }
        infoProviderMap.put(context, provider);
    }

    @Override
    public <T, R> @NotNull IGraphContentConverter<T, R> getConverter(Class<T> context) {
        return (IGraphContentConverter<T, R>) contentConverterMap.get(context);
    }

    @Override
    public <T, R> @NotNull IGraphContentConverter<T, R> getStackConverter(Class<T> context) {
        return (IGraphContentConverter<T, R>) stackConverterMap.get(context);
    }

    @Override
    public <T> @NotNull IIngredientInfoProvider<T> getProvider(Class<T> context) {
        return (IIngredientInfoProvider<T>) infoProviderMap.get(context);
    }

    @Override
    public <T> @NotNull IIngredientInfoProvider<T> getProvider(T ingredient) {
        return (IIngredientInfoProvider<T>) infoProviderMap.get(ingredient.getClass());
    }

    @Override
    public <T> @NotNull IGraphTag<T> createTag(IGraphTag.TagContext<T> context, long amount, int percent) {
        IGraphStackConverter<?, ?> converter = stackConverterMap.get(context.context());
        if (converter != null) {
            return (IGraphTag<T>) converter.convertTag((TagKey) context.tagKey(), amount, percent);
        }
        return new CommonTagContent<>(context, amount, percent);
    }

    @Override
    public <T, V extends IForgeRegistryEntry<V>> @NotNull List<IGraphTag<V>> createTags(List<T> ingredients, Class<V> context, long amount, int percent) {
        if (ingredients.isEmpty()) {
            return Collections.emptyList();
        }

        IGraphStackConverter<T, V> converter = (IGraphStackConverter<T, V>) stackConverterMap.get(context);
        if (converter != null) {

            ITagManager<V> tagManager = converter.getTagSupplier().get();
            List<V> converted = ingredients.stream()
                    .map(ingredient -> converter.getStackConverter().apply(ingredient))
                    .toList();
            List<ITag<V>> tagsByFirst = tagManager.stream()
                    .filter(t -> t.contains(converted.get(0)))
                    .toList();
            return tagsByFirst.stream()
                    .filter(tagKey -> check(tagKey, converted))
                    .map(ITag::getKey)
                    .map(tag -> this.createTag(new IGraphTag.TagContext<>(tag, context), amount, percent))
                    .collect(Collectors.toList());

        }
        return Collections.emptyList();
    }

    @Override
    public <T, V extends IForgeRegistryEntry<V>> @NotNull List<IGraphTag<V>> convertTags(List<IGraphContent<T>> contents, Class<V> context, long amount, int percent) {
        List<T> ingredients = contents.stream()
                .filter(IGraphIngredient.class::isInstance)
                .map(content -> ((IGraphIngredient<T>) content).get())
                .toList();

        return createTags(ingredients, context, amount, percent);
    }


    @Override
    public <T> @NotNull IGraphIngredient<T> createIngredient(T ingredient, long amount, int percent) {
        IGraphContentConverter<T, ?> converter = (IGraphContentConverter<T, ?>) contentConverterMap.get(ingredient.getClass());
        if (converter != null) {
            return (IGraphIngredient<T>) converter.convert(ingredient, amount, percent);
        }
        throw new UnsupportedOperationException(ingredient.getClass().getCanonicalName() + "doesn't register a converter!");
    }

    @Override
    public <T> @NotNull IIngredientList<T> createList(Collection<T> ingredients, long amount, int percent) {
        //TODO:
        return null;
    }

    private <T> boolean check(ITag<T> tag, List<T> ingredients) {
        return ingredients.stream()
                .allMatch(tag::contains);
    }


}
