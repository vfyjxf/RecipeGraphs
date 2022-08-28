package com.github.vfyjxf.recipegraphs.ingredient;

import com.github.vfyjxf.recipegraphs.api.ingredients.IGraphContent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ItemIngredient extends AbstractIngredient<Item> {

    private final CompoundTag compoundTag;

    public ItemIngredient(@NotNull ItemStack stack, int percent) {
        super(stack.getItem(), stack.getCount(), percent);
        this.compoundTag = stack.getTag();
    }

    public ItemIngredient(@NotNull ItemStack stack) {
        super(stack.getItem(), stack.getCount());
        this.compoundTag = stack.getTag();
    }

    @Override
    public <C extends IGraphContent<Item>> boolean merge(@NotNull C c1, @NotNull C c2) {
        return false;
    }
}
