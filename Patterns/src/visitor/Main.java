/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package visitor;

/**
 * Created by forando on 31.07.15.
 */
public class Main {
    public static void main(String[] args) {
        Point p = new Point2d( 1, 2 );
        //Visitor v = new Chebyshev();
        Visitor v = new Euclid();
        p.accept( v );
        System.out.println( p.getMetric() );
    }
}
