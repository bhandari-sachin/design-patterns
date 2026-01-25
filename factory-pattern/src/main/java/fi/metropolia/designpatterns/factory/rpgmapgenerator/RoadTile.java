package fi.metropolia.designpatterns.factory.rpgmapgenerator;

public class RoadTile extends Tile{
    public char getCharacter() {
        return 'R';
    }
    public String getType() {
        return "Road";
    }
    public void action() {  }
}