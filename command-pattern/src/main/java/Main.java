import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Main extends Application {

    private PixelEditor editor = new PixelEditor();
    private GridPane gridPane = new GridPane();

    @Override
    public void start(Stage stage) {

        // --- Commands ---
        Command moveUp = new MoveCursorUpCommand(editor);
        Command moveDown = new MoveCursorDownCommand(editor);
        Command moveLeft = new MoveCursorLeftCommand(editor);
        Command moveRight = new MoveCursorRightCommand(editor);
        Command toggle = new TogglePixelCommand(editor);
        Command generate = new GenerateCodeCommand(editor);

        // --- UI ---
        Button generateButton = new Button("Generate Code");
        generateButton.setOnAction(e -> generate.execute());

        VBox root = new VBox(10, gridPane, generateButton);

        Scene scene = new Scene(root, 350, 400);

        // --- Key handling (Invoker) ---
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) moveUp.execute();
            else if (event.getCode() == KeyCode.DOWN) moveDown.execute();
            else if (event.getCode() == KeyCode.LEFT) moveLeft.execute();
            else if (event.getCode() == KeyCode.RIGHT) moveRight.execute();
            else if (event.getCode() == KeyCode.SPACE) toggle.execute();

            redrawGrid();
        });

        redrawGrid();

        stage.setTitle("Pixel Art Editor");
        stage.setScene(scene);
        stage.show();
    }

    // --- Rendering ---
    private void redrawGrid() {
        gridPane.getChildren().clear();

        int[][] grid = editor.getGrid();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                Rectangle rect = new Rectangle(40, 40);

                if (row == editor.getCursorRow() && col == editor.getCursorCol()) {
                    rect.setStyle("-fx-fill: red; -fx-stroke: black;");
                } else if (grid[row][col] == 1) {
                    rect.setStyle("-fx-fill: black;");
                } else {
                    rect.setStyle("-fx-fill: white; -fx-stroke: gray;");
                }

                gridPane.add(rect, col, row);
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}