package com.github.vfyjxf.recipegraphs;

import com.github.vfyjxf.recipegraphs.config.KeyBindings;
import com.github.vfyjxf.recipegraphs.gui.texture.GraphTextureManager;
import com.github.vfyjxf.recipegraphs.gui.texture.GraphTextures;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.eclipse.elk.core.data.LayoutMetaDataService;

@Mod(RecipeGraphsMod.MOD_ID)
public class RecipeGraphsMod {

    public static final String MOD_ID = "recipegraphs";

    public RecipeGraphsMod() {
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> KeyBindings::init);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> RecipeGraphsMod::init);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onRegisterClientReloadListenersEvent);
    }

    @SubscribeEvent
    public void onRegisterClientReloadListenersEvent(RegisterClientReloadListenersEvent event) {
        GraphTextureManager spritesManager = new GraphTextureManager(Minecraft.getInstance().textureManager);
        GraphTextures textures = new GraphTextures(spritesManager);
        event.registerReloadListener(spritesManager);
    }

    private static void init() {
        LayoutMetaDataService.getInstance(RecipeGraphsMod.class.getClassLoader());
    }

}
