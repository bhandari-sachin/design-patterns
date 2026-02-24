import java.util.Random;

public class GameCharacter {
    private final String name;

    private int experience;
    private int health;
    private final int maxHealth;

    private CharacterState state;

    // Level thresholds (tweak as desired)
    public static final int TO_INTERMEDIATE = 50;
    public static final int TO_EXPERT = 150;
    public static final int TO_MASTER = 300;

    private final Random rng = new Random();

    public GameCharacter(String name) {
        this.name = name;
        this.experience = 0;
        this.maxHealth = 100;
        this.health = 60;
        this.state = new NoviceState();
    }

    // ---- State delegation ----
    public void train() { state.train(this); checkLevelUp(); }
    public void meditate() { state.meditate(this); checkLevelUp(); }
    public void fight() { state.fight(this); checkLevelUp(); }

    // ---- Level-up logic ----
    private void checkLevelUp() {
        if (state instanceof MasterState) return;

        if (experience >= TO_MASTER) {
            setState(new MasterState());
            System.out.println("\n🏆 " + name + " has reached MASTER level! The journey is complete.");
            return;
        }
        if (experience >= TO_EXPERT && !(state instanceof ExpertState)) {
            setState(new ExpertState());
            System.out.println("\n⚔️  Level up! " + name + " is now EXPERT.");
            return;
        }
        if (experience >= TO_INTERMEDIATE && state instanceof NoviceState) {
            setState(new IntermediateState());
            System.out.println("\n🧘 Level up! " + name + " is now INTERMEDIATE.");
        }
    }

    // ---- Helpers used by states ----
    public void addExperience(int amount) {
        experience = Math.max(0, experience + amount);
    }

    public void addHealth(int amount) {
        health = Math.min(maxHealth, health + amount);
    }

    public void loseHealth(int amount) {
        health = Math.max(0, health - amount);
    }

    public int roll(int minInclusive, int maxInclusive) {
        return rng.nextInt(maxInclusive - minInclusive + 1) + minInclusive;
    }

    // ---- Getters / setters ----
    public String getName() { return name; }
    public int getExperience() { return experience; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }

    public CharacterState getState() { return state; }
    public void setState(CharacterState state) { this.state = state; }

    public boolean isGameOver() {
        return (state instanceof MasterState);
    }

    public String nextGoalText() {
        if (state instanceof NoviceState) return "Next: INTERMEDIATE at " + TO_INTERMEDIATE + " EXP";
        if (state instanceof IntermediateState) return "Next: EXPERT at " + TO_EXPERT + " EXP";
        if (state instanceof ExpertState) return "Next: MASTER at " + TO_MASTER + " EXP";
        return "You are MASTER.";
    }
}