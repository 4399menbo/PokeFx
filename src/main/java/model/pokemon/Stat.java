package model.pokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

public class Stat {
    private Species stat;
    @JsonProperty("base_stat")
    private long baseStat;
    private long effort;

    public Species getStat() {
        return stat;
    }

    public void setStat(Species value) {
        this.stat = value;
    }

    public long getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(long value) {
        this.baseStat = value;
    }

    public long getEffort() {
        return effort;
    }

    public void setEffort(long value) {
        this.effort = value;
    }
}
