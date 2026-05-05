public class TogglePixelCommand implements Command {

    private PixelEditor editor;

    public TogglePixelCommand(PixelEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.togglePixel();
    }
}