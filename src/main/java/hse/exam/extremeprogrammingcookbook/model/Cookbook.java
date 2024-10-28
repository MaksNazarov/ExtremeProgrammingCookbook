package hse.exam.extremeprogrammingcookbook.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Cookbook {

    private static Set<String> global_ingredients = new TreeSet<>();
    private static Set<Recipe>recipes = new TreeSet<>();

    void addGlobalIngredient(String ingredient) {
        global_ingredients.add(ingredient);
    }

    Set<String> getAvailableIngredients() {
        return global_ingredients;
    }

    public Cookbook() {

    }

    Recipe getRecipe(String name) {
        for (Recipe recipe: recipes) {
            if (recipe.recipe_name.equals(name)) {
                return recipe;
            }
        }
        return null;
    }

    void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    private void loadIngredients(String filepath) {

    }

    private void loadRecipe(String filepath) {

    }

}
