/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package decorator;


/**
 * Created by forando on 18.12.14.
 */
public abstract class Decorator implements InterfaceComponent {
    protected InterfaceComponent component;

    public Decorator (InterfaceComponent c) {
        component = c;
    }

    @Override
    public void doOperation() {
        component.doOperation();
    }

    public void newOperation() {
        System.out.println("Do Nothing");
    }
}
