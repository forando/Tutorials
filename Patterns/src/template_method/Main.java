package template_method;

/**
 * Created by forando on 01.12.14.
 */
public class Main {

    public static void main(String[] args) {
        //final GameCode gameCode = GameCode.CHESS;
        final GameCode gameCode = GameCode.MONOPOLY;

        Game game;

        switch (gameCode){
            case CHESS :
                game = new Chess();
                break;
            case MONOPOLY :
                game = new Monopoly();
                break;
            default :
                throw new IllegalStateException();
        }

        game.playOneGame(2);
    }

    public enum GameCode {
        CHESS,
        MONOPOLY
    }
}
