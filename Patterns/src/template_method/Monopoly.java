/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package template_method;

/**
 * Created by forando on 01.12.14.<br>
 * Игра "Монополия". Специфически только для монополии реализует методы класса Game.
 */
public class Monopoly extends Game{

    @Override
    protected void initializeGame() {
        System.out.println("Monopoly: initializeGame method invoked");
        // monopoly specific initialization actions
    }

    @Override
    protected void playGame() {
        System.out.println("Monopoly: playGame method invoked");
        // monopoly specific play actions
    }

    @Override
    protected void endGame() {
        System.out.println("Monopoly: endGame method invoked");
        // monopoly specific actions to end a game
    }

    @Override
    protected void printWinner() {
        System.out.println("Monopoly: printWinner method invoked");
        // monopoly specific actions to print winner
    }

}
