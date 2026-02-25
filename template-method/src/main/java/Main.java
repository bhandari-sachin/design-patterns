import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players (2-6): ");
        int n = sc.nextInt();
        if (n < 2) n = 2;
        if (n > 6) n = 6;

        Game game = new DiceRaceGame(30); // target score = 30
        game.play(n);

        sc.close();
    }
}