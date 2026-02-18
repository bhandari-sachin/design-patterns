package asciiui.ui;

public abstract class UIElement {
    protected String text;

    protected UIElement(String text) {
        this.text = text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
    public abstract void display();
}
