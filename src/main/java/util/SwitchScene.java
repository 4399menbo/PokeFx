package util;

import controller.detailScreen.DetailScreenController;
import controller.mainScreen.MainScreenController;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SwitchScene {
    private static MainScreenController mainScreenController;
    private static DetailScreenController detailScreenController;
    private static Stage stage;
    public static void switchScene(Stage stage, Scene scene){
        stage.setScene(scene);
    }

    public static void setStage(Stage stage1){
        stage = stage1;
    }

    public static Stage getStage() {
        return stage;
    }

    public static DetailScreenController getDetailScreenController() {
        return detailScreenController;
    }

    public static void setDetailScreenController(DetailScreenController detailScreenController) {
        SwitchScene.detailScreenController = detailScreenController;
    }

    public static MainScreenController getMainScreenController() {
        return mainScreenController;
    }

    public static void setMainScreenController(MainScreenController mainScreenController) {
        SwitchScene.mainScreenController = mainScreenController;
    }
}
