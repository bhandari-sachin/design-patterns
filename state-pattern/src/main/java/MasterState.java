import java.util.List;

public class MasterState implements CharacterState {

    @Override
    public String getLevelName() {
        return "Master";
    }

    @Override
    public List<String> getAvailableActions() {
        return List.of(); // none; game ends
    }

    @Override
    public void train(GameCharacter c) {
        System.out.println("You have already mastered the path.");
    }

    @Override
    public void meditate(GameCharacter c) {
        System.out.println("You are at perfect balance already.");
    }

    @Override
    public void fight(GameCharacter c) {
        System.out.println("There is nothing left to prove.");
    }
}