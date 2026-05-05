public class MoveCursorLeftCommand implements Command {

    private PixelEditor editor;

    public MoveCursorLeftCommand(PixelEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.moveLeft();
    }
}