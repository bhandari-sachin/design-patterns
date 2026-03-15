package memento.guistate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;

public class Gui extends Application {

    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;

    public void start(Stage stage) {

        controller = new Controller(this);

        Insets insets = new Insets(10,10,10,10);

        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        checkBox.setOnAction(event -> {
            controller.setIsSelected(checkBox.isSelected());
        });

        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);

        Button historyButton = new Button("Show History");
        historyButton.setOnAction(e -> controller.openHistoryWindow());

        Label label = new Label("Ctrl-Z = Undo | Ctrl-Y = Redo");

        VBox vBox = new VBox(hBox, checkBox, historyButton, label);
        vBox.setPadding(insets);

        Scene scene = new Scene(vBox);

        scene.setOnKeyPressed(event -> {

            if(event.isControlDown() && event.getCode() == KeyCode.Z){
                controller.undo();
            }

            if(event.isControlDown() && event.getCode() == KeyCode.Y){
                controller.redo();
            }

        });

        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();
    }

    public void updateGui() {

        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
    }
}