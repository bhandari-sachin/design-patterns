package fi.metropolia.designpatterns.factory.adventuregame;

public class RelaxedGame extends Game {
    @Override
    public Room createRoom() {
        return new LovelyRoom();
    }
}
