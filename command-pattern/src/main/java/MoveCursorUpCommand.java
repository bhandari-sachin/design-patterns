public class MoveCursorUpCommand implements Command {

    private PixelEditor editor;

    public MoveCursorUpCommand(PixelEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.moveUp();
    }
}