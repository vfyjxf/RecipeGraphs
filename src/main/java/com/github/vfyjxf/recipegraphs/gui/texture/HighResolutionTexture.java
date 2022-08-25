package com.github.vfyjxf.recipegraphs.gui.texture;

import com.github.vfyjxf.recipegraphs.api.gui.texture.IGuiTexture;
import com.google.common.base.Preconditions;
import com.mojang.blaze3d.vertex.PoseStack;
import mezz.jei.gui.elements.HighResolutionDrawable;

/**
 * Based on {@link HighResolutionDrawable}
 */
public class HighResolutionTexture implements IGuiTexture {

    private final IGuiTexture texture;
    private final int scale;

    public HighResolutionTexture(IGuiTexture texture, int scale) {
        int width = texture.getWidth();
        int height = texture.getHeight();
        Preconditions.checkArgument(
                width % scale == 0,
                String.format("drawable width %s must be divisible by the scale %s", width, scale)
        );
        Preconditions.checkArgument(
                height % scale == 0,
                String.format("drawable height %s must be divisible by the scale %s", height, scale)
        );

        this.texture = texture;
        this.scale = scale;
    }

    @Override
    public int getWidth() {
        return texture.getWidth() / scale;
    }

    @Override
    public int getHeight() {
        return texture.getHeight() / scale;
    }

    @Override
    public void draw(PoseStack poseStack, int xOffset, int yOffset) {
        poseStack.pushPose();
        {
            poseStack.translate(xOffset, yOffset, 0);
            poseStack.scale(1 / (float) scale, 1 / (float) scale, 1);
            this.texture.draw(poseStack);
        }
        poseStack.popPose();
    }

    @Override
    public void draw(PoseStack poseStack) {
        poseStack.pushPose();
        {
            poseStack.scale(1 / (float) scale, 1 / (float) scale, 1);
            this.texture.draw(poseStack);
        }
        poseStack.popPose();
    }
}
