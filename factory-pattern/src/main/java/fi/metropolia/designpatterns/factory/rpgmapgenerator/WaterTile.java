package fi.metropolia.designpatterns.factory.rpgmapgenerator;

public class WaterTile extends Tile {
    public char getCharacter() {
        return 'W';
    }
    public String getType() {
        return "Water";
    }

    public void action() {  }
}