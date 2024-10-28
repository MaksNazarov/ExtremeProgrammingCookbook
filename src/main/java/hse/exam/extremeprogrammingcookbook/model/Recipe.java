package hse.exam.extremeprogrammingcookbook.model;

import javafx.util.Pair;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Recipe {
    private static Map<String,Integer> ingredients = new TreeMap<>();

    public File preview_image;
    public String recipe_name;


    Recipe(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    boolean addIngredient(String ingredient, Integer measure) {
        return ingredients.put(ingredient, measure) == null;
    }

    boolean containsIngredient(String ingredient) {
        return ingredients.get(ingredient) != null;
    }

    boolean removeIngredient(String ingredient) {
        return ingredients.remove(ingredient) != null;
    }

    Map<String, Integer> getIngredientList() {
        return ingredients;
    }


}