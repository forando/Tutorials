/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package prototype;

/**
 * Created by forando on 06.07.15.<br/>
 * Concrete prototype.
 */
public class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
