/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package abstract_factory;

/**
 * Created by forando on 05.07.15.<br/>
 * Concrete object.
 */
public class IncreaserB implements AbstractIncreaser {

    private int val;

    public IncreaserB(int value) {
        this.val = value;
    }

    @Override
    public int increase(int value) {
        return val * value;
    }
}
