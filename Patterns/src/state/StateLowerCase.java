/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package state;

/**
 * Created by forando on 01.12.14.
 */
class StateLowerCase implements State {

    @Override
    public void writeName(final StateContext context, final String name) {
        System.out.println(name.toLowerCase());
        context.setState(new StateMultipleUpperCase());
    }

}
