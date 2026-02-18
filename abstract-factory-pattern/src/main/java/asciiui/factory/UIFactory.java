package asciiui.factory;

import asciiui.ui.Button;
import asciiui.ui.Checkbox;
import asciiui.ui.TextField;

public abstract class UIFactory {
    public abstract Button createButton(String text);
    public abstract TextField createTextField(String text);
    public abstract Checkbox createCheckbox(String text);
}
