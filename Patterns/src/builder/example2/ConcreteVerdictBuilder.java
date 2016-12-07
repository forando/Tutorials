/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package builder.example2;

/**
 * Created by forando on 05.07.15.<br/>
 * Изолирует код, реализующий конструирование от представления.<br/>
 * Дает более тонкий контроль над процессом конструирования.
 */
public class ConcreteVerdictBuilder implements VerdictBuilder {

    private Verdict verdict = new Verdict();

    @Override
    public void buildPartA() {
        verdict.addVerdictpart("КАЗНИТЬ");
    }

    @Override
    public void buildPartB() {
        verdict.addVerdictpart("НЕЛЬЗЯ");
    }

    @Override
    public void buildPartC() {
        verdict.addVerdictpart("ПОМИЛОВАТЬ");
    }

    @Override
    public Verdict getVerdict() {
        return verdict;
    }
}
