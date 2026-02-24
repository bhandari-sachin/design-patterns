import java.util.List;

public class IntermediateState implements CharacterState {

    @Override
    public String getLevelName() {
        return "Intermediate";
    }

    @Override
    public List<String> getAvailableActions() {
        return List.of("train", "meditate");
    }

    @Override
    public void train(GameCharacter c) {
        int gain = c.roll(10, 18);
        c.addExperience(gain);
        System.out.println("You train with discipline. +" + gain + " EXP.");
    }

    @Override
    public void meditate(GameCharacter c) {
        int heal = c.roll(10, 20);
        int before = c.getHealth();
        c.addHealth(heal);
        int actual = c.getHealth() - before;
        System.out.println("You meditate and recover. +" + actual + " HP.");
    }

    @Override
    public void fight(GameCharacter c) {
        System.out.println("Fighting is not available yet (locked until Expert).");
    }
}