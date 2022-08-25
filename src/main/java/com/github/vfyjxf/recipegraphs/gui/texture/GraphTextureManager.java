package com.github.vfyjxf.recipegraphs.gui.texture;

import com.github.vfyjxf.recipegraphs.api.Globals;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.TextureAtlasHolder;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Based on {@link mezz.jei.gui.textures.JeiSpriteUploader}
 */
public class GraphTextureManager extends TextureAtlasHolder {
    private final Set<ResourceLocation> sprites = new HashSet<>();

    public GraphTextureManager(TextureManager textureManager) {
        super(textureManager, Globals.LOCATION_GRAPH_TEXTURE_ATLAS, "gui");
    }

    public void registerSprite(ResourceLocation location) {
        sprites.add(location);
    }

    @Override
    protected @NotNull Stream<ResourceLocation> getResourcesToLoad() {
        return Collections.unmodifiableSet(sprites).stream();
    }

    @Override
    public @NotNull TextureAtlasSprite getSprite(@NotNull ResourceLocation location) {
        return super.getSprite(location);
    }
}
