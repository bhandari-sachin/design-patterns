import java.util.List;

public class ExpertState implements CharacterState {

    @Override
    public String getLevelName() {
        return "Expert";
    }

    @Override
    public List<String> getAvailableActions() {
        return List.of("train", "meditate", "fight");
    }

    @Override
    public void train(GameCharacter c) {
        int gain = c.roll(12, 22);
        c.addExperience(gain);
        System.out.println("You refine advanced techniques. +" + gain + " EXP.");
    }

    @Override
    public void meditate(GameCharacter c) {
        int heal = c.roll(12, 24);
        int before = c.getHealth();
        c.addHealth(heal);
        int actual = c.getHealth() - before;
        System.out.println("Deep meditation restores you. +" + actual + " HP.");
    }

    @Override
    public void fight(GameCharacter c) {
        // Safety rule: don't allow fighting at critical HP
        if (c.getHealth() < 15) {
            System.out.println("You are too weak to fight. Meditate first!");
            return;
        }

        int expGain = c.roll(20, 40);
        int hpLoss = c.roll(10, 25);

        c.addExperience(expGain);
        c.loseHealth(hpLoss);

        System.out.println("You fight fiercely! +" + expGain + " EXP, -" + hpLoss + " HP.");

        if (c.getHealth() == 0) {
            System.out.println("You collapsed from exhaustion... but you can still train/meditate to recover.");
        }
    }
}