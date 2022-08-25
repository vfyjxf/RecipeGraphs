package com.github.vfyjxf.recipegraphs.jei;

import com.github.vfyjxf.recipegraphs.container.RecipeDataContainer;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.transfer.IRecipeTransferError;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandler;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RecipeTransferHandler implements IRecipeTransferHandler<RecipeDataContainer, Object> {
    @Override
    public @NotNull Class<RecipeDataContainer> getContainerClass() {
        return RecipeDataContainer.class;
    }

    @Override
    public @NotNull Class<Object> getRecipeClass() {
        //In fact, it is useless.
        return Object.class;
    }

    @Override
    public @Nullable IRecipeTransferError transferRecipe(
            @NotNull RecipeDataContainer container,
            @NotNull Object recipe,
            @NotNull IRecipeSlotsView recipeSlots,
            @NotNull Player player,
            boolean maxTransfer,
            boolean doTransfer
    ) {
        return null;
    }


}
