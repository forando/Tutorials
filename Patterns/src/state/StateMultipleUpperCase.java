/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package state;

/**
 * Created by forando on 01.12.14.
 */
class StateMultipleUpperCase implements State {
    /** Counter local to this state */
    private int count = 0;

    @Override
    public void writeName(final StateContext context, final String name) {
        System.out.println(name.toUpperCase());
        /* Change state after StateMultipleUpperCase's writeName() gets invoked twice */
        if(++count > 1) {
            context.setState(new StateLowerCase());
        }
    }

}
