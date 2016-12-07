/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package visitor;

/**
 * Created by forando on 31.07.15.
 */
public class Point3d extends Point {
    public Point3d ( double x, double y, double z ) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void accept ( Visitor v ) {
        v.visit( this );
    }

    private double x;
    public double getX () { return x; }

    private double y;
    public double getY () { return y; }

    private double z;
    public double getZ () { return z; }
}
