/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package abstract_factory;

/**
 * Created by forando on 05.07.15.<br/>
 * Concrete factory.
 */
public class MathFactoryA implements AbstractMathOperationsFactory {
    @Override
    public String getFactoryType() {
        return "A";
    }

    @Override
    public AbstractIncreaser createIncreaser(int param) {
        return new IncreaserA(param);
    }

    @Override
    public AbstractDerceaser createDecreaser(int param) {
        return new DecreaserA(param);
    }
}
