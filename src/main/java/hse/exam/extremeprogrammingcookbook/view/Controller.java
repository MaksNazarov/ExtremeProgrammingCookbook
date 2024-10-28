package hse.exam.extremeprogrammingcookbook.view;

import hse.exam.extremeprogrammingcookbook.model.Cookbook;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class Controller {
    Cookbook cookbook;

    @FXML
    VBox recipePane = new VBox();

    @FXML
    ScrollPane scrollPane = new ScrollPane();

    @FXML
    HBox recipeAddHBox = new HBox();

    @FXML
    VBox recipeAddVBox = new VBox();

    @FXML
    TilePane recipesTilePane = new TilePane();

    public Controller() {
         cookbook = new Cookbook();
    }

    @FXML
    void initialize() {

    }

    @FXML
    protected void onAddRecipeClick() {

    }
}