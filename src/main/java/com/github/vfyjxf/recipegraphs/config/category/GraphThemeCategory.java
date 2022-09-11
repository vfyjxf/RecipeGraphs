package com.github.vfyjxf.recipegraphs.config.category;

import com.github.vfyjxf.recipegraphs.config.theme.GraphThemes;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class GraphThemeCategory extends AbstractConfigCategory {

    private final ForgeConfigSpec.ConfigValue<ResourceLocation> currentTheme;
    private final ForgeConfigSpec.IntValue linkedColor;

    public GraphThemeCategory(ForgeConfigSpec.Builder builder) {
        super(ConfigCategories.THEME_CATEGORY);
        builder.push(categoryName);
        {
            configValues.addAll(List.of(
                    currentTheme = builder.comment("The theme of current graph").define("CurrentTheme", GraphThemes.SIMPLE_RAINBOW.uid()),
                    linkedColor = builder.comment("The linked color of SingleColor Theme").defineInRange("LinkedColor", 0x000000, Integer.MIN_VALUE, Integer.MAX_VALUE)
            ));
        }
        builder.pop();
    }

    public ForgeConfigSpec.ConfigValue<ResourceLocation> getCurrentTheme() {
        return currentTheme;
    }

    public int getLinkedColor() {
        return linkedColor.get();
    }
}
