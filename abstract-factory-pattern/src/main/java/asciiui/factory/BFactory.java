package asciiui.factory;

import asciiui.ui.Button;
import asciiui.ui.Checkbox;
import asciiui.ui.TextField;
import asciiui.ui.b.ButtonB;
import asciiui.ui.b.CheckboxB;
import asciiui.ui.b.TextFieldB;

public class BFactory extends UIFactory {
    @Override
    public Button createButton(String text) { return new ButtonB(text); }
    @Override
    public TextField createTextField(String text) { return new TextFieldB(text); }
    @Override
    public Checkbox createCheckbox(String text) { return new CheckboxB(text); }
}