public class PixelEditor {

    private final int SIZE = 8;
    private int[][] grid = new int[SIZE][SIZE];

    private int cursorRow = 0;
    private int cursorCol = 0;

    // Cursor movement
    public void moveUp() {
        if (cursorRow > 0) cursorRow--;
    }

    public void moveDown() {
        if (cursorRow < SIZE - 1) cursorRow++;
    }

    public void moveLeft() {
        if (cursorCol > 0) cursorCol--;
    }

    public void moveRight() {
        if (cursorCol < SIZE - 1) cursorCol++;
    }

    // Toggle pixel
    public void togglePixel() {
        grid[cursorRow][cursorCol] =
                (grid[cursorRow][cursorCol] == 0) ? 1 : 0;
    }

    public int[][] getGrid() {
        return grid;
    }

    public int getCursorRow() { return cursorRow; }
    public int getCursorCol() { return cursorCol; }
}