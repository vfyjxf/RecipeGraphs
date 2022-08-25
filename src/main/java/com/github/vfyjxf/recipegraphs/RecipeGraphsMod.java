package com.github.vfyjxf.recipegraphs;

import com.github.vfyjxf.recipegraphs.config.KeyBindings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import org.eclipse.elk.core.data.LayoutMetaDataService;

@Mod(RecipeGraphsMod.MOD_ID)
public class RecipeGraphsMod {

    public static final String MOD_ID = "recipegraphs";

    public RecipeGraphsMod() {
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> KeyBindings::init);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> RecipeGraphsMod::init);
    }

    private static void init() {
        LayoutMetaDataService.getInstance(RecipeGraphsMod.class.getClassLoader());
    }

}
