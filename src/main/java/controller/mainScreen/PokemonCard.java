package controller.mainScreen;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Person;
import util.FxmlPathImpl;
import util.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PokemonCard extends AnchorPane {
    @FXML
    private Label attack;

    @FXML
    private Label defense;

    @FXML
    private Label height;

    @FXML
    private Label hp;

    @FXML
    private Label type;

    @FXML
    private Label width;

    @FXML
    private ImageView pokeImg;

    @FXML
    private ImageView pokeGif;

    @FXML
    private Label pokeId;

    @FXML
    private Label pokeName;




    public PokemonCard() {
        FXMLLoader fxmlLoader = new FXMLLoader(new FxmlPathImpl().getPokemonCard());
        fxmlLoader.setController(this);
        try {
            Parent root = fxmlLoader.load();
            getChildren().add(root);

            List<Person> parents = new ArrayList<>();
            setupTable(parents,parents);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setPokeImage(Image svg,Image gif,int id,String name)  {
        pokeImg.setImage(svg);
        pokeGif.setImage(gif);
        pokeId.setText("No."+id);
        pokeName.setText(name);
    }

    public void setupTable(List<Person> bmiList,List<Person> baseTypeList) {
        if (bmiList == null || bmiList.size() == 0) {
            bmiList = new ArrayList<>();
            bmiList.addAll(Util.getBmi("???", "???", "???"));
        }

        if (baseTypeList == null || baseTypeList.size() == 0) {
            baseTypeList = new ArrayList<>();
            baseTypeList.addAll(Util.getBmi("???", "???", "???"));
        }


        type.setText(bmiList.get(0).content());
        height.setText(bmiList.get(1).content());
        width.setText(bmiList.get(2).content());

        hp.setText(baseTypeList.get(0).content());
        attack.setText(baseTypeList.get(1).content());
        defense.setText(baseTypeList.get(2).content());
    }
}
