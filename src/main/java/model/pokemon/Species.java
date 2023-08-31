package model.pokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation
@JsonIgnoreProperties(ignoreUnknown = true)
public class Species {
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String geturl() {
        return url;
    }

    public void seturl(String value) {
        this.url = value;
    }
}
