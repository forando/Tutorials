/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package prototype;

/**
 * Created by forando on 06.07.15.<br/>
 * Concrete prototype.
 */
public class Square extends Shape {

    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
