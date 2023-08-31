// Pokemon.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package model.pokemon;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    private String locationAreaEncounters;
    private List<Type> types;
    @JsonProperty("base_experience")
    private long baseExperience;
    private List<Object> heldItems;
    private long weight;
    private boolean isDefault;
    private List<Object> pastTypes;
    private Sprites sprites;
    private List<Ability> abilities;
    private List<GameIndex> gameIndices;
    private Species species;
    private List<Stat> stats;
    private List<Move> moves;
    private String name;
    private long id;
    private List<Species> forms;
    private long height;
    private long order;

    public String getLocationAreaEncounters() { return locationAreaEncounters; }
    public void setLocationAreaEncounters(String value) { this.locationAreaEncounters = value; }

    public List<Type> getTypes() { return types; }
    public void setTypes(List<Type> value) { this.types = value; }

    public long getBaseExperience() { return baseExperience; }
    public void setBaseExperience(long value) { this.baseExperience = value; }

    public List<Object> getHeldItems() { return heldItems; }
    public void setHeldItems(List<Object> value) { this.heldItems = value; }

    public long getWeight() { return weight; }
    public void setWeight(long value) { this.weight = value; }

    public boolean getIsDefault() { return isDefault; }
    public void setIsDefault(boolean value) { this.isDefault = value; }

    public List<Object> getPastTypes() { return pastTypes; }
    public void setPastTypes(List<Object> value) { this.pastTypes = value; }

    public Sprites getSprites() { return sprites; }
    public void setSprites(Sprites value) { this.sprites = value; }

    public List<Ability> getAbilities() { return abilities; }
    public void setAbilities(List<Ability> value) { this.abilities = value; }

    public List<GameIndex> getGameIndices() { return gameIndices; }
    public void setGameIndices(List<GameIndex> value) { this.gameIndices = value; }

    public Species getSpecies() { return species; }
    public void setSpecies(Species value) { this.species = value; }

    public List<Stat> getStats() { return stats; }
    public void setStats(List<Stat> value) { this.stats = value; }

    public List<Move> getMoves() { return moves; }
    public void setMoves(List<Move> value) { this.moves = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public long getid() { return id; }
    public void setid(long value) { this.id = value; }

    public List<Species> getForms() { return forms; }
    public void setForms(List<Species> value) { this.forms = value; }

    public long getHeight() { return height; }
    public void setHeight(long value) { this.height = value; }

    public long getOrder() { return order; }
    public void setOrder(long value) { this.order = value; }
}

// Ability.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation
@JsonIgnoreProperties(ignoreUnknown = true)
class Ability {
    private boolean isHidden;
    private Species ability;
    private long slot;

    public boolean getIsHidden() { return isHidden; }
    public void setIsHidden(boolean value) { this.isHidden = value; }

    public Species getAbility() { return ability; }
    public void setAbility(Species value) { this.ability = value; }

    public long getSlot() { return slot; }
    public void setSlot(long value) { this.slot = value; }
}

// Species.java

// GameIndex.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation
@JsonIgnoreProperties(ignoreUnknown = true)
class GameIndex {
    private long gameIndex;
    private Species version;

    public long getGameIndex() { return gameIndex; }
    public void setGameIndex(long value) { this.gameIndex = value; }

    public Species getVersion() { return version; }
    public void setVersion(Species value) { this.version = value; }
}

// Move.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation
@JsonIgnoreProperties(ignoreUnknown = true)
class Move {
    private List<VersionGroupDetail> versionGroupDetails;
    private Species move;

    public List<VersionGroupDetail> getVersionGroupDetails() { return versionGroupDetails; }
    public void setVersionGroupDetails(List<VersionGroupDetail> value) { this.versionGroupDetails = value; }

    public Species getMove() { return move; }
    public void setMove(Species value) { this.move = value; }
}

// VersionGroupDetail.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation
@JsonIgnoreProperties(ignoreUnknown = true)
class VersionGroupDetail {
    private long levelLearnedAt;
    private Species versionGroup;
    private Species moveLearnMethod;

    public long getLevelLearnedAt() { return levelLearnedAt; }
    public void setLevelLearnedAt(long value) { this.levelLearnedAt = value; }

    public Species getVersionGroup() { return versionGroup; }
    public void setVersionGroup(Species value) { this.versionGroup = value; }

    public Species getMoveLearnMethod() { return moveLearnMethod; }
    public void setMoveLearnMethod(Species value) { this.moveLearnMethod = value; }
}

// Sprites.java

// Other.java

// DreamWorld.java

// Home.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation
@JsonIgnoreProperties(ignoreUnknown = true)
class Home {
    private String frontDefault;
    private String frontShiny;

    public String getFrontDefault() { return frontDefault; }
    public void setFrontDefault(String value) { this.frontDefault = value; }

    public String getFrontShiny() { return frontShiny; }
    public void setFrontShiny(String value) { this.frontShiny = value; }
}

// Versions.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

@JsonIgnoreProperties(ignoreUnknown = true)
class Versions {
    private GenerationIii generationIii;
    private GenerationIi generationIi;
    private GenerationV generationV;
    private GenerationIv generationIv;
    private GenerationVii generationVii;
    private GenerationI generationI;
    private GenerationViii generationViii;
    private Map<String, Home> generationVi;

    public GenerationIii getGenerationIii() { return generationIii; }
    public void setGenerationIii(GenerationIii value) { this.generationIii = value; }

    public GenerationIi getGenerationIi() { return generationIi; }
    public void setGenerationIi(GenerationIi value) { this.generationIi = value; }

    public GenerationV getGenerationV() { return generationV; }
    public void setGenerationV(GenerationV value) { this.generationV = value; }

    public GenerationIv getGenerationIv() { return generationIv; }
    public void setGenerationIv(GenerationIv value) { this.generationIv = value; }

    public GenerationVii getGenerationVii() { return generationVii; }
    public void setGenerationVii(GenerationVii value) { this.generationVii = value; }

    public GenerationI getGenerationI() { return generationI; }
    public void setGenerationI(GenerationI value) { this.generationI = value; }

    public GenerationViii getGenerationViii() { return generationViii; }
    public void setGenerationViii(GenerationViii value) { this.generationViii = value; }

    public Map<String, Home> getGenerationVi() { return generationVi; }
    public void setGenerationVi(Map<String, Home> value) { this.generationVi = value; }
}

// GenerationI.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation
@JsonIgnoreProperties(ignoreUnknown = true)
class GenerationI {
    private RedBlue yellow;
    private RedBlue redBlue;

    public RedBlue getYellow() { return yellow; }
    public void setYellow(RedBlue value) { this.yellow = value; }

    public RedBlue getRedBlue() { return redBlue; }
    public void setRedBlue(RedBlue value) { this.redBlue = value; }
}

// RedBlue.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation
@JsonIgnoreProperties(ignoreUnknown = true)
class RedBlue {
    private String frontGray;
    private String backTransparent;
    private String backDefault;
    private String backGray;
    private String frontDefault;
    private String frontTransparent;

    public String getFrontGray() { return frontGray; }
    public void setFrontGray(String value) { this.frontGray = value; }

    public String getBackTransparent() { return backTransparent; }
    public void setBackTransparent(String value) { this.backTransparent = value; }

    public String getBackDefault() { return backDefault; }
    public void setBackDefault(String value) { this.backDefault = value; }

    public String getBackGray() { return backGray; }
    public void setBackGray(String value) { this.backGray = value; }

    public String getFrontDefault() { return frontDefault; }
    public void setFrontDefault(String value) { this.frontDefault = value; }

    public String getFrontTransparent() { return frontTransparent; }
    public void setFrontTransparent(String value) { this.frontTransparent = value; }
}

// GenerationIi.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation
@JsonIgnoreProperties(ignoreUnknown = true)
class GenerationIi {
    private Gold gold;
    private Crystal crystal;
    private Gold silver;

    public Gold getGold() { return gold; }
    public void setGold(Gold value) { this.gold = value; }

    public Crystal getCrystal() { return crystal; }
    public void setCrystal(Crystal value) { this.crystal = value; }

    public Gold getSilver() { return silver; }
    public void setSilver(Gold value) { this.silver = value; }
}

// Crystal.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation
@JsonIgnoreProperties(ignoreUnknown = true)
class Crystal {
    private String backTransparent;
    private String backShinyTransparent;
    private String backDefault;
    private String frontDefault;
    private String frontTransparent;
    private String frontShinyTransparent;
    private String backShiny;
    private String frontShiny;

    public String getBackTransparent() { return backTransparent; }
    public void setBackTransparent(String value) { this.backTransparent = value; }

    public String getBackShinyTransparent() { return backShinyTransparent; }
    public void setBackShinyTransparent(String value) { this.backShinyTransparent = value; }

    public String getBackDefault() { return backDefault; }
    public void setBackDefault(String value) { this.backDefault = value; }

    public String getFrontDefault() { return frontDefault; }
    public void setFrontDefault(String value) { this.frontDefault = value; }

    public String getFrontTransparent() { return frontTransparent; }
    public void setFrontTransparent(String value) { this.frontTransparent = value; }

    public String getFrontShinyTransparent() { return frontShinyTransparent; }
    public void setFrontShinyTransparent(String value) { this.frontShinyTransparent = value; }

    public String getBackShiny() { return backShiny; }
    public void setBackShiny(String value) { this.backShiny = value; }

    public String getFrontShiny() { return frontShiny; }
    public void setFrontShiny(String value) { this.frontShiny = value; }
}

// Gold.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation
@JsonIgnoreProperties(ignoreUnknown = true)
class Gold {
    private String backDefault;
    private String frontDefault;
    private String frontTransparent;
    private String backShiny;
    private String frontShiny;
    private Gold animated;

    public String getBackDefault() { return backDefault; }
    public void setBackDefault(String value) { this.backDefault = value; }

    public String getFrontDefault() { return frontDefault; }
    public void setFrontDefault(String value) { this.frontDefault = value; }

    public String getFrontTransparent() { return frontTransparent; }
    public void setFrontTransparent(String value) { this.frontTransparent = value; }

    public String getBackShiny() { return backShiny; }
    public void setBackShiny(String value) { this.backShiny = value; }

    public String getFrontShiny() { return frontShiny; }
    public void setFrontShiny(String value) { this.frontShiny = value; }

    public Gold getAnimated() { return animated; }
    public void setAnimated(Gold value) { this.animated = value; }
}

// GenerationIii.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation
@JsonIgnoreProperties(ignoreUnknown = true)
class GenerationIii {
    private Gold fireredLeafgreen;
    private Gold rubySapphire;
    private Home emerald;

    public Gold getFireredLeafgreen() { return fireredLeafgreen; }
    public void setFireredLeafgreen(Gold value) { this.fireredLeafgreen = value; }

    public Gold getRubySapphire() { return rubySapphire; }
    public void setRubySapphire(Gold value) { this.rubySapphire = value; }

    public Home getEmerald() { return emerald; }
    public void setEmerald(Home value) { this.emerald = value; }
}

// GenerationIv.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation
@JsonIgnoreProperties(ignoreUnknown = true)
class GenerationIv {
    private Gold platinum;
    private Gold diamondPearl;
    private Gold heartgoldSoulsilver;

    public Gold getPlatinum() { return platinum; }
    public void setPlatinum(Gold value) { this.platinum = value; }

    public Gold getDiamondPearl() { return diamondPearl; }
    public void setDiamondPearl(Gold value) { this.diamondPearl = value; }

    public Gold getHeartgoldSoulsilver() { return heartgoldSoulsilver; }
    public void setHeartgoldSoulsilver(Gold value) { this.heartgoldSoulsilver = value; }
}

// GenerationV.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation
@JsonIgnoreProperties(ignoreUnknown = true)
class GenerationV {
    private Gold blackWhite;

    public Gold getBlackWhite() { return blackWhite; }
    public void setBlackWhite(Gold value) { this.blackWhite = value; }
}

// GenerationVii.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation
@JsonIgnoreProperties(ignoreUnknown = true)
class GenerationVii {
    private DreamWorld icons;
    private Home ultraSunUltraMoon;

    public DreamWorld getIcons() { return icons; }
    public void setIcons(DreamWorld value) { this.icons = value; }

    public Home getUltraSunUltraMoon() { return ultraSunUltraMoon; }
    public void setUltraSunUltraMoon(Home value) { this.ultraSunUltraMoon = value; }
}

// GenerationViii.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation
@JsonIgnoreProperties(ignoreUnknown = true)
class GenerationViii {
    private DreamWorld icons;

    public DreamWorld getIcons() { return icons; }
    public void setIcons(DreamWorld value) { this.icons = value; }
}

// Stat.java

// Type.java

