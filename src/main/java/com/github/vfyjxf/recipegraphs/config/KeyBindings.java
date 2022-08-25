package com.github.vfyjxf.recipegraphs.config;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {
    public static final KeyMapping openGraphGui;

    static {
        openGraphGui = new KeyMapping("key.recipetree.openGraphGui", KeyConflictContext.GUI, KeyModifier.CONTROL, getKey(GLFW.GLFW_KEY_F), "key.recipetree.category");
    }

    static InputConstants.Key getKey(int key) {
        return InputConstants.Type.KEYSYM.getOrCreate(key);
    }

    public static void init() {
        ClientRegistry.registerKeyBinding(openGraphGui);
    }
}
