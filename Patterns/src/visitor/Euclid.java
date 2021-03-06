/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package visitor;

/**
 * Created by forando on 31.07.15.
 */
public class Euclid implements Visitor {
    public void visit ( Point2d p ) {
        p.setMetric( Math.sqrt( p.getX()*p.getX() + p.getY()*p.getY() ) );
    }
    public void visit ( Point3d p ) {
        p.setMetric( Math.sqrt( p.getX()*p.getX() + p.getY()*p.getY() + p.getZ()*p.getZ() ) );
    }
}
