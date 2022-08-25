package com.github.vfyjxf.recipegraphs.gui;

import com.github.vfyjxf.recipegraphs.RecipeGraphsMod;
import com.github.vfyjxf.recipegraphs.config.KeyBindings;
import com.github.vfyjxf.recipegraphs.jei.RecipeDiagramsPlugin;
import com.mojang.blaze3d.platform.InputConstants;
import mezz.jei.gui.recipes.RecipeLayout;
import mezz.jei.gui.recipes.RecipesGui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.TextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RecipeGraphsMod.MOD_ID, value = Dist.CLIENT)
public class GuiEventHandler {

    private static RecipeGraphGui gui = new RecipeGraphGui();

    @SubscribeEvent
    public static void onKeyboardKeyPressedEvent(ScreenEvent.KeyboardKeyPressedEvent.Pre event) {
        InputConstants.Key input = InputConstants.getKey(event.getKeyCode(), event.getScanCode());
        if (KeyBindings.openGraphGui.isActiveAndMatches(input)) {
            Minecraft.getInstance().setScreen(gui);
        }
    }

    @SubscribeEvent
    public static void onRecipeGuiInit(ScreenEvent.InitScreenEvent.Post event) {
        if (event.getScreen() instanceof RecipesGui recipesGui) {
            for (RecipeLayout<?> recipeLayout : RecipeDiagramsPlugin.getRecipeLayouts(recipesGui)) {
                Button button = recipeLayout.getRecipeTransferButton();
                event.addListener(new Button(button.x, button.y - 15,13,13, TextComponent.EMPTY,(b) ->{

                }));
            }
        }
    }

}
