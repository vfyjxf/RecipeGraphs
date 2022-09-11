package com.github.vfyjxf.recipegraphs.ingredient.converter;

import com.github.vfyjxf.recipegraphs.api.ingredients.IGraphIngredient;
import com.github.vfyjxf.recipegraphs.api.ingredients.IGraphStackConverter;
import com.github.vfyjxf.recipegraphs.api.ingredients.IGraphTag;
import com.github.vfyjxf.recipegraphs.ingredient.ItemIngredient;
import com.github.vfyjxf.recipegraphs.ingredient.tag.ItemTagContent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITagManager;

import java.util.function.Function;
import java.util.function.Supplier;

public class ItemStackConverter implements IGraphStackConverter<ItemStack, Item> {

    @Override
    public Class<ItemStack> getContext() {
        return ItemStack.class;
    }

    @Override
    public Class<Item> getTagContext() {
        return Item.class;
    }

    @Override
    public IGraphIngredient<Item> convert(ItemStack content, long amount, int percent) {
        return new ItemIngredient(content, percent);
    }

    @Override
    public Supplier<ITagManager<Item>> getTagSupplier() {
        return ForgeRegistries.ITEMS::tags;
    }

    @Override
    public Function<ItemStack, Item> getStackConverter() {
        return ItemStack::getItem;
    }


    @Override
    public IGraphTag<Item> convertTag(TagKey<Item> tagKey, long amount, int percent) {
        return new ItemTagContent(tagKey, amount, percent);
    }

}
