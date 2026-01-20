package fi.metropolia.designpatterns.factory.adventuregame;

public class HorrorGame extends Game {
    @Override
    public Room createRoom() {
        return new ScaryRoom();
    }
}