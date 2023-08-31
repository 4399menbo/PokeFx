package util;

import java.net.URL;

public class FxmlPathImpl implements FxmlPath {
    @Override
    public URL getPokemonItemFxml() {
        return getClass().getResource("/fxml/mainScreen/PokemonItem.fxml");
    }

    @Override
    public URL getMainScreenFxml() {
        return getClass().getResource("/fxml/mainScreen/MainScreen.fxml");
    }

    @Override
    public URL getPokemonCard() {
        return getClass().getResource("/fxml/mainScreen/PokemonCard.fxml");
    }

    @Override
    public URL getPokeDetail() {
        return getClass().getResource("/fxml/detailScreen/DetailScreen.fxml");
    }
}
