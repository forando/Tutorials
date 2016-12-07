/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package adapter;

/**
 * Created by forando on 29.11.14.<br>
 *     Шаблон Адаптер позволяет включать уже существующие объекты (в данном случае объект Plumber)
 *     в новые объектные структуры (в данном случае Chief),независимо от различий в их интерфейсах.<br>
 *     Шаблон Адаптер позволяет в процессе проектирования не принимать во внимание возможные
 *     различия в интерфейсах уже существующих классов. Если есть класс, обладающий требуемыми
 *     методами и свойствами (по крайней мере, концептуально), то при необходимости всегда
 *     можно воспользоваться шаблоном Адаптер для приведения его интерфейса к нужному виду.<br>
 *     Близким Адаптеру является шаблон Фасад, не всегда можно отличить один от другого
 */
public class ChiefAdapter implements Chief{

    private Plumber plumber;

    public ChiefAdapter(Plumber plumber) {
        this.plumber = plumber;
    }

    @Override
    public Object makeBreakfast() {
        return plumber.getKey();
    }

    @Override
    public Object makeDinner() {
        return plumber.getScrewDriver();
    }

    @Override
    public Object makeSupper() {
        return plumber.getPipe();
    }

}
