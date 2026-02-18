package asciiui.ui.a;

import asciiui.ui.TextField;

public class TextFieldA extends TextField {
    public TextFieldA(String text) {
        super(text);
    }

    @Override
    public void display(){
        String content = " " + text + " ";
        String border = "+" + "=".repeat(content.length()) + "+";
        System.out.println(border);
        System.out.println("|" + content + "|");
        System.out.println(border);

    }
}
