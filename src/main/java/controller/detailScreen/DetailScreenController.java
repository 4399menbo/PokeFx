package controller.detailScreen;

import app.TextConvert;
import io.github.palexdev.materialfx.controls.MFXProgressBar;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;
import util.Config;
import util.SwitchScene;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class DetailScreenController implements Initializable {
    @FXML
    private WebView colorBg;

    @FXML
    private ImageView pokeIcon;

    @FXML
    private Label pokeName;

    @FXML
    private TextArea pokeType;

    @FXML
    private TextArea stat;

    @FXML
    private VBox progressParent;

    @FXML
    private Label pokeId;

    private Scene mainScene;
    private AnimationTimer animationTimer;
    private ScaleTransition scaleIn;
    private ScaleTransition scaleOut;
    private SequentialTransition sequentialTransition;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        try {
            loadBgSvg("black");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void switchScene(ActionEvent event) {
        SwitchScene.switchScene(SwitchScene.getStage(),mainScene);
    }

    public void loadBgSvg(String color) {

        WebEngine webEngine = colorBg.getEngine();
        //colorBg.setBlendMode(BlendMode.DARKEN);
        // Load the HTML template file

        String svg = new TextConvert("/img/colorBack.svg").getContent();

        String template = new TextConvert("/html/ColorBack.html")
                .textReplace("svg", svg)
                .textReplace("color", color)
                .textReplace("backImg", getClass().getResource("/img/mainScreen.png").toExternalForm())
                .getContent();


        // Replace the placeholder in the template with the SVG URL
        webEngine.loadContent(template);


    }

    public void setPokeInfo(String id,Image image, String name, String type, String experience) {
        pokeIcon.setImage(image);
        pokeName.setText(name);
        pokeType.setText("TYPE:" + type + "\n" +
                "EXPERIENCE:" + experience);

        pokeId.setText("No."+id);
    }

    public void setPokeStat(long hp, long att, long def, long spe_att, long spe_def, long spe) {
        double max = 0;
        List<Long> stats = new ArrayList<Long>();
        stats.add(hp);
        stats.add(att);
        stats.add(def);
        stats.add(spe_att);
        stats.add(spe_def);
        stats.add(spe);

        for (int i = 0; i < stats.size(); i++) {

            if (max < stats.get(i)) {
                max = stats.get(i);
            }
        }

        stat.setText("HP:" + hp + "\n" +
                "ATT:" + att + "\n" +
                "DEF:" + def + "\n" +
                "SPE-ATT:" + spe_att + "\n" +
                "SPE-DEF:" + spe_def + "\n" +
                "SPE:" + spe);

        for (int i = 0; i < progressParent.getChildren().size(); i++) {
            MFXProgressBar progressBar = (MFXProgressBar) progressParent.getChildren().get(i);
            progressBar.setProgress(0.95);
        }

        setProgressAni(stats, max);

        pokeIconAni();
    }

    void pokeIconAni(){
        scaleIn = new ScaleTransition(Config.QUICK_SPEED,pokeIcon);
        scaleIn.setFromX(1);
        scaleIn.setToX(1.4);
        scaleIn.setFromY(1);
        scaleIn.setToY(1.4);
        scaleIn.setInterpolator(Interpolator.EASE_OUT);
        scaleIn.setCycleCount(1);

        scaleOut = new ScaleTransition(Config.QUICK_SPEED,pokeIcon);
        scaleOut.setFromX(1.4);
        scaleOut.setToX(1.2);
        scaleOut.setFromY(1.4);
        scaleOut.setToY(1.2);
        scaleOut.setInterpolator(Interpolator.EASE_IN);
        scaleOut.setCycleCount(1);

        sequentialTransition = new SequentialTransition(scaleIn, scaleOut);
        sequentialTransition.play();

    }

    void setProgressAni(List<Long> stats, double max) {

        if (animationTimer != null)
            animationTimer.stop();
        animationTimer = new AnimationTimer() {

            long lastTime = System.nanoTime();

            @Override
            public void handle(long l) {
                double deltaTime = (l - lastTime) / 1e9; // Convert nanoseconds to seconds

                for (int i = 0; i < progressParent.getChildren().size(); i++) {
                    MFXProgressBar progressBar = (MFXProgressBar) progressParent.getChildren().get(i);
                    double person = 1.0 - stats.get(i) / max;

                    if (progressBar.getProgress() > person) {
                        progressBar.setProgress(progressBar.getProgress() - 0.05 * deltaTime);

                    } else if (progressBar.getProgress() < person) {
                        progressBar.setProgress(person);
                    }
                }
            }
        };

        animationTimer.start();
    }

    public void setMainScene(Scene mainScene) {
        this.mainScene = mainScene;
    }

}
