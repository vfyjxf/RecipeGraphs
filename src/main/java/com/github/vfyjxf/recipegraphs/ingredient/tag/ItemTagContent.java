package com.github.vfyjxf.recipegraphs.ingredient.tag;

import com.github.vfyjxf.recipegraphs.api.ingredients.IGraphTag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ItemTagContent extends AbstractTagContent<Item> {

    public ItemTagContent(TagKey<Item> tagKey, long amount, int percent) {
        super(tagKey, amount, percent);
    }

    public ItemTagContent(TagKey<Item> tagKey, long amount) {
        super(tagKey, amount);
    }

    public ItemTagContent(IGraphTag<Item> graphTag) {
        super(graphTag);
    }

    @Override
    public <C extends IGraphTag<Item>> boolean merge(C c1, C c2) {
        return false;
    }

    @Override
    public <C extends IGraphTag<Item>> boolean mergeFuzzy(C c1, C c2) {
        return false;
    }
}
