package fi.metropolia.designpatterns.factory.rpgmapgenerator;

public class WildernessMap extends Map {

    public WildernessMap(int rows, int cols) {
        super(rows, cols);
    }

    @Override
    protected Tile createTile() {
        int choice = random.nextInt(3);

        return switch (choice) {
            case 0 -> new SwampTile();
            case 1 -> new WaterTile();
            default -> new ForestTile();
        };
    }
}
