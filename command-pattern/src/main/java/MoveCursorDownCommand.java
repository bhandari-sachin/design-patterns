public class MoveCursorDownCommand implements Command {

    private PixelEditor editor;

    public MoveCursorDownCommand(PixelEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.moveDown();
    }
}