package fi.metropolia.designpatterns.factory.rpgmapgenerator;

public class ForestTile extends Tile {
    @Override
    public char getCharacter() {
        return 'F';
    }
    @Override
    public String getType() {
        return "Forest";
    }
    @Override
    public void action() {}
}