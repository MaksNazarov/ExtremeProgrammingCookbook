package hse.exam.extremeprogrammingcookbook.model;

import java.io.*;
import java.util.*;

public class Cookbook {
    private static final String recipes_file = "recipes.txt";
    private static Set<String> global_ingredients = new TreeSet<>();
    private static Set<Recipe>recipes = new TreeSet<>(Comparator.comparing(r -> r.recipe_name));

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

    void makeRecipeList() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(recipes_file))) {
            for (Recipe recipe: recipes) {
                String content = recipe.recipe_name + '\n' + recipe.description;
                writer.write(content);
                writer.newLine();
            }
            System.out.println("Recipe list created successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    void makeCookbookFromFile() {
        recipes.clear();

    }

    private void loadIngredients(String filepath) {

    }

    private void loadRecipe(String filepath) {

    }

}
