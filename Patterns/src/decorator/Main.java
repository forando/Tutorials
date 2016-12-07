/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package decorator;

import decorator.filter.*;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.zip.GZIPOutputStream;

/**
 * Created by forando on 29.11.14.
 */
public class Main {

    public static void main(String[] args) {
        placeFilterExample();
    }

    private static void example(){
        Decorator c = new DecoratorHello(new DecoratorComma(new DecoratorSpace(new MainComponent())));
        c.doOperation(); // Результат выполнения программы "Hello, World!"
        c.newOperation(); // New hello operation
    }

    private static void placeFilterExample(){
        PlacesFilterDecorator rawPlaces = new PlacesFilterOut(new PlacesFilterUniqe(new PlacesHolder()), "gas|bo");
        //PlacesFilterDecorator rawPlaces = new PlacesFilterOut(new PlacesHolder(), "gas|beaut");
        ArrayList<Place> places = rawPlaces.filter();

        for (Place place : places) {
            System.out.println("place.getName() = " + place.getName());
        }
    }

    private static void realExample(){
        try {
            FileOutputStream fos = new FileOutputStream("/home/forando/Загрузки/test.txt");
            /*
            Декоратор предусматривает расширение функциональности объекта без определения подклассов.
            Важно, что классы, реализующие этот шаблон, не меняют своего типа, но только
            добавляют к основному типу (в данном случае это OutputStream) дополнительные фичи.
            Применение этого шаблона позволяет нанизывать на основной объект те фичи, которые нам
            сейчас необходимы и в том порядке, который нам нужен. И делается всё это на на стадии
            компиляции, а в Runtime.
             */
            OutputStream out =
                    new BufferedOutputStream(
                            new GZIPOutputStream(fos)
                    );
            out.write(42);
            out.write(42);
            out.write(42);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
