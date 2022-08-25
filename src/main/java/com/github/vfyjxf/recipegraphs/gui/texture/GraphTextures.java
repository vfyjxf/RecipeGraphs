package com.github.vfyjxf.recipegraphs.gui.texture;

import com.github.vfyjxf.recipegraphs.RecipeGraphsMod;
import net.minecraft.resources.ResourceLocation;

/**
 * Based on {@link mezz.jei.gui.textures.Textures}
 */
public class GraphTextures {

    private static GraphTextures instance;

    private final GraphTextureManager textureManager;

    public static GraphTextures getInstance() {
        return instance;
    }

    public GraphTextures(GraphTextureManager textureManager) {
        this.textureManager = textureManager;
        {

        }
        instance = this;
    }

    private ResourceLocation registerSprite(String name) {
        ResourceLocation location = new ResourceLocation(RecipeGraphsMod.MOD_ID, name);
        textureManager.registerSprite(location);
        return location;
    }

    private ResourceTexture registerGuiSprite(String name, int width, int height) {
        ResourceLocation location = registerSprite(name);
        return new ResourceTexture(textureManager, location, width, height);
    }

    private ResourceNineSliceTexture registerNineSliceGuiSprite(String name, int width, int height, int left, int right, int top, int bottom) {
        ResourceLocation location = registerSprite(name);
        return new ResourceNineSliceTexture(textureManager, location, width, height, left, right, top, bottom);
    }

}
