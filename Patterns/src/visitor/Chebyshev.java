/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package visitor;

/**
 * Created by forando on 31.07.15.
 */
public class Chebyshev implements Visitor {
    public void visit ( Point2d p ) {
        double ax = Math.abs( p.getX() );
        double ay = Math.abs( p.getY() );
        p.setMetric( ax>ay ? ax : ay );
    }
    public void visit ( Point3d p ) {
        double ax = Math.abs( p.getX() );
        double ay = Math.abs( p.getY() );
        double az = Math.abs( p.getZ() );
        double max = ax>ay ? ax : ay;
        if ( max<az ) max = az;
        p.setMetric( max );
    }
}
