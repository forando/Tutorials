package template_method;

/**
 * Created by forando on 01.12.14.<br>
 *     Абстрактный класс, реализация абстрактных методов которого
 *     будет специфичной для каждого вида игры.
 */
public abstract class Game {

    private int playersAmount;

    protected abstract void initializeGame();

    protected abstract void playGame();

    protected abstract void endGame();

    protected abstract void printWinner();

    /**
     * This method is common for all subclasses.
     * @param playersAmount
     */
    public void playOneGame(int playersAmount){
        System.out.println("Game: playOneGame method invoked");
        setPlayersAmount(playersAmount);

        initializeGame();
        playGame();
        endGame();

        printWinner();
    }

    /**
     * This method is common for all subclasses.
     * @param playersAmount
     */
    public void setPlayersAmount(int playersAmount){
        this.playersAmount = playersAmount;
        System.out.println("Game: setPlayersAmount method invoked");
    }

}
