package model.pokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sprites {
    private Other other;
    private String backDefault;
    private String frontDefault;
    private Versions versions;
    private String backShiny;
    private String frontShiny;

    public Other getOther() {
        return other;
    }

    public void setOther(Other value) {
        this.other = value;
    }

    public String getBackDefault() {
        return backDefault;
    }

    public void setBackDefault(String value) {
        this.backDefault = value;
    }

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String value) {
        this.frontDefault = value;
    }

    public Versions getVersions() {
        return versions;
    }

    public void setVersions(Versions value) {
        this.versions = value;
    }

    public String getBackShiny() {
        return backShiny;
    }

    public void setBackShiny(String value) {
        this.backShiny = value;
    }

    public String getFrontShiny() {
        return frontShiny;
    }

    public void setFrontShiny(String value) {
        this.frontShiny = value;
    }
}
