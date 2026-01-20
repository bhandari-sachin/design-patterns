package fi.metropolia.designpatterns.factory.adventuregame;

public class Main {

    public static void main(String[] args) {
        Game game = new RelaxedGame();
        game.play();
    }
}