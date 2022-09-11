package com.github.vfyjxf.recipegraphs.api.ingredients;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;

import java.util.List;

public interface IIngredientInfoProvider<T> {

    Class<T> getContext();

    long getAmount(T ingredient);

    CompoundTag getTag(T ingredient);

    List<Component> getTooltips(T ingredient);

    Component getName(T ingredient);

    Component getModId(T ingredient);

}
