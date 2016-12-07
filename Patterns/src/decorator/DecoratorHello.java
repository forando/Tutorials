/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package decorator;

/**
 * Created by forando on 18.12.14.
 */
public class DecoratorHello extends Decorator {

    public DecoratorHello(InterfaceComponent c) {
        super(c);
    }

    @Override
    public void doOperation() {
        System.out.print("Hello");
        super.doOperation();
    }

    @Override
    public void newOperation() {
        System.out.println("New hello operation");
    }
}
