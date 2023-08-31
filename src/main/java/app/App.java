package app;

import controller.detailScreen.DetailScreenController;
import controller.mainScreen.MainScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.FxmlPathImpl;
import util.SwitchScene;

import java.io.IOException;


public class App extends Application {

    private boolean isVisible;
    private AnchorPane cardView;
    private Stage stage;
    private Scene detailScene;
    private Scene mainScene;
    private MainScreenController mainScreenController;
    private DetailScreenController detailScreenController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        mainScene = mainScene();
        detailScene = detailScene();

        mainScreenController.setDetailScene(detailScene);
        detailScreenController.setMainScene(mainScene);
        SwitchScene.setMainScreenController(mainScreenController);
        SwitchScene.setDetailScreenController(detailScreenController);

        SwitchScene.setStage(stage);

        stage.setScene(mainScene);
        this.stage = stage;
        this.stage.setTitle("PokeFx");
        this.stage.setResizable(false);
        this.stage.getIcons().add(new Image(getClass().getResource("/img/pokemon.png").toExternalForm()));
        this.stage.show();
    }



    Scene detailScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(new FxmlPathImpl().getPokeDetail());
        Parent root = loader.load();
        Scene detailScene = new Scene(root);

        detailScreenController = loader.getController();

        return detailScene;
    }

    Scene mainScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(new FxmlPathImpl().getMainScreenFxml());
        Parent root = loader.load();

        Scene mainScene = new Scene(root);
        mainScreenController = loader.getController();
        cardView = mainScreenController.getCardView();

        mainScene.setOnKeyPressed(keyEvent -> {
            switch ((keyEvent.getCode())) {
                case ENTER -> {
                    mainScreenController.searchPoke(null);
                }
            }
        });

        mainScene.widthProperty().addListener((observableValue, number, t1) -> {
            if (Double.isNaN(number.doubleValue())) {
                return;
            }
            widthListener(mainScene);
        });

        return mainScene;
    }

    void widthListener(Scene scene) {
        double width = scene.getWidth();
        isVisible = true;

        if (width < 970) {
            isVisible = false;
        } else if (width < 1200) {
            cardView.setLayoutX(84);
        } else if (width < 1300) {
            cardView.setLayoutX(100);
        } else if (width < 1500) {
            cardView.setLayoutX(120);
        } else if (width < 1600) {
            cardView.setLayoutX(150);
        } else {
            cardView.setLayoutX(200);
        }

        cardView.setVisible(isVisible);
    }


}
