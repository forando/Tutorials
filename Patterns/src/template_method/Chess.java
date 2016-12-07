/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package template_method;

/**
 * Created by forando on 01.12.14.<br>
 * Игра "Шахматы". Специфически только для шахмат реализует методы класса Game.
 */
public class Chess extends Game {

    @Override
    protected void initializeGame() {
        System.out.println("Chess: initializeGame method invoked");
        // chess specific initialization actions
    }

    @Override
    protected void playGame() {
        System.out.println("Chess: playGame method invoked");
        // chess specific play actions
    }

    @Override
    protected void endGame() {
        System.out.println("Chess: endGame method invoked");
        // chess specific actions to end a game
    }

    @Override
    protected void printWinner() {
        System.out.println("Chess: printWinner method invoked");
        // chess specific actions to print winner
    }

}
