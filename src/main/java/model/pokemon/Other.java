package model.pokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation
@JsonIgnoreProperties(ignoreUnknown = true)
public class Other {
    private DreamWorld dreamWorld;
    private Home officialArtwork;
    private Home home;

    public DreamWorld getDreamWorld() {
        return dreamWorld;
    }

    public void setDreamWorld(DreamWorld value) {
        this.dreamWorld = value;
    }

    public Home getOfficialArtwork() {
        return officialArtwork;
    }

    public void setOfficialArtwork(Home value) {
        this.officialArtwork = value;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home value) {
        this.home = value;
    }
}
