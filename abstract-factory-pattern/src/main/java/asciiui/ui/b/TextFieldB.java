package asciiui.ui.b;

import asciiui.ui.TextField;

public class TextFieldB extends TextField {
    public TextFieldB(String text) {
        super(text);
    }

    @Override
    public void display() {
        String content = "{" + text + "}";
        String border = "." + "-".repeat(content.length() + 2) + ".";
        System.out.println(border);
        System.out.println(": " + content + " :");
        System.out.println("'" + "-".repeat(content.length() + 2) + "'");
    }
}
