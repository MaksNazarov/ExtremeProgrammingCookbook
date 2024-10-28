package hse.exam.extremeprogrammingcookbook.view;

import hse.exam.extremeprogrammingcookbook.model.Cookbook;
import hse.exam.extremeprogrammingcookbook.model.Recipe;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class Controller {
    Cookbook cookbook;


    @FXML
    private BorderPane rootBorderPane = new BorderPane();

    @FXML
    VBox recipeViewContainer = new VBox();

    @FXML
    HBox recipeAddContainer = new HBox();

    @FXML
    TilePane recipesTilePane = new TilePane();

    public Controller() {
         cookbook = new Cookbook();
    }

    public void initialize() {
        cookbook.makeCookbookFromFile();
        rootBorderPane.setOnMouseClicked(event -> {
            System.out.println("yeah");
            if (!event.getTarget().equals(singleRecipeViewBox)) {
                singleRecipeViewBox.setVisible(false);
            }
        });
        loadRecipeListInView();
    }

    @FXML
    protected void seeAddRecipeMenu() {
        recipeViewContainer.setVisible(false);
        recipeAddContainer.setVisible(true);
    }

    @FXML
    public void saveRecipes() {
        cookbook.makeRecipeList();
    }

    @FXML
    void loadRecipeListInView() {
        recipeViewContainer.setVisible(true);
        recipesTilePane.getChildren().clear();

        for (Recipe recipe : cookbook.getRecipes()) {
            Button recipeButton = new Button(recipe.recipe_name);
            recipeButton.setOnAction(event -> showRecipeDescription(recipe));
            recipesTilePane.getChildren().add(recipeButton);
        }
    }

    @FXML
    VBox singleRecipeViewBox = new VBox();

    @FXML
    Label singleRecipeTitle = new Label();

    @FXML
    Label singleRecipeDescription = new Label();

    @FXML
    void showRecipeDescription(Recipe recipe) {
        System.out.println("Show recipe works");
        singleRecipeTitle.setText(recipe.recipe_name);
        singleRecipeDescription.setText(recipe.description);
        singleRecipeViewBox.setVisible(true);
    }

    @FXML
    protected void goBackToRecipeListMenu() {
        recipeAddContainer.setVisible(false);
        loadRecipeListInView();
    }

    @FXML
    TextField recipeTitle = new TextField();
    @FXML
    TextArea recipeDescription = new TextArea();

    @FXML
    protected void onClickBtnAddRecipe() {
        String title = recipeTitle.getText();
        String description = recipeDescription.getText();

        Recipe recipe = new Recipe(title, description);
        cookbook.addRecipe(recipe);

        recipeTitle.clear();
        recipeDescription.clear();

        goBackToRecipeListMenu();
    }

}