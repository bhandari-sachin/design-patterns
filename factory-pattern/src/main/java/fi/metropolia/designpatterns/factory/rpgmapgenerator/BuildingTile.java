package fi.metropolia.designpatterns.factory.rpgmapgenerator;

public class BuildingTile extends Tile {
    public char getCharacter() {
        return 'B';
    }

    public String getType() {
        return "Building";
    }
    public void action() {}
}
