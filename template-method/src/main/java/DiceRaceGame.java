import java.util.ArrayList;
import java.util.List;

public class DiceRaceGame extends Game {

    private final int targetScore;
    private final Die die = new Die();
    private final List<Player> players = new ArrayList<>();

    private boolean gameOver = false;
    private Player winner = null;

    public DiceRaceGame(int targetScore) {
        this.targetScore = targetScore;
    }

    @Override
    public void initializeGame(int numberOfPlayers) {
        players.clear();
        gameOver = false;
        winner = null;

        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player("Player " + (i + 1)));
        }

        System.out.println("=== Dice Race ===");
        System.out.println("Players: " + numberOfPlayers);
        System.out.println("Target score: " + targetScore);
        System.out.println("Rule: roll 1 => bust (gain 0 this turn)\n");
    }

    @Override
    public boolean endOfGame() {
        return gameOver;
    }

    @Override
    public void playSingleTurn(int playerIndex) {
        Player p = players.get(playerIndex);

        System.out.println("---- " + p.getName() + "'s turn ----");
        System.out.println("Current score: " + p.getScore());

        // Simple “push your luck”: roll up to 3 times, but a 1 busts the whole turn.
        int turnPoints = 0;

        for (int rollNum = 1; rollNum <= 3; rollNum++) {
            int r = die.roll();
            System.out.println("Roll " + rollNum + ": " + r);

            if (r == 1) {
                turnPoints = 0;
                System.out.println("Bust! You gained 0 points this turn.");
                break;
            } else {
                turnPoints += r;
            }
        }

        p.addScore(turnPoints);

        System.out.println("Points gained this turn: " + turnPoints);
        System.out.println("New score: " + p.getScore() + "\n");

        // Check win condition
        if (p.getScore() >= targetScore) {
            winner = p;
            gameOver = true;
        }
    }

    @Override
    public void displayWinner() {
        System.out.println("=== Game Over ===");
        if (winner != null) {
            System.out.println("Winner: " + winner.getName() + " with " + winner.getScore() + " points!");
        } else {
            System.out.println("No winner (unexpected).");
        }

        System.out.println("\nFinal scores:");
        for (Player p : players) {
            System.out.println("- " + p.getName() + ": " + p.getScore());
        }
    }
}