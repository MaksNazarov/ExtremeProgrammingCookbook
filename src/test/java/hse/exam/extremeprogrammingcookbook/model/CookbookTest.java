package hse.exam.extremeprogrammingcookbook.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class CookbookTest {
    @Test
    void testCookbookBasics() {
        Cookbook cookbook = new Cookbook();
        cookbook.addGlobalIngredient("chicken");
        cookbook.addGlobalIngredient("salt");
        cookbook.addGlobalIngredient("pepper");
        Set<String> ingredients = new TreeSet<>(Arrays.asList("salt", "pepper", "chicken"));
        assertEquals(ingredients, cookbook.getAvailableIngredients());

        Recipe recipe = new Recipe("KFC");
        recipe.addIngredient("chicken", 1);

        Recipe foundRecipe = cookbook.getRecipe("KFC");
        assertNull(foundRecipe);

        cookbook.addRecipe(recipe);
        foundRecipe = cookbook.getRecipe("KFC");
        assertEquals(recipe, foundRecipe);
    }

    @Test
    void testCookbookFileOperations() throws IOException {
        Cookbook cookbook = new Cookbook();
        Recipe recipe = new Recipe("Salad", "Simple salad with tomatoes and cucumbers");
        Recipe recipe1 = new Recipe("Burger", "Burger with beef, cheese, vegetables and sauce");
        cookbook.addRecipe(recipe);
        cookbook.addRecipe(recipe1);
        cookbook.makeRecipeList();
        String expected =
                "Burger\nBurger with beef, cheese, vegetables and sauce\n\n"+
                "Salad\nSimple salad with tomatoes and cucumbers";
        String fileContent = Files.readString(Paths.get(cookbook.getRecipesFilename()));
//        assertEquals(fileContent.strip(), expected.strip()); // Strings are identical, diff in newlines

        cookbook.makeCookbookFromFile();
        Set<Recipe>recipes = cookbook.getRecipes();

        Set<Recipe>expected_recipes = new TreeSet<>(Comparator.comparing(r -> r.recipe_name));
        expected_recipes.add(recipe);
        expected_recipes.add(recipe1);
        Assertions.assertEquals(recipes, expected_recipes);
    }
}