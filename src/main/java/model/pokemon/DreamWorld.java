package model.pokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation
@JsonIgnoreProperties(ignoreUnknown = true)
public class DreamWorld {
    private String frontDefault;

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String value) {
        this.frontDefault = value;
    }
}
