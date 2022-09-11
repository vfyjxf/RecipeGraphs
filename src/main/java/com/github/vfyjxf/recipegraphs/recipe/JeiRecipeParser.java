package com.github.vfyjxf.recipegraphs.recipe;

import com.github.vfyjxf.recipegraphs.api.ingredients.*;
import com.github.vfyjxf.recipegraphs.api.recipe.IRecipeParser;
import com.github.vfyjxf.recipegraphs.api.recipe.IRecipeParserManager;
import com.github.vfyjxf.recipegraphs.api.recipe.RecipeRole;
import mezz.jei.api.gui.ingredient.IRecipeSlotView;
import mezz.jei.api.ingredients.ITypedIngredient;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.gui.recipes.RecipeLayout;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

/**
 * We use jei api to parse out the recipe information and
 * provide the api for the mod author to intervene in this operation
 * to provide more specific information.
 * <p>
 * Recipes should usually have only three Ingredient,
 * and CATALYST should be the machine that processes the recipe, not the actual "catalyst".
 */
@SuppressWarnings("unchecked")
public class JeiRecipeParser implements IRecipeParser<RecipeLayout, JeiRecipeParser.RecipeIngredients> {

    private final IRecipeParserManager parserManager;
    private final IGraphContentManager contentManager;

    public JeiRecipeParser(IRecipeParserManager parserManager, IGraphContentManager contentManager) {
        this.parserManager = parserManager;
        this.contentManager = contentManager;
    }

    @Override
    public @NotNull Class<RecipeLayout> getRecipeClass() {
        return RecipeLayout.class;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <R> @NotNull Map<RecipeRole, Collection<RecipeIngredients>> parseRecipe(@NotNull RecipeLayout recipeLayout) {
        R recipe = (R) recipeLayout.getRecipe();
        IRecipeParser<R, ?> recipeParser = parserManager.getRecipeParser(recipe);
        HashMap<RecipeRole, Collection<RecipeIngredients>> ingredientMap = new HashMap<>(RecipeRole.values().length);
        if (recipeParser != null) {
            //use the special parser
            if (recipeParser.isChanceRecipe(recipe)) {
                //TODO:
            } else {
                Map<RecipeRole, ? extends Collection<?>> recipeInfo = recipeParser.parseRecipe(recipe);
                recipeInfo.forEach((key, value) -> ingredientMap.put(key, castIngredients(value)));
                return ingredientMap;
            }

        } else {
            //use the universal parser
            ingredientMap.put(RecipeRole.INPUT, getIngredients(recipeLayout, RecipeIngredientRole.INPUT));
            ingredientMap.put(RecipeRole.OUTPUT, getIngredients(recipeLayout, RecipeIngredientRole.OUTPUT));
            ingredientMap.put(RecipeRole.CATALYST, getIngredients(recipeLayout, RecipeIngredientRole.CATALYST));
        }
        return ingredientMap;
    }

    private List<RecipeIngredients> getIngredients(RecipeLayout<?> recipeLayout, RecipeIngredientRole role) {
        return recipeLayout.getRecipeSlots()
                .getView()
                .getSlotViews(role)
                .stream()
                .map(slotView -> {
                    boolean mixedSlot = isMixedSlot(slotView);
                    List<?> ingredients = slotView.getAllIngredients().map(ITypedIngredient::getIngredient).toList();
                    IGraphContent<?> contents = createContent(mixedSlot, ingredients);
                    return new RecipeIngredients(mixedSlot, contents);
                })
                .collect(Collectors.toList());
    }

    private boolean isMixedSlot(@NotNull IRecipeSlotView slotView) {
        return slotView.getAllIngredients()
                .parallel()
                .map(ITypedIngredient::getType)
                .distinct()
                .count() > 1;
    }

    private <T> List<RecipeIngredients> castIngredients(@NotNull Collection<?> origin) {
        if (origin.isEmpty()) {
            return Collections.emptyList();
        }
        List<RecipeIngredients> ingredients = new ArrayList<>();
        for (Object object : origin) {
            if (object instanceof List<?> list) {
                boolean isMixedSlot = list.stream().map(Object::getClass).distinct().count() > 1;
                ingredients.add(new RecipeIngredients(isMixedSlot, createContent(isMixedSlot, list)));
            } else {
                T ingredient = (T) object;
                IGraphContent<?> content;
                IIngredientInfoProvider<T> provider = contentManager.getProvider(ingredient);
                if (provider == null) {
                    content = IGraphContent.empty();
                } else {
                    content = contentManager.createIngredient(ingredient, provider.getAmount(ingredient), 1000);
                }
                ingredients.add(new RecipeIngredients(false, content));
            }
        }

        return ingredients;
    }

    @SuppressWarnings("rawtypes")
    private @NotNull <T, R> IGraphContent<R> createContent(boolean isMixedSlot, List<T> ingredients) {
        if (ingredients.isEmpty()) {
            return IGraphContent.empty();
        }
        T first = ingredients.get(0);
        IIngredientInfoProvider<T> provider = contentManager.getProvider(first);
        if (provider == null) return IGraphContent.empty();
        long amount = provider.getAmount(first);

        if (isMixedSlot) {
            return (IGraphContent<R>) contentManager.createList(new ArrayList<>(ingredients), amount);
        } else {
            if (ingredients.size() > 1) {
                IGraphStackConverter stackConverter = (IGraphStackConverter) contentManager.getStackConverter(first.getClass());
                if (stackConverter == null) return (IGraphContent<R>) IGraphTag.empty();

                List<IGraphTag<R>> tags = contentManager.createTags(ingredients, stackConverter.getTagContext(), amount, 1000);
                return tags.isEmpty() ? (IGraphContent<R>) contentManager.createIngredient(first, amount) : (IGraphContent<R>) tags.get(0);
            } else {
                return (IGraphContent<R>) contentManager.createIngredient(first, amount);
            }
        }
    }

    public record RecipeIngredients(boolean isMixedSlot, @NotNull IGraphContent<?> ingredients) {

    }

    /*
    private List<Pair<Boolean, Set<ITypedIngredient<?>>>> getIngredients(RecipeLayoutBuilder builder, RecipeIngredientRole role) {
        return ((RecipeLayoutBuilderAccessor) builder).callSlotStream()
                .filter(slot -> slot.getRole() == role && slot instanceof RecipeSlotBuilder)
                .map(slot -> {
                    boolean simpleSlot = slot.getIngredientTypes().count() == 1;
                    return Pair.of(simpleSlot, ((RecipeSlotBuilderAccessor) slot).getIngredients().getAllIngredients());
                })
                .map(pair -> Pair.of(pair.getLeft(),
                        pair.getRight().parallelStream()
                                .flatMap(Optional::stream)
                                .collect(Collectors.toSet()))
                )
                .filter(pair -> !pair.getRight().isEmpty())
                .collect(Collectors.toList());
    }

     */

}
