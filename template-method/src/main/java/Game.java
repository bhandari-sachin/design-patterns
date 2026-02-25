public abstract class Game {
    public final void play(int numberOfPlayers){
        initializeGame(numberOfPlayers);
        int playerInTurn = 0;
        while(!endOfGame()) {
            playSingleTurn(playerInTurn);
            playerInTurn = ++playerInTurn % numberOfPlayers;
        }
        displayWinner();
    }
    public abstract void initializeGame(int numberOfPlayers);
    public abstract void playSingleTurn(int playerInTurn);
    public abstract void displayWinner();
    public abstract boolean endOfGame();


}
