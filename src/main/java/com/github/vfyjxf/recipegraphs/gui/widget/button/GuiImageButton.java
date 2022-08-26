package com.github.vfyjxf.recipegraphs.gui.widget.button;

import com.github.vfyjxf.recipegraphs.api.gui.texture.IGuiTexture;
import com.github.vfyjxf.recipegraphs.gui.texture.GraphTextures;
import com.github.vfyjxf.recipegraphs.gui.texture.ResourceNineSliceTexture;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import mezz.jei.gui.elements.DrawableNineSliceTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.TextComponent;

import java.awt.*;

public class GuiImageButton extends Button {

    private final IGuiTexture image;
    private Rectangle area;

    public GuiImageButton(int x, int y, int width, int height, IGuiTexture image, OnPress onPress) {
        super(x, y, width, height, TextComponent.EMPTY, onPress);
        this.image = image;
        this.area = new Rectangle(x, y, width, height);
    }

    public GuiImageButton(Rectangle area, IGuiTexture image, OnPress onPress) {
        super(area.x, area.y, area.width, area.height, TextComponent.EMPTY, onPress);
        this.image = image;
        this.area = new Rectangle(x, y, width, height);
    }

    public Rectangle getArea() {
        return area;
    }

    public void setArea(Rectangle area) {
        this.area = area;
    }

    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        if (this.visible) {
            Minecraft minecraft = Minecraft.getInstance();
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            boolean hovered = isMouseOver(mouseX, mouseY);
            ResourceNineSliceTexture texture = GraphTextures.getInstance().getButtonForState(this.active, hovered);
            texture.draw(poseStack, this.x, this.y, this.width, this.height);
            this.renderBg(poseStack, minecraft, mouseX, mouseY);

            int color = 14737632;
            if (packedFGColor != 0) {
                color = packedFGColor;
            } else if (!this.active) {
                color = 10526880;
            } else if (hovered) {
                color = 16777120;
            }
            if ((color & -67108864) == 0) {
                color |= -16777216;
            }

            float red = (color >> 16 & 255) / 255.0F;
            float blue = (color >> 8 & 255) / 255.0F;
            float green = (color & 255) / 255.0F;
            float alpha = (color >> 24 & 255) / 255.0F;
            RenderSystem.setShaderColor(red, blue, green, alpha);

            double xOffset = x + (width - this.image.getWidth()) / 2.0;
            double yOffset = y + (height - this.image.getHeight()) / 2.0;
            poseStack.pushPose();
            {
                poseStack.translate(xOffset, yOffset, 0);
                this.image.draw(poseStack);
            }
            poseStack.popPose();
        }
    }


}
