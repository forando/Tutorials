/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package builder.example2;

/**
 * Created by forando on 05.07.15.<br/>
 * This is <b>Director</b> realisation according to Builder Pattern.
 */
public class GoodJudge implements Judge {
    @Override
    public void announceVerdict(VerdictBuilder builder){
        /*
        процесс конструирования обеспечивает различные представления конструируемого объекта.
        Здесь, в зависимости от того в какой очереди будут конструироваться одни и те же элементы,
        мы будем получать совершенно разные представления объекта (в нашем случае это приговор).
         */
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
    }
}
