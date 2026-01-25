package fi.metropolia.designpatterns.factory.rpgmapgenerator;

public class SwampTile extends Tile{
    public char getCharacter() {
        return 'S';
    }
    public String getType() {
        return "Swamp";
    }
    public void action() {  }
}
