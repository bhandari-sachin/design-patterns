package fi.metropolia.designpatterns.factory.rpgmapgenerator;


import java.util.Random;

public abstract class Map {
    protected Tile[][] tiles;
    protected int rows;
    protected int cols;
    protected Random random = new Random();

    public Map(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        tiles = new Tile[rows][cols];
        generateMap();
    }

    private void generateMap() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tiles[i][j] = createTile(); // Factory Method
            }
        }
    }

    protected abstract Tile createTile();

    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(tiles[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}
