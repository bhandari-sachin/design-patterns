package asciiui.factory;

import asciiui.ui.Button;
import asciiui.ui.Checkbox;
import asciiui.ui.TextField;
import asciiui.ui.a.ButtonA;
import asciiui.ui.a.CheckboxA;
import asciiui.ui.a.TextFieldA;

public class AFactory extends UIFactory {
    @Override
    public Button createButton(String text) { return new ButtonA(text); }
    @Override
    public TextField createTextField(String text) { return new TextFieldA(text); }
    @Override
    public Checkbox createCheckbox(String text) { return new CheckboxA(text); }
}