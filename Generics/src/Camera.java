/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

import java.util.List;

/**
 * Created by forando on 13.11.14.
 */
public class Camera extends Product<Camera> {
    public int pixel;
    public Camera(String name, int price, int pixel) {
        super(name, price);
        this.pixel = pixel;
    }

    @Override
    int subCompare(Camera camera) {
        if(price>camera.price) return 1;
        return 0;
    }

}
