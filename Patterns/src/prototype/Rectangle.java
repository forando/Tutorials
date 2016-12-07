/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package prototype;

/**
 * Created by forando on 06.07.15.<br/>
 * Concrete prototype.
 */
public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
