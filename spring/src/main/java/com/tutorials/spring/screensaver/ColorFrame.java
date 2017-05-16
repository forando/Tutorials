package com.tutorials.spring.screensaver;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
@org.springframework.stereotype.Component
public abstract class ColorFrame extends JFrame {

    public ColorFrame() {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace(){
        Random random = new Random();
        setLocation(random.nextInt(1700), random.nextInt(1000));
        getContentPane().setBackground(getColor());
        repaint();
    }

    /**
     * Нам нужно обратиться к контексту, но мы не хотим его в этом классе держать.
     * Поэтому этот метод абстрактный. Он имплементируется в java Config файле.
     * @return Bean color
     */
    protected abstract Color getColor();
}
