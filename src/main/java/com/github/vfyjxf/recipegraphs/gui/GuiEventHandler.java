package com.github.vfyjxf.recipegraphs.gui;

import com.github.vfyjxf.recipegraphs.RecipeGraphsMod;
import com.github.vfyjxf.recipegraphs.config.KeyBindings;
import com.github.vfyjxf.recipegraphs.jei.RecipeGraphsPlugin;
import com.github.vfyjxf.recipegraphs.mixin.RecipeLayoutAccessor;
import com.mojang.blaze3d.platform.InputConstants;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.gui.recipes.RecipeLayout;
import mezz.jei.gui.recipes.RecipesGui;
import mezz.jei.ingredients.IIngredientSupplier;
import mezz.jei.recipes.IngredientSupplierHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.stream.Collectors;

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
            for (RecipeLayout recipeLayout : RecipeGraphsPlugin.getRecipeLayouts(recipesGui)) {
            }
        }
    }

}
