/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package abstract_factory;

/**
 * Created by forando on 05.07.15.<br/>
 * Concrete object.
 */
public class DecreaserA implements AbstractDerceaser {

    private int val;

    public DecreaserA(int value) {
        this.val = value;
    }

    @Override
    public int dercease(int value) {
        return val - value;
    }
}
