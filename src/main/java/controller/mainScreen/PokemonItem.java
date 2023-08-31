package controller.mainScreen;

import app.APIConnector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leewyatt.rxcontrols.controls.RXAvatar;
import io.github.palexdev.materialfx.controls.MFXProgressSpinner;
import io.github.palexdev.materialfx.utils.SwingFXUtils;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.pokemon.Pokemon;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.json.simple.JSONObject;
import util.BufferedImageTranscoder;
import util.FechStat;
import util.FxmlPathImpl;
import util.Util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class PokemonItem extends AnchorPane {
    @FXML
    private MFXProgressSpinner AvatorLoad;

    @FXML
    private RXAvatar pokeAvator;

    @FXML
    private ImageView pokeBall;

    @FXML
    private Label pokeId;

    @FXML
    private Label pokeName;

    private Pokemon pokemon;
    private Image svgImg = new Image(getClass().getResource("/img/egg.png").toExternalForm());

    public PokemonItem(String name, String url) {
        FXMLLoader fxmlLoader = new FXMLLoader(new FxmlPathImpl().getPokemonItemFxml());
        fxmlLoader.setController(this);

        try {
            Parent root = fxmlLoader.load();
            getChildren().add(root);

            pokeName.setText(name);
            getPokeData(url);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    void getPokeData(String url) {
        Task<Void> fetchTask = new Task<>() {
            APIConnector apiConnector;
            FechStat fechUrl = FechStat.LOAD;

            @Override
            protected Void call() {
                try {
                    apiConnector = new APIConnector(url, "GET");
                    fechUrl = FechStat.SUCCESS;

                } catch (Exception e) {
                    fechUrl = FechStat.ERROR;
                }
                switch (fechUrl) {
                    case LOAD -> {

                    }
                    case ERROR -> {
                        System.out.println("LoadError");
                    }
                    case SUCCESS -> {
                        JSONObject pokeData = apiConnector.getJSONObject("");
                        try {
                            ObjectMapper mapper = new ObjectMapper();

                            // 直接使用原始 JSON 物件進行轉換，不需要再手動構建 key
                            pokemon = mapper.readValue(pokeData.toString(), Pokemon.class);
                            UpdateUI((int) pokemon.getid());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    default -> {
                    }
                }
                return null;
            }
        };

        Thread fetchThread = new Thread(fetchTask);
        fetchThread.start();
    }

    void UpdateUI(int id) throws MalformedURLException {
        Platform.runLater(() -> {
            pokeId.setText("No" + id); // 將 UI 更新的程式碼放在 runLater 中
            AvatorLoad.setVisible(false);
            pokeAvator.setVisible(true);
        });
        Image image = new Image(Util.getGifPath(id));
        pokeAvator.setImage(image);

        loadSvg(id);
    }

    void loadSvg(int id) throws MalformedURLException {
        String pokePath = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/"+id+".svg";
        BufferedImageTranscoder transcoder = new BufferedImageTranscoder();
        URL url = new URL(pokePath);
        try (InputStream file = url.openStream()) {
            TranscoderInput transIn = new TranscoderInput(file);
            try {
                transcoder.transcode(transIn, null);
                svgImg = SwingFXUtils.toFXImage(transcoder.getBufferedImage(), null);
            } catch (TranscoderException ex) {
                ex.printStackTrace();
            }
        }
        catch (IOException io) {
            io.printStackTrace();
        }
    }

    public Image getSvgImg(){
        return svgImg;
    }

    public RXAvatar getPokeAvator() {
        return pokeAvator;
    }

    public Pokemon getPokemon(){
        return pokemon;
    }
    public Label getPokeName() {
        return pokeName;
    }
}
