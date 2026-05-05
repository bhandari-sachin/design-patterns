public class MoveCursorRightCommand implements Command {

    private PixelEditor editor;

    public MoveCursorRightCommand(PixelEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.moveRight();
    }
}