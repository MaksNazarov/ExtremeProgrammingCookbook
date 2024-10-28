package hse.exam.extremeprogrammingcookbook.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;
class RecipeTest {
    @Test
    void testIngredientAddition() {
        Recipe recipe = new Recipe("KFC");
        Assertions.assertFalse(recipe.containsIngredient("chicken"));

        recipe.addIngredient("chicken", 1);
        Assertions.assertTrue(recipe.containsIngredient("chicken"));

        recipe.removeIngredient("chicken");
        Assertions.assertFalse(recipe.containsIngredient("chicken"));
    }
    @Test
    void testCookbook() {
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
}