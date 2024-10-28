package hse.exam.extremeprogrammingcookbook.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}