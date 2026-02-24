import java.util.List;

public class NoviceState implements CharacterState {

    @Override
    public String getLevelName() {
        return "Novice";
    }

    @Override
    public List<String> getAvailableActions() {
        return List.of("train");
    }

    @Override
    public void train(GameCharacter c) {
        int gain = c.roll(8, 14);
        c.addExperience(gain);
        System.out.println("You train hard. +" + gain + " EXP.");
    }

    @Override
    public void meditate(GameCharacter c) {
        System.out.println("You are too inexperienced to meditate effectively (locked at Novice).");
    }

    @Override
    public void fight(GameCharacter c) {
        System.out.println("You are not ready to fight (locked at Novice).");
    }
}