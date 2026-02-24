import java.util.List;

public interface CharacterState {
    String getLevelName();
    List<String> getAvailableActions();

    void train(GameCharacter c);
    void meditate(GameCharacter c);
    void fight(GameCharacter c);
}