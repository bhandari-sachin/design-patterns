package memento.guistate;

public class Model {

    private int[] options = new int[3];
    private boolean isSelected;

    public void setOption(int optionNumber, int choice){

        if(optionNumber >=1 && optionNumber <=3){
            options[optionNumber-1] = choice;
        }
    }

    public int getOption(int optionNumber){

        if(optionNumber >=1 && optionNumber <=3){
            return options[optionNumber-1];
        }

        return -1;
    }

    public void setIsSelected(boolean isSelected){
        this.isSelected = isSelected;
    }

    public boolean getIsSelected(){
        return isSelected;
    }

    public IMemento createMemento(){
        return new Memento(options, isSelected);
    }

    public void restoreState(IMemento m){

        Memento mem = (Memento)m;

        options = mem.getOptions();
        isSelected = mem.isSelected();
    }
}