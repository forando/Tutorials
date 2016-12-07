/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

package builder;

import builder.example1.NutritionFacts;
import builder.example2.*;

/**
 * Created by forando on 05.07.15.
 */
public class Main {
    public static void main(String[] args) {
        example2();
    }

    static void example1(){
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
    }

    static void example2(){
        Judge judge;
        /*
        алгоритм создания и представления сложного объекта не зависит от того,
        из каких частей состоит объект и как они стыкуются между собой
        (тобиш от самого конструирования объекта);
         */
        judge = new GoodJudge();
        announceVerdict(judge);

        /*
        Видим что помимо подстановки другой реализации Судьи, алгоритм представления
        приговора остался абсолютно неизменным. А результат другим, так как алгоритм
        конструирования приговора обрабатывается отдельно от этого кода.
         */
        judge = new BadJudge();
        announceVerdict(judge);
    }

    /*
    Эта часть кода неизменна
     */
    static void announceVerdict(Judge judge){
        VerdictBuilder verdictBuilder = new ConcreteVerdictBuilder();
        judge.announceVerdict(verdictBuilder);
        verdictBuilder.getVerdict().announce();
    }
}
