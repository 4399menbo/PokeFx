package model.pokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation
@JsonIgnoreProperties(ignoreUnknown = true)
public
class Type {
    private long slot;
    private Species type;

    public long getSlot() {
        return slot;
    }

    public void setSlot(long value) {
        this.slot = value;
    }

    public Species getType() {
        return type;
    }

    public void setType(Species value) {
        this.type = value;
    }
}
