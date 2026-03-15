package memento.guistate;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Memento implements IMemento {

    private int[] options;
    private boolean isSelected;
    private LocalDateTime time;

    public Memento(int[] options, boolean isSelected){

        this.options = options.clone();
        this.isSelected = isSelected;
        this.time = LocalDateTime.now();
    }

    public int[] getOptions(){
        return options.clone();
    }

    public boolean isSelected(){
        return isSelected;
    }

    public String getName(){
        return "Saved: " + time.toString();
    }

    public String toString(){
        return getName() + " " + Arrays.toString(options) + " checkbox=" + isSelected;
    }
}