package memento.guistate;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller {

    private Model model;
    private Gui gui;

    private List<IMemento> undoHistory;
    private List<IMemento> redoHistory;

    public Controller(Gui gui) {

        this.gui = gui;
        model = new Model();

        undoHistory = new ArrayList<>();
        redoHistory = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {

        saveState();
        redoHistory.clear();

        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {

        saveState();
        redoHistory.clear();

        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    private void saveState() {

        IMemento m = model.createMemento();
        undoHistory.add(m);
    }

    public void undo() {

        if(!undoHistory.isEmpty()){

            redoHistory.add(model.createMemento());

            IMemento m = undoHistory.remove(undoHistory.size()-1);

            model.restoreState(m);
            gui.updateGui();
        }
    }

    public void redo() {

        if(!redoHistory.isEmpty()){

            undoHistory.add(model.createMemento());

            IMemento m = redoHistory.remove(redoHistory.size()-1);

            model.restoreState(m);
            gui.updateGui();
        }
    }

    public void openHistoryWindow(){

        Stage stage = new Stage();

        ListView<IMemento> list = new ListView<>();

        list.getItems().addAll(undoHistory);

        list.setOnMouseClicked(event -> {

            IMemento selected = list.getSelectionModel().getSelectedItem();

            if(selected != null){
                model.restoreState(selected);
                gui.updateGui();
            }

        });

        VBox root = new VBox(list);

        Scene scene = new Scene(root,300,400);

        stage.setScene(scene);
        stage.setTitle("History");
        stage.show();
    }
}