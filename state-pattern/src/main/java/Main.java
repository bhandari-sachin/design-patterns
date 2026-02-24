import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter character name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) name = "Hero";

        GameCharacter c = new GameCharacter(name);

        System.out.println("\nWelcome, " + c.getName() + "!");
        while (!c.isGameOver()) {
            printStatus(c);
            printActions(c);

            System.out.print("\nChoose an action (or 'quit'): ");
            String input = sc.nextLine().trim().toLowerCase(Locale.ROOT);

            if (input.equals("quit")) {
                System.out.println("Goodbye!");
                return;
            }

            switch (input) {
                case "train" -> c.train();
                case "meditate" -> c.meditate();
                case "fight" -> c.fight();
                default -> System.out.println("Unknown command. Try one of the listed actions.");
            }
        }
        // Master reached message is printed by GameCharacter.checkLevelUp()
        sc.close();
    }

    private static void printStatus(GameCharacter c) {
        System.out.println("\n==============================");
        System.out.println("Name:  " + c.getName());
        System.out.println("Level: " + c.getState().getLevelName());
        System.out.println("EXP:   " + c.getExperience() + " (" + c.nextGoalText() + ")");
        System.out.println("HP:    " + c.getHealth() + "/" + c.getMaxHealth());
        System.out.println("==============================");
    }

    private static void printActions(GameCharacter c) {
        System.out.println("Available actions: " + c.getState().getAvailableActions());
    }
}