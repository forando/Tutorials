/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package decorator;

import java.util.ArrayList;

/**
 * Created by forando on 18.12.14.
 */
public class DecoratorSpace extends Decorator{

    public DecoratorSpace(InterfaceComponent c) {
        super(c);
    }

    @Override
    public void doOperation() {
        System.out.print(" ");
        super.doOperation();
    }

    @Override
    public void newOperation() {
        System.out.println("New space operation");
    }
}
