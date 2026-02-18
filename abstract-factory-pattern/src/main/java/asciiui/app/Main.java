package asciiui.app;

import asciiui.factory.AFactory;
import asciiui.factory.BFactory;
import asciiui.factory.UIFactory;
import asciiui.ui.Button;
import asciiui.ui.Checkbox;
import asciiui.ui.TextField;

public class Main {
    private static UIFactory chooseFactory(String style){
        return switch (style.toUpperCase()){
            case "B" -> new BFactory();
            case "A" -> new AFactory();
            default -> throw new IllegalArgumentException("Invalid style");

        };
    }

    public static void main(String[] args) {
        String style = (args.length > 0) ? args[0] : "B";
        UIFactory factory = chooseFactory(style);

        Button button = factory.createButton("play");
        TextField textField = factory.createTextField("Name: Hero");
        Checkbox checkbox = factory.createCheckbox("Enable sound");

        button.display();
        textField.display();
        checkbox.display();

        System.out.println("\n--- After setText() ---");
        button.setText("Start Game");
        textField.setText("Name: Mage");
        checkbox.setText("Enable music");

        button.display();
        textField.display();
        checkbox.display();
    }
}
