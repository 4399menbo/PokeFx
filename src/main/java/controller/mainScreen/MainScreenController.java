package controller.mainScreen;

import app.APIConnector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leewyatt.rxcontrols.controls.RXFillButton;
import controller.detailScreen.DetailScreenController;
import io.github.palexdev.materialfx.controls.MFXProgressSpinner;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.Person;
import model.PokemonList;
import model.Result;
import model.pokemon.Pokemon;
import model.pokemon.Stat;
import model.pokemon.Type;
import org.json.simple.JSONObject;
import util.FechStat;
import util.SwitchScene;
import util.Util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    @FXML
    private VBox listPanel;
    @FXML
    private MFXProgressSpinner spinnerBar;
    @FXML
    private AnchorPane cardView;
    @FXML
    private MFXTextField searchBar;
    private Scene detailScene;
    @FXML
    private RXFillButton loadBar;


    private PokemonCard card = new PokemonCard();
    private final String pokedexAPI = "https://pokeapi.co/api/v2/pokemon?limit=30&offset=0";
    private String nextApi = "";

    private FechStat fechStat = FechStat.LOAD;
    private APIConnector apiConnector;
    private List<Node> listChildren = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cardView.getChildren().add(card);

        fechData();
    }


    @FXML
    public void searchPoke(ActionEvent event) {
        listPanel.getChildren().remove(loadBar);
        String search = searchBar.getText().trim();

        System.out.println(listChildren.size());

        if (listPanel.getChildren().contains(spinnerBar)) {
            return;
        }

        if(listChildren!=null&&!search.equals("")){
            List<Node> searchList = new ArrayList<>();

            for (int i = 0; i < listChildren.size(); i++) {
                Node item = listChildren.get(i);
                PokemonItem outPanel = (PokemonItem) item;
                //System.out.println(listChildren.size());
                if(outPanel.getPokeName().getText().contains(search)){
                    searchList.add(item);
                    System.out.println((outPanel.getPokeName().getText()));
                }
            }

            //B
            while (listPanel.getChildren().size()!=0){
                listPanel.getChildren().remove(0);
            }

            for (int i = 0; i < searchList.size(); i++) {
                listPanel.getChildren().add(searchList.get(i));
            }
        }
        else {


            if (listChildren!=null){
                while (listPanel.getChildren().size()!=0){
                    listPanel.getChildren().remove(0);
                }

                for (int i = 0; i < listChildren.size(); i++) {
                    listPanel.getChildren().add(listChildren.get(i));
                }
            }

            listPanel.getChildren().add(loadBar);
        }



    }

    @FXML
    void loadData(MouseEvent event) {
        fechData();
    }


    void fechData() {
        listPanel.getChildren().remove(loadBar);
        if (!listPanel.getChildren().contains(spinnerBar)) {
            listPanel.getChildren().add(spinnerBar);
        }

        fechStat = FechStat.LOAD;
        Task<Void> fetchTask = new Task<>() {
            @Override
            protected Void call() {
                try {
                    apiConnector = new APIConnector(nextApi.equals("") == false ? nextApi : pokedexAPI, "GET");
                    fechStat = FechStat.SUCCESS;

                } catch (MalformedURLException e) {
                    fechStat = FechStat.ERROR;
                }
                switch (fechStat) {
                    case ERROR -> {
                    }
                    case SUCCESS -> {
                        JSONObject pokeListData = apiConnector.getJSONObject("");
                        try {
                            ObjectMapper mapper = new ObjectMapper();

                            // 直接使用原始 JSON 物件進行轉換，不需要再手動構建 key
                            PokemonList pokemonList = mapper.readValue(pokeListData.toString(), PokemonList.class);

                            nextApi = pokemonList.getNext();
                            loadListUi(pokemonList.getResults());
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

    void loadListUi(List<Result> results) {
        Platform.runLater(() -> {
            listPanel.getChildren().remove(spinnerBar);

            for (int i = 0; i < results.size(); i++) {
                String name = results.get(i).getName().toString();
                String url = results.get(i).geturl();
                PokemonItem item = new PokemonItem(name,url);

                item.setOnMouseEntered(event -> {
                    try {
                        updateCard(item,name);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                });

                item.setOnMouseClicked(event -> {
                    try {
                        switchScene(item);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

                listPanel.getChildren().add(item);
                listChildren.add(item);
            }

            listPanel.getChildren().add(loadBar);
            //listPanel.getChildren().add(spinnerBar);
        });
    }

    void switchScene(PokemonItem item) {
        Pokemon pokemon = item.getPokemon();
        if(pokemon == null)
            return;

        DetailScreenController controller = SwitchScene.getDetailScreenController();
        controller.setPokeInfo(
                pokemon.getid()+"",
                item.getSvgImg(),
                pokemon.getName(),
                getType(pokemon.getTypes()),
                pokemon.getBaseExperience()+""
        );

        String color = Util.getColours().get(pokemon.getTypes().get(0).getType().getName());
        controller.loadBgSvg(color);
        controller.setPokeStat(
                pokemon.getStats().get(0).getBaseStat(),
                pokemon.getStats().get(1).getBaseStat(),
                pokemon.getStats().get(2).getBaseStat(),
                pokemon.getStats().get(3).getBaseStat(),
                pokemon.getStats().get(4).getBaseStat(),
                pokemon.getStats().get(5).getBaseStat()
        );

        SwitchScene.switchScene(SwitchScene.getStage(),detailScene);

    }



    String getType(List<Type> typeslist){
        List<Type> types = typeslist;
        String typeName="";
        for (int j = 0; j < types.size(); j++) {
            if (j>0){
                typeName+=" ";
            }
            typeName += types.get(j).getType().getName();
        }
        return typeName.toUpperCase(Locale.ROOT);
    }

    void updateCard(PokemonItem item,String name) throws MalformedURLException {
        Pokemon pokemon = item.getPokemon();
        if(pokemon == null)
            return;
        List<Person> bmiList = new ArrayList<>();
        List<Person> statList = new ArrayList<>();



        bmiList.add(new Person("type",getType(pokemon.getTypes())));
        bmiList.add(new Person("height",pokemon.getHeight()+""));
        bmiList.add(new Person("width",pokemon.getWeight()+""));

        Stat hp = pokemon.getStats().get(0);
        Stat attack = pokemon.getStats().get(1);
        Stat defense = pokemon.getStats().get(2);

        statList.add(new Person("hp",hp.getBaseStat()+""));
        statList.add(new Person("attack",attack.getBaseStat()+""));
        statList.add(new Person("defense",defense.getBaseStat()+""));
        card.setupTable(bmiList,statList);

        card.setPokeImage(item.getSvgImg(),item.getPokeAvator().getImage(), (int) pokemon.getid(),name);
    }

    public AnchorPane getCardView() {
        return cardView;
    }

    public void setDetailScene(Scene detailScene) {
        this.detailScene = detailScene;
    }

}
