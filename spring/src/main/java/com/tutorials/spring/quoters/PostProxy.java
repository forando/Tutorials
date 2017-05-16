package com.tutorials.spring.quoters;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Все методы с этой аннотацией запускаются сами после того как все proxy уже сгенерированы и настроены
 * По сути, эти методы являются конструкторами фазы 3
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface PostProxy {
}
