package util;

import controller.mainScreen.MainScreenController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import model.Person;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Util {

    public static String getGifPath(int id){
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/" + id + ".gif";
    }

    public static List<Person> getBmi(String type, String height, String width){
        return List.of(new Person[]{
                new Person("Type", type),
                new Person("Height", height),
                new Person("Width", width)
        });
    }


    public static Map<String, String> getColours() {
        Map<String, String> colours = new HashMap<>();
        colours.put("normal", "#A8A77A");
        colours.put("fire", "#EE8130");
        colours.put("water", "#6390F0");
        colours.put("electric", "#F7D02C");
        colours.put("grass", "#7AC74C");
        colours.put("ice", "#96D9D6");
        colours.put("fighting", "#C22E28");
        colours.put("poison", "#A33EA1");
        colours.put("ground", "#E2BF65");
        colours.put("flying", "#A98FF3");
        colours.put("psychic", "#F95587");
        colours.put("bug", "#A6B91A");
        colours.put("rock", "#B6A136");
        colours.put("ghost", "#735797");
        colours.put("dragon", "#6F35FC");
        colours.put("dark", "#705746");
        colours.put("steel", "#B7B7CE");
        colours.put("fairy", "#D685AD");
        return colours;
    }
}
