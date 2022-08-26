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

    private final ResourceNineSliceTexture slotBackground;
    private final ResourceNineSliceTexture buttonDisabled;
    private final ResourceNineSliceTexture buttonEnabled;
    private final ResourceNineSliceTexture buttonHighlight;
    private final HighResolutionTexture graphIcon;

    public GraphTextures(GraphTextureManager textureManager) {
        this.textureManager = textureManager;
        {
            this.slotBackground = registerNineSliceGuiSprite("slot_background", 64, 64, 6, 6, 6, 6);
            this.buttonDisabled = registerNineSliceGuiSprite("button_disabled", 20, 20, 6, 6, 6, 6);
            this.buttonEnabled = registerNineSliceGuiSprite("button_enabled", 20, 20, 6, 6, 6, 6);
            this.buttonHighlight = registerNineSliceGuiSprite("button_highlight", 20, 20, 6, 6, 6, 6);
            ResourceTexture graphIcon = registerGuiSprite("icons/diagram_icon", 32, 32)
                    .trim(1, 2, 1, 1);
            this.graphIcon = new HighResolutionTexture(graphIcon, 4);
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

    public ResourceNineSliceTexture getButtonForState(boolean enabled, boolean hovered) {
        if (!enabled) {
            return buttonDisabled;
        } else if (hovered) {
            return buttonHighlight;
        } else {
            return buttonEnabled;
        }
    }

    public GraphTextureManager getTextureManager() {
        return textureManager;
    }

    public ResourceNineSliceTexture getSlotBackground() {
        return slotBackground;
    }

    public ResourceNineSliceTexture getButtonDisabled() {
        return buttonDisabled;
    }

    public ResourceNineSliceTexture getButtonEnabled() {
        return buttonEnabled;
    }

    public ResourceNineSliceTexture getButtonHighlight() {
        return buttonHighlight;
    }

    public HighResolutionTexture getGraphIcon() {
        return graphIcon;
    }
}
